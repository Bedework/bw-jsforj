package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSList;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSParticipant extends JSValue {
  void setName(String val);

  String getName();

  void setEmail(String val);

  String getEmail();

  void setKind(String val);

  String getKind();

  void setLocationId(String val);

  String getLocationId();

  void setLanguage(String val);

  String getLanguage();

  void setParticipationComment(String val);

  String getParticipationComment();

  void setParticipationStatus(String val);

  String getParticipationStatus();

  void setScheduleAgent(String val);

  String getScheduleAgent();

  void setInvitedBy(String val);

  String getInvitedBy();

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getRoles(boolean create);
}
