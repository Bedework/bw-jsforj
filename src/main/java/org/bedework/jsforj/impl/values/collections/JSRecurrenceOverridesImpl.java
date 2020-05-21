/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.impl.values.dataTypes.JSLocalDateTimeImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceOverridesImpl
        extends JSMapImpl<JSLocalDateTime, JSOverride>
        implements JSRecurrenceOverrides {
  private JSCalendarObject master;

  public JSRecurrenceOverridesImpl(final String type,
                                   final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setMaster(final JSCalendarObject val) {
    master = val;
  }

  @Override
  public JSCalendarObject getMaster() {
    return master;
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeOverride;
  }

  @Override
  protected String convertKey(final JSLocalDateTime key) {
    return key.getStringValue();
  }

  @Override
  protected JSLocalDateTime convertFieldName(
          final String fieldName) {
    return new JSLocalDateTimeImpl(fieldName);
  }

  protected JSProperty<JSOverride> postCreate(
          final JSProperty<JSOverride> entry) {
    entry.getValue().setMaster(getMaster());

    return entry;
  }
}
