/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.collections.JSList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLocationImpl extends JSValueImpl
        implements JSLocation {
  public JSLocationImpl(final String type,
                        final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setName(final String val) {
    setProperty(JSPropertyNames.name, val);
  }

  @Override
  public String getName() {
    return getStringProperty(JSPropertyNames.name);
  }

  @Override
  public void setDescription(final String val) {
    setProperty(JSPropertyNames.description, val);
  }

  @Override
  public String getDescription() {
    return getStringProperty(JSPropertyNames.description);
  }

  @Override
  public void setRelativeTo(final String val) {
    setProperty(JSPropertyNames.relativeTo, val);
  }

  @Override
  public String getRelativeTo() {
    return getStringProperty(JSPropertyNames.relativeTo);
  }

  @Override
  public void setTimeZone(final String val) {
    setProperty(JSPropertyNames.timeZone, val);
  }

  @Override
  public String getTimeZone() {
    return getStringProperty(JSPropertyNames.timeZone);
  }

  @Override
  public void setCoordinates(final String val) {
    setProperty(JSPropertyNames.coordinates, val);
  }

  @Override
  public String getCoordinates() {
    return getStringProperty(JSPropertyNames.coordinates);
  }

  @Override
  public void setLocationTypes(final JSList<String> val) {
    setProperty(factory.makeProperty(JSPropertyNames.locationTypes, val));
  }

  @Override
  public JSList<String> getLocationTypes(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.locationTypes,
                    create);
  }
}
