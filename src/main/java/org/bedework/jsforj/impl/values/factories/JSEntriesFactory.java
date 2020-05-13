/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.collections.JSEntriesImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSEntriesFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String name,
                          final JsonNode nd) {
    if (nd == null) {
      return new JSEntriesImpl(name,
                               new ObjectNode(JsonNodeFactory.instance));
    }
    return new JSEntriesImpl(name, nd);
  }
}
