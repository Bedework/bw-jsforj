/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.collections.JSAlerts;
import org.bedework.jsforj.model.values.collections.JSLinks;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSLocations;
import org.bedework.jsforj.model.values.collections.JSParticipants;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.collections.JSRecurrenceRules;
import org.bedework.jsforj.model.values.collections.JSRelations;
import org.bedework.jsforj.model.values.collections.JSReplyTo;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:09
 */
public class JSCalendarObjectImpl extends JSValueImpl
        implements JSCalendarObject {
  public JSCalendarObjectImpl(final String type,
                              final JsonNode node) {
    super(type, node);
    if (JSTypes.typeOverride.equals(type)) {
      return; // No type for overrides
    }
    setProperty(JSPropertyNames.type, type);
  }

  @Override
  public void setUid(final String val) {
    if (getUid() != null) {
      throw new JsforjException("uid is immutable");
    }

    setProperty(factory.makeProperty(JSPropertyNames.uid,
                                     val));
  }

  @Override
  public String getUid() {
    return getStringProperty(JSPropertyNames.uid);
  }

  @Override
  public void setDescription(final String val) {
    setProperty(factory.makeProperty(JSPropertyNames.description,
                                     val));
  }

  @Override
  public String getDescription() {
    return getStringProperty(JSPropertyNames.description);
  }

  @Override
  public void setTitle(final String val) {
    setProperty(factory.makeProperty(JSPropertyNames.title,
                                     val));
  }

  @Override
  public String getTitle() {
    return getStringProperty(JSPropertyNames.title);
  }

  @Override
  public void setRecurrenceId(final JSLocalDateTime val) {
    if (getRecurrenceId() != null) {
      throw new JsforjException("recurrenceId is immutable");
    }
    setProperty(factory.makeProperty(JSPropertyNames.recurrenceId, val));
  }

  @Override
  public JSLocalDateTime getRecurrenceId() {
    return (JSLocalDateTime)getPropertyValue(JSPropertyNames.recurrenceId);
  }

  @Override
  public JSAlerts getAlerts(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.alerts, create);
  }

  /*
  @Override
  public void addComment(final String val) {
    getComments(true).add(val);
  }

  @Override
  public JSArray<String> getComments(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.comments,
                    create);
  }

  @Override
  public void clearComments() {
    if (getComments(false) != null) {
      removeProperty(JSPropertyNames.comments);
    }
  }
   */

  @Override
  public JSList<String> getKeywords(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.keywords, create);
  }

  @Override
  public JSLinks getLinks(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.links, create);
  }

  @Override
  public JSLocations getLocations(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.locations, create);
  }

  @Override
  public JSParticipants getParticipants(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.participants, create);
  }

  @Override
  public JSRecurrenceRules getExcludedRecurrenceRules(
          final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.excludedRecurrenceRules, create);
  }

  @Override
  public JSRecurrenceRules getRecurrenceRules(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.recurrenceRules, create);
  }

  @Override
  public JSReplyTo getReplyTo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.replyTo, create);
  }

  @Override
  public JSRecurrenceOverrides getOverrides(final boolean create) {
    final JSRecurrenceOverrides ovs =
            getValue(new TypeReference<>() {},
                     JSPropertyNames.recurrenceOverrides, create);
    if (ovs != null) {
      ovs.setMaster(this);
    }
    return ovs;
  }

  @Override
  public JSRelations getRelatedTo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.relatedTo, create);
  }
}
