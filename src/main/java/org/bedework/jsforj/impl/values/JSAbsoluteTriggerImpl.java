/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.model.values.JSAbsoluteTrigger;
import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSAbsoluteTriggerImpl extends JSValueImpl
        implements JSAbsoluteTrigger {
  public JSAbsoluteTriggerImpl(final String type,
                               final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setWhen(final JSUTCDateTime val) {
    setProperty(factory.makeProperty(JSPropertyNames.when, val));
  }

  @Override
  public JSUTCDateTime getWhen() {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.when, false);  }
}
