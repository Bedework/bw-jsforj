package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSRelations;
import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

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

  /**
   *
   * @return an absolute trigger. Will be set in alert.
   */
  JSAbsoluteTrigger makeAbsoluteTrigger();

  /**
   *
   * @return an offset trigger. Will be set in alert.
   */
  JSOffsetTrigger makeOffsetTrigger();

  void setAction(String val);

  String getAction();

  void setAcknowledged(JSUTCDateTime val);

  JSUTCDateTime getAcknowledged();

  /**
   *
   * @param create true if we create property if it doesn't exist
   * @return relations object
   */
  JSRelations getRelatedTo(boolean create);
}
