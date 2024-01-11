/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.JSRegistration;
import org.bedework.jsforj.JSTypeInfo;
import org.bedework.jsforj.JSValueFactory;
import org.bedework.jsforj.impl.values.factories.JSAlertFactory;
import org.bedework.jsforj.impl.values.factories.JSAlertsFactory;
import org.bedework.jsforj.impl.values.factories.JSBooleanFactory;
import org.bedework.jsforj.impl.values.factories.JSCalendarObjectFactory;
import org.bedework.jsforj.impl.values.factories.JSDurationFactory;
import org.bedework.jsforj.impl.values.factories.JSEntriesFactory;
import org.bedework.jsforj.impl.values.factories.JSIntArrayFactory;
import org.bedework.jsforj.impl.values.factories.JSIntegerFactory;
import org.bedework.jsforj.impl.values.factories.JSLinkFactory;
import org.bedework.jsforj.impl.values.factories.JSLinksFactory;
import org.bedework.jsforj.impl.values.factories.JSLocalDateTimeFactory;
import org.bedework.jsforj.impl.values.factories.JSLocationFactory;
import org.bedework.jsforj.impl.values.factories.JSLocationsFactory;
import org.bedework.jsforj.impl.values.factories.JSOverrideFactory;
import org.bedework.jsforj.impl.values.factories.JSParticipantFactory;
import org.bedework.jsforj.impl.values.factories.JSParticipantsFactory;
import org.bedework.jsforj.impl.values.factories.JSRecurrenceOverridesFactory;
import org.bedework.jsforj.impl.values.factories.JSRecurrenceRuleFactory;
import org.bedework.jsforj.impl.values.factories.JSRecurrenceRulesFactory;
import org.bedework.jsforj.impl.values.factories.JSRelationFactory;
import org.bedework.jsforj.impl.values.factories.JSRelationsFactory;
import org.bedework.jsforj.impl.values.factories.JSReplyToFactory;
import org.bedework.jsforj.impl.values.factories.JSRolesFactory;
import org.bedework.jsforj.impl.values.factories.JSSendToFactory;
import org.bedework.jsforj.impl.values.factories.JSSignedDurationFactory;
import org.bedework.jsforj.impl.values.factories.JSStringArrayFactory;
import org.bedework.jsforj.impl.values.factories.JSStringFactory;
import org.bedework.jsforj.impl.values.factories.JSStringListFactory;
import org.bedework.jsforj.impl.values.factories.JSTimeZoneFactory;
import org.bedework.jsforj.impl.values.factories.JSTimeZoneRuleFactory;
import org.bedework.jsforj.impl.values.factories.JSTriggerFactory;
import org.bedework.jsforj.impl.values.factories.JSURIFactory;
import org.bedework.jsforj.impl.values.factories.JSUTCDateTimeFactory;
import org.bedework.jsforj.impl.values.factories.JSUnsignedIntArrayFactory;
import org.bedework.jsforj.impl.values.factories.JSUnsignedIntFactory;
import org.bedework.jsforj.impl.values.factories.JSVirtualLocationFactory;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Mappings for property names to types and valid objects
 *
 * User: mike Date: 10/23/19 Time: 16:53
 */
class JSPropertyAttributes implements JSRegistration {
  public final static String registrationName = "RFC8984";

  // Type names for properties
  private final static Map<String, String> ptypes =
          new HashMap<>();

  // Type info for types
  private final static Map<String, JSTypeInfo> types =
          new HashMap<>();

  private final static Map<String, List<String>> validFor =
          new HashMap<>();

  private final static Map<String, List<String>> contains =
          new HashMap<>();

