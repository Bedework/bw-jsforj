/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.collections.JSList;

import java.util.List;

/** Represents the set of links
 *
 * User: mike Date: 4/3/20 Time: 21:50
 */
public interface JSLinks extends JSList<JSProperty> {
  /**
   *
   * @return list of JSLink with given rel - never null
   */
  List<JSLink> getAll(final String rel);

  JSProperty makeLink(final String href);
}
