/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.impl.values.collections.JSListImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceOverridesImpl extends JSListImpl<JSProperty>
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
  protected void store(final JSProperty val) {
    final String rid = val.getName();
    if (rid == null) {
      throw new RuntimeException(
              "Recurrenceid must be set for an override");
    }

    ((JSOverride)val.getValue()).setMaster(master);

    addProperty(val);
  }

  @Override
  protected String fieldName(final JSProperty val) {
    return val.getName();
  }

  @Override
  protected JSProperty convertToT(final String val) {
    final JSProperty ov =
            getFactory().makeProperty(val,
                                      JSTypes.typeOverride,
                                      getNode().get(val));
    ((JSOverride)ov.getValue()).setMaster(master);
    return ov;
  }

  @Override
  public JSProperty makeOverride(final String rid) {
    final JSProperty ov =
            getFactory().makeProperty(rid,
                                      JSTypes.typeOverride,
                                      null);
    add(ov);

    return ov;
  }
}
