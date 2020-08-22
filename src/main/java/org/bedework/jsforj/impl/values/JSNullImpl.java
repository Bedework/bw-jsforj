/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSNull;

import com.fasterxml.jackson.databind.node.NullNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSNullImpl extends JSValueImpl
        implements JSNull {
  public JSNullImpl() {
    super(JSTypes.typeNull, NullNode.getInstance());
  }
}
