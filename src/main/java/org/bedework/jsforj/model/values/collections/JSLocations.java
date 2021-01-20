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
        extends JSMap<String, JSLocation> {
  /** Create and add a new location object with a small integer as key
   *
   */
  JSProperty<JSLocation> makeLocation();
}
