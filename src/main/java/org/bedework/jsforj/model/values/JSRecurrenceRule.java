package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSArray;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSRecurrenceRule extends JSValue {
  String freqYearly = "yearly";
  String freqMonthly = "monthly";
  String freqWeekly = "weekly";
  String freqDaily = "daily";
  String freqHourly = "hourly";
  String freqMinutely = "minutely";
  String freqSecondly = "secondly";

  void setFrequency(String val);

  String getFrequency(boolean create);

  void setInterval(UnsignedInteger val);

  UnsignedInteger getInterval(boolean create);

  void setRscale(String val);

  String getRscale(boolean create);

  void setSkip(String val);

  String getSkip(boolean create);

  void setFirstDayOfWeek(String val);

  String getFirstDayOfWeek(boolean create);

  // byDay: "NDay[]"

  JSArray<JSNDay> getByDay(boolean create);

  void addByDayValue(String day,
                     Integer nthOfPeriod);

  void setByMonthDay(JSArray<Integer> val);

  JSArray<Integer> getByMonthDay(boolean create);

  void setByMonth(JSArray<String> val);

  JSArray<String> getByMonth(boolean create);

  void setByYearDay(JSArray<Integer> val);

  JSArray<Integer> getByYearDay(boolean create);

  void setByWeekNo(JSArray<Integer> val);

  JSArray<Integer> getByWeekNo(boolean create);

  void setByHour(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getByHour(boolean create);

  void setByMinute(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getByMinute(boolean create);

  void setBySecond(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getBySecond(boolean create);

  void setBySetPosition(JSArray<Integer> val);

  JSArray<Integer> getBySetPosition(boolean create);

  void setCount(UnsignedInteger val);

  UnsignedInteger getCount(boolean create);

  void setUntil(JSLocalDateTime val);

  JSLocalDateTime getUntil(boolean create);
}
