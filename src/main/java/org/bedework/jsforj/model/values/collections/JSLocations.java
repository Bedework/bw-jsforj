/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSLocations extends JSList<JSProperty> {
  /** Create and add a new location object
   *
   * @param id - the id
   */
  JSProperty makeLocation(String id);
}
