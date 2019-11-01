/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSParticipantImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSParticipantFactory extends JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String typeName,
                          final JsonNode nd) {
    if (nd != null) {
      return new JSParticipantImpl(typeName, nd);
    }

    return new JSParticipantImpl(typeName, newObject(typeName));
  }
}