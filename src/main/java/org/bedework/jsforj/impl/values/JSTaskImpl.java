/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSTask;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/24/19 Time: 17:20
 */
public class JSTaskImpl extends JSCalendarObjectImpl
        implements JSTask {
  public JSTaskImpl(final String type,
                    final JsonNode node) {
    super(type, node);
  }
}
