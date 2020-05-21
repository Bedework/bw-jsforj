/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSRelation;
import org.bedework.jsforj.model.values.collections.JSRelations;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRelationsImpl
        extends JSMapImpl<String, JSRelation>
        implements JSRelations {
  public JSRelationsImpl(final String type,
                         final JsonNode node) {
    super(type, node);
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeRelation;
  }

  @Override
  protected String convertKey(final String key) {
    return key;
  }

  @Override
  protected String convertFieldName(final String fieldName) {
    return fieldName;
  }
}
