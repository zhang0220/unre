/** 
 * 
 * Copyright (c) 2015-2015 ele.me,Inc.All Rights Reserved.
 */
package com.unre.photo.biz.response;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseResponse implements Serializable {
    
	private Error error = null;
	
	private String code;

	private int page;

	private int pageCount;

	private int pageSize;

	private int total;
	

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPage() {
		return page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setPage(String page, int total, int pageSize) {
		this.total = total;
		this.pageSize = pageSize;
		this.pageCount = (int) ((this.total + this.pageSize - 1) / this.pageSize);

		if (page == null) {
			this.page = 1;
		} else {
			try {
				this.page = Integer.parseInt(page);
				if (this.page < 1) {
					this.page = pageCount;
				} else if (this.page > pageCount) {
					//	this.page = 1;
				}
			} catch (Exception e) {
				this.page = 1;
			}
		}
	}
	public void setPage(int page, int total, int pageSize) {
		this.setPage(String.valueOf(page), total, pageSize);
	}
}
