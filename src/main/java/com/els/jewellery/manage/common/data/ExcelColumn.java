package com.els.jewellery.manage.common.data;

public enum ExcelColumn {
	SERIAL_NUMBER(0,"序号"),
	ENTERPRISE_NAME(1, "公司名称"), 
	CONTACTS_NAME(2, "联系人"),
	MOBILE(3,"手机"),
//	PHONE(4, "电话"), 
	ADDRESS(5,"地址"),
	INDUSTRY(6,"行业"),
	INTRODUCE(7,"介绍"),
	EMAIL(8, "邮箱"), 
	WEBSITE(9, "网站"), 
//	WECHAT_NUMBER(10,"微信号"),
	PWD(11, "密码");

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private ExcelColumn(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
