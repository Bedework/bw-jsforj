/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.impl.values.collections.JSRolesImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSRolesFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSRolesImpl(typeName, nd);
    }

    return new JSRolesImpl(typeName,
                           new ObjectNode(JsonNodeFactory.instance));
  }
}
