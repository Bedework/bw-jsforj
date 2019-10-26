package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSCalendarObject;

import java.util.List;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSEntries extends JSValue {
  List<JSCalendarObject> getEntries();

  void addEntry(JSCalendarObject val);
}
