/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSUTCDateTimeImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSUTCDateTimeFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String type,
                          final JsonNode nd) {
    return new JSUTCDateTimeImpl(type, nd);
  }
}
