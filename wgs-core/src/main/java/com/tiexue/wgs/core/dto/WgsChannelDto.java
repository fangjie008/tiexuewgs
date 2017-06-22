package com.tiexue.wgs.core.dto;

import java.util.List;

public class WgsChannelDto {
    
	private Integer id;

    private String name;

    private String intro;

    private String coverimg;

    private Integer mark;

    private Integer status;
    
    private Integer type;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg == null ? null : coverimg.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


}