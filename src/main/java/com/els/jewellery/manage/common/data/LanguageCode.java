package com.els.jewellery.manage.common.data;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public enum LanguageCode {

	CS("zh_CN", "简体中文", "简体中文"), AE("en_US", "美式英语", "English"), VN("vi_VN", "越南语", "Tiếng Việt");

	private String code;
	private String name;
	private String showName;

	private LanguageCode(String code, String name, String showName) {
		this.code = code;
		this.name = name;
		this.showName = showName;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getShowName() {
		return showName;
	}

	public static List<String> toList() {
		List<LanguageCode> list = Arrays.asList(LanguageCode.values());
		List<String> languageCodeList = Lists.transform(list, new Function<LanguageCode, String>() {
			@Override
			public String apply(LanguageCode language) {
				return language.getCode();
			}
		});
		return languageCodeList;
	}

}
