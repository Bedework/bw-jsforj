package org.bedework.jsforj.model.values;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSNDay extends JSValue {
  void setDay(String val);

  String getDay();

  void setNthOfPeriod(String val);

  String getNthOfPeriod();
}
