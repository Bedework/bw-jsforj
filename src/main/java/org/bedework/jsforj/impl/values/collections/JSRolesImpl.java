/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.values.JSRoles;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 4/22/20 Time: 16:20
 */
public class JSRolesImpl extends JSStringListImpl
        implements JSRoles {
  public JSRolesImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }
}
