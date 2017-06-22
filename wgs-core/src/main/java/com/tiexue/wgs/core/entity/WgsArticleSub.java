package com.tiexue.wgs.core.entity;

public class WgsArticleSub {
    private Integer id;

    private String originalcontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalcontent() {
        return originalcontent;
    }

    public void setOriginalcontent(String originalcontent) {
        this.originalcontent = originalcontent == null ? null : originalcontent.trim();
    }
}