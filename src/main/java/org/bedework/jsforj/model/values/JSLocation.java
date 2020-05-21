package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSList;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSLocation extends JSValue {
  void setName(String val);

  String getName();

  void setDescription(String val);

  String getDescription();

  void setRelativeTo(String val);

  String getRelativeTo();

  void setTimeZone(String val);

  String getTimeZone();

  void setCoordinates(String val);

  String getCoordinates();

  void setLocationTypes(JSList<String> val);

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return list of location types
   */
  JSList<String> getLocationTypes(boolean create);

  // linkIds: "Id[Boolean]"
}
