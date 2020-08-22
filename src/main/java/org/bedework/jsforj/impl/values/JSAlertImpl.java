/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSAbsoluteTrigger;
import org.bedework.jsforj.model.values.JSAlert;
import org.bedework.jsforj.model.values.JSOffsetTrigger;
import org.bedework.jsforj.model.values.JSTrigger;
import org.bedework.jsforj.model.values.collections.JSRelations;
import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

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
  public void setTrigger(final JSTrigger val) {
    setProperty(factory.makeProperty(JSPropertyNames.trigger, val));
  }

  @Override
  public JSTrigger getTrigger() {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.trigger, false);
  }

  @Override
  public JSAbsoluteTrigger makeAbsoluteTrigger() {
    final JSAbsoluteTrigger trigger =
            (JSAbsoluteTrigger)factory.newValue(JSTypes.typeAbsoluteTrigger);
    setTrigger(trigger);

    return trigger;
  }

  @Override
  public JSOffsetTrigger makeOffsetTrigger() {
    final JSOffsetTrigger trigger =
            (JSOffsetTrigger)factory.newValue(JSTypes.typeOffsetTrigger);
    setTrigger(trigger);

    return trigger;
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
  public void setAcknowledged(final JSUTCDateTime offset) {
    setProperty(getFactory().makeProperty(JSPropertyNames.acknowledged,
                                          offset));
  }

  @Override
  public JSUTCDateTime getAcknowledged() {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.acknowledged,
                    false);
  }

  @Override
  public JSRelations getRelatedTo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.relatedTo, create);
  }
}
