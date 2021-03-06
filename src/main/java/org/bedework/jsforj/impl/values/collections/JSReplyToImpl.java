/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.collections.JSReplyTo;
import org.bedework.jsforj.model.values.dataTypes.JSString;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSReplyToImpl
        extends JSMapImpl<String, JSString>
        implements JSReplyTo {
  public JSReplyToImpl(final String type,
                       final JsonNode node) {
    super(type, node);
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeString;
  }

  @Override
  protected String convertKey(final String key) {
    return key;
  }

  @Override
  protected String convertFieldName(final String fieldName) {
    return fieldName;
  }

  @Override
  public JSProperty<JSString> makeReplyTo(final String method,
                                          final String address) {
    final var prop = getFactory().makeProperty(method, address);

    put(prop);

    return prop;
  }
}
