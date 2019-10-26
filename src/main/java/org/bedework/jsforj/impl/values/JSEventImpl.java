/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSEvent;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 */
public class JSEventImpl extends JSCalendarObjectImpl
        implements JSEvent {
  public JSEventImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }
}
