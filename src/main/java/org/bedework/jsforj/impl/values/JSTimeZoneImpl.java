/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.values.JSTimeZone;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSTimeZoneImpl extends JSValueImpl
        implements JSTimeZone {
  public JSTimeZoneImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }
}
