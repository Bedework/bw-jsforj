/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.test;

import org.bedework.jsforj.impl.values.dataTypes.JSLocalDateTimeImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSUTCDateTimeImpl;
import org.bedework.jsforj.model.values.dataTypes.JSDateTime;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * User: mike Date: 1/25/21 Time: 14:29
 */
public class JsDateTimeTest {

  @BeforeClass
  public static void oneTimeSetUp() {

  }

  @AfterClass
  public static void oneTimeTearDown() {

  }

  @Test
  public void testReadData() {
    try {
      testDt("2021-03-15T13:31:07",
             2021, 3, 15, 13, 31, 7, 0, false);

      testDt("2022-04-14T14:41:17.12345",
             2022, 4, 14, 14, 41, 17, 12345, false);

      testDt("2021-03-15T13:31:07Z",
             2021, 3, 15, 13, 31, 7, 0, true);

      testDt("2021-03-15T13:31:07.12345Z",
             2021, 3, 15, 13, 31, 7, 12345, true);

    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  private void testDt(final String val,
                      final long year,
                      final int month,
                      final int day,

                      final int hours,
                      final int minutes,
                      final int seconds,

                      final long fractional,

                      final boolean utc) {
    final JSDateTime dt;

    if (utc) {
      dt = new JSUTCDateTimeImpl(val);
    } else {
      dt = new JSLocalDateTimeImpl(val);
    }

    final var dtc = dt.getComponents();

    if (utc) {
      Assert.assertTrue("Must be UTC", dtc.isUtc());
    } else {
      Assert.assertFalse("Must not be UTC", dtc.isUtc());
    }

    Assert.assertEquals("Years match", year, dtc.getYear());
    Assert.assertEquals("Months match", month, dtc.getMonth());
    Assert.assertEquals("Days match", day, dtc.getDay());

    Assert.assertEquals("Hours match", hours, dtc.getHours());
    Assert.assertEquals("Minutes match", minutes, dtc.getMinutes());
    Assert.assertEquals("Seconds match", seconds, dtc.getSeconds());

    Assert.assertEquals("Fractionals match", fractional, dtc.getFractional());
  }
}