  static {
    ptype(JSPropertyNames.type,
          JSTypes.typeString);

    ptype(JSPropertyNames.acknowledged,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.action,
          JSTypes.typeString);

    ptype(JSPropertyNames.alerts,
          JSTypes.typeAlerts);

    ptype(JSPropertyNames.byDay,
          JSTypes.typeNDayArray);

    ptype(JSPropertyNames.byHour,
          JSTypes.typeUnsignedIntArray);

    ptype(JSPropertyNames.byMinute,
          JSTypes.typeUnsignedIntArray);

    ptype(JSPropertyNames.byMonth,
          JSTypes.typeStringArray);

    ptype(JSPropertyNames.byMonthDay,
          JSTypes.typeIntArray);

    ptype(JSPropertyNames.bySecond,
          JSTypes.typeUnsignedIntArray);

    ptype(JSPropertyNames.bySetPosition,
          JSTypes.typeIntArray);

    ptype(JSPropertyNames.byWeekNo,
          JSTypes.typeIntArray);

    ptype(JSPropertyNames.byYearDay,
          JSTypes.typeIntArray);

    ptype(JSPropertyNames.categories,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.cid,
          JSTypes.typeString);

    ptype(JSPropertyNames.color,
          JSTypes.typeString);

    ptype(JSPropertyNames.comments,
          JSTypes.typeStringArray);

    ptype(JSPropertyNames.contentType,
          JSTypes.typeString);

    ptype(JSPropertyNames.coordinates,
          JSTypes.typeURI);

    ptype(JSPropertyNames.count,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.created,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.day,
          JSTypes.typeString);

    ptype(JSPropertyNames.delegatedFrom,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.delegatedTo,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.description,
          JSTypes.typeString);

    ptype(JSPropertyNames.descriptionContentType,
          JSTypes.typeString);

    ptype(JSPropertyNames.display,
          JSTypes.typeString);

    ptype(JSPropertyNames.due,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.duration,
          JSTypes.typeDuration);

    ptype(JSPropertyNames.email,
          JSTypes.typeString);

    ptype(JSPropertyNames.entries,
          JSTypes.typeEntries);

    ptype(JSPropertyNames.estimatedDuration,
          JSTypes.typeDuration);

    ptype(JSPropertyNames.excluded,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.excludedRecurrenceRules,
          JSTypes.typeRecurrenceRules);

    ptype(JSPropertyNames.expectReply,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.firstDayOfWeek,
          JSTypes.typeString);

    ptype(JSPropertyNames.freeBusyStatus,
          JSTypes.typeString);

    ptype(JSPropertyNames.frequency,
          JSTypes.typeString);

    ptype(JSPropertyNames.href,
          JSTypes.typeURI);

    ptype(JSPropertyNames.interval,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.invitedBy,
          JSTypes.typeString);

    ptype(JSPropertyNames.keywords,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.kind,
          JSTypes.typeString);

    ptype(JSPropertyNames.language,
          JSTypes.typeString);

    ptype(JSPropertyNames.links,
          JSTypes.typeLinks);

    ptype(JSPropertyNames.locale,
          JSTypes.typeString);

    ptype(JSPropertyNames.localizations,
          JSTypes.typeLocalizations);

    ptype(JSPropertyNames.locationId,
          JSTypes.typeString);

    ptype(JSPropertyNames.locations,
          JSTypes.typeLocations);

    ptype(JSPropertyNames.locationTypes,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.memberOf,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.method,
          JSTypes.typeString);

    ptype(JSPropertyNames.name,
          JSTypes.typeString);

    ptype(JSPropertyNames.nthOfPeriod,
          JSTypes.typeInt);

    ptype(JSPropertyNames.offset,
          JSTypes.typeSignedDuration);

    ptype(JSPropertyNames.participants,
          JSTypes.typeParticipants);

    ptype(JSPropertyNames.participationComment,
          JSTypes.typeString);

    ptype(JSPropertyNames.participationStatus,
          JSTypes.typeString);

    ptype(JSPropertyNames.percentComplete,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.priority,
          JSTypes.typeInt);

    ptype(JSPropertyNames.privacy,
          JSTypes.typeString);

    ptype(JSPropertyNames.prodId,
          JSTypes.typeString);

    ptype(JSPropertyNames.progress,
          JSTypes.typeString);

    ptype(JSPropertyNames.progressUpdated,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.recurrenceId,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.recurrenceOverrides,
          JSTypes.typeRecurrenceOverrides);

    ptype(JSPropertyNames.recurrenceRules,
          JSTypes.typeRecurrenceRules);

    ptype(JSPropertyNames.rel,
          JSTypes.typeString);

    ptype(JSPropertyNames.relatedTo,
          JSTypes.typeRelations);

    ptype(JSPropertyNames.relation,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.relativeTo,
          JSTypes.typeString);

    ptype(JSPropertyNames.replyTo,
          JSTypes.typeReplyTo);

    ptype(JSPropertyNames.roles,
          JSTypes.typeRoles);

    ptype(JSPropertyNames.rscale,
          JSTypes.typeString);

    ptype(JSPropertyNames.scheduleAgent,
          JSTypes.typeString);

    ptype(JSPropertyNames.scheduleForceSend,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.scheduleSequence,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.scheduleStatus,
          JSTypes.typeStringArray);

    ptype(JSPropertyNames.scheduleUpdated,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.scheme,
          JSTypes.typeString);

    ptype(JSPropertyNames.sendTo,
          JSTypes.typeSendTo);

    ptype(JSPropertyNames.sequence,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.showWithoutTime,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.size,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.skip,
          JSTypes.typeString);

    ptype(JSPropertyNames.start,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.source,
          JSTypes.typeString);

    ptype(JSPropertyNames.status,
          JSTypes.typeString);

    ptype(JSPropertyNames.timeZone,
          JSTypes.typeString);

    ptype(JSPropertyNames.timeZones,
          JSTypes.typeTimeZones);

    ptype(JSPropertyNames.title,
          JSTypes.typeString);

    ptype(JSPropertyNames.trigger,
          JSTypes.typeTrigger);

    ptype(JSPropertyNames.uid,
          JSTypes.typeString);

    ptype(JSPropertyNames.until,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.updated,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.uri,
          JSTypes.typeString);

    ptype(JSPropertyNames.useDefaultAlerts,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.virtualLocations,
          JSTypes.typeVirtualLocations);

    ptype(JSPropertyNames.when,
          JSTypes.typeUTCDateTime);

    /* ===== info for types ======================= */

    type(JSTypes.typeAlert,
         true, // requiresType
         false, // valueList
         false, // propertyList
         types(JSTypes.typeAlert), // elementType
         true, // object
         JSAlertFactory.class); // factoryClass

    type(JSTypes.typeAlerts,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeAlert), // elementType
         false, // object
         JSAlertsFactory.class); // factoryClass

