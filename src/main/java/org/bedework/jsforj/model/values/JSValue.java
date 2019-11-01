package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSProperty;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * User: mike Date: 10/24/19 Time: 10:21
 */
public interface JSValue {
  /**
   *
   * @return the type of the value
   */
  String getType();

  /** For example
   * <pre>
   *          "roles": {
   *            "owner": true,
   *            "attendee": true,
   *            "chair": true
   *          }
   * </pre>
   *
   * @return true if this is a list of values
   */
  boolean isValueList();

  /**
   *
   * @return values if this is a value list
   * @throws RuntimeException if not a value list
   */
  List<JSValue> getValueList();

  /** For example
   * <pre>
   *      "locations": {
   *        "2a358cee-6489-4f14-a57f-c104db4dc2f1": {
   *          "@type": "Location",
   *          "rel": "start",
   *          "name": "Frankfurt Airport (FRA)"
   *        },
   *        "c2c7ac67-dc13-411e-a7d4-0780fb61fb08": {
   *          "@type": "Location",
   *          "rel": "end",
   *          "name": "Narita International Airport (NRT)",
   *          "timeZone": "Asia/Tokyo"
   *        }
   *      }
   * </pre>
   * @return true if this is a list of properties, e.g.
   */
  boolean isPropertyList();

  /** Properties will al have the same type, e.g. location
   *
   * @return properties if this is a properties list
   * @throws RuntimeException if not a properties list
   */
  List<JSProperty> getPropertyList();

  /**
   *
   * @return true if this is an object with properties
   */
  boolean isObject();

  /** Return all contained properties
   *
   * @return properties
   * @throws RuntimeException if not an object
   */
  List<JSProperty> getProperties();

  /** Return named property
   *
   * @return property or null
   * @throws RuntimeException if not an object
   */
  JSProperty getProperty(String name);

  /** Remove named property
   *
   * @throws RuntimeException if not an object
   */
  void removeProperty(String name);

  /**
   *
   * @param val the property - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty addProperty(JSProperty val);

  /** Set the value for a string type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   */
  JSProperty setProperty(final String name, final String val);

  /** Get the value. Create the property if absent.
   *
   * @param name of property
   * @return the value
   */
  JSValue getPropertyValueAlways(final String name);

  /** Get the value. Return null if absent.
   *
   * @param name of property
   * @return the value or null
   */
  JSValue getPropertyValue(final String name);

  /** Add a string type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty addProperty(final String name, final String val);

  /** Returns value of named String property.
   *
   * @param name the property name - non null
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  String getStringProperty(String name);

  /**
   *
   * @return true if this is a string
   */
  boolean isString();

  /** Set the value for an UnsignedInteger type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   */
  JSProperty setProperty(final String name, final UnsignedInteger val);

  /** Add an UnsignedInteger type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty addProperty(final String name, final UnsignedInteger val);

  /** Returns value of named UnsignedInteger property.
   *
   * @param name the property name - non null
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  UnsignedInteger getUnsignedIntegerProperty(String name);

  /** Returns value as a String.
   *
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  String getStringValue();

  /** Convert to json with this as root
   *
   * @param mapper to convert
   * @return Json
   */
  String writeValueAsString(ObjectMapper mapper);

  /** Convert to formatted json with this as root
   *
   * @param mapper to convert
   * @return Json
   */
  String writeValueAsStringFormatted(ObjectMapper mapper);
}
