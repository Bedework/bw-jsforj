/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSOffsetTrigger;
import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSOffsetTriggerImpl extends JSValueImpl
        implements JSOffsetTrigger {
  public JSOffsetTriggerImpl(final String type,
                             final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setOffset(final JSSignedDuration val) {
    setProperty(factory.makeProperty(JSPropertyNames.offset, val));
  }

  @Override
  public JSSignedDuration getOffset() {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.offset, false);
  }

  @Override
  public void setRelativeTo(final String val) {
    setProperty(JSPropertyNames.relativeTo, val);
  }

  @Override
  public String getRelativeTo() {
    return getStringProperty(JSPropertyNames.relativeTo);
  }
}
