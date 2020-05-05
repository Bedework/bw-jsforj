package org.bedework.jsforj.model;

import org.bedework.jsforj.model.values.JSLinks;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.collections.JSArray;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.collections.JSRelations;

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
   * @return recurrences object
   */
  JSRecurrenceOverrides getOverrides(boolean create);

  /** Remove all overrides
   *
   */
  void clearOverrides();

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return relations object
   */
  JSRelations getRelations(boolean create);
}
