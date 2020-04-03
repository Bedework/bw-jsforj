package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSCalendarObject;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSOverride extends JSCalendarObject {
  void setRecurrenceId(final String val);

  String getRecurrenceId();

  void setMaster(final JSCalendarObject val);

  JSCalendarObject getMaster();
}
