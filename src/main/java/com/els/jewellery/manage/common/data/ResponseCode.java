package com.els.jewellery.manage.common.data;

import com.els.jewellery.manage.common.model.ResponseResult;

/**
 * 响应码：0表示成功，其他表示错误或失败
 *
 */
public enum ResponseCode {

	Success("0", "操作成功", "tips_common_emptypage_result_success"), Unknown_Error("-1", "未知错误",
			"tips_common_emptypage_result_unknownerror"), Fail("1001", "操作失败",
					"tips_common_emptypage_result_fail"), Error("1002", "操作不当",
							"tips_common_emptypage_result_misoperation"), Validate("2000", "验证错误",
									"tips_common_emptypage_result_validerror"), Empty("2001", "参数为空",
											"tips_common_emptypage_result_emptyparam"), Format("2002", "格式错误",
													"tips_common_emptypage_result_invalidformat"), No_Exist("3001",
															"记录不存在或已被删除",
															"tips_common_emptypage_result_notexist"), No_Operation_Permissions(
																	"3002", "没有操作权限",
																	"tips_common_emptypage_result_noprivileges"), Account_No_Login(
																			"4001", "没有登录,或登录已过期",
																			"tips_common_emptypage_result_nologin"), Account_Permission_denied(
																					"4001", "没有操作权限",
																					"tips_common_emptypage_result_noprivileges");

	private String code;
	private String msg;
	private String key; // 国际化信息key

	private ResponseCode(String code, String msg, String key) {
		this.code = code;
		this.msg = msg;
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public <T> ResponseResult<T> toResponseResult() {
		ResponseResult<T> res = new ResponseResult<>();
		res.setCode(this.code);
		res.setMsg(this.msg);
		res.setKey(this.key);
		return res;
	}

}
