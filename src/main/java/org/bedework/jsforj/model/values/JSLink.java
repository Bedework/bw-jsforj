package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSLink extends JSValue {
  void setHref(String val);

  String getHref();

  void setScheme(String val);

  String getScheme();

  void setCid(String val);

  String getCid();

  void setContentType(String val);

  String getContentType();

  /** The size, in octets, of the resource when fully decoded (i.e., the
   * number of octets in the file the user would download), if known.
   * Note that this is an informational estimate, and implementations
   * must be prepared to handle the actual size being quite different
   * when the resource is fetched.
   *
   * @param val size >= 0
   */
  void setSize(JSUnsignedInteger val);

  JSUnsignedInteger getSize();

  void setRel(String val);

  String getRel();

  void setDisplay(String val);

  String getDisplay();

  void setTitle(String val);

  String getTitle();
}
