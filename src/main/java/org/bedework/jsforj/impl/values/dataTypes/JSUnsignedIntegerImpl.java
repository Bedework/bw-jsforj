/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * User: mike Date: 5/18/20 Time: 17:50
 */
public class JSUnsignedIntegerImpl extends JSValueImpl
        implements JSUnsignedInteger {
  public JSUnsignedIntegerImpl(final int value) {
    super(JSTypes.typeUnsignedInt, new IntNode(value));
    if (value < 0) {
      throw new RuntimeException("Value < 0 for unsigned int:" + value);
    }
  }

  public JSUnsignedIntegerImpl(final String typeName,
                               final JsonNode node) {
    super(typeName, node);
    assertIntNode();
  }

  @Override
  public int get() {
    return getNode().asInt();
  }

  @Override
  public int compare(final int that) {
    return Integer.compareUnsigned(get(), that);
  }

  @Override
  public int compare(final JSUnsignedInteger that) {
    return Integer.compareUnsigned(get(), that.get());
  }

  public String toString() {
    return String.valueOf(get());
  }
}
