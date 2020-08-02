package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSAbsoluteTrigger extends JSTrigger {
  void setWhen(JSUTCDateTime val);

  JSUTCDateTime getWhen();
}
