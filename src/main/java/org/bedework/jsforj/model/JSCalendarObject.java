package org.bedework.jsforj.model;

import org.bedework.jsforj.model.values.JSArray;
import org.bedework.jsforj.model.values.JSLinks;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.JSValue;

/** Top level objects
 *
 * User: mike Date: 10/23/19 Time: 16:46
 */
public interface JSCalendarObject extends JSValue {
  /**
   *
   * @param val the uid
   * @throws RuntimeException if value already present
   */
  void setUid(final String val);

  /**
   *
   * @return uid or null if none set
   */
  String getUid();

  void addParticipant(String uid, JSParticipant part);

  void addComment(String val);

  /**
   *
   * @return list of comments - never null
   */
  JSArray<String> getComments();

  /** Remove all comments
   *
   */
  void clearComments();

  /**
   *
   * @return JSLinks object - never null if create true
   */
  JSLinks getLinks(boolean create);

  /**
   *
   * @return list of JSOverride - never null
   */
  JSRecurrenceOverrides getOverrides();

  /** Remove all overrides
   *
   */
  void clearOverrides();
}
