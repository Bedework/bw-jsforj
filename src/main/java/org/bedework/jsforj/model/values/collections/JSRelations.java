/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSRelations extends JSList<JSProperty> {
  /** Create and add a new relation object
   *
   * @param uid - the target uid
   */
  JSProperty makeRelation(String uid);
}
