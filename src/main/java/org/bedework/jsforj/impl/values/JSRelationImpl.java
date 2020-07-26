/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.impl.JSPropertyNames;
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
    final JSProperty<JSList<String>> val =
            getProperty(new TypeReference<>() {},
                        JSPropertyNames.relation);

    if (val != null) {
      return val.getValue();
    }

    if (!create) {
      return null;
    }

    return (JSList<String>)addProperty(
            factory.makeProperty(JSPropertyNames.relation)).getValue();
  }
}
