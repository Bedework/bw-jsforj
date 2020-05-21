/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSRecurrenceOverrides
        extends JSMap<JSLocalDateTime, JSOverride> {
  void setMaster(JSCalendarObject val);

  JSCalendarObject getMaster();
}
