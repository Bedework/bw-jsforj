/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.values.JSArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public abstract class JSArrayImpl<T> extends JSValueImpl
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
  protected abstract String convertToString(final T val);

  /**
   *
   * @param val internal representation (json field name)
   * @return external representation
   */
  protected abstract T convertToT(final String val);

  @Override
  public int size() {
    assertArray("size");

    return getNode().size();
  }

  @Override
  public List<T> get() {
    assertArray("get");

    final var res = new ArrayList<T>(getNode().size());

    for (var it = getNode().fieldNames(); it.hasNext(); ) {
      res.add(convertToT(it.next()));
    }

    return res;
  }

  @Override
  public T get(final int index) {
    assertArray("get(i)");

    if ((index < 0) || (index >= getNode().size())) {
      throw new RuntimeException("Index " + index +
              " out of bounds for " + getType());
    }

    /* Jackson apparently doesn't expose the field names as a
       list
     */

    var node = (ArrayNode)getNode();
    return convertToT(node.get(index).asText());
  }

  @Override
  public void add(final T val) {
    assertArray("add");

    var node = (ArrayNode)getNode();

    node.add(convertToString(val));
  }

  @Override
  public void remove(final int index) {
    assertArray("remove");

    if ((index < 0) || (index >= getNode().size())) {
      throw new RuntimeException("Index " + index +
                                         " out of bounds for " + getType());
    }

    var node = (ArrayNode)getNode();

    node.remove(index);
  }

    @Override
  public boolean remove(final T val) {
    assertArray("remove");

    var node = (ArrayNode)getNode();
    for (int i = 0; i <= node.size(); i++) {
      var elval = get(i);
      if (elval.equals(val)) {
        remove(i);
        return true;
      }
    }

    return false;
  }

  public void clear() {
    assertArray("clear");

    var node = (ArrayNode)getNode();
    node.removeAll();
  }
}
