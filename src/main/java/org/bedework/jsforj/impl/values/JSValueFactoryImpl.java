/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.JSValueFactory;
import org.bedework.jsforj.model.JSPropertyNames;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 15:00
 */
public abstract class JSValueFactoryImpl extends JSValueFactory {
  public final static JSFactory factory = JSFactory.getFactory();

  /**
   *
   * @param typeName to be added as property
   * @return ObjectNode
   */
  protected JsonNode newObject(final String typeName) {
    final var node = new ObjectNode(JsonNodeFactory.instance);

    node.put(JSPropertyNames.type, typeName);

    return node;
  }

  /**
   *
   * @param typeName to be added as property
   * @return ObjectNode
   */
  protected JsonNode ensureType(final String typeName,
                                final ObjectNode node) {
    if (node.get(JSPropertyNames.type) == null) {
      node.put(JSPropertyNames.type, typeName);
    }

    return node;
  }
}
