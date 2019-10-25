/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
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

  public JSProperty makeProperty(final String name,
                                  final JsonNode nd) {
    var typeInfo = JSPropertyAttributes.getTypeInfo(name);

    final String type;
    if (typeInfo == null) {
      if (!nd.isObject()) {
        type = JSTypes.typeUnknown;
      } else {
        type = getType(nd);
      }
    } else {
      var types = typeInfo.getTypes();
      if (types.size() == 1) {
        type = types.get(0);
      } else {
        // Better be object
        if (!nd.isObject()) {
          throw new RuntimeException("Cannot determine type for " + nd);
        }

        type = getType(nd);
        if (!types.contains(type)) {
          throw new RuntimeException("Invalid type for " + nd);
        }
      }
    }

    var value = newObjectValue(type, nd);
    return newProperty(name, value);
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

  public JSValue newObjectValue(final String type,
                                final JsonNode node) {
    return new JSValueImpl(type, node);
  }

  public String getType(final JsonNode nd) {
    final JsonNode typeNode = nd.get(JSPropertyNames.type);

    if (typeNode == null) {
      throw new RuntimeException("No @type for calendar object");
    }

    if (!typeNode.isTextual()) {
      throw new RuntimeException("Wrong type for @type");
    }

    return typeNode.asText();
  }
}
