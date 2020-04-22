/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.collections.JSArray;
import org.bedework.jsforj.model.values.JSLinks;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;

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
  public JSRecurrenceOverrides getOverrides(final boolean create) {
    JSProperty ovsp =
            getProperty(JSPropertyNames.recurrenceOverrides);

    if (ovsp == null) {
      if (!create) {
        return null;
      }

      ovsp = addProperty(
              factory.makeProperty(JSPropertyNames.links));
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
}
