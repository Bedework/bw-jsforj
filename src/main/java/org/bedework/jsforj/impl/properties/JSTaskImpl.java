/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.model.JSTask;
import org.bedework.jsforj.model.JSValue;

/**
 * User: mike Date: 10/24/19 Time: 17:20
 */
public class JSTaskImpl extends JSCalendarObjectImpl
        implements JSTask {
  public JSTaskImpl(final String name,
                    JSValue value) {
    super(name, value);
  }
}
