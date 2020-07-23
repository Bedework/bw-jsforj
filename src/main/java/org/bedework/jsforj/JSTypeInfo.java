/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj;

import org.bedework.jsforj.model.JSTypes;

/**
 * User: mike Date: 7/23/20 Time: 13:30
 */
public class JSTypeInfo {
  final String name;
  private final boolean valueList;
  private final boolean propertyList;
  private final String[] elementType;
  private final boolean object;
  private final Class<? extends JSValueFactory> factoryClass;

  public JSTypeInfo(final String name,
                    final boolean valueList,
                    final boolean propertyList,
                    final String[] elementType,
                    final boolean object,
                    final Class<? extends JSValueFactory> factoryClass) {
    this.name = name;
    this.valueList = valueList;
    this.propertyList = propertyList;
    this.elementType = elementType;
    this.object = object;
    this.factoryClass = factoryClass;
  }

  public String getName() {
    return name;
  }

  public boolean getValueList() {
    return valueList;
  }

  public boolean getPropertyList() {
    return propertyList;
  }

  /**
   *
   * @return true if we need a boolean node
   */
  public boolean getBoolean() {
    return name.equals(JSTypes.typeBoolean);
  }

  /**
   *
   * @return true if we need an integer node
   */
  public boolean getInteger() {
    return name.equals(JSTypes.typeInt) ||
            name.equals(JSTypes.typeUnsignedInt);
  }

  /**
   *
   * @return true if we need a String node
   */
  public boolean getString() {
    return name.equals(JSTypes.typeString);
  }

  public String[] getElementType() {
    return elementType;
  }

  public boolean getObject() {
    return object;
  }

  /**
   *
   * @return class used to create objects - maybe the class represented here
   *               or elements of the property list.
   */
  public Class<?> getFactoryClass() {
    return factoryClass;
  }
}
