package com.els.jewellery.manage.common.data;

/**
 * 审核状态
 *
 */
public enum AuditStatus {

	Un_Audit(0, "未审核"), Auditing(1, "审核中"), Pass(2, "审核通过"), No_Pass(3, "审核不通过");

	private int id;
	private String name;

	private AuditStatus(int id, String name) {
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
