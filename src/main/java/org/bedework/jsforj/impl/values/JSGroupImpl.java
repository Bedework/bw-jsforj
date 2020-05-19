/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.collections.JSEntries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Collections;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 17:21
 */
public class JSGroupImpl extends JSCalendarObjectImpl
        implements JSGroup {
  public JSGroupImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  public List<JSCalendarObject> getEntries() {
    var entsVal = getEntsVal();

    if (entsVal == null) {
      return Collections.emptyList();
    }

    return entsVal.get();
  }

  @Override
  public void addEntry(final JSCalendarObject val) {
    var entsVal = getEntsVal();

    if (entsVal == null) {
      // Add new property
      JSProperty entries = factory.makeProperty(JSPropertyNames.entries,
                                                (JsonNode)null);
      addProperty(entries);

      entsVal = getEntsVal();
    }

    entsVal.add(val);
  }

  private JSEntries getEntsVal() {
    JSProperty<JSEntries> entries = getProperty(
            new TypeReference<>() {},
            JSPropertyNames.entries);

    if (entries == null) {
      return null;
    }

    return entries.getValue();
  }
}
