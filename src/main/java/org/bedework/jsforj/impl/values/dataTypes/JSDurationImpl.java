/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSDuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

/** Use a string node tohold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSDurationImpl extends JSValueImpl
        implements JSDuration {
  public JSDurationImpl(final String value) {
    super(JSTypes.typeDuration, new TextNode(value));

    // validate it
    // ...
  }

  public JSDurationImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }
}
