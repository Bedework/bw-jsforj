/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.dataTypes.JSStringImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSString;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * User: mike Date: 5/11/20 Time: 15:30
 */
public class JSStringArrayImpl extends JSArrayImpl<JSString> {
  public JSStringArrayImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final JSString val) {
    return ((JSStringImpl)val).getNode();
  }

  @Override
  protected JSString convertToT(final JsonNode node) {
    if (!(node instanceof TextNode)) {
      throw new JsforjException("Bad node class: " + node.getClass());
    }

    return (JSString)factory.newValue(JSTypes.typeString, node);
  }
}
