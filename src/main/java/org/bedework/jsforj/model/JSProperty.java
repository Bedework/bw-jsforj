package org.bedework.jsforj.model;

import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/23/19 Time: 13:25
 */
public interface JSProperty {
  /**
   *
   * @return String name of the property
   */
  String getName();

  /**
   *
   * @return the type of the value
   */
  String getType();

  /** Returns values as Objects - all int and boolean values will be returned as
   * the corresponding object class.
   *
   * @return the value of the property
   */
  JSValue getValue();
}
