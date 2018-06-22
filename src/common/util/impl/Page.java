package common.util.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int totalRecords; //总记录数
	private int pageSize=3;   //页尺寸 每页多少条记录
	private int totalPages;   //总页数
	private int currentPage=1; //当前页
	private List<T> dataList=new ArrayList<T>(); //当前页的记录
	private int from; //当前页第一条记录的index
	public Page() {
		super();
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		this.totalPages=totalRecords%pageSize==0?totalRecords/pageSize:(totalRecords/pageSize+1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.from=(this.currentPage-1)*pageSize;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "Page [totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", currentPage=" + currentPage
				+ ", dataList=" + dataList + ", from=" + from + "]";
    }
}

