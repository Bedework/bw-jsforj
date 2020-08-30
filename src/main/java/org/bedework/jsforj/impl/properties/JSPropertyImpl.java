/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/23/19 Time: 23:36
 */
public class JSPropertyImpl<T extends JSValue>
        implements JSProperty<T> {
  final static JSFactory factory = JSFactory.getFactory();

  private final String name;
  private final T value;

  public JSPropertyImpl(final String name,
                        final T value) {
    this.name = name;
    this.value = value;
    ((JSValueImpl)value).setParentProperty(this);
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

  @Override
  public JSProperty<T> copy() {
    return new JSPropertyImpl<T>(getName(),
                                 (T)getValue().copy());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof JSPropertyImpl)) {
      return false;
    }

    final var that = (JSPropertyImpl<?>)o;

    if (!name.equals(that.name)) {
      return false;
    }

    return getValue().equals(that.getValue());
  }
}
