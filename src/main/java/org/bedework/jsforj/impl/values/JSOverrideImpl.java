/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSOverride;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 */
public class JSOverrideImpl extends JSPatchObjectImpl
        implements JSOverride {
  private JSCalendarObject master;

  public JSOverrideImpl(final String typeName,
                        final JsonNode node) {
    super(typeName, node);
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
  public void markExcluded() {
    setProperty(JSPropertyNames.excluded, true);
  }

  @Override
  public boolean getExcluded() {
    final var excluded = getProperty(new TypeReference<>() {}, JSPropertyNames.excluded);
    if (excluded == null) {
      return false;
    }

    return excluded.getValue().getBooleanValue();
  }

  @Override
  public void setUid(final String val) {
    throw new RuntimeException("Cannot set uid in patch object");
  }

  @Override
  public String getUid() {
    return null;
  }
}
