/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSParticipants extends JSList<JSProperty> {
  /** Create and add a new participant object with a random uuid as key
   *
   */
  JSProperty makeParticipant();

  /** Create and add a new participant object
   *
   * @param id - the id
   */
  JSProperty makeParticipant(String id);
}
