/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.values.collections.JSArrayImpl;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSRoles;
import org.bedework.jsforj.model.values.collections.JSLinks;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSSendTo;
import org.bedework.jsforj.model.values.dataTypes.JSString;

import com.fasterxml.jackson.core.type.TypeReference;
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
    setProperty(JSPropertyNames.name, val);
  }

  @Override
  public String getName() {
    return getStringProperty(JSPropertyNames.name);
  }

  @Override
  public void setDescription(final String val) {
    setProperty(JSPropertyNames.description, val);
  }

  @Override
  public String getDescription() {
    return getStringProperty(JSPropertyNames.description);
  }

  @Override
  public void setEmail(final String val) {
    setProperty(JSPropertyNames.email, val);
  }

  @Override
  public String getEmail() {
    return getStringProperty(JSPropertyNames.email);
  }

  @Override
  public void setExpectReply(final boolean val) {
    setProperty(JSPropertyNames.expectReply, val);
  }

  @Override
  public boolean getExpectReply() {
    return getBooleanProperty(JSPropertyNames.expectReply);
  }

  @Override
  public void setKind(final String val) {
    setProperty(JSPropertyNames.kind, val);
  }

  @Override
  public String getKind() {
    return getStringProperty(JSPropertyNames.kind);
  }

  @Override
  public void setLocationId(final String val) {
    setProperty(JSPropertyNames.locationId, val);
  }

  @Override
  public String getLocationId() {
    return getStringProperty(JSPropertyNames.locationId);
  }

  @Override
  public void setLanguage(final String val) {
    setProperty(JSPropertyNames.language, val);
  }

  @Override
  public String getLanguage() {
    return getStringProperty(JSPropertyNames.language);
  }

  @Override
  public void setParticipationComment(final String val) {
    setProperty(JSPropertyNames.participationComment, val);
  }

  @Override
  public String getParticipationComment() {
    return getStringProperty(JSPropertyNames.participationComment);
  }

  @Override
  public void setParticipationStatus(final String val) {
    setProperty(JSPropertyNames.participationStatus, val);
  }

  @Override
  public String getParticipationStatus() {
    return getStringProperty(JSPropertyNames.participationStatus);
  }

  @Override
  public void setScheduleAgent(final String val) {
    setProperty(JSPropertyNames.scheduleAgent, val);
  }

  @Override
  public String getScheduleAgent() {
    return getStringProperty(JSPropertyNames.scheduleAgent);
  }

  @Override
  public void setScheduleForceSend(final String val) {
    setProperty(JSPropertyNames.scheduleForceSend, val);
  }

  @Override
  public String getScheduleForceSend() {
    return getStringProperty(JSPropertyNames.scheduleForceSend);
  }

  @Override
  public JSArrayImpl<JSString> getScheduleStatus(
          final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.scheduleStatus,
                    create);
  }

  @Override
  public JSSendTo getSendTo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.sendTo,
                    create);
  }

  @Override
  public void setInvitedBy(final String val) {
    setProperty(JSPropertyNames.invitedBy, val);
  }

  @Override
  public String getInvitedBy() {
    return getStringProperty(JSPropertyNames.invitedBy);
  }

  @Override
  public JSRoles getRoles(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.roles,
                    create);
  }

  @Override
  public JSList<String> getDelegatedTo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.delegatedTo,
                    create);
  }

  @Override
  public JSList<String> getDelegatedFrom(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.delegatedFrom,
                    create);
  }

  @Override
  public JSList<String> getMemberOf(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.memberOf,
                    create);
  }

  @Override
  public JSLinks getLinks(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.links,
                    create);
  }
}
