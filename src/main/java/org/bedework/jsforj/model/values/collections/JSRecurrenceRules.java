package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.values.JSRecurrenceRule;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSRecurrenceRules
        extends JSArray<JSRecurrenceRule> {
  /** Create and add a new rrule object
   *
   */
  JSRecurrenceRule makeRecurrenceRule();
}
