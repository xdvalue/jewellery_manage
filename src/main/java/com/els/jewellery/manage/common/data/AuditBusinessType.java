package com.els.jewellery.manage.common.data;

/**
 * 审批逻辑类型类型
 *
 */
public enum AuditBusinessType {

	Enterprise(0, "企业"),Product(1, "产品"),Resume(2, "简历"),Recruit(3,"招聘"),Building(4,"房产");

	private int id;
	private String name;

	private AuditBusinessType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
