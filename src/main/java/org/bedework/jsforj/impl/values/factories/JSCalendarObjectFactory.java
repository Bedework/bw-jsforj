/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSEventImpl;
import org.bedework.jsforj.impl.values.JSGroupImpl;
import org.bedework.jsforj.impl.values.JSTaskImpl;
import org.bedework.jsforj.impl.values.JSUnknownTypeImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSCalendarObjectFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    var theNode = nd;

    if (nd == null) {
      theNode = newObject(typeName);
    }

    switch (typeName) {
      case JSTypes.typeEvent:
        return new JSEventImpl(typeName, theNode);

      case JSTypes.typeTask:
        return new JSTaskImpl(typeName, theNode);

      case JSTypes.typeGroup:
        return new JSGroupImpl(typeName, theNode);

      default:
        return new JSUnknownTypeImpl(typeName, theNode);
    }
  }
}
