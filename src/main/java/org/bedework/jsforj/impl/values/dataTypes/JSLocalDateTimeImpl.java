/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.dataTypes;

import org.bedework.jsforj.impl.values.JSValueImpl;
import org.bedework.jsforj.model.DateTimeComponents;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Use a string node tohold the value
 *
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSLocalDateTimeImpl extends JSValueImpl
        implements JSLocalDateTime {
  //Build formatter
  static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

  public JSLocalDateTimeImpl(final String value) {
    super(JSTypes.typeLocalDateTime, new TextNode(value));

    // validate it
    LocalDateTime.parse(value, formatter);
  }

  public JSLocalDateTimeImpl(final String type,
                             final JsonNode node) {
    super(type, node);
  }

  @Override
  public LocalDateTime getDt() {
    return LocalDateTime.parse(getNode().textValue(), formatter);
  }

  private  final static Pattern localDatePattern =
          Pattern.compile(
                  "(?<year>\\d\\d\\d\\d)-(?<month>\\d\\d)-(?<day>\\d\\d)" + // date
                          "T(?<hours>\\d\\d):(?<minutes>\\d\\d):(?<seconds>\\d\\d)" +
                          "(\\.(?<fraction>\\d*))?" +  // [time]
                          "(?<trailing>.*)");        // trailing junk

  @Override
  public DateTimeComponents getComponents() {
    final Matcher m = localDatePattern.matcher(getStringValue());
    if (!m.matches()) {
      return null;
    }

    final String trailing = m.group("trailing");

    if ((trailing != null) && (trailing.length() > 0)) {
      return null; // trailing junk
    }

    final var res = new DateTimeComponents();

    res.setDateOnly(false);
    res.setUtc(false);

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
