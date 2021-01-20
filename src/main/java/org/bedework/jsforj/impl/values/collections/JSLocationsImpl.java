/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.collections.JSLocations;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLocationsImpl
        extends JSIdMapImpl<String, JSLocation>
        implements JSLocations {
  private final AtomicInteger idCtr = new AtomicInteger();

  public JSLocationsImpl(final String type,
                         final JsonNode node) {
    super(type, node);
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeLocation;
  }

  @Override
  protected String convertKey(final String key) {
    return key;
  }

  @Override
  protected String convertFieldName(final String fieldName) {
    return fieldName;
  }

  @Override
  public JSProperty<JSLocation> makeLocation() {
    return makeEntry(nextId());
  }
}
