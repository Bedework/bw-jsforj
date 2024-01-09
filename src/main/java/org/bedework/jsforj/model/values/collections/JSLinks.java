/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSLink;

import java.net.URI;
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
  List<JSProperty<JSLink>> getAll(String rel);

  /** Create and add a new link object with a random uuid as key
   *
   */
  JSProperty<JSLink> makeLink();

  /** Try to find the link object with the given href
   *
   */
  JSProperty<JSLink> findLink(URI href);
}
