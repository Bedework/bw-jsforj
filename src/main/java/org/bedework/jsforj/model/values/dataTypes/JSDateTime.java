package org.bedework.jsforj.model.values.dataTypes;

import org.bedework.jsforj.model.DateTimeComponents;
import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSDateTime extends JSValue {
  /**
   *
   * @return the date and time broken into its components.
   */
  DateTimeComponents getComponents();
}
