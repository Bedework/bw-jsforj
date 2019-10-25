/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties.factories;

import org.bedework.jsforj.impl.properties.JSEventImpl;
import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.impl.properties.JSTaskImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSCalendarObjectFactory extends JSPropertyFactoryImpl {
  @Override
  public JSProperty newProperty(final String name,
                                final JsonNode nd) {
    final JSValue val = factory.makeValue(name, nd);

    final String type = val.getType();

    switch (type) {
      case JSTypes.typeJSEvent:
        return new JSEventImpl(name, val);

      case JSTypes.typeJSTask:
        return new JSTaskImpl(name, val);

      default:
        return new JSPropertyImpl(name, val);
    }
  }
}
