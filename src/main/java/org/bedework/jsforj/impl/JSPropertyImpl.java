/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSValue;

/**
 * User: mike Date: 10/23/19 Time: 23:36
 */
class JSPropertyImpl implements JSProperty {
  private String name;
  private JSValue value;

  JSPropertyImpl(final String name,
                 JSValue value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getType() {
    if (value == null) {
      return null;
    }
    return value.getType();
  }

  @Override
  public JSValue getValue() {
    return value;
  }
}
