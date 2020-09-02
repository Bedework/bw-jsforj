/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.JSRegistration;
import org.bedework.jsforj.JSTypeInfo;
import org.bedework.jsforj.JSValueFactory;
import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.impl.values.JSNullImpl;
import org.bedework.jsforj.impl.values.JSUnknownTypeImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.dataTypes.JSString;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.ArrayList;
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

  private final static List<JSRegistration> registrations =
          new ArrayList<>();

  static {
    register(new JSPropertyAttributes());
  }

  public static JSFactory getFactory() {
    return factory;
  }

  public static void register(final JSRegistration val) {
    registrations.add(val);
  }

  /**
   *
   * @param name of property
   * @return type name - null if unknown property
   */
  public static String getPropertyType(final String name) {
    for (final var registration: registrations) {
      final var ptype = registration.getType(name);
      if (ptype != null) {
        return ptype;
      }
    }

    return null;
  }

  /**
   *
   * @param name of type
   * @return type information - null if unknown type
   */
  public static JSTypeInfo getTypeInfo(final String name) {
    for (final var registration: registrations) {
      final var typeInfo = registration.getTypeInfo(name);
      if (typeInfo != null) {
        return typeInfo;
      }
    }

    return null;
  }

  /**
   * Creates objects which may be independent top level objects or
   * entries in a group.
   * @param nd
   * @return
   */
  public JSCalendarObject makeCalObj(final JsonNode nd) {
    if (!nd.isObject()) {
      throw new JsforjException("Not an object node");
    }

    final String type = getType(nd);

    try {
      return (JSCalendarObject)newValue(type, nd);
    } catch (final Throwable t) {
      throw new JsforjException(t);
    }
  }

  /**
   *
   * @param propertyName - may be a path
   * @param nd - representing value
   * @return the new value
   */
  public JSValue makePropertyValue(final String propertyName,
                                   final JsonNode nd,
                                   final String providedType) {
    final String theName;
    if (propertyName.contains("/")) {
      theName = JsonPointer.compile("/" + propertyName)
                           .last().getMatchingProperty();
    } else {
      theName = propertyName;
    }

    String type = getPropertyType(theName);

    if (type == null) {
      type = providedType;
    } else if ((providedType != null) &&
            !providedType.equals(type)) {
      throw new JsforjException("Mismatched types, expected: " +
              type + " provided: " + providedType);
    }
    if (type == null) {
      if ((nd == null) || (!nd.isObject())) {
        type = JSTypes.typeUnknown;
      } else {
        type = getType(nd);
      }
    } else {
      final var typeInfo = getTypeInfo(theName);
      if ((typeInfo != null) && typeInfo.getRequiresType()) {
        // Could validate here
        if (nd.isObject() && !type.equals(JSTypes.typePatchObject)) {
          final var ntype = getType(nd);
          if (type.equals(ntype)) {
            throw new JsforjException("Invalid type for ",
                                      nd.toString());
          }
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
  public JSProperty<JSString> makeProperty(final String propertyName,
                                           final String value) {
    final var node = new TextNode(value);

    return (JSProperty<JSString>)makeProperty(propertyName, node,
                                              JSTypes.typeString);
  }

  /** Create an UnsignedInteger property
   *
   * @param propertyName of property
   * @param value UnsignedInteger
   * @return the property
   */
  public JSProperty<?> makeProperty(final String propertyName,
                                    final JSUnsignedInteger value) {
    final var node = new IntNode(value.get());

    return makeProperty(propertyName, node,
                        JSTypes.typeUnsignedInt);
  }

  /** Create an Integer property
   *
   * @param propertyName of property
   * @param value Integer
   * @return the property
   */
  public JSProperty<?> makeProperty(final String propertyName,
                                    final Integer value) {
    final var node = new IntNode(value);

    return makeProperty(propertyName, node,
                        JSTypes.typeInt);
  }

  /** Create a boolean property
   *
   * @param propertyName of property
   * @param value true/false
   * @return the property
   */
  public JSProperty<?> makeProperty(final String propertyName,
                                    final boolean value) {
    final JsonNode node;

    if (value) {
      node = BooleanNode.getTrue();
    } else {
      node = BooleanNode.getFalse();
    }

    return makeProperty(propertyName, node,
                        JSTypes.typeBoolean);
  }

  public JSProperty<?> makeProperty(final String propertyName) {
    return makeProperty(propertyName, (JsonNode)null);
  }

  public JSProperty<?> makeProperty(final String propertyName,
                                    final JsonNode nd) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makePropertyValue(propertyName, nd, null);

    return new JSPropertyImpl<>(propertyName, value);
  }

  public JSProperty<?> makeProperty(final String propertyName,
                                    final JsonNode nd,
                                    final String providedType) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makePropertyValue(propertyName, nd, providedType);

    return new JSPropertyImpl<>(propertyName, value);
  }

  /** Used for the situations where we have no @type - path objects.
   * These are used for overrides and localizations.
   *
   * @param propertyName the name of the property
   * @param type the type the value it needs to be
   * @param nd the node with the value
   * @return a new property
   */
  public <ValClass extends JSValue> JSProperty<ValClass> makeProperty(
          final String propertyName,
          final String type,
          final JsonNode nd) {
    //final var pInfo = JSPropertyAttributes.getPropertyTypeInfo(name);
    final var value = makePropertyValueWithType(type, nd);

    return new JSPropertyImpl<>(propertyName, (ValClass)value);
  }

  public JSProperty<?> makeProperty(final String propertyName,
                                 final JSValue value) {
    return new JSPropertyImpl<>(propertyName, value);
  }

/*  public JSValue newStringValue(final String val) {
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
  }*/

  public JSValue newValue(final String type) {
    return newValue(type, (JsonNode)null);
  }

  public JSValue newValue(final String type,
                          final JsonNode node) {
    if (node instanceof NullNode) {
      return new JSNullImpl();
    }

    final var typeInfo = getTypeInfo(type);
    var theNode = node;

    if (typeInfo == null) {
      if (theNode == null) {
        theNode = new ObjectNode(JsonNodeFactory.instance);
      }
      return new JSUnknownTypeImpl(type, theNode);
    }

    final var factoryClass = typeInfo.getFactoryClass();

    if (theNode == null) {
      if (typeInfo.getObject() || typeInfo.getPropertyList()) {
        theNode = new ObjectNode(JsonNodeFactory.instance);
      } else if (typeInfo.getValueList()) {
        theNode = new ArrayNode(JsonNodeFactory.instance);
      } else {
        throw new JsforjException("Unable to create node for " +
                                           type);
      }
    }

    if (factoryClass == null) {
      return new JSUnknownTypeImpl(type, theNode);
    }

    JSValueFactory vfactory = valueFactories.get(factoryClass);

    if (vfactory == null) {
      try {
        vfactory =
                (JSValueFactory)factoryClass
                        .getConstructor().newInstance();
      } catch (final Throwable t) {
        throw new JsforjException(t);
      }

      valueFactories.put(factoryClass, vfactory);
    }

    return vfactory.newValue(type, theNode);
  }

  public String getType(final JsonNode nd) {
    final JsonNode typeNode = nd.get(JSPropertyNames.type);

    if (typeNode == null) {
      throw new JsforjException("No @type for calendar object: ",
                                nd.toString());
    }

    if (!typeNode.isTextual()) {
      throw new JsforjException("Wrong type for @type");
    }

    return typeNode.asText();
  }
}
