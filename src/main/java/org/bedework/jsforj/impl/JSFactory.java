/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.JSValue;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 10:51
 */
public class JSFactory {
  final static JsonNodeFactory nodeFactory =
          JsonNodeFactory.withExactBigDecimals(false);

  /** Used to create a property
   *
   *
   * @param name of the property
   * @param value of the property
   * @return new property instance
   * @throws RuntimeException if type or value not compatible
   */
  public JSProperty newProperty(String name,
                                JSValue value) {
    return new JSPropertyImpl(name, value);
  }

  public JSValue newValue(final String val) {
    return new JSValueImpl(JSTypes.typeString,
                           nodeFactory.textNode(val));
  }

  public JSValue newValue(final String type,
                          final List<JSValue> val) {
    final ArrayNode nd = nodeFactory.arrayNode(val.size());

    for (final var el: val) {
      nd.add(((JSValueImpl)el).getNode());
    }

    return new JSValueImpl(type, nd);
  }

  public JSValue newObjectValue(final String type) {
    return new JSValueImpl(type, nodeFactory.objectNode());
  }
}
