/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.collections.JSIdMap;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: mike Date: 1/20/21 Time: 18:03
 */
public abstract class JSIdMapImpl<K, E extends JSValue>
        extends JSMapImpl<K, E>
        implements JSIdMap<K, E> {
  private final AtomicInteger idCtr = new AtomicInteger();

  public JSIdMapImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  public String nextId() {
    return String.valueOf(idCtr.incrementAndGet());
  }
}
