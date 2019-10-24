package org.bedework.jsforj.model;

import java.util.Collection;

/**
 * User: mike Date: 10/23/19 Time: 16:46
 */
public interface JSCalendarObject {
  /**
   *
   * @return the type of the value
   */
  String getType();

  /**
   *
   * @return a Collection of the properties
   */
  Collection<JSProperty> getProperties();

  /**
   *
   * @param name of the property
   * @return property or null
   */
  JSProperty getProperty(String name);

  /**
   *
   * @param val the property
   * @throws RuntimeException if already present
   */
  void addProperty(final JSProperty val);

  /**
   *
   * @param name of the property
   */
  void removeProperty(String name);
}
