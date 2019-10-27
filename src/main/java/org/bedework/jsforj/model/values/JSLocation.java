package org.bedework.jsforj.model.values;

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

  // locationTypes: "String[Boolean]"
  // linkIds: "Id[Boolean]"
}
