/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSParticipant;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSParticipants
        extends JSMap<String, JSParticipant> {
  /** Create and add a new participant object with a random uuid as key
   *
   */
  JSProperty<JSParticipant> makeParticipant();
}
