/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: mike Date: 10/24/19 Time: 17:09
 */
public class JSCalendarObjectImpl implements JSCalendarObject {
  private final String type;

  private final Map<String, JSProperty> properties = new HashMap<>();

  JSCalendarObjectImpl(final String type) {
    this.type = type;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public Collection<JSProperty> getProperties() {
    return properties.values();
  }

  @Override
  public JSProperty getProperty(final String name) {
    return properties.get(name);
  }

  @Override
  public void addProperty(final JSProperty val) {
    final var name = val.getName();

    if (properties.get(name) != null) {
      throw new RuntimeException("Property " + name + " already present");
    }

    properties.put(name, val);
  }

  @Override
  public void removeProperty(final String name) {
    properties.remove(name);
  }
}
