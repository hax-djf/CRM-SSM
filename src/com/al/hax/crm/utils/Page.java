package com.al.hax.crm.utils;

import java.util.List;

public class Page<T> {
	
	private int total; //总的记录数
	private int page; // 当前页码数
	private int size; //，每页显示的条数
	private List<T> rows; //结果集

	public Page() {
		super();
	}

	/**
	 * 
	 * @param total
	 *            查询数据总条数
	 * @param page
	 *            当前页码数
	 * @param size
	 *            每页显示数据条数
	 * @param rows
	 *            查询结果集
	 */
	public Page(int total, int page, int size, List<T> rows) {
		super();
		this.total = total;
		this.page = page;
		this.size = size;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
