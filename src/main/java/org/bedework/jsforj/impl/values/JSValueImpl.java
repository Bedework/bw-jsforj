/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.JSPropertyAttributes;
import org.bedework.jsforj.impl.values.collections.JSArrayImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSUnsignedIntegerImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.dataTypes.JSString;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 10:35
 */
public class JSValueImpl implements JSValue {
  protected final static JSFactory factory = JSFactory.getFactory();

  private final String type;
  private final JSPropertyAttributes.TypeInfo typeInfo;

  // Parsed value
  private final JsonNode node;

  public JSValueImpl(final String type,
                     final JsonNode node) {
    if (node == null) {
      throw new JsforjException("Null node value");
    }
    if (type == null) {
      throw new JsforjException("Null value type for " + node);
    }

    this.type = type;
    this.node = node;
    typeInfo = JSPropertyAttributes.getTypeInfo(type);
//    if (typeInfo == null) {
//      throw new JsforjException("Null value typeInfo for type"
//                                         + type
//                                         + " and node " + node);
//    }
  }

  protected JSFactory getFactory() {
    return factory;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public boolean isArray() {
    if (typeInfo == null) {
      return node.isArray();
    }

    return this instanceof JSArrayImpl;
  }

  @Override
  public boolean isValueList() {
    if (typeInfo == null) {
      return node.isArray();
    }
    return typeInfo.getValueList();
  }

  @Override
  public List<JSValue> getValueList() {
    return null;
  }

  @Override
  public boolean isPropertyList() {
    if (typeInfo == null) {
      return node.isArray();
    }
    return typeInfo.getPropertyList();
  }

  @Override
  public List<JSProperty> getPropertyList() {
    assertObject("getPropertyList");

    // Exactly as get properties - except all the elements should have
    // constrained types

    final var props = new ArrayList<JSProperty>();
    final var nd = getNode();

    for (final var it = nd.fieldNames(); it.hasNext(); ) {
      final var fieldName = it.next();

      props.add(factory.makeProperty(fieldName,
                                     nd.get(fieldName)));
    }

    return Collections.unmodifiableList(props);
  }

  @Override
  public boolean isObject() {
    if (typeInfo == null) {
      return node.isObject();
    }
    return typeInfo.getObject();
  }

  @Override
  public List<JSProperty> getProperties() {
    if (!isObject()) {
      return Collections.emptyList();
    }

    final var props = new ArrayList<JSProperty>();
    final var nd = getNode();

    for (final var it = nd.fieldNames(); it.hasNext(); ) {
      final var fieldName = it.next();

      props.add(factory.makeProperty(fieldName,
                                     node.get(fieldName)));
    }

    return props;
  }

  @Override
  public <T extends JSValue> JSProperty<T> getProperty(
          final TypeReference<T> type,
          final String name) {
    assertObject("getProperty");

    final var pnode = node.get(name);

    if (pnode == null) {
      return null;
    }

    return (JSProperty<T>)factory.makeProperty(name, pnode);
  }

  @Override
  public void removeProperty(final String name) {
    assertObject("removeProperty");

    ((ObjectNode)node).remove(name);
  }

  @Override
  public void clear() {
    assertObject("clear");

    ((ObjectNode)node).removeAll();
  }

  @Override
  public <ValType extends JSValue> JSProperty<ValType> addProperty(
          final JSProperty<ValType> val) {
    assertObject("addProperty");

    final var name = val.getName();
    if (node.get(name) != null) {
      throw new JsforjException("Property " + name + " already present");
    }
    final var value = (JSValueImpl)val.getValue();
    ((ObjectNode)node).set(name, value.getNode());

    return val;
  }

  @Override
  public JSProperty<JSString> addProperty(final String name,
                                          final String val) {
    return addProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty<?> setProperty(final JSProperty<?> val) {
    final var name = val.getName();

    final var prop = getProperty(new TypeReference<>() {}, name);

    if (prop != null) {
      // Remove then add
      removeProperty(name);
    }

    return addProperty(val);
  }

  @Override
  public JSProperty<JSString> setProperty(final String name,
                                          final String val) {
    final var prop = getProperty(new TypeReference<>() {}, name);

    if (prop != null) {
      // Remove then add
      removeProperty(name);
    }

    return addProperty(name, val);
  }

  @Override
  public JSValue getPropertyValue(final String name) {
    final var prop = getProperty(new TypeReference<>() {}, name);

    if (prop == null) {
      return null;
    }

    return prop.getValue();
  }

  @Override
  public String getStringProperty(final String name) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop == null) {
      return null;
    }

    return prop.getValue().getStringValue();
  }

