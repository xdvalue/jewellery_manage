package com.els.jewellery.manage.common.data;

public enum FileType {

	PRIVATE("0","加密"),OPEN("1","公开");
	
	private String id;
	private String desc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private FileType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
}
