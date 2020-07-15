package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSAlert extends JSValue {
  void setAction(String val);

  String getAction();

  void setOffset(JSSignedDuration offset);

  JSSignedDuration getOffset();

  void setRelativeTo(String val);

  String getRelativeTo();
}
