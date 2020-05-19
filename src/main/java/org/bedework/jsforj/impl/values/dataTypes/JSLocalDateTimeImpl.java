/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Use a string node tohold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLocalDateTimeImpl extends JSValueImpl
        implements JSLocalDateTime {
  //Build formatter
  static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

  public JSLocalDateTimeImpl(final String value) {
    super(JSTypes.typeLocalDateTime, new TextNode(value));

    // validate it
    LocalDateTime.parse(value, formatter);
  }

  public JSLocalDateTimeImpl(final String type,
                             final JsonNode node) {
    super(type, node);
  }

  @Override
  public LocalDateTime getDt() {
    return LocalDateTime.parse(getNode().textValue(), formatter);
  }
}
