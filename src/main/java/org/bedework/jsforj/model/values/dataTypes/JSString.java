/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.dataTypes;

import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/28/19 Time: 12:09
 */
public interface JSString extends JSValue {
  String get();

  /**
   * Compares with a String value.
   *
   * @param that the value to compare
   * @return the value 0 if this == that; a value less than 0 if this < that; and a value greater than 0 if this > that
   */
  int compare(final String that);

  /**
   * Compares with a JSString value.
   *
   * @param that the value to compare
   * @return the value 0 if this == that; a value less than 0 if this < that; and a value greater than 0 if this > that
   */
  int compare(final JSString that);
}
