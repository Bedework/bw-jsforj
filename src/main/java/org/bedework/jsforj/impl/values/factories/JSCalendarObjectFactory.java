/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSEventImpl;
import org.bedework.jsforj.impl.values.JSGroupImpl;
import org.bedework.jsforj.impl.values.JSTaskImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.impl.values.JSValueImpl;
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
      case JSTypes.typeJSEvent:
        return new JSEventImpl(typeName, theNode);

      case JSTypes.typeJSTask:
        return new JSTaskImpl(typeName, theNode);

      case JSTypes.typeJSGroup:
        return new JSGroupImpl(typeName, theNode);

      default:
        return new JSValueImpl(typeName, theNode);
    }
  }
}
