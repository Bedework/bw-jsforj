/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSOverride;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSRecurrenceOverrides
        extends JSList<JSProperty<JSOverride>> {
  void setMaster(JSCalendarObject val);

  JSCalendarObject getMaster();

  /** Create and add a new override object
   *
   * @param rid - the recurrenceId
   */
  JSProperty<JSOverride> makeOverride(String rid);
}
