/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.model;

/** The values for each part are the numeric representation of that part
 * of the date or date-time. e,g, in 2020-30-15 the month will be 3.
 *
 * User: mike Date: 1/25/21 Time: 13:48
 */
public class DateTimeComponents {
  private long year;
  private int month;
  private int day;

  private int hours;
  private int minutes;
  private int seconds;

  private long fractional;

  private boolean dateOnly;

  public long getYear() {
    return year;
  }

  public void setYear(final long val) {
    this.year = val;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(final int val) {
    this.month = val;
  }

  public int getDay() {
    return day;
  }

  public void setDay(final int val) {
    this.day = val;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(final int val) {
    this.hours = val;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(final int val) {
    this.minutes = val;
  }

  public int getSeconds() {
    return seconds;
  }

  public void setSeconds(final int val) {
    this.seconds = val;
  }

  public long getFractional() {
    return fractional;
  }

  public void setFractional(final long val) {
    this.fractional = val;
  }

  public boolean isDateOnly() {
    return dateOnly;
  }

  public void setDateOnly(final boolean val) {
    this.dateOnly = val;
  }

  public boolean isUtc() {
    return utc;
  }

  public void setUtc(final boolean val) {
    this.utc = val;
  }

  private boolean utc;

}
