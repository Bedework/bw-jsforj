/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.collections.JSArrayImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSIntArrayFactory extends JSValueFactoryImpl {
  static class JSIntArrayImpl extends JSArrayImpl<Integer> {
    public JSIntArrayImpl(final String type,
                            final JsonNode node) {
      super(type, node);
    }

    @Override
    protected String convertToString(final Integer val) {
      return val.toString();
    }

    @Override
    protected Integer convertToT(final String val) {
      return Integer.parseInt(val);
    }
  }

  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSIntArrayImpl(typeName, nd);
    }

    return new JSIntArrayImpl(typeName,
                                new ObjectNode(JsonNodeFactory.instance));
  }
}
