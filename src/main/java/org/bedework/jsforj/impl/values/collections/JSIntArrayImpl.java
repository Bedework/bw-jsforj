/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * User: mike Date: 5/11/20 Time: 00:46
 */
public class JSIntArrayImpl  extends JSArrayImpl<Integer> {
  public JSIntArrayImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final Integer val) {
    return new IntNode(val);
  }

  @Override
  protected Integer convertToT(final JsonNode node) {
    if (!(node instanceof IntNode)) {
      throw new RuntimeException("Bad node class: " + node .getClass());
    }

    return ((IntNode)node).intValue();
  }
}
