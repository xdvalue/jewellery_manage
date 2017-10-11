package com.els.jewellery.manage.common.page;

import java.io.Serializable;

/**
 * 分页请求对象
 *
 */
public class PagingReq implements Serializable {

	private static final long serialVersionUID = 6865724777166009497L;

	private int offset = 0; // 记录数偏移量
	private int limit = 10; // 每页个数

	/**
	 * 将偏移量转换为页码
	 */
	public int offsetToPageNumber() {
		int pageNubmer = (offset / limit) + 1;
		return pageNubmer;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
