package com.tiexue.wgs.webapi.dto;

import java.util.List;

public class ApiList {

	private Integer page;
	private boolean hasMore;
	private List<ApiArticle> list;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public List<ApiArticle> getList() {
		return list;
	}
	public void setList(List<ApiArticle> list) {
		this.list = list;
	}
	
}
