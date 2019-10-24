/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTask;
import org.bedework.jsforj.model.JSTypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;

/**
 * User: mike Date: 10/23/19 Time: 23:44
 */
public class JsonMapper extends ObjectMapper {
  public JsonMapper() {
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // configure(JsonFactory.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public JSCalendarObject parse(final Reader rdr) {
    try {
      final JsonNode nd = readTree(rdr);
      final JsonNode typeNode = nd.get(JSProperty.type);

      if (typeNode == null) {
        throw new RuntimeException("No @type for calendar object");
      }

      final String type = nd.asText();

      switch (type) {
        case JSTypes.typeJSEvent:
          return parseEvent();
        case JSTypes.typeJSTask:
          return parseTask();
        case JSTypes.typeJSGroup:
          return parseGroup();
        default:
          throw new RuntimeException("Unknown or unsupported type: " +
                                             type);
      }
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  private JSEvent parseEvent() {
    return null;
  }

  private JSTask parseTask() {
    return null;
  }

  private JSGroup parseGroup() {
    return null;
  }
}
