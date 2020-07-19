/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.JSRecurrenceRuleImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.collections.JSRecurrenceRules;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceRulesImpl
        extends JSArrayImpl<JSRecurrenceRule>
        implements JSRecurrenceRules {
  public JSRecurrenceRulesImpl(final String type,
                               final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final JSRecurrenceRule val) {
    return ((JSRecurrenceRuleImpl)val).getNode();
  }

  @Override
  protected JSRecurrenceRule convertToT(final JsonNode node) {
    if (!(node instanceof ObjectNode)) {
      throw new JsforjException("Bad node class: " + node.getClass());
    }

    return (JSRecurrenceRule)factory.newValue(
            JSTypes.typeRecurrenceRule, node);
  }

  @Override
  public JSRecurrenceRule makeRecurrenceRule() {
    final JSRecurrenceRule rr =
            (JSRecurrenceRule)factory.newValue(
                    JSTypes.typeRecurrenceRule,
                    (JsonNode)null);
    add(rr);

    return rr;
  }
}
