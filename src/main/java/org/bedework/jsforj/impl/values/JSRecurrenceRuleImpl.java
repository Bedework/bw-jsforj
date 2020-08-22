/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.dataTypes.JSLocalDateTime;
import org.bedework.jsforj.model.values.JSNDay;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.dataTypes.JSString;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;
import org.bedework.jsforj.model.values.collections.JSArray;

import com.fasterxml.jackson.core.type.TypeReference;
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
    final JSString val = getValue(new TypeReference<>() {},
                                  JSPropertyNames.frequency, create);
    if (val == null) {
      return null;
    }
    return val.get();
  }

  @Override
  public void setInterval(final JSUnsignedInteger val) {
    setProperty(JSPropertyNames.interval, val);
  }

  @Override
  public JSUnsignedInteger getInterval(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.interval, create);
  }

  @Override
  public void setRscale(final String val) {
    setProperty(JSPropertyNames.rscale, val);
  }

  @Override
  public String getRscale(final boolean create) {
    final JSString val = getValue(new TypeReference<>() {},
                                  JSPropertyNames.rscale, create);
    if (val == null) {
      return null;
    }
    return val.get();
  }

  @Override
  public void setSkip(final String val) {
    setProperty(JSPropertyNames.skip, val);
  }

  @Override
  public String getSkip(final boolean create) {
    final JSString val = getValue(new TypeReference<>() {},
                                  JSPropertyNames.skip, create);
    if (val == null) {
      return null;
    }
    return val.get();
  }

  @Override
  public void setFirstDayOfWeek(final String val) {
    setProperty(JSPropertyNames.firstDayOfWeek, val);
  }

  @Override
  public String getFirstDayOfWeek(final boolean create) {
    final JSString val = getValue(new TypeReference<>() {},
                                  JSPropertyNames.firstDayOfWeek, create);
    if (val == null) {
      return null;
    }
    return val.get();
  }

  @Override
  public JSArray<JSNDay> getByDay(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byDay, create);
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
    setProperty(factory.makeProperty(JSPropertyNames.byMonthDay, val));
  }

  @Override
  public JSArray<Integer> getByMonthDay(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byMonthDay, create);
  }

  @Override
  public void setByMonth(final JSArray<String> val) {
    setProperty(factory.makeProperty(JSPropertyNames.byMonth, val));
  }

  @Override
  public JSArray<String> getByMonth(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byMonth, create);
  }

  @Override
  public void setByYearDay(final JSArray<Integer> val) {
    setProperty(factory.makeProperty(JSPropertyNames.byYearDay, val));
  }

  @Override
  public JSArray<Integer> getByYearDay(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byYearDay, create);
  }

  @Override
  public void setByWeekNo(final JSArray<Integer> val) {
    setProperty(factory.makeProperty(JSPropertyNames.byWeekNo, val));
  }

  @Override
  public JSArray<Integer> getByWeekNo(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byWeekNo, create);
  }

  @Override
  public void setByHour(final JSArray<JSUnsignedInteger> val) {
    setProperty(factory.makeProperty(JSPropertyNames.byHour, val));
  }

  @Override
  public JSArray<JSUnsignedInteger> getByHour(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byHour, create);
  }

  @Override
  public void setByMinute(final JSArray<JSUnsignedInteger> val) {
    setProperty(factory.makeProperty(JSPropertyNames.byMinute, val));
  }

  @Override
  public JSArray<JSUnsignedInteger> getByMinute(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.byMinute, create);
  }

  @Override
  public void setBySecond(final JSArray<JSUnsignedInteger> val) {
    setProperty(factory.makeProperty(JSPropertyNames.bySecond, val));
  }

  @Override
  public JSArray<JSUnsignedInteger> getBySecond(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.bySecond, create);
  }

  @Override
  public void setBySetPosition(final JSArray<Integer> val) {
    setProperty(factory.makeProperty(JSPropertyNames.bySetPosition, val));
  }

  @Override
  public JSArray<Integer> getBySetPosition(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.bySetPosition, create);
  }

  @Override
  public void setCount(final JSUnsignedInteger val) {
    setProperty(JSPropertyNames.count, val);
  }

  @Override
  public JSUnsignedInteger getCount(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.count, create);
  }

  @Override
  public void setUntil(final JSLocalDateTime val) {
    setProperty(factory.makeProperty(JSPropertyNames.until, val));
  }

  @Override
  public JSLocalDateTime getUntil(final boolean create) {
    return getValue(new TypeReference<>() {},
                    JSPropertyNames.until, create);
  }
}
