/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mike Date: 10/24/19 Time: 10:51
 */
public class JSFactory {
  private final static JSFactory factory = new JSFactory();

  private final static JsonNodeFactory nodeFactory =
          JsonNodeFactory.withExactBigDecimals(false);

  private final static Map<Class, JSValueFactory> valueFactories =
          new HashMap<>();

  public static JSFactory getFactory() {
    return factory;
  }

  public JSValue makeValue(final String name,
                              final JsonNode nd) {
    var typeInfo = JSPropertyAttributes.getPropertyTypeInfo(name);

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

    return newObjectValue(type, nd);
  }

  public JSProperty makeProperty(final String name,
                                 final JsonNode nd) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makeValue(name, nd);

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

  public JSValue newObjectValue(final String type,
                                final JsonNode node) {
    final var typeInfo = JSPropertyAttributes.getTypeInfo(type);

    if (typeInfo == null) {
      return new JSValueImpl(type, node);
    }

    final var factoryClass = typeInfo.getFactoryClass();

    if (factoryClass == null) {
      // Use generic class.
      return new JSValueImpl(type, node);
    }

    JSValueFactory vfactory = valueFactories.get(factoryClass);

    if (vfactory == null) {
      try {
        vfactory =
                (JSValueFactory)factoryClass
                        .getConstructor().newInstance();
      } catch (final Throwable t) {
        throw new RuntimeException(t);
      }

      valueFactories.put(factoryClass, vfactory);
    }

    return vfactory.newValue(type, node);
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
