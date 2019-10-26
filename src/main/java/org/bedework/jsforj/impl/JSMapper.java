/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSCalendarObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;

/**
 * User: mike Date: 10/23/19 Time: 23:44
 */
public class JSMapper extends ObjectMapper {
  final static JSFactory factory = JSFactory.getFactory();

  public JSMapper() {
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // configure(JsonFactory.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public JSCalendarObject parse(final Reader rdr) {
    final JsonNode nd;

    try {
      nd = readTree(rdr);
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }

    return factory.makeCalObj(nd);
  }
}
