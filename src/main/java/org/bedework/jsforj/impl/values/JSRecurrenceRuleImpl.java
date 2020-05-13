/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLocalDateTime;
import org.bedework.jsforj.model.values.JSNDay;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.UnsignedInteger;
import org.bedework.jsforj.model.values.collections.JSArray;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSRecurrenceRuleImpl extends JSValueImpl
        implements JSRecurrenceRule {
  public JSRecurrenceRuleImpl(final String type,
                              final JsonNode node) {
    super(type, node);
  }

  @Override
  public void setFrequency(final String val) {
    setProperty(JSPropertyNames.frequency, val);
  }

  @Override
  public String getFrequency(final boolean create) {
    return getValue(String.class, JSPropertyNames.frequency, create);
  }

  @Override
  public void setInterval(final UnsignedInteger val) {
    setProperty(JSPropertyNames.interval, val);
  }

  @Override
  public UnsignedInteger getInterval(final boolean create) {
    return getValue(UnsignedInteger.class, JSPropertyNames.interval, create);
  }

  @Override
  public void setRscale(final String val) {
    setProperty(JSPropertyNames.rscale, val);
  }

  @Override
  public String getRscale(final boolean create) {
    return getValue(String.class, JSPropertyNames.rscale, create);
  }

  @Override
  public void setSkip(final String val) {
    setProperty(JSPropertyNames.skip, val);
  }

  @Override
  public String getSkip(final boolean create) {
    return getValue(String.class, JSPropertyNames.skip, create);
  }

  @Override
  public void setFirstDayOfWeek(final String val) {
    setProperty(JSPropertyNames.firstDayOfWeek, val);
  }

  @Override
  public String getFirstDayOfWeek(final boolean create) {
    return getValue(String.class, JSPropertyNames.firstDayOfWeek, create);
  }

  @Override
  public JSArray<JSNDay> getByDay(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byDay, create);
  }

  @Override
  public void addByDayValue(final String day,
                            final Integer nthOfPeriod) {
    final JSNDay nday = (JSNDay)factory.newValue(JSTypes.typeNDay);

    nday.setProperty(JSPropertyNames.day, day);
    if ((nthOfPeriod != null) && (nthOfPeriod != 0)) {
      nday.setProperty(JSPropertyNames.nthOfPeriod, nthOfPeriod);
    }

    getByDay(true).add(nday);
  }

  @Override
  public void setByMonthDay(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMonthDay, val));
  }

  @Override
  public JSArray<Integer> getByMonthDay(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byMonthDay, create);
  }

  @Override
  public void setByMonth(final JSArray<String> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMonth, val));
  }

  @Override
  public JSArray<String> getByMonth(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byMonth, create);
  }

  @Override
  public void setByYearDay(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byYearDay, val));
  }

  @Override
  public JSArray<Integer> getByYearDay(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byYearDay, create);
  }

  @Override
  public void setByWeekNo(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byWeekNo, val));
  }

  @Override
  public JSArray<Integer> getByWeekNo(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byWeekNo, create);
  }

  @Override
  public void setByHour(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byHour, val));
  }

  @Override
  public JSArray<UnsignedInteger> getByHour(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byHour, create);
  }

  @Override
  public void setByMinute(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMinute, val));
  }

  @Override
  public JSArray<UnsignedInteger> getByMinute(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.byMinute, create);
  }

  @Override
  public void setBySecond(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.bySecond, val));
  }

  @Override
  public JSArray<UnsignedInteger> getBySecond(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.bySecond, create);
  }

  @Override
  public void setBySetPosition(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.bySetPosition, val));
  }

  @Override
  public JSArray<Integer> getBySetPosition(final boolean create) {
    return getValue(JSArray.class, JSPropertyNames.bySetPosition, create);
  }

  @Override
  public void setCount(final UnsignedInteger val) {
    setProperty(JSPropertyNames.count, val);
  }

  @Override
  public UnsignedInteger getCount(final boolean create) {
    return getValue(UnsignedInteger.class, JSPropertyNames.count, create);
  }

  @Override
  public void setUntil(final JSLocalDateTime val) {
    addProperty(factory.makeProperty(JSPropertyNames.until, val));
  }

  @Override
  public JSLocalDateTime getUntil(final boolean create) {
    return getValue(JSLocalDateTime.class, JSPropertyNames.until, create);
  }
}
