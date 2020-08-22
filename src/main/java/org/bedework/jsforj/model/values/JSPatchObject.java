/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * User: mike Date: 4/21/20 Time: 13:45
 */
public interface JSPatchObject extends JSValue {
  /** Sets the named property to have a value of null.
   * This is only used for patch objects to signify the removal of a
   * property by an override.
   *
   * @param name of properties - generates a path
   */
  void setNull(String... name);

  /** Set the value for a string type property
   *
   * @param val the property value - non null
   * @param names the property names - non null - forms path
   * @return the property
   */
  JSProperty<?> setOverrideProperty(String val, String... names);

  /** Set the value for an UnsignedInteger type property
   *
   * @param val the property value - non null
   * @param names the property names - non null - forms path
   * @return the property
   */
  JSProperty<?> setOverrideProperty(JSUnsignedInteger val, String... names);

  /** Set the value for an UnsignedInteger type property
   *
   * @param val the property value - non null
   * @param names the property names - non null - forms path
   * @return the property
   */
  JSProperty<?> setOverrideProperty(boolean val, String... names);

  /** Create a property of the given type. NOT added or set
   *
   * @param typeRef the property typeref
   * @param type the property type
   * @param names the property names - non null
   * @return the property
   */
  <T extends JSValue> JSProperty<T> newOverrideProperty(
          TypeReference<T> typeRef,
          String type,
          String... names);
}
