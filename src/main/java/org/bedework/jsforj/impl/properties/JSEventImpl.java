/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSValue;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 */
public class JSEventImpl extends JSCalendarObjectImpl
        implements JSEvent {
  public JSEventImpl(final String name,
                     JSValue value) {
    super(name, value);
  }
}
