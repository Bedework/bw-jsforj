/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSArrayImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSStringArrayFactory extends JSValueFactoryImpl {
  static class JSStringArrayImpl extends JSArrayImpl<String> {
    public JSStringArrayImpl(final String type,
                            final JsonNode node) {
      super(type, node);
    }

    @Override
    protected String convertToString(final String val) {
      return val;
    }

    @Override
    protected String convertToT(final String val) {
      return val;
    }
  }
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSStringArrayImpl(typeName, nd);
    }

    return new JSStringArrayImpl(typeName,
                                new ObjectNode(JsonNodeFactory.instance));
  }
}
