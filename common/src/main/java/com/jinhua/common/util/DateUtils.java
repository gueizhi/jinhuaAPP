package com.jinhua.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 系统时间公共类
 * @author ljx
 */
public class DateUtils {
	public static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 取得昨天此时的时间
	 * 
	 * @return 昨天日期（Date）
	 */
	public static Date getYesterdayDate() {
		return new Date(System.currentTimeMillis() - 0x5265c00L);
	}
	
	
	public static Date getSomeDate(int days) {
		return new Date(System.currentTimeMillis() - 0x5265c00L * days);
	}

	public static Date parse(String date, SimpleDateFormat format) {

		try {
			return format.parse(date);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @Title: parse @Description: 将字符串格式的日期转换为日期 @param date @return @return
	 * Date @throws
	 */
	public static Date parse(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(date);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 取得去过i天的时间
	 * 
	 * @param i
	 *            过去时间天数
	 * @return 昨天日期（Date）
	 */
	public static Date getPastdayDate(int i) {
		return new Date(System.currentTimeMillis() - 0x5265c00L * i);
	}

	public static Date getPastdayDate(Date date, int i) {
		return new Date(date.getTime() - 0x5265c00L * i);
	}

	/**
	 * 取得某日期时间的特定表示格式的字符串
	 * 
	 * @param format
	 *            时间格式
	 * @param date
	 *            某日期（Date）
	 * @return 某日期的字符串
	 */
	public static synchronized String format(Date date, String format) {
		SimpleDateFormat ft = new SimpleDateFormat(format);
		return ft.format(date);
	}

	/**
	 * 取得某日期时间的特定表示格式的字符串
	 * 
	 * @param format
	 *            时间格式
	 * @param date
	 *            某日期（Date）
	 * @return 某日期的字符串
	 */
	public static synchronized String format(Date date, DateFormat format) {
		return format.format(date);
	}
	
	
	/**
	 * 以分钟的形式表示两个长整型数表示的时间间隔
	 * 
	 * @param from
	 *            开始的长整型数据
	 * @param to
	 *            结束的长整型数据
	 * @return 相隔的分钟数
	 */
	public static String getOffDayHours_abs(Date from, Date to) {
		long mid = from.getTime() - to.getTime();
		if(mid < 0){
			return "0";
		}
		int seconds = (int) (mid / 1000L );
		int hours = (int) (mid / 3600000L );
		int days = hours / 24;
		int lefthours = hours % 24;
		int leftmins = seconds / 60;
		int leftseconds = seconds % 60;
		if(days > 0){
			return days + "天";
		}else if(days == 0 && lefthours > 0){
			return lefthours + "小时";
		}else if(days == 0 && lefthours == 0 && leftmins > 0){
			return leftmins + "分钟";
		}else if(days == 0 && lefthours == 0 && leftmins == 0 && leftseconds > 0){
			return leftseconds + "秒";
		}else{
			return "已结束";
		}
	}
	
	
	/**
	 * 以分钟的形式表示两个长整型数表示的时间间隔
	 * 
	 * @param from
	 *            开始的长整型数据
	 * @param to
	 *            结束的长整型数据
	 * @return 相隔的分钟数
	 */
	public static int getOffHours_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / 3600000L ));
	}

