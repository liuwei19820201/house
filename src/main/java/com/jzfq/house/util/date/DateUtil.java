package com.jzfq.house.util.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具类
 *
 * @author liuwei
 */
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {

    public static final String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 初始化格式:yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMATTING_DATETIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 初始化格式:yyyy-MM-dd HH:mm:ss.SS
     */
    public static final String FORMATTING_DATETIME_SECOND = "yyyy-MM-dd HH:mm:ss.SS";
    /**
     * 初始化格式:yyyy-MM-dd
     */
    public static final String FORMATTING_DATE = "yyyy-MM-dd";
    /**
     * 初始化格式:yyyy年M月d日
     */
    public static final String FORMATTING_DATE_C = "yyyy年M月d日";
    /**
     * 初始化格式:yyyyMMddHHmmss
     */
    public static final String FORMATTING_DATE_HMS = "yyyyMMddHHmmss";

    public static final String FORMATTING_YMD = "yyyyMMdd";

    public static final String FORMATTING_DATE_MM_SS = "mm:ss";
    public static final String FORMATTING_DATE_HH_MM = "hh:mm";

    /**
     * 获取年
     */
    public static final int YEAR = Calendar.YEAR;


    /**
     * 获取月
     */
    public static final int MONTH = Calendar.MONTH;

    /**
     * 获取日
     */
    public static final int DAY = Calendar.DAY_OF_MONTH;
    /**
     * 获取小时
     */
    public static final int HOUR = Calendar.HOUR;
    /**
     * 获取分钟
     */
    public static final int MINUTE = Calendar.MINUTE;
    /**
     * 获取秒钟
     */
    public static final int SECOND = Calendar.SECOND;
    /**
     * 获取毫秒
     */
    public static final int MILLISECOND = Calendar.MILLISECOND;

    /**
     * 获取时间初始化实例
     *
     * @param formatting 初始化格式
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(String formatting) {
        return new SimpleDateFormat(formatting);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }


    public static String getDate(String formatting) {
        return formatting(getDate(), formatting);
    }

    /**
     * 获取当前年
     *
     * @return
     */
    public static int getYear() {
        return getYear(null);
    }

    /**
     * 获取指定时间的年
     *
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(YEAR);
    }

    /**
     * 获取当前月
     *
     * @return
     */
    public static int getMonth() {
        return Calendar.getInstance().get(MONTH) + 1;
    }

    /**
     * 获取指定时间的月
     *
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(MONTH) + 1;
    }

    /**
     * 获取当前日
     *
     * @return
     */
    public static int getDay() {
        return getDay(null);
    }

    /**
     * 获取指定时间的日
     *
     * @return
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(DAY);
    }

    /**
     * 获取当前时
     *
     * @return
     */
    public static int getHour() {
        return getHour(null);
    }

    /**
     * 获取指定时间的时
     *
     * @return
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(HOUR);
    }

    /**
     * 获取当前分
     *
     * @return
     */
    public static int getMinute() {
        return getMinute(null);
    }

    /**
     * 获取指定时间的分
     *
     * @return
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(MINUTE);
    }

    /**
     * 获取当前秒
     *
     * @return
     */
    public static int getSecond() {
        return getSecond(null);
    }

    /**
     * 获取指定时间的秒
     *
     * @return
     */
    public static int getSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(SECOND);
    }

    public static long getcurrentDateToLong() {
        return getDate().getTime();
    }

    /**
     * 时间类型转字符串类型
     *
     * @param date
     * @return
     */
    public static String formatting(Date date) {
        return formatting(date, FORMATTING_DATETIME);
    }

    /**
     * 时间类型转字符串类型
     *
     * @param date
     * @param formatting
     * @return
     */
    public static String formatting(Date date, String formatting) {
        return getSimpleDateFormat(formatting).format(date);
    }


    /**
     * 时间转换
     *
     * @param date
     * @param formatting
     * @return
     */
    public static Date formattingToDate(Date date, String formatting) {
        return DateUtil.formatting(DateUtil.formatting(date, formatting), formatting);
    }

    /**
     * 字符串类型转时间类型
     *
     * @param date
     * @return
     */
    public static Date formatting(String date, String formatting) {
        try {
            if (isDate(date, formatting)) {
                return getSimpleDateFormat(formatting).parse(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串类型转时间类型
     *
     * @param date
     * @return
     */
    public static Date formatting(String date) {
        return formatting(date, FORMATTING_DATETIME);
    }

    /**
     * 获取当前 年月日时分秒毫秒
     *
     * @return
     */
    public static String getCurrentDatetimeSecond() {
        return DateUtil.formatting(DateUtil.getDate(), DateUtil.FORMATTING_DATETIME_SECOND);
    }


    /**
     * 判断是否是时间
     *
     * @param dateOrDatetime
     * @return
     */
    public static boolean isDate(String dateOrDatetime, String formatting) {
        try {
            getSimpleDateFormat(formatting).parse(dateOrDatetime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取某时间的之前或之后的时间
     *
     * @param datetime 时间
     * @param value    计算的值
     *                 正数为指定时间的下一个计算类型
     *                 负数数为指定时间的上一个计算类型
     * @param type     计算类型
     *                 DateUtil.YEAR 获取年
     *                 DateUtil.MONTH 获取月
     *                 DateUtil.DAY 获取天
     *                 DateUtil.HOUR 获取小时
     *                 DateUtil.MINUTE 获取分钟
     *                 DateUtil.SECOND 获取秒钟
     * @return
     */
    public static Date getCalculateDate(Date datetime, int value, int type) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);
        cal.add(type, value);
        return cal.getTime();
    }

    /**
     * 计算时间差
     *
     * @param first 第一个时间
     * @param last  第二个时间
     * @param type  计算相差结果类型：
     *              DateUtil.DAY 获取相差多少天
     *              DateUtil.HOUR 获取相差多少小时
     *              DateUtil.MINUTE 获取相差多少分钟
     *              DateUtil.SECOND 获取相差多少秒钟
     * @return 返回 -1 则获取失败
     */
    public static long getDateDiff(Date first, Date last, int type) {
        long millisecond = 1; // 1毫秒
        long second = millisecond * 1000; // 一秒钟的毫秒值
        long minute = second * 60; // 一分钟的毫秒值
        long hour = minute * 60; // 一小时的毫秒值
        long day = hour * 24; // 一天的毫秒值
        long diff = Math.abs(first.getTime() - last.getTime());
        if (DAY == type) { // 计算相差多少天
            return diff / day;
        } else if (HOUR == type) { // 计算相差多少小时
            return diff / hour;
        } else if (MINUTE == type) { // 计算相差多少分钟
            return diff / minute;
        } else if (SECOND == type) { // 计算相差多少秒钟
            return diff / second;
        } else if (MILLISECOND == type) { // 计算相差多少毫秒
            return diff / millisecond;
        }
        return -1L;
    }

    /**
     * 获取当前的周期
     *
     * @return
     */
    public static int getCurrentDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);
        return week == 1 ? 7 : week - 1;
    }

    /**
     * 获取指定时间的周期
     *
     * @param date 当前日期
     * @return
     */
    public static int getCurrentDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        return week == 1 ? 7 : week - 1;
    }

    /**
     * 比较时间的大小
     *
     * @param first 第一个时间
     * @param last  最后一个时间
     * @return -1 first<last, 0 first=last, 1 first>last
     */
    public static int compareTo(Date first, Date last) {
        Calendar calFirst = Calendar.getInstance();
        calFirst.setTime(first);
        Calendar calLast = Calendar.getInstance();
        calLast.setTime(last);
        return calFirst.compareTo(calLast);
    }

    /**
     * 获取当月第一天
     *
     * @return
     */
    public static Date currentMonthFirstDay() {
        return monthFirstDay(null);
    }

    /**
     * 获取指定日期的当月第一天
     *
     * @param date
     * @return
     */
    public static Date monthFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取当月最后一天
     *
     * @return
     */
    public static Date currentMonthLastDay() {
        return monthLastDay(null);
    }

    /**
     * 获取指定日期的当月最后一天
     *
     * @return
     */
    public static Date monthLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取当前年是否为闰年
     *
     * @return
     */
    public static boolean isLeapYear() {
        return isLeapYear(getYear());
    }

    /**
     * 获取指定时间是否为闰年
     *
     * @param date
     * @return
     */
    public static boolean isLeapYear(Date date) {
        return isLeapYear(getYear(date));
    }

    /**
     * 获取指定时间是否为闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 4) == 0;
    }

    /**
     * 计算n个月之后的实际日期，如果传入的日期大于月末日，则返回该月的月末日
     *
     * @param startDate  开始日期
     * @param addMonths  加减的月数
     * @param dayOfMonth 日
     * @return
     */
    public static Date calculateActualDateAfterMonths(Date startDate, int addMonths, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, addMonths);
        int actualMaximumDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (dayOfMonth > actualMaximumDay) {
            dayOfMonth = actualMaximumDay;
        }
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return cal.getTime();
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDateStr() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDateStr(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(getDate(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTimeHms() {
        return formatDate(new Date(), DateUtil.FORMATTING_DATE_HMS);
    }

    /**
     * 得到当前日期字符串 格式（yyyyMMdd）
     */
    public static String getDateHms() {
        return formatDate(new Date(), DateUtil.FORMATTING_YMD);
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     *//*
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	*//**
     * 得到当前月份字符串 格式（MM）
     *//*
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	*//**
     * 得到当天字符串 格式（dd）
     *//*
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}
*/

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 计算两个日期之间相差的天数（不包含起始日），排除时间的影响
     *
     * @param startDate 起始日
     * @param endDate   结束日
     * @return
     */
    public static int calcDateDiffIgnoreTime(Date startDate, Date endDate) {
        startDate = truncate(startDate, Calendar.DATE);
        endDate = truncate(endDate, Calendar.DATE);
        long diffMilliseconds = endDate.getTime() - startDate.getTime();
        return (int) TimeUnit.DAYS.convert(diffMilliseconds, TimeUnit.MILLISECONDS);
    }

    /**
     * 获取当月实际天数
     *
     * @param date
     * @return
     */
    public static int getActualMaximumDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 根据签约日期计算起始还款时间
     */
    public static Date calculateStartDate(Date signDate) {
        int signedDay = DateUtil.getDay(signDate);
        int repaymentDate = 15;
        Date startDate = null;
        if (signedDay <= 15) {
            repaymentDate = 30;
            startDate = DateUtil.calculateActualDateAfterMonths(signDate, 0, repaymentDate);
        } else {
            startDate = DateUtil.calculateActualDateAfterMonths(signDate, 1, repaymentDate);
        }
        return startDate;
    }

    /**
     * 根据签约日期计算终止还款时间
     */
    public static Date calculateEndDate(Date signDate, int period) {
        int signedDay = DateUtil.getDay(signDate);
        int repaymentDate = 15;
        Date endDate = null;
        if (signedDay <= 15) {
            repaymentDate = 30;
            endDate = DateUtil.calculateActualDateAfterMonths(signDate, period - 1, repaymentDate);
        } else {
            endDate = DateUtil.calculateActualDateAfterMonths(signDate, period, repaymentDate);
        }
        return endDate;
    }

    /**
     * 根据首个还款日期计算终止还款日期
     */
    public static Date calculateEndDateByFirst(Date firstDate, int period) {
        int repaymentDate = DateUtil.getDay(firstDate);
        Date endDate = DateUtil.calculateActualDateAfterMonths(firstDate, period - 1, repaymentDate);
        return endDate;
    }


    /**
     * 返回标准的指定格式的当前时间
     *
     * @return
     */
    public static String getStandardCurrentTime() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * arg to date
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String arg) throws ParseException {
        String dateString = Format.formatDate(arg);
        if (dateString == null || "".equals(dateString)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(Pattern.DATE.value());
        return sdf.parse(dateString);
    }

    /**
     * arg to time
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static Date parseTime(String arg) throws ParseException {
        String timeString = Format.formatTime(arg);
        if (timeString == null || "".equals(timeString)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(Pattern.TIME.value());
        return sdf.parse(timeString);
    }

    /**
     * arg to date
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static String parseDateString(Date arg) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(Pattern.DATE.value());
        return Format.formatDate(sdf.format(arg));
    }

    /**
     * arg to time
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static String parseTimeString(Date arg) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(Pattern.TIME.value());
        return Format.formatTime(sdf.format(arg));
    }

    /**
     * arg to date
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static String parseDateString(String arg) throws ParseException {
        return Format.formatDate(arg);
    }

    /**
     * arg to time
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static String parseTimeString(String arg) throws ParseException {
        return Format.formatTime(arg);
    }

    /**
     * arg to date
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static Date parseDate(Date arg) throws ParseException {
        String dateString = parseDateString(arg);
        return parseDate(dateString);
    }

    /**
     * arg to long
     *
     * @param arg
     * @return
     * @throws ParseException
     */
    public static Long getTime(String arg) throws ParseException {
        Date date = parseTime(arg);
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    /**
     * arg to time
     *
     * @param arg
     * @return
     */
    public static Date parseTime(long arg) {
        return new Date(arg);
    }

    /**
     * time - subtractedTime = days
     *
     * @param time
     * @param subtractedTime
     * @return
     */
    public static Long minusTime(Date time, Date subtractedTime) {
        if (time == null || subtractedTime == null) {
            return null;
        }
        return (time.getTime() - subtractedTime.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * date - subtractedDate = days
     *
     * @param date
     * @param subtractedDate
     * @return
     */
    public static Long minusDate(Date date, Date subtractedDate) {
        if (date == null || subtractedDate == null) {
            return null;
        }
        return (date.getTime() - subtractedDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * date + days
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        long l = date.getTime() + days * 24 * 60 * 60 * 1000;
        return parseTime(l);
    }

    /**
     * date - days
     *
     * @param date
     * @param days
     * @return
     */
    public static Date minusDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        long l = date.getTime() - days * 24 * 60 * 60 * 1000;
        return parseTime(l);
    }

    /**
     * date + Minute
     *
     * @param minute
     * @return date
     */
    public static Date minusTimes(int minute) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, minute);
        return nowTime.getTime();
    }

    /**
     * 当前时间
     * @param format
     * @return
     */
    public static String now(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
