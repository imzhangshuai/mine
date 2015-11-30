package com.team.mine.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class PageBean<T> implements Serializable {

	/**当前页码*/
	public int currPage;
	
	/**分页条数*/
	public int pageSize;
	
	/**总记录条数*/
	public int count;
	 
	/**总页数*/
	public int pageLen;
	

	/**当前页数据*/
	public List<T> data;
	
	/**搜索条件*/
	public Map<String,Object> params;

	public int getPageLen(){
		int result=0;
		if(pageSize>0){
			result=count%pageSize==0? count/pageSize:count/pageSize+1;
		}
		return result;
	}
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setPageLen(int pageLen) {
		this.pageLen = pageLen;
	}
	
	
	
}
