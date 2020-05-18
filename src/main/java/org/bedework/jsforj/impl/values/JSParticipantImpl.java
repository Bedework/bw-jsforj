/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.collections.JSList;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSParticipantImpl extends JSValueImpl
        implements JSParticipant {
  public JSParticipantImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setName(final String val) {
    addProperty(JSPropertyNames.name, val);
  }

  @Override
  public String getName() {
    return getStringProperty(JSPropertyNames.name);
  }

  @Override
  public void setDescription(final String val) {
    addProperty(JSPropertyNames.description, val);
  }

  @Override
  public String getDescription() {
    return getStringProperty(JSPropertyNames.description);
  }

  @Override
  public void setEmail(final String val) {
    addProperty(JSPropertyNames.email, val);
  }

  @Override
  public String getEmail() {
    return getStringProperty(JSPropertyNames.email);
  }

  @Override
  public void setKind(final String val) {
    addProperty(JSPropertyNames.kind, val);
  }

  @Override
  public String getKind() {
    return getStringProperty(JSPropertyNames.kind);
  }

  @Override
  public void setLocationId(final String val) {
    addProperty(JSPropertyNames.locationId, val);
  }

  @Override
  public String getLocationId() {
    return getStringProperty(JSPropertyNames.locationId);
  }

  @Override
  public void setLanguage(final String val) {
    addProperty(JSPropertyNames.language, val);
  }

  @Override
  public String getLanguage() {
    return getStringProperty(JSPropertyNames.language);
  }

  @Override
  public void setParticipationComment(final String val) {
    addProperty(JSPropertyNames.participationComment, val);
  }

  @Override
  public String getParticipationComment() {
    return getStringProperty(JSPropertyNames.participationComment);
  }

  @Override
  public void setParticipationStatus(final String val) {
    addProperty(JSPropertyNames.participationStatus, val);
  }

  @Override
  public String getParticipationStatus() {
    return getStringProperty(JSPropertyNames.participationStatus);
  }

  @Override
  public void setScheduleAgent(final String val) {
    addProperty(JSPropertyNames.scheduleAgent, val);
  }

  @Override
  public String getScheduleAgent() {
    return getStringProperty(JSPropertyNames.scheduleAgent);
  }

  @Override
  public void setInvitedBy(final String val) {
    addProperty(JSPropertyNames.invitedBy, val);
  }

  @Override
  public String getInvitedBy() {
    return getStringProperty(JSPropertyNames.invitedBy);
  }

  @Override
  public JSList<String> getRoles(final boolean create) {
    final JSProperty val = getProperty(JSPropertyNames.roles);

    if (val != null) {
      return (JSList<String>)val.getValue();
    }

    if (!create) {
      return null;
    }

    return (JSList<String>)addProperty(
            factory.makeProperty(JSPropertyNames.roles)).getValue();
  }
}
