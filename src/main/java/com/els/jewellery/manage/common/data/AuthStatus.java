package com.els.jewellery.manage.common.data;

/**
 * 认证状态
 *
 */
public enum AuthStatus {

	Un_Auth(0, "未审核"), Authenticating(1, "认证中"), Pass(2, "认证通过"), No_Pass(3, "认证不通过");

	private int id;
	private String name;

	private AuthStatus(int id, String name) {
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
