/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSArray;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.JSParticipant;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 17:09
 */
public class JSCalendarObjectImpl extends JSValueImpl
        implements JSCalendarObject {
  public JSCalendarObjectImpl(final String type,
                              final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setUid(final String val) {
    if (getUid() != null) {
      throw new RuntimeException("uid is immutable");
    }

    addProperty(factory.makeProperty(JSPropertyNames.uid,
                                     val));
  }

  @Override
  public String getUid() {
    return getStringProperty(JSPropertyNames.uid);
  }

  @Override
  public void addParticipant(final String uid,
                             final JSParticipant part) {
    JSProperty participants = getProperty(JSPropertyNames.participants);

    if (participants == null) {
      participants = addProperty(
              factory.makeProperty(JSPropertyNames.participants));
    }

    participants.getValue().addProperty(factory.makeProperty(uid, part));
  }

  @Override
  public void addComment(final String val) {
    getComments().add(val);
  }

  @Override
  public JSArray<String> getComments() {
    return (JSArray<String>)getPropertyValueAlways(JSPropertyNames.comments);
  }

  @Override
  public void clearComments() {
    getComments().clear();
  }

  @Override
  public void addLink(final JSLink link) {
    final String href = link.getStringProperty(JSPropertyNames.href);
    if (href == null) {
      throw new RuntimeException("Href must be set for a link");
    }

    JSProperty links = getProperty(JSPropertyNames.links);

    if (links == null) {
      links = addProperty(
              factory.makeProperty(JSPropertyNames.links));
    }

    links.getValue().setProperty(factory.makeProperty(href, link));
  }

  @Override
  public List<JSLink> getLinks() {
    JSProperty links = getProperty(JSPropertyNames.links);

    final List<JSLink> res = new ArrayList<>();

    if (links == null) {
      return res;
    }

    for (final JSProperty prop: links.getValue().getPropertyList()) {
      res.add((JSLink)prop.getValue());
    }

    return res;
  }

  @Override
  public void clearLinks() {
    removeProperty(JSPropertyNames.links);
  }

  @Override
  public void addOverride(final JSOverride val) {
    final String rid = val.getRecurrenceId();
    if (rid == null) {
      throw new RuntimeException("Recurrenceid must be set for an override");
    }

    val.setMaster(this);

    JSProperty ovs = getProperty(JSPropertyNames.recurrenceOverrides);

    if (ovs == null) {
      ovs = addProperty(
              factory.makeProperty(JSPropertyNames.recurrenceOverrides));
    }

    ovs.getValue().setProperty(factory.makeProperty(rid, val));
  }

  @Override
  public List<JSOverride> getOverrides() {
    JSProperty ovs = getProperty(JSPropertyNames.recurrenceOverrides);

    final List<JSOverride> res = new ArrayList<>();

    if (ovs == null) {
      return res;
    }

    for (final JSProperty prop: ovs.getValue().getPropertyList()) {
      final JSOverride ov = (JSOverride)prop.getValue();
      ov.setMaster(this);
      res.add(ov);
    }

    return res;
  }

  @Override
  public void clearOverrides() {
    removeProperty(JSPropertyNames.recurrenceOverrides);
  }
}
