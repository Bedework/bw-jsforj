package org.bedework.jsforj.model.values;

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

  String getFrequency();

  void setInterval(UnsignedInteger val);

  UnsignedInteger getInterval();

  void setRscale(String val);

  String getRscale();

  void setSkip(String val);

  String getSkip();

  void setFirstDayOfWeek(String val);

  String getFirstDayOfWeek();

  // byDay: "NDay[]"

  void setByMonthDay(JSArray<Integer> val);

  JSArray<Integer> getByMonthDay();

  void setByMonth(JSArray<String> val);

  JSArray<String> getByMonth();

  void setByYearDay(JSArray<Integer> val);

  JSArray<Integer> getByYearDay();

  void setByWeekNo(JSArray<Integer> val);

  JSArray<Integer> getByWeekNo();

  void setByHour(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getByHour();

  void setByMinute(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getByMinute();

  void setBySecond(JSArray<UnsignedInteger> val);

  JSArray<UnsignedInteger> getBySecond();

  void setBySetPosition(JSArray<Integer> val);

  JSArray<Integer> getBySetPosition();

  void setCount(UnsignedInteger val);

  UnsignedInteger getCount();

  void setUntil(JSLocalDateTime val);

  JSLocalDateTime getUntil();
}
