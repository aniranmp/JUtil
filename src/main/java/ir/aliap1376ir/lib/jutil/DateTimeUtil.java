package ir.aliap1376ir.lib.jutil;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

import java.util.Date;

public class DateTimeUtil {

    public static final long TIME_UNIT_1_MIN = 60 * 1000; // 1 M

    public static long convertMinToMillis(long timeInMinute) {
        return timeInMinute * TIME_UNIT_1_MIN;
    }

    public static long nMinuteAfterNow(long timeInMinute) {
        return getNowTime() + convertMinToMillis(timeInMinute);
    }

    public static Date getNowTimeStamp() {
        return new Date();
    }

    public static long getNowTime() {
        return getNowTimeStamp().getTime();
    }

    public static Date getDateFromTime(long time) {
        return new Date(time);
    }

    public static String dateToString(long time) {
        return dateToString(getDateFromTime(time));
    }

    public static String dateToString(Date date) {
        return date.toString();
    }

    public static String persianDateToString(long time) {
        return persianDateToString(getDateFromTime(time));
    }

    public static int getMonthDiffPersian(Date dateFrom, Date dateTo) {
        PersianCalendar persianDateFrom = getPersianDate(dateFrom);
        return persianDateFrom.fieldDifference(dateTo, Calendar.MONTH);
    }

    public static String persianDateToString(Date date) {
        DateFormat df = getPersianDate().getDateTimeFormat(DateFormat.FULL, DateFormat.DEFAULT, new ULocale("fa", "IR", ""));
        return df.format(date);
    }

    public static String persianDateToStringShort(Date date) {
        DateFormat df = getPersianDate().getDateTimeFormat(DateFormat.SHORT, DateFormat.DEFAULT, new ULocale("fa", "IR", ""));
        return df.format(date);
    }

    public static String getPersianDateShortWhitLatinNumber(Date date) {
        return StringUtil.persianToLatinNumber(persianDateToStringShort(date));
    }

    public static String printPersianDateJustDate(Date date) {
        return persianDateToStringShort(date).split("،")[0].trim();
    }

    public static String getPersianDateShortJustDateWhitLatinNumber(Date date) {
        return StringUtil.persianToLatinNumber(printPersianDateJustDate(date));
    }

    public static PersianCalendar getPersianDate(long time) {
        return getPersianDate(getDateFromTime(time));
    }

    public static PersianCalendar getPersianDate(Date date) {
        return new PersianCalendar(date);
    }

    public static PersianCalendar getPersianDate() {
        return new PersianCalendar();
    }

    public static PersianCalendar getPersianDateFromPersianYearAndMonth(int year, int month) {
        return new PersianCalendar(year, month - 1, 1, 0, 0, 0);
    }

    public static PersianCalendar getPersianDateFromPersianYearAndMonthInLastDay(int year, int month) {
        PersianCalendar persianCalendar = getPersianDateFromPersianYearAndMonth(year, month);
        persianCalendar.add(Calendar.MONTH, 1);
        persianCalendar.add(Calendar.SECOND, -1);
        return persianCalendar;
    }

    public static Date getDateFromPersianDateString(String stringDate) {
        try {
            DateFormat df = getPersianDate().getDateTimeFormat(DateFormat.SHORT, DateFormat.DEFAULT, new ULocale("fa", "IR", ""));
            return df.parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static PersianCalendar getPersianDateFromPersianDateString(String stringDate) {
        return getPersianDate(getDateFromPersianDateString(stringDate));
    }

    public static long[] getStartAndEndMillisOfPersianYear(int year) {
        PersianCalendar date = new PersianCalendar(year, 0, 1, 0, 0, 0);
        long start = date.getTime().getTime();
        date.roll(PersianCalendar.YEAR, true);
        long end = date.getTime().getTime();
        return new long[]{start, end};
    }
}
