package org.bedework.jsforj.model.values;

import org.bedework.jsforj.impl.values.collections.JSArrayImpl;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSSendTo;
import org.bedework.jsforj.model.values.dataTypes.JSString;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSParticipant extends JSValue {
  /** A set of participant ids that this participant is acting as a
   delegate for.  Each key in the set MUST be the id of a
   participant.  The value for each key in the set MUST be true.  If
   there are no delegators, this MUST be omitted (rather than
   specified as an empty set).
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getDelegatedFrom(boolean create);

  /** A set of participant ids that this participant has delegated their
   participation to.  Each key in the set MUST be the id of a
   participant.  The value for each key in the set MUST be true.  If
   there are no delegates, this MUST be omitted (rather than
   specified as an empty set).
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getDelegatedTo(boolean create);

  void setDescription(String val);

  String getDescription();

  void setEmail(String val);

  String getEmail();

  /**
   * The RSVP parameter in 5545
   * @param val true if reply expected
   */
  void setExpectReply(boolean val);

  boolean getExpectReply();

  void setInvitedBy(String val);

  String getInvitedBy();

  void setKind(String val);

  String getKind();

  void setLocationId(String val);

  String getLocationId();

  void setLanguage(String val);

  String getLanguage();

  void setName(String val);

  String getName();

  void setParticipationComment(String val);

  String getParticipationComment();

  void setParticipationStatus(String val);

  String getParticipationStatus();

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSRoles getRoles(boolean create);

  void setScheduleAgent(String val);

  String getScheduleAgent();

  void setScheduleForceSend(String val);

  String getScheduleForceSend();

  JSArrayImpl<JSString> getScheduleStatus(boolean create);

  JSSendTo getSendTo(boolean create);

  /** A set of group participants that were invited to this calendar
  object, which caused this participant to be invited due to their
  membership in the group(s).  Each key in the set MUST be the id of
  a participant.  The value for each key in the set MUST be true.
  If there are no groups, this MUST be omitted (rather than
      specified as an empty set).
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getMemberOf(boolean create);

  /** A set of links to more information about this participant, for
  example in vCard format.  The keys in the set MUST be the id of a
  Link object in the calendar object's "links" property.  The value
          for each key in the set MUST be true.  If there are no links, this
  MUST be omitted (rather than specified as an empty set).
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getLinkIds(boolean create);
}
