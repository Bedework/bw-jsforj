/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSRelation;
import org.bedework.jsforj.model.values.collections.JSList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRelationImpl extends JSValueImpl
        implements JSRelation {
  public JSRelationImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }

  @Override
  public JSList<String> getRelations(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.relation, create);
  }
}
