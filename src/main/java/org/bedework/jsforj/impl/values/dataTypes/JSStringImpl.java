/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSString;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * User: mike Date: 5/18/20 Time: 17:50
 */
public class JSStringImpl extends JSValueImpl
        implements JSString {
  public JSStringImpl(final String value) {
    super(JSTypes.typeString, new TextNode(value));
  }

  public JSStringImpl(final String typeName,
                      final JsonNode node) {
    super(typeName, node);
    assertStringNode();
  }

  @Override
  public String get() {
    return getNode().asText();
  }

  @Override
  public int compare(final String that) {
    return get().compareTo(that);
  }

  @Override
  public int compare(final JSString that) {
    return get().compareTo(that.get());
  }

  public String toString() {
    return get();
  }
}
