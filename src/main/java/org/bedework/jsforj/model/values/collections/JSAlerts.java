/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSAlert;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSAlerts
        extends JSMap<String, JSAlert> {
  /** Create and add a new alert object with a random uuid as key
   *
   */
  JSProperty<JSAlert> makeAlert();
}
