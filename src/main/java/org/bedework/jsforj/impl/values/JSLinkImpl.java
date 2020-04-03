/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSLink;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLinkImpl extends JSValueImpl
        implements JSLink {
  public JSLinkImpl(final String type,
                    final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setHref(final String val) {
    addProperty(JSPropertyNames.href, val);
  }

  @Override
  public String getHref() {
    return getStringProperty(JSPropertyNames.href);
  }

  @Override
  public void setRel(final String val) {
    addProperty(JSPropertyNames.rel, val);
  }

  @Override
  public String getRel() {
    return getStringProperty(JSPropertyNames.rel);
  }
}
