/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.values.JSRecurrenceRule;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceRuleImpl extends JSValueImpl
        implements JSRecurrenceRule {
  public JSRecurrenceRuleImpl(final String type,
                              final JsonNode node) {
    super(type, node);
  }
}
