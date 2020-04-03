/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.values.JSOverride;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 */
public class JSOverrideImpl extends JSCalendarObjectImpl
        implements JSOverride {
  private String recurrenceId;
  private JSCalendarObject master;

  public JSOverrideImpl(final String typeName,
                        final JsonNode node) {
    super(typeName, node);
  }

  @Override
  public void setRecurrenceId(final String val) {
    recurrenceId = val;
  }

  @Override
  public String getRecurrenceId() {
    return recurrenceId;
  }

  @Override
  public void setMaster(final JSCalendarObject val) {
    master = val;
  }

  @Override
  public JSCalendarObject getMaster() {
    return master;
  }
}
