/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.collections.JSList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public abstract class JSListImpl<T> extends JSValueImpl
        implements JSList<T> {
  public JSListImpl(final String type,
                    final JsonNode node) {
    super(type, node);
  }

  /**
   *
   * @param val external representation
   */
  protected abstract void store(T val);

  /**
   *
   * @param val external representation
   * @return field name
   */
  protected abstract String fieldName(T val);

  /**
   *
   * @param val json field name
   * @return external representation
   */
  protected abstract T convertToT(String val);

  @Override
  protected JSProperty<?> makeProperty(final String name,
                                       final JsonNode node) {
    return factory.makeProperty(name, node,
                                JSTypes.typeBoolean);
  }

  @Override
  public int size() {
    assertObject("size");

    return getNode().size();
  }

  @Override
  public List<T> get() {
    assertObject("get");

    final var res = new ArrayList<T>(getNode().size());
    final var node = (ObjectNode)getNode();

    for (final var it = node.fieldNames(); it.hasNext(); ) {
      res.add(convertToT(it.next()));
    }

    return Collections.unmodifiableList(res);
  }

  @Override
  public T get(final int index) {
    assertObject("get(i)");

    if ((index < 0) || (index >= getNode().size())) {
      throw new JsforjException("Index " + index +
              " out of bounds for " + getType());
    }

    /* Jackson apparently doesn't expose the field names as a
       list
     */

    final var node = (ObjectNode)getNode();
    final var it = node.fieldNames();

    String fld = null;
    for (int i = 0; i <= index; i++) {
      fld = it.next();
    }

    return convertToT(fld);
  }

  @Override
  public void add(final T val) {
    assertObject("add");

    store(val);
  }

  @Override
  public void remove(final T val) {
    assertObject("remove");

    final var node = (ObjectNode)getNode();
    node.remove(fieldName(val));
  }
}
