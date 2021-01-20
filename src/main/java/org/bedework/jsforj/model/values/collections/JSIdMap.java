package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 1/20/21 Time: 18:01
 */
public interface JSIdMap<K, E extends JSValue>
        extends JSMap<K, E>  {
  /**
   * @return a small unique id
   */
  String nextId();
}
