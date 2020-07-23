/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/23/19 Time: 23:36
 */
public class JSPropertyImpl<T extends JSValue>
        implements JSProperty<T> {
  private final String name;
  private final T value;

  public JSPropertyImpl(final String name,
                        final T value) {
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
  public T getValue() {
    return value;
  }
}
