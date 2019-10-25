/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSTypes;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 */
public class JSEventImpl extends JSCalendarObjectImpl
        implements JSEvent {
  JSEventImpl() {
    super(JSTypes.typeJSEvent);
  }
}
