/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSArray;
import org.bedework.jsforj.model.values.JSLocalDateTime;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.UnsignedInteger;

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
  public String getFrequency() {
    return getStringProperty(JSPropertyNames.frequency);
  }

  @Override
  public void setInterval(final UnsignedInteger val) {
    setProperty(JSPropertyNames.interval, val);
  }

  @Override
  public UnsignedInteger getInterval() {
    return getUnsignedIntegerProperty(JSPropertyNames.interval);
  }

  @Override
  public void setRscale(final String val) {
    setProperty(JSPropertyNames.rscale, val);
  }

  @Override
  public String getRscale() {
    return getStringProperty(JSPropertyNames.rscale);
  }

  @Override
  public void setSkip(final String val) {
    setProperty(JSPropertyNames.skip, val);
  }

  @Override
  public String getSkip() {
    return getStringProperty(JSPropertyNames.skip);
  }

  @Override
  public void setFirstDayOfWeek(final String val) {
    setProperty(JSPropertyNames.firstDayOfWeek, val);
  }

  @Override
  public String getFirstDayOfWeek() {
    return getStringProperty(JSPropertyNames.firstDayOfWeek);
  }

  @Override
  public void setByMonthDay(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMonthDay, val));
  }

  @Override
  public JSArray<Integer> getByMonthDay() {
    return (JSArray<Integer>)getPropertyValueAlways(JSPropertyNames.byMonthDay);
  }

  @Override
  public void setByMonth(final JSArray<String> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMonth, val));
  }

  @Override
  public JSArray<String> getByMonth() {
    return (JSArray<String>)getPropertyValueAlways(JSPropertyNames.byMonth);
  }

  @Override
  public void setByYearDay(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byYearDay, val));
  }

  @Override
  public JSArray<Integer> getByYearDay() {
    return (JSArray<Integer>)getPropertyValueAlways(JSPropertyNames.byYearDay);
  }

  @Override
  public void setByWeekNo(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byWeekNo, val));
  }

  @Override
  public JSArray<Integer> getByWeekNo() {
    return (JSArray<Integer>)getPropertyValueAlways(JSPropertyNames.byWeekNo);
  }

  @Override
  public void setByHour(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byHour, val));
  }

  @Override
  public JSArray<UnsignedInteger> getByHour() {
    return (JSArray<UnsignedInteger>)getPropertyValueAlways(JSPropertyNames.byHour);
  }

  @Override
  public void setByMinute(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.byMinute, val));
  }

  @Override
  public JSArray<UnsignedInteger> getByMinute() {
    return (JSArray<UnsignedInteger>)getPropertyValueAlways(JSPropertyNames.byMinute);
  }

  @Override
  public void setBySecond(final JSArray<UnsignedInteger> val) {
    addProperty(factory.makeProperty(JSPropertyNames.bySecond, val));
  }

  @Override
  public JSArray<UnsignedInteger> getBySecond() {
    return (JSArray<UnsignedInteger>)getPropertyValueAlways(JSPropertyNames.bySecond);
  }

  @Override
  public void setBySetPosition(final JSArray<Integer> val) {
    addProperty(factory.makeProperty(JSPropertyNames.bySetPosition, val));
  }

  @Override
  public JSArray<Integer> getBySetPosition() {
    return (JSArray<Integer>)getPropertyValueAlways(JSPropertyNames.bySetPosition);
  }

  @Override
  public void setCount(final UnsignedInteger val) {
    setProperty(JSPropertyNames.count, val);
  }

  @Override
  public UnsignedInteger getCount() {
    return getUnsignedIntegerProperty(JSPropertyNames.count);
  }

  @Override
  public void setUntil(final JSLocalDateTime val) {
    addProperty(factory.makeProperty(JSPropertyNames.until, val));
  }

  @Override
  public JSLocalDateTime getUntil() {
    return (JSLocalDateTime)getPropertyValue(JSPropertyNames.until);
  }
}
