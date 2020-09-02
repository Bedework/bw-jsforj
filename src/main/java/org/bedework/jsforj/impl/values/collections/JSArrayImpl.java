/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.collections.JSArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public abstract class JSArrayImpl<T extends JSValue> extends JSValueImpl
        implements JSArray<T> {
  public JSArrayImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  /**
   *
   * @param val external representation
   * @return internal representation (json field name)
   */
  protected abstract JsonNode convertToElement(T val);

  /**
   *
   * @param node representing the object
   * @return external representation
   */
  protected abstract T convertToT(JsonNode node);

  @Override
  public void preWrite() {
    for (final var v: get()) {
      v.preWrite();
    }
  }

  @Override
  public int size() {
    assertArray("size");

    return getNode().size();
  }

  @Override
  public List<T> get() {
    assertArray("get");

    final var res = new ArrayList<T>(getNode().size());

    for (final var it = getNode().elements(); it.hasNext(); ) {
      res.add(convertToT(it.next()));
    }

    return res;
  }

  @Override
  public T get(final int index) {
    assertArray("get(i)");

    if ((index < 0) || (index >= getNode().size())) {
      throw new JsforjException("Index " + index +
              " out of bounds for " + getType());
    }

    /* Jackson apparently doesn't expose the field names as a
       list
     */

    final var node = (ArrayNode)getNode();
    return convertToT(node.get(index));
  }

  @Override
  public void add(final T val) {
    assertArray("add");

    final var node = (ArrayNode)getNode();

    node.add(convertToElement(val));
  }

  @Override
  public void remove(final int index) {
    assertArray("remove");

    if ((index < 0) || (index >= getNode().size())) {
      throw new JsforjException("Index " + index +
                                         " out of bounds for " + getType());
    }

    final var node = (ArrayNode)getNode();

    node.remove(index);
  }

  @Override
  public boolean remove(final T val) {
    assertArray("remove");

    final var node = (ArrayNode)getNode();
    for (int i = 0; i <= node.size(); i++) {
      final var elval = get(i);
      if (elval.equals(val)) {
        remove(i);
        return true;
      }
    }

    return false;
  }

  @Override
  public void clear() {
    assertArray("clear");

    final var node = (ArrayNode)getNode();
    node.removeAll();
  }
}
