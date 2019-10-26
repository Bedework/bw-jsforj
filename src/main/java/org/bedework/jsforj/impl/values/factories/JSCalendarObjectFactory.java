/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSEventImpl;
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
  public JSValue newValue(final String name,
                          final JsonNode nd) {
    final String type = factory.getType(nd);

    switch (type) {
      case JSTypes.typeJSEvent:
        return new JSEventImpl(name, nd);

      case JSTypes.typeJSTask:
        return new JSTaskImpl(name, nd);

      default:
        return new JSValueImpl(name, nd);
    }
  }
}
