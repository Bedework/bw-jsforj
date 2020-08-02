/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.time.Instant;

/** Use a string node to hold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSUTCDateTimeImpl extends JSValueImpl
        implements JSUTCDateTime {
  public JSUTCDateTimeImpl(final String value) {
    super(JSTypes.typeUTCDateTime, new TextNode(value));

    // validate it
    Instant.parse(value);
  }

  public JSUTCDateTimeImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }

  @Override
  public Instant getDt() {
    return Instant.parse(getNode().textValue());
  }
}