  @Override
  public void setNull(final String... name) {
    if ((name == null) || (name.length == 0)) {
      throw new JsforjException("Empty path");
    }
    final var pathsb = new StringBuilder();
    for (final var n: name) {
      if (pathsb.length() != 0) {
        pathsb.append("/");
      }
      pathsb.append(n);
    }

    final var path = pathsb.toString();

    final var prop = getProperty(new TypeReference<>() {},
                                 path);

    if (prop != null) {
      // Remove then add
      removeProperty(path);
    }

    ((ObjectNode)node).set(path, NullNode.getInstance());
  }

  @Override
  public boolean isString() {
    return node.isTextual();
  }

  @Override
  public JSProperty setProperty(final String name,
                                final JSUnsignedInteger val) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop != null) {
      // Remove then add
      removeProperty(name);
    }

    return addProperty(name, val);
  }

  @Override
  public JSProperty<?> addProperty(final String name,
                                   final JSUnsignedInteger val) {
    return addProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty<?> setProperty(final String name,
                                   final Integer val) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop != null) {
      // Remove then add
      removeProperty(name);
    }

    return addProperty(name, val);
  }

  @Override
  public JSProperty<?> setProperty(final String name,
                                   final boolean val) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop != null) {
      if (prop.getValue().getBooleanValue() == val) {
        return prop;
      }
      // Remove then add
      removeProperty(name);
    }

    return addProperty(name, val);
  }

  @Override
  public JSProperty addProperty(final String name,
                                final Integer val) {
    return addProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty addProperty(final String name,
                                final boolean val) {
    return addProperty(factory.makeProperty(name, val));
  }

  @Override
  public <T extends JSValue> JSProperty<T> makeProperty(
          final TypeReference<T> typeRef,
          final String name,
          final String type) {
    final JSProperty<T> p =
            getFactory().makeProperty(name,
                                      type,
                                      null);
    addProperty(p);

    return p;
  }

  @Override
  public JSUnsignedInteger getUnsignedIntegerProperty(final String name) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop == null) {
      return null;
    }

    final var val = ((JSValueImpl)prop.getValue()).getNode();
    return new JSUnsignedIntegerImpl(val.intValue());
  }

  @Override
  public String getStringValue() {
    if (node.isTextual()) {
      return node.textValue();
    }

    throw new JsforjException("Not String value");
  }

  @Override
  public boolean getBooleanValue() {
    if (node.isBoolean()) {
      return node.asBoolean();
    }

    throw new JsforjException("Not boolean value");
  }

  @Override
  public void writeValue(final Writer wtr,
                           final ObjectMapper mapper) {
    try {
      mapper.writeValue(wtr, node);
    } catch (final Throwable t) {
      throw new JsforjException(t);
    }
  }

  @Override
  public String writeValueAsString(final ObjectMapper mapper) {
    try {
      return mapper.writeValueAsString(node);
    } catch (final JsonProcessingException e) {
      throw new JsforjException(e);
    }
  }

  @Override
  public String writeValueAsStringFormatted(final ObjectMapper mapper) {
    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
    } catch (final JsonProcessingException e) {
      throw new JsforjException(e);
    }
  }

  public JsonNode getNode() {
    return node;
  }

  protected <T extends JSValue> T getValue(
          final TypeReference<T> type,
                           final String pname,
                           final boolean create) {
    JSProperty<T> p = getProperty(new TypeReference<>() {}, pname);

    if (p == null) {
      if (!create) {
        return null;
      }

      p = addProperty(factory.makeProperty(pname));
    }

    return p.getValue();
  }

  protected void assertStringNode() {
    if (node == null) {
      throw new JsforjException("Null node for type: "
                                         + type);
    }

    if (node.isTextual()) {
      return;
    }

    throw new JsforjException("Not String value. Type: "
                                       + type);
  }

  protected void assertIntNode() {
    if (node == null) {
      throw new JsforjException("Null node for type: "
                                         + type);
    }

    if (node.isInt()) {
      return;
    }

    throw new JsforjException("Not int value. Type: "
                                       + type);
  }

  protected void assertObject(final String action) {
    if (node.isObject()) {
      return;
    }
    if (action == null) {
      throw new JsforjException("Not object value. Type: "
                                         + type);
    }

    throw new JsforjException("Not object value. Type: "
                                       + type + " action: " + action);
  }

  protected void assertArray(final String action) {
    if (node.isArray()) {
      return;
    }
    if (action == null) {
      throw new JsforjException("Not array value. Type: "
                                         + type);
    }

    throw new JsforjException("Not array value. Type: "
                                       + type + " action: " + action);
  }
}
