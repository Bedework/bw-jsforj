package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSCalendarObject;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSOverride extends JSPatchObject, JSCalendarObject {
  void setMaster(final JSCalendarObject val);

  JSCalendarObject getMaster();
}
