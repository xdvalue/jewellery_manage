package com.els.jewellery.manage.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.els.jewellery.manage.common.data.Constant;

/**
 * 主键生成器
 *
 */
public class IdGenerator {

	/**
	 * 生成标准产品ID
	 * 
	 * @return
	 */
	public static String createStandardId() {
		return createDateTimeAndRandomIdByPrefix(null, null, Constant.PREFIX_STANDARD);
	}

	/**
	 * 根据前缀和日期对象生成时间格式字符串主建，精确到毫秒
	 * 
	 * @param date
	 *            日期对象，当为null时则处理为当前时间
	 * @param prefix
	 *            前缀
	 * @return
	 */
	public static String createDateTimeIdByPrefix(Date date, String prefix) {
		if (StringUtils.isBlank(prefix)) {
			return createDateTimeId(date);
		}
		String id = createDateTimeId(date);
		return prefix + "_" + id;
	}

	/**
	 * 根据日期对象和随机字符串长度以及前缀生成时间格式字符串主建，精确到毫秒，并加上指定长度的随机字符串
	 * 
	 * @param date
	 *            日期对象，当为null时则处理为当前时间
	 * @param randomLength
	 *            随机字符串长度，为null时取6
	 * @param prefix
	 *            前缀
	 * @return
	 */
	public static String createDateTimeAndRandomIdByPrefix(Date date, Integer randomLength, String prefix) {
		if (StringUtils.isBlank(prefix)) {
			return createDateTimeAndRandomId(date, randomLength);
		}
		String id = createDateTimeAndRandomId(date, randomLength);
		return prefix + "_" + id;
	}

	/**
	 * 根据日期对象生成时间格式字符串主建，精确到毫秒
	 * 
	 * @param date
	 *            日期对象，当为null时则处理为当前时间
	 * @return
	 */
	public static String createDateTimeId(Date date) {
		Date dateObj = (null == date) ? new Date() : date;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return dateformat.format(dateObj);
	}

	/**
	 * 根据日期对象和随机字符串长度生成时间格式字符串主建，精确到毫秒，并加上指定长度的随机字符串
	 * 
	 * @param date
	 *            日期对象，当为null时则处理为当前时间
	 * @param randomLength
	 *            随机字符串长度，为null时取6
	 * @return
	 */
	public static String createDateTimeAndRandomId(Date date, Integer randomLength) {
		String dateTime = createDateTimeId(date);
		String random = StringUtil.createRandom(randomLength);
		return dateTime + "_" + random;
	}

	public static void main(String[] args) {
		try {
			System.out.println(createDateTimeId(null));
			System.out.println(createDateTimeAndRandomId(null, null));
			System.out.println(createDateTimeAndRandomIdByPrefix(null, null, Constant.PREFIX_USER));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
