package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Writer;
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

  /** Will return true if getValueList will return an array of values
   * and the external representation is an array.
   *
   * @return true if this is an array of values
   */
  boolean isArray();

  /** Will return true if getValueList will return an array of values.
   *
   * @return true if this is a list of values
   */
  boolean isValueList();

  /** Will return conceptual arrays of properties as a value list,
   * for example
   * <pre>
   *          "comments": {
   *            "owner": true,
   *            "attendee": true,
   *            "chair": true
   *          }
   * </pre>
   * will return ["owner", "attendee", "chair"]
   *
   * @return unmodifiable list of values if this is a value list
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
   * @return true if this is a list of properties, e.g. locations
   */
  boolean isPropertyList();

  /** Properties will all have the same type, e.g. location
   *
   * @return unmodifiable list of properties if this is a properties list
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
  <T extends JSValue> JSProperty<T> getProperty(
          TypeReference<T> type,
          String name);

  /** Remove named property
   *
   * @throws RuntimeException if not an object
   */
  void removeProperty(String name);

  /**
   * Remove all contained properties and values
   */
  void clear();

  /**
   *
   * @param val the property - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  <ValType extends JSValue> JSProperty<ValType> addProperty(
          JSProperty<ValType> val);

  /** Add a string type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty<?> addProperty(String name, String val);

  /** Add or replace the named property
   *
   * @param val the property - non null
   * @return the property
   */
  JSProperty<?> setProperty(JSProperty<?> val);

  /** Set the value for a string type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   */
  JSProperty<?> setProperty(String name, String val);

  /** Get the value. Return null if absent.
   *
   * @param name of property
   * @return the value or null
   */
  JSValue getPropertyValue(String name);

  /** Returns value of named String property.
   *
   * @param name the property name - non null
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  String getStringProperty(String name);

  /** Sets the named property to have a value of null.
   * This is only used for patch objects to signify the removal of a
   * property by an override.
   *
   * @param name of properties - generates a path
   */
  void setNull(String... name);
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
  JSProperty<?> setProperty(String name, JSUnsignedInteger val);

  /** Add an UnsignedInteger type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty<?> addProperty(String name, JSUnsignedInteger val);

  /** Set the value for an UnsignedInteger type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   */
  JSProperty<?> setProperty(String name, Integer val);

  /** Set the value for a boolean type property
   *
   * @param name the property name - non null
   * @param val the property value
   * @return the property
   */
  JSProperty<?> setProperty(String name, boolean val);

  /** Add an UnsignedInteger type property
   *
   * @param name the property name - non null
   * @param val the property value - non null
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty<?> addProperty(String name, Integer val);

  /** Add a boolean type property
   *
   * @param name the property name - non null
   * @param val the property value - true/false
   * @return the property
   * @throws RuntimeException if not an object or property already exists
   */
  JSProperty<?> addProperty(String name, boolean val);

  /** Add a property of given type.
   *
   * @param name the property name - non null
   * @param type the property type
   * @return the property
   * @throws RuntimeException if property already exists
   */
  <T extends JSValue> JSProperty<T> makeProperty(
          TypeReference<T> typeRef,
          String name, String type);

  /** Returns value of named UnsignedInteger property.
   *
   * @param name the property name - non null
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  JSUnsignedInteger getUnsignedIntegerProperty(String name);

  /** Returns value as a String.
   *
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  String getStringValue();

  /** Returns value as a boolean.
   *
   * @return the value of the property
   * @throws RuntimeException if not a boolean property
   */
  boolean getBooleanValue();

  /** Convert to json with this as root
   *
   * @param wtr to write to
   * @param mapper to convert
   */
  void writeValue(Writer wtr,
                  ObjectMapper mapper);

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
