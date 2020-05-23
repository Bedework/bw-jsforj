/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSLink;

import java.util.List;

/** Represents the set of links
 *
 * User: mike Date: 4/3/20 Time: 21:50
 */
public interface JSLinks extends JSMap<String, JSLink> {
  /**
   *
   * @return list of JSLink with given rel - never null
   */
  List<JSProperty<JSLink>> getAll(final String rel);

  /** Create and add a new location object with a random uuid as key
   *
   */
  JSProperty<JSLink> makeLink();
}
