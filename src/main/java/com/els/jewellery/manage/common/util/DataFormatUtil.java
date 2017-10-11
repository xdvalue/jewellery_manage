package com.els.jewellery.manage.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转化
 * @author chenyd
 *
 */
public class DataFormatUtil {
	
	/** yyyy */
	public static final String YEAR = "yyyy";
	
	/**  MM */
	public static final String MONTH = "MM";
	
	/** dd */
	public static final String DAY = "dd";
	
	/** yyyy-MM */
	public static final String TO_MONTH = "yyyy-MM";
	
	/**
	 * yyyy-MM-dd
	 */
	public static final String TO_DATE = "yyyy-MM-dd";
	
	/**
	 * yyyyMMdd
	 */
	public static final String BASIC_DATE="yyyyMMdd";
	
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String TO_MINUTE = "yyyy-MM-dd HH:mm";
	
	/**   yyyy-MM-dd HH:mm:ss  */
	public static final String TO_SECOND = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyy-MM-dd HH:mm:ss SSSS
	 */
	public static final String TO_MILLISECOND = "yyyy-MM-dd HH:mm:ss SSSS";
	
	/**
	 * 日期转字符类型
	 * @param date 操作日期
	 * @param dateType 转化的类型
	 * @return
	 */
	public static String parseDateTimeString(Date date,String dateType) {
		SimpleDateFormat dateformat = new SimpleDateFormat(dateType);
		String dateTime = dateformat.format(date);
		return dateTime;
	}
	
	/**
	 * 字符转日期格式
	 * @param value 操作的字符
	 * @param dateType 转化的类型
	 * @return
	 */
	public static Date parseStringtoDateTime(String value,String dateType) {
		SimpleDateFormat dateformat = new SimpleDateFormat(dateType);
		Date date = null;
		try {
			date = dateformat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
