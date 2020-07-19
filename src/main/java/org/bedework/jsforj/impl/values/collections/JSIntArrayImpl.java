/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.dataTypes.JSIntegerImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * User: mike Date: 5/11/20 Time: 00:46
 */
public class JSIntArrayImpl  extends JSArrayImpl<JSInteger> {
  public JSIntArrayImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final JSInteger val) {
    return ((JSIntegerImpl)val).getNode();
  }

  @Override
  protected JSInteger convertToT(final JsonNode node) {
    if (!(node instanceof IntNode)) {
      throw new JsforjException("Bad node class:",
                                node.getClass().getName());
    }

    return (JSInteger)factory.newValue(JSTypes.typeInt, node);
  }
}
