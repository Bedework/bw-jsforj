package org.bedework.jsforj.model;

import org.bedework.jsforj.model.values.JSValue;
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

/** Top level objects
 *
 * User: mike Date: 10/23/19 Time: 16:46
 */
public interface JSCalendarObject extends JSValue {
  /**
   *
   * @param val the uid
   * throws JsforjException if value already present
   */
  void setUid(String val);

  /**
   *
   * @return uid or null if none set
   */
  String getUid();

  /**
   *
   * @param val the recurrence id
   * throws JsforjException if value already present or not override
   */
  void setRecurrenceId(JSLocalDateTime val);

  /**
   *
   * @return Recurrence id or null if none set
   */
  JSLocalDateTime getRecurrenceId();

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return list of alerts
   */
  JSAlerts getAlerts(boolean create);

  /*
  void addComment(String val);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return list of comments
   * /
  JSArray<String> getComments(boolean create);

  /** Remove all comments
   *
   * /
  void clearComments();
     */

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getKeywords(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSLinks object - never null if create true
   */
  JSLinks getLinks(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSLocations object - never null if create true
   */
  JSLocations getLocations(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return recurrences object
   */
  JSRecurrenceOverrides getOverrides(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return participants object
   */
  JSParticipants getParticipants(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return recurrence rules object
   */
  JSRecurrenceRules getExcludedRecurrenceRules(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return recurrence rules object
   */
  JSRecurrenceRules getRecurrenceRules(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return replyTo object
   */
  JSReplyTo getReplyTo(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return relations object
   */
  JSRelations getRelatedTo(boolean create);
}
