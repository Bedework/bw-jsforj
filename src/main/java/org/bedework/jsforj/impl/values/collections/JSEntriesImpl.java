/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.impl.values.JSCalendarObjectImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.values.collections.JSEntries;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSEntriesImpl extends JSArrayImpl<JSCalendarObject>
        implements JSEntries {
  public JSEntriesImpl(final String type,
                       final JsonNode node) {
    super(type, node);
  }

  @Override
  protected JsonNode convertToElement(final JSCalendarObject val) {
    return ((JSCalendarObjectImpl)val).getNode();
  }

  @Override
  protected JSCalendarObject convertToT(final JsonNode node) {
    if (!(node instanceof ObjectNode)) {
      throw new RuntimeException("Bad node class: " + node .getClass());
    }

    return factory.makeCalObj(node);
  }
}
