package com.els.jewellery.manage.common.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author
 *
 * 		加密
 */
public class EncryptUtil {

	public static String md5(String str) {

		return DigestUtils.md5Hex(str);

	}

	@SuppressWarnings("deprecation")
	public static String sha(String str) {

		return DigestUtils.shaHex(str);

	}

	public static String base64Encode(String str) {

		byte[] b = Base64.encodeBase64(str.getBytes(), true);
		return new String(b);

	}

	public static String base64Decode(String str) {
		// 解密
		byte[] b = Base64.decodeBase64(str.getBytes());
		return new String(b);
	}

	public static void main(String[] args) {
		
		System.out.println(EncryptUtil.md5("123"));
	}

}
