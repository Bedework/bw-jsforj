/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.collections.JSLocations;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLocationsImpl
        extends JSListImpl<JSProperty<JSLocation>>
        implements JSLocations {
  public JSLocationsImpl(final String type,
                         final JsonNode node) {
    super(type, node);
  }

  @Override
  protected void store(final JSProperty<JSLocation> val) {
    final String id = val.getName();
    if (id == null) {
      throw new RuntimeException(
              "Id must be set for a location");
    }

    addProperty(val);
  }

  @Override
  protected String fieldName(final JSProperty<JSLocation> val) {
    return val.getName();
  }

  @Override
  protected JSProperty<JSLocation> convertToT(final String val) {
    return getFactory().makeProperty(val,
                                     JSTypes.typeLocation,
                                     getNode().get(val));
  }

  @Override
  public JSProperty<JSLocation> makeLocation() {
    return makeLocation(UUID.randomUUID().toString());
  }

  @Override
  public JSProperty<JSLocation> makeLocation(final String id) {
    final JSProperty<JSLocation> p =
            getFactory().makeProperty(id,
                                      JSTypes.typeLocation,
                                      null);
    add(p);

    return p;
  }
}
