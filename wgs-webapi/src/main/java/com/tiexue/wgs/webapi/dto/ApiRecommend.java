package com.tiexue.wgs.webapi.dto;

import java.util.List;

public class ApiRecommend {

    private String msg;
	private int code;
	private List<ApiArticle> slider;
	private List<ApiArticle> venues;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<ApiArticle> getSlider() {
		return slider;
	}
	public void setSlider(List<ApiArticle> slider) {
		this.slider = slider;
	}
	public List<ApiArticle> getVenues() {
		return venues;
	}
	public void setVenues(List<ApiArticle> venues) {
		this.venues = venues;
	}
	
	
}
