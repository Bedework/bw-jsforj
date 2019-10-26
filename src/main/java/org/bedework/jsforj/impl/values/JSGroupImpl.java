/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSGroup;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 17:21
 */
public class JSGroupImpl extends JSCalendarObjectImpl
        implements JSGroup {
  private List<JSCalendarObject> entries = new ArrayList<>();

  public JSGroupImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  public List<JSCalendarObject> getEntries() {
    return entries;
  }

  @Override
  public void addEntry(final JSCalendarObject val) {
    entries.add(val);
  }
}
