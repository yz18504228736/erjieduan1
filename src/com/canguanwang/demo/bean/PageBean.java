package com.canguanwang.demo.bean;

import com.canguanwang.demo.utils.Constant;

import java.util.ArrayList;
import java.util.List;


public class PageBean<T> {
	private int pageNum = 1;
	private int totalPages = 1;
	private int totalPages1 = 1;
	private int totalPages2 = 1;
	private int totalPages3 = 1;
	private int totalPages4 = 1;
	private int pageSize = Constant.PAGE_SIZE;
	private int totalRecords = 0;
	private int nowRecords = 1;
	private boolean haveNextPage = false;
	private boolean havePrePage = false;
	private boolean haveNextRecord = false;
	private boolean havePreRecord = false;
	private List<T> pageDatas = new ArrayList<T>();
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		this.totalPages = totalRecords % pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
		this.totalPages1 = totalRecords % 8==0?totalRecords/8:(totalRecords/8)+1;
		this.totalPages2 = totalRecords % 10==0?totalRecords/10:(totalRecords/10)+1;
		this.totalPages3 = totalRecords % 10==0?totalRecords/10:(totalRecords/10)+1;
		this.totalPages4 = totalRecords % 4==0?totalRecords/4:(totalRecords/4)+1;
	}
	public int getNowRecords() {
		return nowRecords;
	}
	public void setNowRecords(int nowRecords) {
		this.nowRecords = nowRecords;
	}
	
	public boolean isHaveNextRecord() {
		if(nowRecords<totalRecords){
			return true;
		}else{
			return false;
		}
	}
	public void setHaveNextRecord(boolean haveNextRecord) {
		this.haveNextRecord = haveNextRecord;
	}
	public boolean isHavePreRecord() {
		if(nowRecords>1){
			return true;
		}else{
			return false;
		}
	}
	public void setHavePreRecord(boolean havePreRecord) {
		this.havePreRecord = havePreRecord;
	}
	public boolean isHaveNextPage() {
		if(this.pageNum < this.totalPages)
			return true;
		else
			return false;
	}
	public void setHaveNextPage(boolean haveNextPage) {
		this.haveNextPage = haveNextPage;
	}
	public boolean isHavePrePage() {
		if(this.pageNum > 1)
			return true;
		else
			return false;
	}
	public void setHavePrePage(boolean havePrePage) {
		this.havePrePage = havePrePage;
	}
	public List<T> getPageDatas() {
		return pageDatas;
	}
	public void setPageDatas(List<T> pageDetail) {
		this.pageDatas = pageDetail;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getTotalPages1() {
		return totalPages1;
	}
	public int getTotalPages2() {
		return totalPages2;
	}
	public int getTotalPages3() {
		return totalPages3;
	}
	public int getTotalPages4() {
		return totalPages4;
	}
	public int getPageSize() {
		return pageSize;
	}

}
