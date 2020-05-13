/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * User: mike Date: 5/11/20 Time: 15:30
 */
public class JSStringArrayImpl extends JSArrayImpl<String> {
  public JSStringArrayImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final String val) {
    return new TextNode(val);
  }

  @Override
  protected String convertToT(final JsonNode node) {
    if (!(node instanceof TextNode)) {
      throw new RuntimeException("Bad node class: " + node .getClass());
    }

    return node.asText();
  }
}
