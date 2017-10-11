package com.els.jewellery.manage.common.data;

public enum ReturnCode {

	suc("200","操作成功"),
	err("100","失败");
	
	private String code;
	private String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private ReturnCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
}
