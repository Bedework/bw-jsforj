/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSLinks;
import org.bedework.jsforj.model.values.JSLocalDateTime;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.collections.JSArray;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSLocations;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.collections.JSRelations;

import com.fasterxml.jackson.databind.JsonNode;

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
  public void setRecurrenceId(final JSLocalDateTime val) {
    if (getRecurrenceId() != null) {
      throw new RuntimeException("recurrenceId is immutable");
    }
    addProperty(factory.makeProperty(JSPropertyNames.recurrenceId, val));
  }

  @Override
  public JSLocalDateTime getRecurrenceId() {
    return (JSLocalDateTime)getPropertyValue(JSPropertyNames.recurrenceId);
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
  public JSList<String> getKeywords(final boolean create) {
    final JSProperty keywords = getProperty(JSPropertyNames.keywords);

    if (keywords != null) {
      return (JSList<String>)keywords.getValue();
    }

    if (!create) {
      return null;
    }

    return (JSList<String>)addProperty(
            factory.makeProperty(JSPropertyNames.keywords)).getValue();
  }

  @Override
  public JSLinks getLinks(final boolean create) {
    final JSProperty links = getProperty(JSPropertyNames.links);

    if (links != null) {
      return (JSLinks)links.getValue();
    }

    if (!create) {
      return null;
    }

    return (JSLinks)addProperty(
            factory.makeProperty(JSPropertyNames.links)).getValue();
  }

  @Override
  public JSLocations getLocations(final boolean create) {
    final JSProperty p = getProperty(JSPropertyNames.locations);

    if (p != null) {
      return (JSLocations)p.getValue();
    }

    if (!create) {
      return null;
    }

    return (JSLocations)addProperty(
            factory.makeProperty(JSPropertyNames.locations)).getValue();
  }

  @Override
  public JSRecurrenceOverrides getOverrides(final boolean create) {
    JSProperty ovsp =
            getProperty(JSPropertyNames.recurrenceOverrides);

    if (ovsp == null) {
      if (!create) {
        return null;
      }

      ovsp = addProperty(
              factory.makeProperty(JSPropertyNames.recurrenceOverrides));
    }

    final JSRecurrenceOverrides ovs =
            (JSRecurrenceOverrides)ovsp.getValue();

    ovs.setMaster(this);
    return ovs;
  }

  @Override
  public void clearOverrides() {
    removeProperty(JSPropertyNames.recurrenceOverrides);
  }

  @Override
  public JSRelations getRelations(final boolean create) {
    JSProperty relsp =
            getProperty(JSPropertyNames.relatedTo);

    if (relsp == null) {
      if (!create) {
        return null;
      }

      relsp = addProperty(
              factory.makeProperty(JSPropertyNames.relatedTo));
    }

    return (JSRelations)relsp.getValue();
  }
}