	/**
	 * 以分钟的形式表示两个长整型数表示的时间间隔
	 * 
	 * @param from
	 *            开始的长整型数据
	 * @param to
	 *            结束的长整型数据
	 * @return 相隔的分钟数
	 */
	public static int getOffMinutes_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / 60000L));
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return 相隔的秒钟
	 */
	public static int getOffSeconds_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / 1000L));
	}

	/**
	 * 以天的形式表示两个长整型数表示的时间间隔
	 * 
	 * @param from
	 *            开始的长整型数据
	 * @param to
	 *            结束的长整型数据
	 * @return 相隔的天数
	 */
	public static int getOffDays_abs(Date from, Date to) {
		return Math.abs((int) ((from.getTime() - to.getTime()) / (60000L * 60 * 24)));
	}

	/**
	 * 以分钟的形式表示两个长整型数表示的时间间隔
	 * 
	 * @param from
	 *            开始时间
	 * @param to
	 *            结束时间
	 * @return 相隔的分钟数
	 */
	public static int getOffMinutes(Date from, Date to) {
		return (int) ((to.getTime() - from.getTime()) / (60 * 1000L));
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = DateUtils.YYYY_MM_DD;
		smdate = sdf.parse(DateUtils.YYYY_MM_DD.format(smdate));
		bdate = sdf.parse(DateUtils.YYYY_MM_DD.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 获取当前时间 N天之后时间
	 * @param days
	 * @return
	 */
	public static Date toAfterDate(int days){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);//计算30天后的时间
		return c.getTime();

	}


	/*
    获取当前时间之前或之后几小时 hour
	*/
	public static Date getTimeByHour(int hour) throws ParseException {

		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        Date date = sdf1.parse(sdf1.format(calendar.getTime()));
		return date;

	}


	/**
	 *  判断时间是否在一段时间之内
	 * @param nowTime
	 * @param starDate
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime,Date starDate,Date endTime) {

		//Date today = new Date(); //今天日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

			Calendar date = Calendar.getInstance();
			date.setTime(nowTime);

			Calendar begin = Calendar.getInstance();
			begin.setTime(starDate);

			Calendar end = Calendar.getInstance();
			end.setTime(endTime);

			if (date.after(begin) && date.before(end)) {
				return true;
			} else {
				return false;
			}



	}


	public static Date getTimeByMinute(int minute) throws ParseException {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, minute);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



		Date date = sdf1.parse(sdf1.format(calendar.getTime()));
		return date;

	}
	/**获取上n个小时整点小时时间
	 * @param date
	 * @return
	 */
	public static String getLastHourTime(Date date,int n){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY)-n);
		date = ca.getTime();
		return sdf.format(date);
	}
	/**获取当前时间的整点小时时间
	 * @param date
	 * @return
	 */
	public static String getCurrHourTime(Date date){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		date = ca.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**获取过去n天的日期
	 * @param date
	 * @return
	 */
	public static String getLastDay(Date date,int n){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ca.set(Calendar.FRIDAY, ca.get(Calendar.FRIDAY)-n);
		date = ca.getTime();
		return sdf.format(date);
	}
	/**获取过去n月的日期
	 * @param date
	 * @return
	 */
	public static String getLastMonth(Date date,int n){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ca.set(Calendar.MONTH, ca.get(Calendar.MONTH)-n);
		date = ca.getTime();
		return sdf.format(date);
	}

	/**
	 * 获取当前时间所在月份的第一天
	 * @param date
	 * @return
	 */
	public static String getCurrentMonth(Date date){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ca.set(Calendar.MONTH, ca.get(Calendar.MONTH));
		date = ca.getTime();
		return sdf.format(date);
	}

	/**
	 * 当前季度的开始时间，即2012-01-1 00:00:00
	 * @return
	 */
	public static String getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) ;
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 3);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 4);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 9);
			}
			c.set(Calendar.DATE, 1);
			now = shortSdf.format(c.getTime()) + " 00:00:00";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的结束时间。即2012-03-31 23:59:59
	 *
	 * @return
	 */
	public static String getCurrentQuarterEndTime() throws Exception {
		SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(longSdf.parse(getCurrentQuarterStartTime()));
		cal.add(Calendar.MONTH, 3);
		return longSdf.format(cal.getTime());
	}

	/**
	 * 获取当前时间距离下一天了凌晨的秒数
	 * @return
	 */
	public static Long getSecondsNextEarlyMorning() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
	}
	public static void main(String[] args)throws  Exception{
		System.out.println(getCurrHourTimeForMillis());
	}

	/**获取当前时间的整点小时时间
	 * @return
	 */
	public static long getCurrHourTimeForMillis(){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		return  ca.getTimeInMillis();
	}
}
