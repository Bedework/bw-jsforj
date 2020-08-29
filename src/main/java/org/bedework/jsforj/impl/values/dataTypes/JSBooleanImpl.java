/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSBoolean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;

/**
 * User: mike Date: 5/18/20 Time: 17:50
 */
public class JSBooleanImpl extends JSValueImpl
        implements JSBoolean {
  public JSBooleanImpl(final boolean value) {
    super(JSTypes.typeBoolean,
          value ? BooleanNode.TRUE: BooleanNode.FALSE);
  }

  public JSBooleanImpl(final String typeName,
                       final JsonNode node) {
    super(typeName, node);
    assertBooleanNode();
  }

  @Override
  public boolean get() {
    return getNode().asBoolean();
  }

  public String toString() {
    return String.valueOf(get());
  }
}
