package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSList;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSRelation extends JSValue {
  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSList<String> object - never null if create true
   */
  JSList<String> getRelations(boolean create);
}
