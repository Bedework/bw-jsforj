/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values;

import java.util.List;

/** Represents the set of links
 *
 * User: mike Date: 4/3/20 Time: 21:50
 */
public interface JSLinks extends JSValue {
  /**
   *
   * @param link to add to collection
   */
  void add(JSLink link);

  /**
   *
   * @return list of JSLink - never null
   */
  List<JSLink> getAll();

  /**
   *
   * @return list of JSLink with given rel - never null
   */
  List<JSLink> getAll(final String rel);
}
