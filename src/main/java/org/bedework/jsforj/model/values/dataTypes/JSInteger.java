/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model.values.dataTypes;

import org.bedework.jsforj.model.values.JSValue;

/**
 * User: mike Date: 10/28/19 Time: 12:09
 */
public interface JSInteger extends JSValue {
  int get();

  /**
   * Compares with an int value numerically. The value returned is
   * identical to what would be returned by:
   *
   * Integer.valueOf(this.value).compareTo(Integer.valueOf(that))
   *
   * @param that the int to compare
   * @return the value 0 if this == that; a value less than 0 if this < that; and a value greater than 0 if this > that
   */
  int compare(final int that);

  /**
   * Compares with an int value numerically. The value returned is
   * identical to what would be returned by:
   *
   * Integer.valueOf(this.value).compareTo(Integer.valueOf(that))
   *
   * @param that the int to compare
   * @return the value 0 if this == that; a value less than 0 if this < that; and a value greater than 0 if this > that
   */
  int compare(final JSInteger that);
}
