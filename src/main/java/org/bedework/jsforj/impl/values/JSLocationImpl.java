/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.values.dataTypes.JSURIImpl;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.collections.JSLinks;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.dataTypes.JSURI;

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
  public void setUid(final String val) {
    if (getUid() != null) {
      throw new JsforjException("uid is immutable");
    }

    setProperty(factory.makeProperty(JSPropertyNames.uid,
                                     val));
  }

  @Override
  public String getUid() {
    return getStringProperty(JSPropertyNames.uid);
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
  public void setCoordinates(final JSURI val) {
    setProperty(JSPropertyNames.coordinates, val);
  }

  @Override
  public void setCoordinates(final String val) {
    setCoordinates(new JSURIImpl(val));
  }

  @Override
  public JSURI getCoordinates(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.href,
                    create);
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

  @Override
  public JSLinks getLinks(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.links, create);
  }
}
