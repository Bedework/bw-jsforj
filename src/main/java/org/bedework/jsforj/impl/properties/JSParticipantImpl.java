/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.model.JSRecurrenceRule;
import org.bedework.jsforj.model.JSValue;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSParticipantImpl extends JSPropertyImpl
        implements JSRecurrenceRule {
  public JSParticipantImpl(final String name,
                           JSValue value) {
    super(name, value);
  }
}
