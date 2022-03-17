/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSAbsoluteTriggerImpl;
import org.bedework.jsforj.impl.values.JSOffsetTriggerImpl;
import org.bedework.jsforj.impl.values.JSUnknownTriggerImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.JSPropertyNames;
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
          return new JSUnknownTriggerImpl(typeName,
                                          newObject(typeName));
      }
    }

    final String theType;
    if ( JSPropertyNames.trigger.equals(typeName)) {
      theType = factory.getType(nd);
    } else {
      theType = typeName;
    }

    switch (theType) {
      case JSTypes.typeAbsoluteTrigger:
        return new JSAbsoluteTriggerImpl(theType, nd);

      case JSTypes.typeOffsetTrigger:
        return new JSOffsetTriggerImpl(theType, nd);

      case JSTypes.typeUnknownTrigger:
      default:
        return new JSUnknownTriggerImpl(theType, nd);
    }
  }
}
