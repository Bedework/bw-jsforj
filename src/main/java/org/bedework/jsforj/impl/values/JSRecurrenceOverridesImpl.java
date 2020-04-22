/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.JSRecurrenceOverrides;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceOverridesImpl extends JSValueImpl
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
  public List<JSProperty> getOverrides() {
    assertObject("getOverrides");

    final List<JSProperty> res = new ArrayList<>();
    var nd = getNode();

    for (var it = nd.fieldNames(); it.hasNext(); ) {
      var fieldName = it.next();

      final JSProperty ov =
              factory.makeProperty(fieldName,
                                   JSTypes.typeOverride,
                                   nd.get(fieldName));
      ((JSOverride)ov.getValue()).setMaster(master);
      res.add(ov);
    }

    return Collections.unmodifiableList(res);
  }

  @Override
  public void addOverride(final JSProperty val) {
    final String rid = val.getName();
    if (rid == null) {
      throw new RuntimeException(
              "Recurrenceid must be set for an override");
    }

    ((JSOverride)val.getValue()).setMaster(master);

    addProperty(val);
  }

  @Override
  public JSProperty addOverride(final String rid) {
    final JSProperty ov =
            factory.makeProperty(rid,
                                 JSTypes.typeOverride,
                                 null);
    addProperty(ov);
    ((JSOverride)ov.getValue()).setMaster(master);

    return ov;
  }
}
