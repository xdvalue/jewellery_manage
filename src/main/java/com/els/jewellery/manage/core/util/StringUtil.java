package com.els.jewellery.manage.core.util;

public class StringUtil {

	public static String cutPrefix(String str, String prefix) {
		String newStr = str.substring(prefix.length(), str.length());
		return newStr;
	}

	public static void main(String[] args) {
		try {
			String str = "/manage/login";
			String prefix = "/manage";
			System.out.println(cutPrefix(str, prefix));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
