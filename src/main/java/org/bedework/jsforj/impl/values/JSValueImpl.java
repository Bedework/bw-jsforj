/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.values.dataTypes.JSUnsignedIntegerImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.dataTypes.JSString;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: mike Date: 10/24/19 Time: 10:35
 *
 * Provides a view of the current json node and allows updates
 * to that node.
 *
 * <p>
 * When handling overrides we interact with the masterCopy.
 * However the original node is still attached to the parent
 * so will be output when serializing the object.
 * </p>
 *
 * <p>
 *   When we update an override we need to update the original
 *   node with the appropriate patches.
 * </p>
 */
public abstract class JSValueImpl implements JSValue {
  protected final static JSFactory factory = JSFactory.getFactory();

  protected final String type;

  // Parsed or updated value
  private JsonNode node;

  // This is set when processing overrides.
  private JsonNode masterCopy;

  private JSProperty<?> parentProperty;

  /* childProperties is only updated when a property is modified or
     removed.
   */
  private final Map<String, JSProperty<?>> childProperties =
          new HashMap<>();

  private JSValue owner;

  private boolean changed;

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
  }

  /**
   * Only used for proxies.
   */
  protected JSValueImpl() {
    type = null;
    node = null;
  }

  public String getObjectType() {
    return type;
  }

  public JsonNode getNode() {
    if (masterCopy != null) {
      return masterCopy;
    }

    return node;
  }

  @Override
  public void preWrite() {
    for (final var p: getProperties()) {
      p.getValue().preWrite();
    }
  }

  protected JSFactory getFactory() {
    return factory;
  }

  /** The owner is the value containing this value.
   *
   * @param val the owner of this value
   */
  public void setOwner(final JSValue val) {
    if (owner != null) {
      throw new JsforjException("Value owner already set");
    }
    owner = val;
  }

  public JSValue getOwner() {
    return owner;
  }

  /** The owner is the property containing the value.
   *
   * @param val the property containing the value
   */
  public void setParentProperty(final JSProperty<?> val) {
    if (parentProperty != null) {
      throw new JsforjException("Value property already set");
    }
    parentProperty = val;
  }

  public JSProperty<?> getParentProperty() {
    return parentProperty;
  }

  @Override
  public boolean getChanged() {
    return changed;
  }

  @Override
  public boolean hasChanges() {
    if (changed) {
      return true;
    }

    for (final var prop: childProperties.values()) {
      if (prop.getValue().hasChanges()) {
        return true;
      }
    }

    return false;
  }

  protected void setMasterCopy(final JsonNode copyNode) {
    masterCopy = copyNode;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public boolean hasProperty(final String propertyName) {
    return getNode().has(propertyName);
  }

  @Override
  public List<JSProperty<?>> getProperties() {
    final var nd = getNode();

    if (!nd.isObject()) {
      return Collections.emptyList();
    }

    final var props = new ArrayList<JSProperty<?>>();

    for (final var it = nd.fieldNames(); it.hasNext(); ) {
      final var fieldName = it.next();

//      final var p = factory.makeProperty(fieldName,
//                                         getNode().get(fieldName));
      final var p = getProperty(fieldName);

      props.add(p);
    }

    return props;
  }

  @Override
  public <T extends JSValue> JSProperty<T> getProperty(
          final TypeReference<T> type,
          final String name) {
    // Return if it's in childrenProperties
    JSProperty<T> p= (JSProperty<T>)childProperties.get(name);
    if (p != null) {
      return p;
    }

    assertObject("getProperty");

    final var pnode = getNode().get(name);

    if (pnode == null) {
      return null;
    }

    p = (JSProperty<T>)factory.makeProperty(name, pnode);
    ((JSValueImpl)p.getValue()).setOwner(this);
    childProperties.put(name, p);

    return p;
  }

  @Override
  public JSProperty<?> getProperty(final String name) {
    // Return if it's in childrenProperties
    JSProperty<?> p= childProperties.get(name);
    if (p != null) {
      return p;
    }

    assertObject("getProperty");

    final var pnode = getNode().get(name);

    if (pnode == null) {
      return null;
    }

    p = factory.makeProperty(name, pnode);
    ((JSValueImpl)p.getValue()).setOwner(this);
    childProperties.put(name, p);

    return p;
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
  public boolean getBooleanProperty(final String name) {
    final var prop = getProperty(new TypeReference<>() {},name);

    if (prop == null) {
      return false;
    }

    return prop.getValue().getBooleanValue();
  }

  @Override
  public boolean isString() {
    return getNode().isTextual();
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
    if (getNode().isTextual()) {
      return getNode().textValue();
    }

    throw new JsforjException("Not String value");
  }

  @Override
  public boolean getBooleanValue() {
    if (getNode().isBoolean()) {
      return getNode().asBoolean();
    }

    throw new JsforjException("Not boolean value");
  }

  @Override
  public <T extends JSValue> T getValue(
          final TypeReference<T> type,
          final String pname,
          final boolean create) {
    JSProperty<T> p = getProperty(new TypeReference<>() {}, pname);

    if (p == null) {
      if (!create) {
        return null;
      }

      p = (JSProperty<T>)addProperty(factory.makeProperty(pname));
    }

    return p.getValue();
  }

  @Override
  public void writeValue(final Writer wtr,
                         final ObjectMapper mapper) {
    preWrite();
    try {
      mapper.writeValue(wtr, getNode());
    } catch (final Throwable t) {
      throw new JsforjException(t);
    }
  }

  @Override
  public String writeValueAsString(final ObjectMapper mapper) {
    preWrite();
    try {
      return mapper.writeValueAsString(getNode());
    } catch (final JsonProcessingException e) {
      throw new JsforjException(e);
    }
  }

  @Override
  public String writeValueAsStringFormatted(final ObjectMapper mapper) {
    preWrite();
    try {
      return mapper.writerWithDefaultPrettyPrinter()
                   .writeValueAsString(getNode());
    } catch (final JsonProcessingException e) {
      throw new JsforjException(e);
    }
  }

  @Override
  public <T extends JSValue> JSProperty<T> newProperty(
          final TypeReference<T> typeRef,
          final String name,
          final String type) {
    return getFactory().makeProperty(name,
                                     type,
                                     null);
  }

  /* ---------------------------- Write methods ------------------- */

  @Override
  public void removeProperty(final String name) {
    assertObject("removeProperty");
    changed = true;

    ((ObjectNode)getNode()).remove(name);
    childProperties.put(name, null);
  }

  @Override
  public void clear() {
    assertObject("clear");
    changed = true;

    ((ObjectNode)getNode()).removeAll();
    childProperties.clear();
  }

  @Override
  public <ValType extends JSValue> JSProperty<ValType> setProperty(
          final JSProperty<ValType> val) {
    final var name = val.getName();

    final var prop = getProperty(new TypeReference<>() {}, name);

    if (prop != null) {
      // Update the property with the value
      return (JSProperty<ValType>)updateProperty(prop,
                                                 val);
    }

    return addProperty(val);
  }

  @Override
  public JSProperty<JSString> setProperty(final String name,
                                          final String val) {
    return setProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty<?> setProperty(final String name,
                                   final JSUnsignedInteger val) {
    return setProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty<?> setProperty(final String name,
                                   final Integer val) {
    return setProperty(factory.makeProperty(name, val));
  }

  @Override
  public JSProperty<?> setProperty(final String name,
                                   final boolean val) {
    return setProperty(factory.makeProperty(name, val));
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
    setProperty(p);

    return p;
  }

  protected void assertStringNode() {
    if (getNode() == null) {
      throw new JsforjException("Null node for type: "
                                         + type);
    }

    if (getNode().isTextual()) {
      return;
    }

    throw new JsforjException("Not String value. Type: "
                                       + type);
  }

  protected void assertIntNode() {
    if (getNode() == null) {
      throw new JsforjException("Null node for type: "
                                         + type);
    }

    if (getNode().isInt()) {
      return;
    }

    throw new JsforjException("Not int value. Type: "
                                       + type);
  }

  protected void assertObject(final String action) {
    if (getNode().isObject()) {
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
    if (getNode().isArray()) {
      return;
    }

    if (action == null) {
      throw new JsforjException("Not array value. Type: "
                                         + type);
    }

    throw new JsforjException("Not array value. Type: "
                                       + type + " action: " + action);
  }

  private <ValType extends JSValue> JSProperty<ValType> addProperty(
          final JSProperty<ValType> val) {
    changed = true;
    assertObject("addProperty");

    final var name = val.getName();
    if (getNode().get(name) != null) {
      throw new JsforjException("Property " + name + " already present");
    }
    final var value = (JSValueImpl)val.getValue();
    value.setOwner(this);
    value.changed = true;
    childProperties.put(name, val);

    ((ObjectNode)getNode()).set(name, value.getNode());

    return val;
  }

  private <ValType extends JSValue> JSProperty<ValType> updateProperty(
          final JSProperty<JSValue> val,
          final JSProperty<ValType> newval) {
    assertObject("updateProperty");

    final var name = val.getName();

    final var theNode = (ObjectNode)getNode();
    if (theNode.get(name) != null) {
      theNode.remove(name);
    }

    ((JSValueImpl)val.getValue()).changed = true;

    final var newValue = (JSValueImpl)newval.getValue();
    theNode.set(name, newValue.getNode());

    // Replace value in property value
    final var value = (JSValueImpl)val.getValue();
    value.node = newValue.getNode();

    return (JSProperty<ValType>)val;
  }
}
