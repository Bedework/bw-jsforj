/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.dataTypes.JSString;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSSendTo
        extends JSMap<String, JSString> {
  /** Create and add a new replyTo entry with a method as key
   *
   */
  JSProperty<JSString> makeSendTo(String method,
                                   String address);
}
