/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.DateTimeComponents;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSUTCDateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Use a string node to hold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSUTCDateTimeImpl extends JSValueImpl
        implements JSUTCDateTime {
  public JSUTCDateTimeImpl(final String value) {
    super(JSTypes.typeUTCDateTime, new TextNode(value));

    // validate it
    Instant.parse(value);
  }

  public JSUTCDateTimeImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }

  @Override
  public Instant getDt() {
    return Instant.parse(getNode().textValue());
  }

  private  final static Pattern utcDatePattern =
          Pattern.compile(
                  "(?<year>\\d\\d\\d\\d)-(?<month>\\d\\d)-(?<day>\\d\\d)" + // date
                   "T(?<hours>\\d\\d):(?<minutes>\\d\\d):(?<seconds>\\d\\d)" +
                          "(\\.(?<fraction>\\d*))?Z" +  // [time]
                          "(?<trailing>.*)");        // trailing junk

  @Override
  public DateTimeComponents getComponents() {
    final Matcher m = utcDatePattern.matcher(getStringValue());
    if (!m.matches()) {
      return null;
    }

    final String trailing = m.group("trailing");

    if ((trailing != null) && (trailing.length() > 0)) {
      return null; // trailing junk
    }

    final var res = new DateTimeComponents();

    res.setDateOnly(false);
    res.setUtc(true);

    res.setYear(Long.parseLong(m.group("year")));
    res.setMonth(Integer.parseInt(m.group("month")));
    res.setDay(Integer.parseInt(m.group("day")));

    res.setHours(Integer.parseInt(m.group("hours")));
    res.setMinutes(Integer.parseInt(m.group("minutes")));
    res.setSeconds(Integer.parseInt(m.group("seconds")));

    final String fraction = m.group("fraction");

    if ((fraction != null) && (fraction.length() > 0)) {
      res.setFractional(Long.parseLong(fraction));
    }

    return res;
  }
}
