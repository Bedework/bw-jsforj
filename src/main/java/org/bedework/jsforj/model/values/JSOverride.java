package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSCalendarObject;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSOverride extends JSCalendarObject {
  /** Once set cannot be changed
   *
   * @param val
   */
  void setRecurrenceId(final JSLocalDateTime val);

  JSLocalDateTime getRecurrenceId();

  void setMaster(final JSCalendarObject val);

  JSCalendarObject getMaster();
}
