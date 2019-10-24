package org.bedework.jsforj.model;

import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 00:23
 */
public interface JSGroup extends JSCalendarObject {
  List<JSCalendarObject> getEntries();
}