    type(JSTypes.typeBoolean,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSBooleanFactory.class); // factoryClass

    type(JSTypes.typeComments,
         false, // requiresType
         true, // valueList
         false, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSStringArrayFactory.class); // factoryClass

    type(JSTypes.typeDuration,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSDurationFactory.class); // factoryClass

    type(JSTypes.typeEntries,
         false, // requiresType
         true, // valueList
         false, // propertyList
         types(JSTypes.typeEvent, JSTypes.typeTask),// elementType
         false, // object
         JSEntriesFactory.class); // factoryClass

    type(JSTypes.typeId,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeIds,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeId), // elementType
         false, // object
         JSStringListFactory.class); // factoryClass

    type(JSTypes.typeInt,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSIntegerFactory.class); // factoryClass

    type(JSTypes.typeIntArray,
         false, // requiresType
         true, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSIntArrayFactory.class); // factoryClass

    type(JSTypes.typeEvent,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSCalendarObjectFactory.class); // factoryClass

    type(JSTypes.typeGroup,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSCalendarObjectFactory.class); // factoryClass

    type(JSTypes.typeTask,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSCalendarObjectFactory.class); // factoryClass

    type(JSTypes.typeLink,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSLinkFactory.class); // factoryClass

    type(JSTypes.typeLinks,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeLink), // elementType
         false, // object
         JSLinksFactory.class); // factoryClass

    type(JSTypes.typeLocalDateTime,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSLocalDateTimeFactory.class); // factoryClass

    type(JSTypes.typeLocalizations,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typePatchObject), // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeLocation,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSLocationFactory.class); // factoryClass

    type(JSTypes.typeLocations,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeLocation), // elementType
         false, // object
         JSLocationsFactory.class); // factoryClass

    type(JSTypes.typeOffsetTrigger,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeOverride,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSOverrideFactory.class); // factoryClass

    type(JSTypes.typeParticipant,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSParticipantFactory.class); // factoryClass

    type(JSTypes.typeParticipants,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeParticipant), // elementType
         false, // object
         JSParticipantsFactory.class); // factoryClass

    type(JSTypes.typePatchObject,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         null); // factoryClass

    type(JSTypes.typeRecurrenceOverrides,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typePatchObject), // elementType
         false, // object
         JSRecurrenceOverridesFactory.class); // factoryClass

    type(JSTypes.typeRecurrenceRule,
         true, // requiresType
         true, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSRecurrenceRuleFactory.class); // factoryClass

    type(JSTypes.typeRecurrenceRules,
         false, // requiresType
         true, // valueList
         false, // propertyList
         types(JSTypes.typeRecurrenceRule),// elementType
         false, // object
         JSRecurrenceRulesFactory.class); // factoryClass

    type(JSTypes.typeRelation,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSRelationFactory.class); // factoryClass

    type(JSTypes.typeRelations,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeRelation), // elementType
         false, // object
         JSRelationsFactory.class); // factoryClass

    type(JSTypes.typeReplyTo,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSReplyToFactory.class); // factoryClass

    type(JSTypes.typeSendTo,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSSendToFactory.class); // factoryClass

    type(JSTypes.typeSignedDuration,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSSignedDurationFactory.class); // factoryClass

    type(JSTypes.typeString,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSStringFactory.class); // factoryClass

    type(JSTypes.typeStringArray,
         false, // requiresType
         true, // valueList
         false, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSStringArrayFactory.class); // factoryClass

    type(JSTypes.typeStrings,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSStringListFactory.class); // factoryClass

    type(JSTypes.typeTimeZone,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTimeZoneFactory.class); // factoryClass

    type(JSTypes.typeTimeZoneRule,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTimeZoneRuleFactory.class); // factoryClass

    type(JSTypes.typeTimeZones,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeTimeZone), // elementType
         false, // object
         JSTimeZoneFactory.class); // factoryClass

    // Internal types
    type(JSTypes.typeRoles,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         JSRolesFactory.class); // factoryClass

    type(JSTypes.typeTrigger,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeUnknownTrigger,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeUnsignedInt,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSUnsignedIntFactory.class); // factoryClass

    type(JSTypes.typeUnsignedIntArray,
         false, // requiresType
         true, // valueList
         false, // propertyList
         types(JSTypes.typeUnsignedInt), // elementType
         false, // object
         JSUnsignedIntArrayFactory.class); // factoryClass

    type(JSTypes.typeURI,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSURIFactory.class); // factoryClass

    type(JSTypes.typeUTCDateTime,
         false, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         JSUTCDateTimeFactory.class); // factoryClass

    type(JSTypes.typeAbsoluteTrigger,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeVirtualLocation,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSVirtualLocationFactory.class); // factoryClass

    type(JSTypes.typeVirtualLocations,
         false, // requiresType
         false, // valueList
         true, // propertyList
         types(JSTypes.typeVirtualLocation), // elementType
         false, // object
         JSVirtualLocationFactory.class); // factoryClass

    /* ===== valid for ============================== */

    validFor(JSPropertyNames.type, JSTypes.typeEvent, JSTypes.typeTask,
             JSTypes.typeGroup, JSTypes.typeAbsoluteTrigger,
             JSTypes.typeAlert, JSTypes.typeLink,
             JSTypes.typeLocation, JSTypes.typeOffsetTrigger,
             JSTypes.typeParticipant,
             JSTypes.typeRecurrenceRule, JSTypes.typeRelation,
             JSTypes.typeTimeZone, JSTypes.typeVirtualLocation);

    validFor(JSPropertyNames.acknowledged, JSTypes.typeAlert);

    validFor(JSPropertyNames.action, JSTypes.typeAlert);

    validFor(JSPropertyNames.alerts, JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.byDay, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byHour, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byMinute, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byMonth, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byMonthDay, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.bySecond, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.bySetPosition, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byWeekNo, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.byYearDay, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.calendarAddress, JSTypes.typeParticipant);
    validFor(JSPropertyNames.categories, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup,
             JSTypes.typeLocation);
    validFor(JSPropertyNames.cid, JSTypes.typeLink);
    validFor(JSPropertyNames.color, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.comments,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.contentType, JSTypes.typeLink);
    validFor(JSPropertyNames.coordinates, JSTypes.typeLocation);
    validFor(JSPropertyNames.count, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.created , JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.delegatedFrom, JSTypes.typeParticipant);
    validFor(JSPropertyNames.delegatedTo, JSTypes.typeParticipant);
    validFor(JSPropertyNames.description, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeLocation,
             JSTypes.typeVirtualLocation);
    validFor(JSPropertyNames.descriptionContentType, JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.display, JSTypes.typeLink);
    validFor(JSPropertyNames.due,  JSTypes.typeTask);
    validFor(JSPropertyNames.duration,  JSTypes.typeEvent);
    validFor(JSPropertyNames.email, JSTypes.typeParticipant);
    validFor(JSPropertyNames.entries, JSTypes.typeGroup);
    validFor(JSPropertyNames.estimatedDuration,  JSTypes.typeTask);
    validFor(JSPropertyNames.excluded,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.expectReply, JSTypes.typeParticipant);
    validFor(JSPropertyNames.firstDayOfWeek, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.freeBusyStatus,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.frequency, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.href, JSTypes.typeLink);
    validFor(JSPropertyNames.interval, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.invitedBy, JSTypes.typeParticipant);
    validFor(JSPropertyNames.keywords, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.kind, JSTypes.typeParticipant);
    validFor(JSPropertyNames.language, JSTypes.typeParticipant);
    validFor(JSPropertyNames.locale, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.localizations,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.locationId, JSTypes.typeParticipant);
    validFor(JSPropertyNames.locations,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.locationTypes, JSTypes.typeLocation);
    validFor(JSPropertyNames.memberOf, JSTypes.typeParticipant);
    validFor(JSPropertyNames.method,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.name, JSTypes.typeLocation,
             JSTypes.typeParticipant);
    validFor(JSPropertyNames.offset, JSTypes.typeOffsetTrigger);
    validFor(JSPropertyNames.participants,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.participationComment, JSTypes.typeParticipant);
    validFor(JSPropertyNames.participationStatus, JSTypes.typeParticipant);
    validFor(JSPropertyNames.priority,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.privacy,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.prodId, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.progress,  JSTypes.typeTask,
             JSTypes.typeParticipant);
    validFor(JSPropertyNames.progressUpdated, JSTypes.typeTask,
             JSTypes.typeParticipant);
    validFor(JSPropertyNames.recurrenceId,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.recurrenceOverrides,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.recurrenceRules,
             JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.rel, JSTypes.typeLink);
    validFor(JSPropertyNames.relatedTo, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeAlert);
    validFor(JSPropertyNames.relation, JSTypes.typeRelation);
    validFor(JSPropertyNames.relativeTo, JSTypes.typeOffsetTrigger,
             JSTypes.typeLocation);
    validFor(JSPropertyNames.replyTo,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.roles, JSTypes.typeParticipant);
    validFor(JSPropertyNames.rscale, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.scheduleAgent, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheduleSequence, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheduleUpdated, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheme, JSTypes.typeLink);
    validFor(JSPropertyNames.sendTo, JSTypes.typeParticipant);
    validFor(JSPropertyNames.sequence,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.showWithoutTime,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.size, JSTypes.typeLink);
    validFor(JSPropertyNames.skip, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.source, JSTypes.typeGroup);
    validFor(JSPropertyNames.start,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.status,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.timeZone, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeLocation);
    validFor(JSPropertyNames.timeZones,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.title, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup, JSTypes.typeLink);
    validFor(JSPropertyNames.trigger, JSTypes.typeOffsetTrigger,
             JSTypes.typeAbsoluteTrigger, JSTypes.typeUnknownTrigger,
             JSTypes.typeAlert);
    validFor(JSPropertyNames.uid, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.until, JSTypes.typeRecurrenceRule);
    validFor(JSPropertyNames.updated, JSTypes.typeEvent,
             JSTypes.typeTask, JSTypes.typeGroup);
    validFor(JSPropertyNames.uri,  JSTypes.typeVirtualLocation);
    validFor(JSPropertyNames.useDefaultAlerts,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.virtualLocations,  JSTypes.typeEvent,
             JSTypes.typeTask);
    validFor(JSPropertyNames.when, JSTypes.typeAbsoluteTrigger);

    // Replace all contains values with immutable lists
    for (final var name: contains.keySet()) {
      final var val = contains.get(name);
      if (val != null) {
        contains.put(name, List.copyOf(val));
      }
    }
  }

  private static void ptype(final String name,
                            final String type) {
    ptypes.put(name, type);
  }

  private static void type(final String typeName,
                           final boolean requiresType,
                           final boolean valueList,
                           final boolean propertyList,
                           final String[] elementType,
                           final boolean object,
                           final Class<? extends JSValueFactory> factoryClass) {
    types.put(typeName,
              new JSTypeInfo(typeName, requiresType, valueList, propertyList,
                             elementType, object, factoryClass));
  }

  private static void validFor(final String name,
                               final String... types) {
    validFor.put(name, List.of(types));

    for (final var type: types) {
      final List<String> contained =
              contains.computeIfAbsent(type,
                                       k -> new ArrayList<>());
      contained.add(name);
    }
  }

  private static String[] types(final String... types) {
    return types;
  }

  @Override
  public String getRegistrationName() {
    return registrationName;
  }

  @Override
  public Set<String> propertyNames() {
    return ptypes.keySet();
  }

  @Override
  public String getType(final String propertyName) {
    return ptypes.get(propertyName);
  }

  /**
   *
   * @param name of type
   * @return type information - null if unknown type
   */
  public JSTypeInfo getTypeInfo(final String name) {
    return types.get(name);
  }

  static List<String> getValidFor(final String name) {
    return validFor.get(name);
  }

  static List<String> getContained(final String name) {
    return contains.get(name);
  }
}
