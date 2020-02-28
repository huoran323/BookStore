package com.hr.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo; //当前页
	private int totalPageNo; //总页数=总条数/每页显示的个数
	private int totalRecord; //总条数
	public static final int PAGE_SIZE = 4; //每页显示条数
	private List<T> list; //当前页的数据集合
	
	public int getPageNo() {
		//解决输入的页码在范围之外的问题
		if (pageNo < 1) {
			return 1;
		}
		if (pageNo > getTotalPageNo()) {
			return getTotalPageNo();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPageNo() {
		//通过判断总条数是否能整除每页的个数，如果能整除，直接返回总页数；如果不能整除，总页数需要+1
		return totalRecord%PAGE_SIZE==0?totalRecord/PAGE_SIZE:totalRecord/PAGE_SIZE+1;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
//	public static int getPageSize() {
//		return PAGE_SIZE;
//	}
	public Page(int pageNo, int totalPageNo, int totalRecord, List<T> list) {
		super();
		this.pageNo = pageNo;
		this.totalPageNo = totalPageNo;
		this.totalRecord = totalRecord;
		this.list = list;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPageNo=" + totalPageNo + ", totalRecord=" + totalRecord + ", list="
				+ list + "]";
	}
	
}
