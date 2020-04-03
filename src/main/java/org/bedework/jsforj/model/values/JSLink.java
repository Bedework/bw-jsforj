package org.bedework.jsforj.model.values;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSLink extends JSValue {
  void setHref(String val);

  String getHref();

  void setRel(String val);

  String getRel();

}
