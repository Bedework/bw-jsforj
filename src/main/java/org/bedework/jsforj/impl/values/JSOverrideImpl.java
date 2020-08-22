/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.util.misc.Util;

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
    return getBooleanProperty(JSPropertyNames.excluded);
  }

  // ------------------------- JsValue ---------------------------- //

  @Override
  public String getStringProperty(final String name) {
    if (hasProperty(name)) {
      return super.getStringProperty(name);
    }

    return getMaster().getStringProperty(name);
  }

  @Override
  public void removeProperty(final String name) {
    if (getMaster() == null) {
      if (JSPropertyNames.type.equals(name)) {
        // Part of init before master gets set
        return;
      }

      throw new JsforjException("No master set in patch object");
    }

    if (!getMaster().hasProperty(name)){
      super.removeProperty(name);
      return;
    }

    setNull(name);
  }

  // -------------------- JsCalendarObject ------------------------ //
  @Override
  public void setUid(final String val) {
    throw new JsforjException("Cannot set uid in patch object");
  }

  @Override
  public String getUid() {
    return getMaster().getUid();
  }

  @Override
  public void setDescription(final String val) {
    if (Util.compareStrings(val, getMaster().getDescription()) == 0) {
      // Not different
      return;
    }

    setProperty(factory.makeProperty(JSPropertyNames.description,
                                     val));
  }

  @Override
  public void setTitle(final String val) {
    if (Util.compareStrings(val, getMaster().getTitle()) == 0) {
      // Not different
      return;
    }

    setProperty(factory.makeProperty(JSPropertyNames.title,
                                     val));
  }
}
