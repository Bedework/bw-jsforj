/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSTriggerImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSTriggerFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String name,
                          final JsonNode nd) {
    final String type = factory.getType(nd);

    switch (type) {
      case JSTypes.typeAbsoluteTrigger:
        return new JSTriggerImpl(name, nd);

      case JSTypes.typeOffsetTrigger:
        return new JSTriggerImpl(name, nd);

      case JSTypes.typeUnknownTrigger:
      default:
        return new JSValueImpl(name, nd);
    }
  }
}
