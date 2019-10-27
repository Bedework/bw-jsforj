/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.JSPropertyAttributes;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 10:35
 */
public class JSValueImpl implements JSValue {
  final static JSFactory factory = JSFactory.getFactory();

  private final String type;
  private final JSPropertyAttributes.TypeInfo typeInfo;

  // Parsed value
  private final JsonNode node;

  public JSValueImpl(final String type,
                     final JsonNode node) {
    if (node == null) {
      throw new RuntimeException("Null node value");
    }
    if (type == null) {
      throw new RuntimeException("Null value type for " + node);
    }

    this.type = type;
    this.node = node;
    typeInfo = JSPropertyAttributes.getTypeInfo(type);
//    if (typeInfo == null) {
//      throw new RuntimeException("Null value typeInfo for type"
//                                         + type
//                                         + " and node " + node);
//    }
  }

  @Override
  public String getType() {
    return type;
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
    if (!node.isObject()) {
      throw new RuntimeException("Not array value. Type: "
                                         + type);
    }

    // Exactly as get properties - except all the elements should have
    // constrained types

    var props = new ArrayList<JSProperty>();
    var nd = getNode();

    for (var it = nd.fieldNames(); it.hasNext(); ) {
      var fieldName = it.next();

      props.add(factory.makeProperty(fieldName,
                                     node.get(fieldName)));
    }

    return props;
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

    var props = new ArrayList<JSProperty>();
    var nd = getNode();

    for (var it = nd.fieldNames(); it.hasNext(); ) {
      var fieldName = it.next();

      props.add(factory.makeProperty(fieldName,
                                     node.get(fieldName)));
    }

    return props;
  }

  @Override
  public JSProperty getProperty(final String name) {
    if (!node.isObject()) {
      throw new RuntimeException("Not Object value. Trying to add : "
                                         + name);
    }

    var pnode = node.get(name);

    if (pnode == null) {
      return null;
    }

    return factory.makeProperty(name, pnode);
  }

  @Override
  public void removeProperty(final String name) {
    if (!node.isObject()) {
      throw new RuntimeException("Not Object value. Trying to remove : "
                                         + name);
    }

    ((ObjectNode)node).remove(name);
  }

  @Override
  public JSProperty addProperty(final JSProperty val) {
    if (!node.isObject()) {
      throw new RuntimeException("Not Object value");
    }

    var name = val.getName();
    if (node.get(name) != null) {
      throw new RuntimeException("Property " + name + "already present");
    }
    var value = (JSValueImpl)val.getValue();
    ((ObjectNode)node).set(name, value.getNode());

    return val;
  }

  @Override
  public JSProperty addProperty(final String name, final String val) {
    return addProperty(factory.makeProperty(name, val));
  }

  @Override
  public String getStringProperty(final String name) {
    var prop = getProperty(name);

    if (prop == null) {
      return null;
    }

    return prop.getValue().getStringValue();
  }

  @Override
  public boolean isString() {
    return node.isTextual();
  }

  @Override
  public String getStringValue() {
    if (node.isTextual()) {
      return node.textValue();
    }

    throw new RuntimeException("Not String value");
  }

  @Override
  public String writeValueAsString(final ObjectMapper mapper) {
    try {
      return mapper.writeValueAsString(node);
    } catch (final JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String writeValueAsStringFormatted(final ObjectMapper mapper) {
    try {
      return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
    } catch (final JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public JsonNode getNode() {
    return node;
  }
}
