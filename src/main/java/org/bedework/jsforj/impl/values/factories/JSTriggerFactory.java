/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSAbsoluteTriggerImpl;
import org.bedework.jsforj.impl.values.JSOffsetTriggerImpl;
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
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd == null) {
      switch (typeName) {
        case JSTypes.typeAbsoluteTrigger:
          return new JSAbsoluteTriggerImpl(typeName,
                                           newObject(typeName));

        case JSTypes.typeOffsetTrigger:
          return new JSOffsetTriggerImpl(typeName,
                                         newObject(typeName));

        case JSTypes.typeUnknownTrigger:
        default:
          return new JSValueImpl(typeName, newObject(typeName));
      }
    }

    final String type = factory.getType(nd);

    switch (type) {
      case JSTypes.typeAbsoluteTrigger:
        return new JSAbsoluteTriggerImpl(typeName, nd);

      case JSTypes.typeOffsetTrigger:
        return new JSOffsetTriggerImpl(typeName, nd);

      case JSTypes.typeUnknownTrigger:
      default:
        return new JSValueImpl(typeName, nd);
    }
  }
}
