/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 17:21
 */
public class JSGroupImpl extends JSCalendarObjectImpl
        implements JSGroup {
  private List<JSCalendarObject> entries = new ArrayList<>();

  JSGroupImpl() {
    super(JSTypes.typeJSGroup);
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
