package com.els.jewellery.manage.common.vo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

@SuppressWarnings("hiding")
public class ReturnExcelVO<T> {
	
	private int successNum;// 成功行数
	private int failureNum;// 失败行数
	private String code;
	private String message;
	private List<T> returnList;
	
	public int getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}
	public int getFailureNum() {
		return failureNum;
	}
	public void setFailureNum(int failureNum) {
		this.failureNum = failureNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getReturnList() {
		return returnList;
	}
	public void setReturnList(List<T> returnList) {
		this.returnList = returnList;
	}
	
}
