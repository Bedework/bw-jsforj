/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSURI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.net.URI;

/** Use a string node tohold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSURIImpl extends JSValueImpl
        implements JSURI {
  public JSURIImpl(final String value) {
    super(JSTypes.typeURI, new TextNode(value));

    // validate it
    try {
      new URI(value);
    } catch (final Throwable t) {
      throw new JsforjException(t);
    }
  }

  public JSURIImpl(final String type,
                   final JsonNode node) {
    super(type, node);
  }

  @Override
  public URI get() {
    final var val = getNode().asText();

    if (val == null) {
      return null;
    }

    try {
      return new URI(val);
    } catch (final Throwable t) {
      throw new JsforjException(t);
    }
  }
}
