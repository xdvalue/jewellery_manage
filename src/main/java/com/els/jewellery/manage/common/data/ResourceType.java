package com.els.jewellery.manage.common.data;

/**
 * 资源业务类型枚举
 * @author chenyd
 *
 */
public enum ResourceType {

	BUILDING("building","房产资源"),PRODUCTIMG("productimg","产品图片"),USERPORTRAIT("userportrait","用户头像"),USERRESUME("userresume","用户简历"),ENTIMAGE("entimage","企业图片");
	
	
	private String key;
	private String remark;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private ResourceType(String key, String remark) {
		this.key = key;
		this.remark = remark;
	}
	
}
