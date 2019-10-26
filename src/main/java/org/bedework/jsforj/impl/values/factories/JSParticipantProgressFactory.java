/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.factories;

import org.bedework.jsforj.impl.values.JSParticipantProgressImpl;
import org.bedework.jsforj.impl.values.JSValueFactoryImpl;
import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSParticipantProgressFactory extends
        JSValueFactoryImpl {
  @Override
  public JSValue newValue(final String name,
                          final JsonNode nd) {
    return new JSParticipantProgressImpl(name,
                                         nd);
  }
}
