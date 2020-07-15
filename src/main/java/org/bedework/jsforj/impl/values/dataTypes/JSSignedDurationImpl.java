/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/** Use a string node tohold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSSignedDurationImpl extends JSValueImpl
        implements JSSignedDuration {
  public JSSignedDurationImpl(final String value) {
    super(JSTypes.typeSignedDuration, new TextNode(value));

    // validate it
    // ...
  }

  public JSSignedDurationImpl(final String type,
                              final JsonNode node) {
    super(type, node);
  }
}
