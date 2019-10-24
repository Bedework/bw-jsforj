package org.bedework.jsforj.model;

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

  /**
   *
   * @param val the property - non null
   * @throws RuntimeException if not an object or property already exists
   */
  void addProperty(JSProperty val);

  /** Returns value as a String.
   *
   * @return the value of the property
   * @throws RuntimeException if not a String property
   */
  String getStringValue();

}
