/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSCalendarObject;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:09
 */
public class JSCalendarObjectImpl extends JSValueImpl
        implements JSCalendarObject {
  public JSCalendarObjectImpl(final String type,
                              final JsonNode node) {
    super(type, node);
  }
}
