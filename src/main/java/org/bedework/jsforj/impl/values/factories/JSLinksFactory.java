/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.collections.JSLinksImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 4/3/20 Time: 21:59
 */
public class JSLinksFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSLinksImpl(typeName, nd);
    }

    return new JSLinksImpl(typeName,
                           new ObjectNode(JsonNodeFactory.instance));
  }
}
