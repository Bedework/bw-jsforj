/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.collections.JSRelations;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRelationsImpl extends JSListImpl<JSProperty>
        implements JSRelations {
  public JSRelationsImpl(final String type,
                         final JsonNode node) {
    super(type, node);
  }

  @Override
  protected void store(final JSProperty val) {
    addProperty(val);
  }

  @Override
  protected String fieldName(final JSProperty val) {
    return val.getName();
  }

  @Override
  protected JSProperty convertToT(final String val) {
    return getFactory().makeProperty(val,
                                      JSTypes.typeRelation,
                                      getNode().get(val));
  }

  @Override
  public JSProperty makeRelation(final String uid) {
    final JSProperty rel =
            getFactory().makeProperty(uid,
                                      JSTypes.typeRelation,
                                      null);
    add(rel);

    return rel;
  }
}
