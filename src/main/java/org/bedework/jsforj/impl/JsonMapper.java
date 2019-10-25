/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSGroup;
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
  final static JSFactory factory = new JSFactory();

  public JsonMapper() {
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // configure(JsonFactory.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public JSCalendarObject parse(final Reader rdr) {
    try {
      final JsonNode nd = readTree(rdr);

      if (!nd.isObject()) {
        throw new RuntimeException("Not a calendar object");
      }

      final String type = factory.getType(nd);

      switch (type) {
        case JSTypes.typeJSEvent:
          return parseEvent(nd);
        case JSTypes.typeJSTask:
          return parseTask(nd);
        case JSTypes.typeJSGroup:
          return parseGroup(nd);
        default:
          throw new RuntimeException(
                  "Unknown or unsupported type: " +
                          type);
      }
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  private JSEvent parseEvent(final JsonNode nd) {
    final JSEventImpl ent = new JSEventImpl();

    parseProperties(ent, nd);

    return ent;
  }

  private JSTask parseTask(final JsonNode nd) {
    final JSTaskImpl ent = new JSTaskImpl();

    parseProperties(ent, nd);

    return ent;
  }

  private JSGroup parseGroup(final JsonNode nd) {
    final JSGroupImpl ent = new JSGroupImpl();

    parseProperties(ent, nd);

    return ent;
  }

  void parseProperties(final JSCalendarObject ent,
                       final JsonNode nd) {
    for (var it = nd.fieldNames(); it.hasNext(); ) {
      var fieldName = it.next();

      //TODO - check validity?

      JsonNode fldNode = nd.findValue(fieldName);
      ent.addProperty(factory.makeProperty(fieldName, fldNode));
    }
  }
}
