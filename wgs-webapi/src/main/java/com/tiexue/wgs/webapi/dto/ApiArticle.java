package com.tiexue.wgs.webapi.dto;

import java.util.List;

public class ApiArticle{

	private Integer id;
	private String title;
	private String Intro;
	private String coverImgs;
	private List<ContentPicModel> contentPic;
	private MaterialModel materials;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return Intro;
	}
	public void setIntro(String intro) {
		Intro = intro;
	}
	public String getCoverImgs() {
		return coverImgs;
	}
	public void setCoverImgs(String coverImgs) {
		this.coverImgs = coverImgs;
	}
	public List<ContentPicModel> getContentPic() {
		return contentPic;
	}
	public void setContentPic(List<ContentPicModel> contentPic) {
		this.contentPic = contentPic;
	}
	public MaterialModel getMaterials() {
		return materials;
	}
	public void setMaterials(MaterialModel materials) {
		this.materials = materials;
	}

}
