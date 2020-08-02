package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.dataTypes.JSSignedDuration;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSAlert extends JSValue {
  /** The alert should be displayed as appropriate for the
    current device and user context.
   */
  String alertActionDisplay = "display";

  /** The alert should trigger an email sent out to the
    user, notifying about the alert.  This action is typically only
    appropriate for server implementations.
   */
  String alertActionEmail = "email";

  void setTrigger(JSTrigger val);

  JSTrigger getTrigger();

  void setAction(String val);

  String getAction();

  void setOffset(JSSignedDuration offset);

  JSSignedDuration getOffset();

  void setRelativeTo(String val);

  String getRelativeTo();
}
