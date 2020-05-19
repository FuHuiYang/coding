package com.cc.codingutil;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.codingutil
 * @Description: 日期工具类
 * @date Date : 2020年05月18日 18:30
 */
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil extends org.apache.commons.lang3.time.DateUtils {
        public static final String DATE_PATTERN = "yyyy-MM-dd";
        public static Logger logger = LoggerFactory.getLogger(DateUtil.class);
        public static String[] parsePatterns = {"yyyy-MM-dd", "yyyyMMdd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
                "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
                "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

        /**
         * 得到当前日期字符串 格式（yyyy-MM-dd）
         */
        public static String getDate() {
            return getDate("yyyy-MM-dd");
        }

        /**
         * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
         */
        public static String getDate(String pattern) {
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
         * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
         */
        public static String formatDateTimeYYMMDD(Date date) {
            return formatDate(date, "yyyyMMdd");
        }

        /**
         * 得到当前时间字符串 格式（HH:mm:ss）
         */
        public static String getTime() {
            return formatDate(new Date(), "HH:mm:ss");
        }

        /**
         * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
         */
        public static String getDateTime() {
            return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        }

        /**
         * 得到当前日期和时间字符串 格式（MSEL）
         */
        public static String getDateTimeMSEL() {
            return formatDate(new Date(), "yyyyMMddHHmmssSSS");
        }

        /**
         * 得到当前年份字符串 格式（yyyy）
         */
        public static String getYear() {
            return formatDate(new Date(), "yyyy");
        }

        /**
         * 得到当前月份字符串 格式（MM）
         */
        public static String getMonth() {
            return formatDate(new Date(), "MM");
        }

        /**
         * 得到当前月份字符串 格式（MM）
         */
        public static String getMonthSingleM() {
            return formatDate(new Date(), "M");
        }

        /**
         * 得到当天字符串 格式（dd）
         */
        public static String getDay() {
            return formatDate(new Date(), "dd");
        }

        /**
         * 得到当天字符串 格式（HH）
         */
        public static String getHour() {
            return formatDate(new Date(), "HH");
        }

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
                logger.error(" parseDate error: ", e);
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
         * Description : [将指定格式日期字符串转换成 yyyy-MM-dd格式字符串]
         * Created in : 2018/4/11 17:57
         * params : [dateStr, pattern]
         * returns : java.lang.String
         * author : [liyang]
         */
        public static String formatStrByPattern(String dateStr, String pattern) {
            if (StringUtils.isBlank(pattern) || StringUtils.isBlank(dateStr)) {
                return null;
            }
            SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);
            try {
                Date date = (Date) sdf1.parse(dateStr);
                return formatDate(date);
            } catch (ParseException e) {
                logger.error(" parseDate error: ", e);
                return null;
            }
        }

        public static String formatStrByPattern(Date date, String pattern) {
            if (StringUtils.isBlank(pattern) || date == null) {
                return null;
            }
            SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);
            return formatDate(date);
        }

        /**
         * @param args
         * @throws ParseException
         */
        public static void main(String[] args) throws ParseException {
            // Date date = new Date();
            // String s = formatStrByPattern(date, "yyyy-MM-dd");
            // System.out.print(s);

            // System.out.println(formatDate(parseDate("20100306")));
            // System.out.println(getDate("yyyy年MM月dd日 E"));
            // long time = new Date().getTime()-parseDate("2012-11-19").getTime();
            // System.out.println(time/(24*60*60*1000));
            // System.out.println(offsetDay(3,"D",new Date(),"yyyy-MM-dd HH:mm:ss"));
            // System.out.println(daysBetween(getNextDay(new Date()),new Date()));

            // System.out.println(daysBetween(parseDate(getDate()),parseDate("20161106")));
            // System.out.println(getDistanceOfTwoDate(parseDate(getDate()),parseDate("20161106")));

            // System.out.println(toDate("20201106"));

            // SimpleDateFormat smdf = new SimpleDateFormat( "yyyy-MM-dd");
            // try {
            // Date start = smdf.parse("2016-07-01 23:15");
            // Date end = smdf.parse("2016-07-02 00:13");
            // long t = (end.getTime() - start.getTime()) / (3600 * 24 * 1000);
            // System.out.println(t);
            // } catch (ParseException e) {
            // e.printStackTrace();
            // }
            // System.out.println(DateToTimestamp("20161012","yyyyMMdd"));

            // Integer in = 22.01;
            // System.out.println();




        }

        /**
         * 时间戳转换成日期格式字符串
         * @param seconds 精确到秒的字符串
         * @param format
         * @return
         */
        public static String timeStamp2Date(String seconds, String format) {
            if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
                return "";
            }
            if (format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date(Long.valueOf(seconds + "000")));
        }

        /**
         * 日期格式字符串转换成时间戳
         * @param date_str 字符串日期
         * @param format 如：yyyy-MM-dd HH:mm:ss
         * @return
         */
        public static String date2TimeStamp(String date_str, String format) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return String.valueOf(sdf.parse(date_str).getTime() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        public static String DateToStr(Date date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = format.format(date);
            return str;
        }

        public static String DateToStr(Date date ,String pattern) {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = format.format(date);
            return str;
        }

        public static long DateToTimestamp(String str, String format) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(str).getTime();
        }

        /**
         * 日期对象转换为时间戳
         */
        public static long date2Timest(Date date) {
            long times = date.getTime();
            return times;
        }

        public static String toDate(String str) {
            Date date = parseDate(str);
            java.text.DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
            return format2.format(date);
        }

        public static String String2Date(String str) {
            Date date = parseDate(str);
            java.text.DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            return format2.format(date);
        }

        /**
         * 字符串的日期格式的计算
         */
        public static int daysBetween(String date) throws ParseException {
            return daysBetween(parseDate(getDate()), parseDate(date));
        }

        /**
         * 得到毫秒字符串
         */
        public static String formatDateMill(Date date) {
            return formatDate(date, "yyyyMMddHHmmssSSS");
        }

        /**
         * 得到秒字符串
         */
        public static String formatDateSecond(Date date) {
            return formatDate(date, "yyyyMMddHHmmss");
        }

        /***
         * 日期偏移方法
         * @param   preDay：日期减一天，nextDay：日期加一天
         *          preMonth：日期减一天，nextMonth：日期加一天
         *          preYear：日期减一天，nextYear：日期加一天
         * @param date
         * @param mode   如 ：yyyy-MM-dd HH:mm:ss
         * @param period 整数
         * @param unit D M Y
         * @return
         *
         * period, String unit
         */
        public static String offsetDay(Integer period, String unit, Date date, String mode) {
            if (period == null || unit == null) {
                return "";
            }
            Calendar cl = Calendar.getInstance();
            SimpleDateFormat sdf;
            try {
                sdf = new SimpleDateFormat(mode);
                cl.setTime(date);
            } catch (Exception e) {
                logger.error("offsetDay error:", e);
                return "";
            }
            if ("D".equals(unit)) {
                cl.add(Calendar.DATE, period.intValue());
            } else if ("M".equals(unit)) {
                cl.add(Calendar.MONTH, period.intValue());
            } else if ("Y".equals(unit)) {
                cl.add(Calendar.YEAR, period.intValue());
            } else {
                return "";
            }
            date = cl.getTime();
            return sdf.format(date);
        }

        /**
         * 获取今天之后的某天日期
         *
         * @param day 今天之后几天
         * @return
         */
        public static String getAddDayDate(int day) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            System.out.println("当前日期：               " + sf.format(c.getTime()));
            c.add(Calendar.DAY_OF_MONTH, day);
            System.out.println("增加一天后日期 ：  " + sf.format(c.getTime()));
            return sf.format(c.getTime());
        }

        /**
         * 获取今天之后的某天日期
         *
         * @param day     今天之后几天
         * @param pattern 格式
         * @return
         */
        public static String getAddDayDate(int day, String pattern) {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            Calendar c = Calendar.getInstance();
            System.out.println("当前日期：               " + sf.format(c.getTime()));
            c.add(Calendar.DAY_OF_MONTH, day);
            System.out.println("增加一天后日期 ：  " + sf.format(c.getTime()));
            return sf.format(c.getTime());
        }

        /**
         * 比较两个时间的大小，1:date1>date2,-1:date1<date2
         * @param date1 时间1 标准时间格式 yyyy-MM-dd HH:mm:ss
         * @param date2 时间2 标准时间格式 yyyy-MM-dd HH:mm:ss
         * @return 1:date1>date2,-1:date1<date2，0:date1=date2
         */
        public static int compare(String date1, String date2) {
            if (StringUtils.isBlank(date1)) {
                date1 = getDateTime();
            }
            if (StringUtils.isBlank(date2)) {
                date2 = getDateTime();
            }
            long beginDate = 0;
            long endDate = 0;

            try {
                beginDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1).getTime();
                endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date2).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (beginDate - endDate > 0) {
                return 1;
            } else if (beginDate - endDate < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        /**
         * 比较两个时间的大小，1:date1>date2,-1:date1<date2
         * @param date 时间1 标准时间格式 yyyy-MM-dd HH:mm:ss
         * @return 1:date1>date2,-1:date1<date2，0:date1=date2
         */
        public static int compareTo(Date date) {
            long beginDate = 0;
            long endDate = 0;
            try {
                beginDate = date.getTime();
                endDate = new Date().getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (beginDate - endDate > 0) {
                return 1;
            } else if (beginDate - endDate < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        /**
         * 比较两个时间的大小，1:date>now,-1:date<now
         * @param date 时间1 标准时间格式 yyyy-MM-dd
         * @return 1:date>now,-1:date<now，0:date=now
         */
        public static int compare(Date date) {

            long beginDate = 0;
            long endDate = 0;
            beginDate = getDayLast(date).getTime();//NOSONAR
            endDate = getDayLast(new Date()).getTime();
            if (beginDate - endDate > 0) {
                return 1;
            } else if (beginDate - endDate < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        /**
         * Description: 返回两个时分秒时间hh:mm:ss的大小，如果返回1，说明time1大于time2，返回0，说明两个时间相同，返回-1，说明time1小于time2
         *
         * @param time1
         * @param time2
         * @return int
         * @throws
         * @Author 耿伟
         * Create Date: 2015年9月6日 下午6:53:40
         */
        public static int compareHMS(String time1, String time2) {
            return Time.valueOf(time1).compareTo(Time.valueOf(time2));
        }

        /**
         * 返回当天23:59:59
         *
         * @param date
         * @return
         */
        public static Date getDayLast(Date date) {
            if (date == null) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }

        /**
         * 返回第二天00:00:00
         *
         * @param date
         * @return
         */
        public static Date getNextDay(Date date) {
            if (date == null) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(calendar.DATE, 1);

            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }

        public static Date toDate(String str, String pattern) {
            SimpleDateFormat sim = new SimpleDateFormat(pattern);
            Date d = null;
            try {
                d = sim.parse(str);
            } catch (ParseException e) {
                logger.error("toDate error:", e);
            }
            return d;
        }

        public static Date covertToDate(String str, String pattern) {
            SimpleDateFormat sim = new SimpleDateFormat(pattern);
            Date d = new Date();
            try {
                d = sim.parse(str);
            } catch (ParseException e) {
                logger.error("toDate error:", e);
            }
            return d;
        }

        /**
         * 计算两个日期之间相差的天数
         *
         * @param smdate 较小的时间
         * @param bdate  较大的时间
         * @return 相差天数
         * @throws ParseException
         */
        public static int daysBetween(Date smdate, Date bdate) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        }

        /**
         * 将字符串转为时间戳
         * @param user_time
         * @return
         */
        public static String getTime(String user_time) {
            String re_time = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date d;
            try {
                d = sdf.parse(user_time);
                long l = d.getTime();
                String str = String.valueOf(l);
                re_time = str.substring(0, 10);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return re_time;
        }

        /**
         * 比较两个日期的相差几天
         * 先比较日期大小然后在 大的日期减去 小的日期 得出 正整数  非负数
         * @param smdate
         * @param bdate
         * @return
         */
        public static int dateBetween(Date smdate, Date bdate) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            long time1 = 0;
            long time2 = 0;
            long between_days = 0;
            try {
                cal.setTime(sdf.parse(sdf.format(smdate)));
                time1 = cal.getTimeInMillis();
                cal.setTime(sdf.parse(sdf.format(bdate)));
                time2 = cal.getTimeInMillis();
                if (time1 > time2) {
                    between_days = (time1 - time2) / (1000 * 3600 * 24);
                    return Integer.parseInt(String.valueOf(between_days));
                } else if (time1 < time2) {
                    between_days = (time2 - time1) / (1000 * 3600 * 24);
                    return Integer.parseInt(String.valueOf(between_days));
                } else {
                    between_days = (time2 - time1) / (1000 * 3600 * 24);
                    return Integer.parseInt(String.valueOf(between_days));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Integer.parseInt(String.valueOf(between_days));
        }

        /**
         * yyyyMMdd 格式转换为 yyyy-mm-dd格式 20170512 转换为 2017-05-12
         * @param date
         * @return
         * @throws ParseException
         */
        public static String strToDateFormat(String date) throws ParseException {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            formatter.setLenient(false);
            Date newDate = formatter.parse(date);
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(newDate);
        }

        /**
         * 获取两个时间之间相差的小时
         * @param smdate
         * @param bdate
         * @return
         */
        public static int getBetweenHour(Date smdate, Date bdate) {
            SimpleDateFormat sdf = new SimpleDateFormat(parsePatterns[2]);
            Calendar cal = Calendar.getInstance();
            long time1 = 0;
            long time2 = 0;
            long betweenHour = 0;
            try {
                cal.setTime(sdf.parse(sdf.format(smdate)));
                time1 = cal.getTimeInMillis();
                cal.setTime(sdf.parse(sdf.format(bdate)));
                time2 = cal.getTimeInMillis();
                if (time1 > time2) {
                    betweenHour = (time1 - time2) / (1000 * 3600);
                    return Integer.parseInt(String.valueOf(betweenHour));
                } else if (time1 < time2) {
                    betweenHour = (time2 - time1) / (1000 * 3600);
                    return Integer.parseInt(String.valueOf(betweenHour));
                } else {
                    betweenHour = (time2 - time1) / (1000 * 3600);
                    return Integer.parseInt(String.valueOf(betweenHour));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Integer.parseInt(String.valueOf(betweenHour));
        }
        /**
         * 字符串解析成时间对象
         * @param dateTimeString String
         * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN，如果为空，则为yyyy-MM-dd
         * @return
         */
        public static Date dateParse(String dateTimeString, String pattern) {
            try {
                if(StringUtils.isBlank(pattern)){
                    pattern = DateUtil.DATE_PATTERN;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.parse(dateTimeString);
            } catch (ParseException e) {
                logger.error("日期格式转换异常:", e);
                return null;
            }
        }
        /**
         * 日期增减计算
         * @param date
         * @param a (1-年、2-月、3-周、5-天)
         * @param b (正数表示加，负数表示减)
         * @return Date
         */
        public static Date dateAddSub(Date date, int a, int b) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
            gc.add(a, b);
            gc.getTime();
            return gc.getTime();
        }
        /**
         * 时间格式化成字符串
         * @param date Date
         * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
         * @return
         */
        public static String dateFormat(Date date, String pattern) {
            if(StringUtils.isBlank(pattern)){
                pattern = DateUtil.DATE_PATTERN;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }

}
