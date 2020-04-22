/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;

import java.util.List;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSRecurrenceOverrides extends JSValue {
  void setMaster(JSCalendarObject val);

  JSCalendarObject getMaster();

  List<JSProperty> getOverrides();

  /** Adds an already existing override object
   *
   * @param val property with name as recurrenceId
   */
  void addOverride(JSProperty val);

  /** Create a new override object
   *
   * @param rid - the recurrenceId
   */
  JSProperty addOverride(String rid);
}
