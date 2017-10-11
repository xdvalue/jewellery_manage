package com.els.jewellery.manage.common.util;

import java.util.Random;

public class StringUtil {

	/**
	 * 生成一定长度的随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String createRandom(Integer length) {
		if (null == length || length <= 0) {
			length = 8;
		}
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9' };
		int maxLen = chars.length;

		StringBuffer buf = new StringBuffer("");
		Random r = new Random();
		while (count < length) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxLen));
			if (i >= 0 && i < maxLen) {
				buf.append(chars[i]);
				count++;
			}
		}

		return buf.toString();
	}

}
