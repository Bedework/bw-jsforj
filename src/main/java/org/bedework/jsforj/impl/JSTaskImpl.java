/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSTask;
import org.bedework.jsforj.model.JSTypes;

/**
 * User: mike Date: 10/24/19 Time: 17:20
 */
public class JSTaskImpl extends JSCalendarObjectImpl
        implements JSTask {
  JSTaskImpl() {
    super(JSTypes.typeJSTask);
  }
}
