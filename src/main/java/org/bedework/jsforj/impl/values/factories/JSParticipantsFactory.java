/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.impl.values.collections.JSParticipantsImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSParticipantsFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSParticipantsImpl(typeName, nd);
    }

    return new JSParticipantsImpl(typeName,
                                  new ObjectNode(JsonNodeFactory.instance));
  }
}
