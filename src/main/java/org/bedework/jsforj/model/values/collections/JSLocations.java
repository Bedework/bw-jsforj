/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSLocation;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSLocations
        extends JSList<JSProperty<JSLocation>> {
  /** Create and add a new location object with a random uuid as key
   *
   */
  JSProperty<JSLocation> makeLocation();

  /** Create and add a new location object
   *
   * @param id - the id
   */
  JSProperty<JSLocation> makeLocation(String id);
}
