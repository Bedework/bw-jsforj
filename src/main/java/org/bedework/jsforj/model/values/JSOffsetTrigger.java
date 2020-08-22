package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSOffsetTrigger extends JSTrigger {
  String relativeToStart = "start";

  String relativeToEnd = "end";

  void setOffset(JSSignedDuration val);

  JSSignedDuration getOffset();

  void setRelativeTo(String val);

  String getRelativeTo();
}
