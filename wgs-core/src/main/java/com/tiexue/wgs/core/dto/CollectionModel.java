package com.tiexue.wgs.core.dto;

import java.util.List;

public class CollectionModel {

	private CollectionArticle article;
	
	private List<CollectionComment> commmets;

	public CollectionArticle getArticle() {
		return article;
	}

	public void setArticle(CollectionArticle article) {
		this.article = article;
	}

	public List<CollectionComment> getCommmets() {
		return commmets;
	}

	public void setCommmets(List<CollectionComment> commmets) {
		this.commmets = commmets;
	}
	
	
}


