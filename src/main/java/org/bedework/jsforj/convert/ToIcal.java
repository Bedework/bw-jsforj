/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.convert;

import org.bedework.jsforj.impl.values.dataTypes.JSLocalDateTimeImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSUTCDateTimeImpl;
import org.bedework.jsforj.model.DateTimeComponents;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSAbsoluteTrigger;
import org.bedework.jsforj.model.values.JSAlert;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.JSOffsetTrigger;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSTrigger;
import org.bedework.jsforj.model.values.dataTypes.JSDateTime;
import org.bedework.util.logging.BwLogger;
import org.bedework.util.logging.Logged;
import org.bedework.util.misc.Util;
import org.bedework.util.misc.response.GetEntityResponse;
import org.bedework.util.misc.response.Response;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.parameter.AltRep;
import net.fortuna.ical4j.model.parameter.Cn;
import net.fortuna.ical4j.model.parameter.CuType;
import net.fortuna.ical4j.model.parameter.Dir;
import net.fortuna.ical4j.model.parameter.Language;
import net.fortuna.ical4j.model.parameter.PartStat;
import net.fortuna.ical4j.model.parameter.Related;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.parameter.Rsvp;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.Categories;
import net.fortuna.ical4j.model.property.Color;
import net.fortuna.ical4j.model.property.Concept;
import net.fortuna.ical4j.model.property.Contact;
import net.fortuna.ical4j.model.property.Created;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Due;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.EstimatedDuration;
import net.fortuna.ical4j.model.property.Sequence;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.Trigger;
import net.fortuna.ical4j.model.property.Uid;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.bedework.jsforj.model.JSTypes.typeEvent;
import static org.bedework.jsforj.model.JSTypes.typeTask;
import static org.bedework.jsforj.model.values.JSLink.linkRelAlternate;
import static org.bedework.jsforj.model.values.JSRoles.roleAttendee;
import static org.bedework.jsforj.model.values.JSRoles.roleChair;
import static org.bedework.jsforj.model.values.JSRoles.roleContact;
import static org.bedework.jsforj.model.values.JSRoles.roleInformational;
import static org.bedework.jsforj.model.values.JSRoles.roleOptional;
import static org.bedework.util.misc.response.Response.Status.failed;

/**
 * User: mike Date: 12/27/23 Time: 22:40
 */
public class ToIcal {
  public static GetEntityResponse<Component> convert(
          final JSCalendarObject val) {
    final var resp = new GetEntityResponse<Component>();

    if (val == null) {
      return Response.notOk(resp, failed, "No entity supplied");
    }

    final var jstype = val.getType();

    final CalendarComponent comp;

    switch (jstype) {
      case typeEvent:
        comp = new VEvent(false);
        break;

      case typeTask:
        comp = new VToDo(false);
        break;

      default:
        return Response
                .error(resp, "org.bedework.invalid.component.type: " +
                        jstype);
    }

    if (!setValues(resp, comp, val).isOk()) {
      return resp;
    }

    resp.setEntity(comp);

    return Response.ok(resp);
  }

