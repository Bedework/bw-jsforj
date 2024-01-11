package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSLinks;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.dataTypes.JSURI;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSLocation extends JSValue {
  void setName(String val);

  String getName();

  void setUid(String val);

  String getUid();

  void setDescription(String val);

  String getDescription();

  void setRelativeTo(String val);

  String getRelativeTo();

  void setTimeZone(String val);

  String getTimeZone();

  void setCoordinates(JSURI val);

  /**
   *
   * @param val must be a valid URI
   */
  void setCoordinates(String val);

  JSURI getCoordinates(boolean create);

  void setLocationTypes(JSList<String> val);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return list of location types
   */
  JSList<String> getLocationTypes(boolean create);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return JSLinks object - never null if create true
   */
  JSLinks getLinks(boolean create);
}
