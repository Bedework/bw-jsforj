/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSPropertyAttributes;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 10:35
 */
public class JSValueImpl implements JSValue {
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
    if (typeInfo == null) {
      throw new RuntimeException("Null value typeInfo for type"
                                         + type
                                         + " and node " + node);
    }
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public boolean isValueList() {
    return typeInfo.getValueList();
  }

  @Override
  public List<JSValue> getValueList() {
    return null;
  }

  @Override
  public boolean isPropertyList() {
    return typeInfo.getPropertyList();
  }

  @Override
  public List<JSProperty> getPropertyList() {
    return null;
  }

  @Override
  public boolean isObject() {
    return typeInfo.getObject();
  }

  @Override
  public List<JSProperty> getProperties() {
    return null;
  }

  @Override
  public JSProperty getProperty(final String name) {
    if (!node.isObject()) {
      throw new RuntimeException("Not Object value. Trying to add : "
                                         + name);
    }
    return null;
  }

  @Override
  public void addProperty(final JSProperty val) {
    if (!node.isObject()) {
      throw new RuntimeException("Not Object value");
    }
  }

  @Override
  public String getStringValue() {
    if (node.isTextual()) {
      return node.textValue();
    }

    throw new RuntimeException("Not String value");
  }

  public JsonNode getNode() {
    return node;
  }
}
