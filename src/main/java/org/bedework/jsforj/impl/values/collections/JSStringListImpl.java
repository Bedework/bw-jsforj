/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 4/22/20 Time: 16:20
 */
public class JSStringListImpl extends JSListImpl<String> {
  public JSStringListImpl(final String type,
                          final JsonNode node) {
    super(type, node);
  }

  @Override
  protected void store(final String val) {
    ((ObjectNode)getNode()).put(val, true);
  }

  @Override
  protected String fieldName(final String val) {
    return val;
  }

  @Override
  protected String convertToT(final String val) {
    return val;
  }
}
