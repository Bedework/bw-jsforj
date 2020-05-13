/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.impl.values.JSEventImpl;
import org.bedework.jsforj.impl.values.JSGroupImpl;
import org.bedework.jsforj.impl.values.JSTaskImpl;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTask;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.UnsignedInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

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

  private final static Map<Class<?>, JSValueFactory> valueFactories =
          new HashMap<>();

  public static JSFactory getFactory() {
    return factory;
  }

  public JSCalendarObject makeCalObj(final JsonNode nd) {
    if (!nd.isObject()) {
      throw new RuntimeException("Not a calendar object");
    }

    final String type = factory.getType(nd);

    switch (type) {
      case JSTypes.typeJSEvent:
        return parseEvent(nd);
      case JSTypes.typeJSTask:
        return parseTask(nd);
      case JSTypes.typeJSGroup:
        return parseGroup(nd);
      default:
        throw new RuntimeException(
                "Unknown or unsupported type: " +
                        type);
    }
  }

  public JSValue makePropertyValue(final String propertyName,
                                   final JsonNode nd) {
    var typeInfo = JSPropertyAttributes.getPropertyTypeInfo(propertyName);

    final String type;
    if (typeInfo == null) {
      if ((nd == null) || (!nd.isObject())) {
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

    return newValue(type, nd);
  }

  public JSValue makePropertyValueWithType(final String type,
                                           final JsonNode nd) {
    return newValue(type, nd);
  }

  /** Create a string property
   *
   * @param propertyName of property
   * @param value String
   * @return the property
   */
  public JSProperty makeProperty(final String propertyName,
                                 final String value) {
    var node = new TextNode(value);

    return makeProperty(propertyName, node);
  }

  /** Create an UnsignedInteger property
   *
   * @param propertyName of property
   * @param value UnsignedInteger
   * @return the property
   */
  public JSProperty makeProperty(final String propertyName,
                                 final UnsignedInteger value) {
    var node = new IntNode(value.get());

    return makeProperty(propertyName, node);
  }

  /** Create an Integer property
   *
   * @param propertyName of property
   * @param value Integer
   * @return the property
   */
  public JSProperty makeProperty(final String propertyName,
                                 final Integer value) {
    var node = new IntNode(value);

    return makeProperty(propertyName, node);
  }

  /** Create a boolean property
   *
   * @param propertyName of property
   * @param value true/false
   * @return the property
   */
  public JSProperty makeProperty(final String propertyName,
                                 final boolean value) {
    JsonNode node;

    if (value) {
      node = BooleanNode.getTrue();
    } else {
      node = BooleanNode.getFalse();
    }

    return makeProperty(propertyName, node);
  }

  public JSProperty makeProperty(final String propertyName) {
    return makeProperty(propertyName, (JsonNode)null);
  }

  public JSProperty makeProperty(final String propertyName,
                                 final JsonNode nd) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makePropertyValue(propertyName, nd);

    return new JSPropertyImpl(propertyName, value);
  }

  /** Used for the situations where we have no @type - path objects.
   * These are used for overrides and localizations.
   *
   * @param propertyName the name of the property
   * @param type the type the value it needs to be
   * @param nd the node with the value
   * @return a new property
   */
  public JSProperty makeProperty(final String propertyName,
                                 final String type,
                                 final JsonNode nd) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makePropertyValueWithType(type, nd);

    return new JSPropertyImpl(propertyName, value);
  }

  public JSProperty makeProperty(final String propertyName,
                                 final JSValue value) {
    return new JSPropertyImpl(propertyName, value);
  }

  public JSValue newStringValue(final String val) {
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

  public JSValue newValue(final String type) {
    return newValue(type, (JsonNode)null);
  }

  public JSValue newValue(final String type,
                          final JsonNode node) {
    final var typeInfo = JSPropertyAttributes.getTypeInfo(type);
    var theNode = node;

    if (typeInfo == null) {
      if (theNode == null) {
        theNode = new ObjectNode(JsonNodeFactory.instance);
      }
      return new JSValueImpl(type, theNode);
    }

    final var factoryClass = typeInfo.getFactoryClass();

    if (theNode == null) {
      if (typeInfo.getObject() || typeInfo.getPropertyList()) {
        theNode = new ObjectNode(JsonNodeFactory.instance);
      } else if (typeInfo.getValueList()) {
        theNode = new ArrayNode(JsonNodeFactory.instance);
      }
    }

    if (factoryClass == null) {
      // Use generic class.
      if (theNode == null) {
        theNode = new ObjectNode(JsonNodeFactory.instance);
      }
      return new JSValueImpl(type, theNode);
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

    return vfactory.newValue(type, theNode);
  }

  public String getType(final JsonNode nd) {
    final JsonNode typeNode = nd.get(JSPropertyNames.type);

    if (typeNode == null) {
      throw new RuntimeException("No @type for calendar object: " + nd);
    }

    if (!typeNode.isTextual()) {
      throw new RuntimeException("Wrong type for @type");
    }

    return typeNode.asText();
  }

  private JSEvent parseEvent(final JsonNode nd) {
    final JSEventImpl ent = new JSEventImpl(JSTypes.typeJSEvent,
                                            nd);

    //parseProperties(ent, nd);

    return ent;
  }

  private JSTask parseTask(final JsonNode nd) {
    final JSTaskImpl ent = new JSTaskImpl(JSTypes.typeJSTask,
                                          nd);

    //parseProperties(ent, nd);

    return ent;
  }

  private JSGroup parseGroup(final JsonNode nd) {
    final JSGroupImpl ent = new JSGroupImpl(JSTypes.typeJSGroup,
                                            nd);

    //parseProperties(ent, nd);

    return ent;
  }
}