  private static GetEntityResponse<Component> setValues(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var props = comp.getProperties();

    /* ------------------- Alarms -------------------- */
    if (!doAlarms(resp, comp, val).isOk()) {
      return resp;
    }

    /* ------------------- Categories -------------------- */
    if (!doCategories(resp, comp, val).isOk()) {
      return resp;
    }

    /* ------------------- Color -------------------- */

    if (val.hasProperty(JSPropertyNames.color)) {
      final var color = val.getColor();
      if (color != null) {
        props.add(new Color(null, color));
      }
    }

    /* ------------------- Created -------------------- */
    if (!doCreated(resp, comp,
                   val.getStringProperty(JSPropertyNames.created)).isOk()) {
      return resp;
    }

    /* ------------------- Dates and duration --------------- */

    if (!setDates(resp, comp, val, recurrenceId)) {
      return resp;
    }

    /* ------------------- Description -------------------- */

    if (val.hasProperty(JSPropertyNames.description)) {
      final var desc = val.getDescription();
      if (desc != null) {
        props.add(new Description(null, desc));
      }
    }

    /* ------------- Description Content type--------------- */
    // Not used

    /* ------------------- Estimated Duration -------------------- */

    if (val.hasProperty(JSPropertyNames.estimatedDuration)) {
      final var estd = val.getStringProperty(JSPropertyNames.estimatedDuration);
      if (estd != null) {
        props.add(new EstimatedDuration(null, estd));
      }
    }

    /* ------------------- guid -------------------- */
    final String guid = val.getUid();

    if (guid == null) {
      /* XXX A guid is required - but are there devices out there without a
       *       guid - and if so how do we handle it?
       */
      return Response.error(resp, "No uid supplied");
    }

    props.add(new Uid(null, guid));

    /* ------------------- keywords -------------------- */
    if (!doKeywords(resp, comp, val).isOk()) {
      return resp;
    }

    /* ------------------- Links ------------------------ */
    if (!doLinks(resp, comp, val).isOk()) {
      return resp;
    }

    /* ------------------- Locations ------------------------ */

    /* ------------------- Participants ------------------------ */
    if (!doParticipants(resp, comp, val).isOk()) {
      return resp;
    }

    /* ------------------- Sequence -------------------- */

    if (val.hasProperty(JSPropertyNames.sequence)) {
      final var seq = val.getUnsignedIntegerProperty(JSPropertyNames.sequence);
      if (seq != null) {
        props.add(new Sequence(null, seq.get()));
      }
    }

    /* ------------------- Summary -------------------- */

    if (val.getTitle() != null) {
      props.add(new Summary(null, val.getTitle();
    }

    ev.setRecurring(false);

    for (final JSProperty<?> prop: val.getProperties()) {
      final var pname = prop.getName();
      final var pval = prop.getValue();

      switch (pname) {
        case JSPropertyNames.entries:
          break;

        case JSPropertyNames.excluded:
          break;

        case JSPropertyNames.freeBusyStatus:
          break;

        case JSPropertyNames.locale:
          break;

        case JSPropertyNames.localizations:
          break;

        case JSPropertyNames.locations:
          break;

        case JSPropertyNames.method:
          break;

        case JSPropertyNames.priority:
          break;

        case JSPropertyNames.privacy:
          break;

        case JSPropertyNames.prodId:
          break;

        case JSPropertyNames.progress:
          break;

        case JSPropertyNames.progressUpdated:
          break;

        case JSPropertyNames.recurrenceRules:
          break;

        case JSPropertyNames.relatedTo:
          break;

        case JSPropertyNames.replyTo:
          break;

        case JSPropertyNames.source:
          break;

        case JSPropertyNames.status:
          break;

        case JSPropertyNames.timeZone:
          break;

        case JSPropertyNames.timeZones:
          break;

        case JSPropertyNames.updated:
          break;

        case JSPropertyNames.useDefaultAlerts:
          break;

        case JSPropertyNames.virtualLocations:
          break;

        default:
          resp.warning("Unknown property: " + pname);
      }
    }
  }

  private static GetEntityResponse<Component> doAlarms(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var alerts = val.getAlerts(false);
    if (alerts == null) {
      return resp;
    }

    final ComponentList<Component> subComps;

    if (comp instanceof VEvent) {
      subComps = ((VEvent)comp).getComponents();
    } else if (comp instanceof VToDo) {
      subComps = ((VToDo)comp).getComponents();
    } else {
      return Response.error(resp,
                            "org.bedework.invalid.component.type " +
                                         comp.getName());
    }

    for (final var alertp: alerts.get()) {
      final var alarm = new VAlarm();

      final var alert = alertp.getValue();
      final var action = alert.getAction();

      final TriggerVal tr = getTrigger(alert.getTrigger());

      String summary = alert.getTitle();
      String desc = alert.getDescription();

      if (summary == null) {
        summary = val.getTitle();
      }

      if (desc == null) {
        desc = val.getDescription();
      }

      if (JSAlert.alertActionDisplay.equals(action)) {
        addProp(alarm, new Action("DISPLAY"));
        addProp(alarm, new Summary(summary));
      } else if (JSAlert.alertActionEmail.equals(action)) {
        addProp(alarm, new Action("EMAIL"));
        addProp(alarm, new Summary(summary));

        if (desc == null) {
          desc = summary;
        }
        addProp(alarm, new Description(desc));
      } else {
        continue;
      }

      try {
        final Trigger trigger;

        if (tr.triggerDateTime) {
          final DateTime dt = new DateTime(tr.trigger);
          trigger = new Trigger(dt);
        } else {
          trigger = new Trigger(new Dur(tr.trigger));
          if (!tr.triggerStart) {
            trigger.getParameters().add(Related.END);
          } else {
            // Not required - it's the default - but we fail some Cyrus tests otherwise
            // Apparently Cyrus now handles the default state correctly
            trigger.getParameters().add(Related.START);
          }
        }

        addProp(alarm, trigger);
      } catch (final Throwable t) {
        return Response.error(resp, t);
      }

      subComps.add(alarm);
    }

    return resp;
  }

  /**
   * @param val JSTrigger subtype
   * @return TriggerVal
   */
  private static TriggerVal getTrigger(final JSTrigger val) {
    final TriggerVal tr = new TriggerVal();

    if (val instanceof JSAbsoluteTrigger) {
      final var absTrigger = (JSAbsoluteTrigger)val;
      final IcalDate icalDate =
              new IcalDate(absTrigger.getWhen().getStringValue());
      tr.trigger = icalDate.format(false);
      tr.triggerDateTime = true;

      return tr;
    }

    if (!(val instanceof JSOffsetTrigger)) {
      return tr;
    }

    final var offsetTrigger = (JSOffsetTrigger)val;
    final var rel = offsetTrigger.getRelativeTo();

    tr.triggerStart = (rel == null) ||
            JSOffsetTrigger.relativeToStart.equals(rel);

    tr.trigger = offsetTrigger.getOffset().getStringValue();

    return tr;
  }

  private static GetEntityResponse<Component> doCategories(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var cats = val.getCategories(false);
    if (cats == null) {
      return resp;
    }

    for (final String cval: cats.get()) {
      try {
        addProp(comp, new Concept(null, cval));
      } catch (final Throwable t) {
        return Response.error(resp, t);
      }
    }

    return resp;
  }

  private static GetEntityResponse<Component> doKeywords(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var keys = val.getKeywords(false);
    if (keys == null) {
      return resp;
    }

    for (final String kw: keys.get()) {
      addProp(comp, new Categories(null, kw));
    }

    return resp;
  }

  private static GetEntityResponse<Component> doLinks(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var links = val.getLinks(false);
    if (links == null) {
      return resp;
    }

    return resp;
  }

  private static final List<String> attendeeRoles =
          Arrays.asList(roleAttendee,
                        roleOptional,
                        roleInformational,
                        roleChair);

  private static GetEntityResponse<Component> doParticipants(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject val) {
    final var participants = val.getParticipants(false);
    if (participants == null) {
      return resp;
    }

    for (final var key: participants.getKeys()) {
      final var partProp = participants.get(key);
      var processed = false;
      final JSParticipant part = partProp.getValue();
      final var roles = part.getRoles(true).get();

      if (roles.contains(roleContact)) {
        if (!doContact(resp, comp, key, part).isOk()) {
          return resp;
        }
        processed = true;
      }

      // Attendee?

      final var isAttendee = attendeeRoles
              .stream()
              .anyMatch(roles::contains);

      if (isAttendee) {
        if (!doAttendee(resp, comp, part).isOk()) {
          return resp;
        }
        processed = true;
      }
    }

    return resp;
  }

  private static GetEntityResponse<Component> doContact(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final String partKey,
          final JSParticipant value) {
    final var cn = value.getDescription();

    final var links = value.getLinks(false);
    JSLink link = null;
    if (links != null) {
      for (final var linkP: links.get()) {
        final var l = linkP.getValue();
        if (linkRelAlternate.equals(l.getRel())) {
          link = l;
          break;
        }
      }
    }

    final var contact = new Contact(cn);

    if (link != null) {
      try {
        contact.getParameters().add(new AltRep(link.getHref()));
      } catch (final URISyntaxException use) {
        return Response.error(resp, use);
      }
    }

    addProp(comp, contact);

    return resp;
  }

  private static GetEntityResponse<Component> doAttendee(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSParticipant value) {
    final var calAddr = getSendTo("imip", value);
    if (calAddr == null) {
      return resp; // No calendar address
    }

    final Attendee attendee;

    try {
      attendee = new Attendee(calAddr);

      if (value.getParticipationStatus() != null) {
        addParam(attendee,
                 new PartStat(value.getParticipationStatus().toUpperCase()));
      }

      if (value.getExpectReply()) {
        addParam(attendee, new Rsvp(true));
      }

      if (value.getName() != null) {
        addParam(attendee, new Cn(value.getName()));
      }

      final var cuType = iCalCutype(value.getKind());
      if (cuType != null) {
        addParam(attendee, new CuType(cuType));
      }

      // delegated from
      // delegated to

      final var links = value.getLinks(false);
      JSLink link = null;
      if (links != null) {
        for (final var linkP: links.get()) {
          final var l = linkP.getValue();
          if (linkRelAlternate.equals(l.getRel())) {
            link = l;
            break;
          }
        }
      }

      if (link != null) {
        addParam(attendee, new Dir(link.getHref()));
      }

      final var lang = value.getLanguage();
      if (lang != null) {
        addParam(attendee, new Language(lang));
      }

      final var roles = value.getRoles(false);

      if (roles != null) {
        addParam(attendee, new Role(iCalRole(roles.get())));
      }

      // scheduleAgent
      // getScheduleStatus
      // ...

      addProp(comp, attendee);
    } catch (final URISyntaxException use) {
      return Response.error(resp, use);
    }

    return resp;
  }

  private static String getSendTo(final String key,
                           final JSParticipant value) {
    final var sendTo = value.getSendTo(false);
    if (sendTo == null) {
      return null; // No calendar address
    }

    final var imipAddr = sendTo.get(key);

    if ((imipAddr == null) || (imipAddr.getValue() == null)) {
      return null; // No send to for calendar address
    }

    return imipAddr.getValue().getStringValue();
  }

  private static String iCalCutype(final String jsCalCutype) {
    if (jsCalCutype == null) {
      return null;
    }

    if ("location".equalsIgnoreCase(jsCalCutype)) {
      return "room";
    }

    return jsCalCutype.toUpperCase();
  }

  private static String iCalRole(final List<String> roles) {
    if (Util.isEmpty(roles)) {
      return null;
    }

    /*
      "CHAIR" -> "chair"
      "REQ-PARTICIPANT" -> "attendee"
      "OPT-PARTICIPANT" -> "attendee", "optional"
      "NON-PARTICIPANT" -> "attendee", "informational"
     */

    boolean attendee = false;
    boolean chair = false;
    boolean optional = false;
    boolean informational = false;

    for (final var val: roles) {
      switch (val.toLowerCase()) {
        case "attendee":
          attendee = true;
          continue;
        case "chair":
          chair = true;
          continue;
        case "optional":
          optional = true;
          continue;
        case "informational":
          informational = true;
      }
    }

    if (!attendee) {
      return null;
    }

    if (chair) {
      return "CHAIR";
    }

    if (optional) {
      return "OPT-PARTICIPANT";
    }

    if (informational) {
      return "NON-PARTICIPANT";
    }

    return "REQ-PARTICIPANT";
  }

  private static GetEntityResponse<Component> doCreated(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final String value) {
    final IcalDate icalDate = new IcalDate(value);
    final String dt = icalDate.format(false);

    try {
      addProp(comp, new Created(dt));
    } catch (final Throwable use) {
      return Response.error(resp, use);
    }

    return resp;
  }

  /*
     If this is an override the value will have a recurrence id which
     we can use to set the date.
   */
  private static GetEntityResponse<Component> setDates(
          final GetEntityResponse<Component> resp,
          final CalendarComponent comp,
          final JSCalendarObject obj,
          final BwDateTime recurrenceId) {
    /*
      We need the following - these values may come from overrides)
        * date or date-time - from showWithoutTimes flag
        * start timezone (if not date)
        * ending timezone (if not date) - from end location
        * start - if override from recurrence id or overridden start
        * duration - possibly overridden - for event
        * due - possibly overridden - for task

       If end timezone is not the same as start then we have to use a
       DTEND with timezone, otherwise duration will do
     */
    try {
//      final JSCalendarObject obj;

      //    if (val == null) {
      //    obj = master;
      //} else {
      // obj = val;
      // }

      // date or date-time - from showWithoutTimes flag
      final var dateOnly =
              obj.getBooleanProperty(JSPropertyNames.showWithoutTime);
      // start timezone
      final String startTimezoneId;
      final String endTimezoneId;

      if (dateOnly) {
        startTimezoneId = null;
        endTimezoneId = null;
      } else {
        startTimezoneId = obj.getStringProperty(JSPropertyNames.timeZone);
        endTimezoneId = null; // from location
      }

      final TimeZone startTz;
      if (startTimezoneId != null) {
        startTz = Timezones.getTz(startTimezoneId);
      } else {
        startTz = null;
      }

      final String start = obj.getStringProperty(JSPropertyNames.start);
      final DtStart st;

      if (start == null) {
        if (recurrenceId != null) {
          // start didn't come from an override.
          // Get it from the recurrence id
          st = recurrenceId.makeDtStart();
        } else {
          return Response.error(resp, "Missing start");
        }
      } else {
        final var icdt = new IcalDate(start);

        st = new DtStart(icdt.format(dateOnly), startTz);
      }

      addProp(comp, st);

      if (comp instanceof VToDo) {
        final var due = obj.getStringProperty(JSPropertyNames.due);
        if (due != null) {
          final var icdt = new IcalDate(due);

          addProp(comp, new Due(icdt.format(dateOnly), startTz));
        }
      }

      final var durStr = obj.getStringProperty(JSPropertyNames.duration);

      if (durStr != null) {
        addProp(comp, new Duration(null, durStr));
      }
    } catch (final Throwable t) {
      return Response.error(resp, t);
    }

    return resp;
  }

  private static class IcalDate {
    private final DateTimeComponents dtc;

    IcalDate(final String val) {
      final var utc = val.endsWith("Z");
      final JSDateTime dt;

      if (utc) {
        dt = new JSUTCDateTimeImpl(val);
      } else {
        dt = new JSLocalDateTimeImpl(val);
      }

      dtc = dt.getComponents();
    }

    private final String utcFormat = "%04d%02d%02dT%02d%02d%02dZ";
    private final String dateTimeFormat = "%04d%02d%02dT%02d%02d%02d";
    private final String dateFormat = "%04d%02d%02d";

    String format(final boolean dtOnly) {
      if (dtc.isUtc()) {
        return String.format(utcFormat,
                             dtc.getYear(),
                             dtc.getMonth(),
                             dtc.getDay(),
                             dtc.getHours(),
                             dtc.getMinutes(),
                             dtc.getSeconds());
      }

      if (dtOnly) {
        return String.format(dateFormat,
                             dtc.getYear(),
                             dtc.getMonth(),
                             dtc.getDay());
      }

      return String.format(dateTimeFormat,
                           dtc.getYear(),
                           dtc.getMonth(),
                           dtc.getDay(),
                           dtc.getHours(),
                           dtc.getMinutes(),
                           dtc.getSeconds());
    }

    long getFractions() {
      return dtc.getFractional();
    }

    boolean isUtc() {
      return dtc.isUtc();
    }
  }

  /** Used fpr constructors
   */
  public static class TriggerVal {
    /** This specifies the time for the alarm in rfc format */
    public String trigger;
    /** true if we trigger off the start */
    public boolean triggerStart;
    /** true if trigger is a date time value */
    public boolean triggerDateTime;
  }

  private static void addProp(final Component comp, final Property prop) {
    comp.getProperties().add(prop);
  }

  private static void addParam(final Property prop, final Parameter param) {
    prop.getParameters().add(param);
  }
}
