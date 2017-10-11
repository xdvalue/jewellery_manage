package com.els.jewellery.manage.common.model;

import java.io.Serializable;

import com.els.jewellery.manage.common.data.ResponseCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应结果
 * 
 */
@ApiModel(value = "响应信息")
public class ResponseResult<T> implements Serializable {

	private static final long serialVersionUID = -9142174760969172405L;

	@ApiModelProperty("响应码：0表示成功，其他表示失败")
	private String code; // 响应码：0表示成功，其他表示失败

	@ApiModelProperty("响应描述")
	private String msg; // 响应描述

	@ApiModelProperty("响应描述国际化信息Key")
	private String key; // 响应描述的国际化信息Key

	@ApiModelProperty("返回数据")
	private T data; // 返回数据

	public ResponseResult() {
		super();
	}

	public ResponseResult(String code, String msg, String key, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.key = key;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> ResponseResult<T> success(T data) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setCode(ResponseCode.Success.getCode());
		result.setMsg(ResponseCode.Success.getMsg());
		result.setKey(ResponseCode.Success.getKey());
		result.setData(data);
		return result;
	}

	public static ResponseResult<String> fail(ResponseCode code) {
		return fail(code, "");
	}

	public static <T> ResponseResult<T> fail(ResponseCode code, T data) {
		ResponseResult<T> result = new ResponseResult<T>();
		result.setCode(code.getCode());
		result.setMsg(code.getMsg());
		result.setKey(code.getKey());
		result.setData(data);
		return result;
	}

}
