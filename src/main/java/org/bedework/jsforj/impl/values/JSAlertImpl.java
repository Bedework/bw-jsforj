/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSAlert;
import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSAlertImpl extends JSValueImpl
        implements JSAlert {
  public JSAlertImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setAction(final String val) {
    setProperty(JSPropertyNames.action, val);
  }

  @Override
  public String getAction() {
    return getStringProperty(JSPropertyNames.action);
  }

  @Override
  public void setOffset(final JSSignedDuration offset) {
    setProperty(getFactory().makeProperty(JSPropertyNames.offset,
                                          offset));
  }

  @Override
  public JSSignedDuration getOffset() {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.offset,
                    false);
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
