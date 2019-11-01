/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.values.JSArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
    assertObject("size");

    return getNode().size();
  }

  @Override
  public List<T> get() {
    assertObject("get");

    final var res = new ArrayList<T>(getNode().size());

    for (var it = getNode().fieldNames(); it.hasNext(); ) {
      res.add(convertToT(it.next()));
    }

    return res;
  }

  @Override
  public T get(final int index) {
    assertObject("get(i)");

    if ((index < 0) || (index >= getNode().size())) {
      throw new RuntimeException("Index " + index +
              " out of bounds for " + getType());
    }

    /* Jackson apparently doesn't expose the field names as a
       list
     */

    var it = getNode().fieldNames();
    String fld = null;
    for (int i = 0; i <= index; i++) {
      fld = it.next();
    }

    return convertToT(fld);
  }

  @Override
  public void add(final T val) {
    assertObject("add");

    var node = (ObjectNode)getNode();

    node.put(convertToString(val), true);
  }

  @Override
  public void remove(final T val) {
    assertObject("remove");

    String fldName = convertToString(val);

    var node = (ObjectNode)getNode();
    node.remove(fldName);
  }
}
