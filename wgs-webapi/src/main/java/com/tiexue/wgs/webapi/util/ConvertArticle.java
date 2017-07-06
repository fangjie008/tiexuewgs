package com.tiexue.wgs.webapi.util;

import java.util.Date;


import com.tiexue.wgs.base.util.DateUtil;
import com.tiexue.wgs.core.dto.CollectionArticle;
import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.entity.WgsConstants;

public class ConvertArticle {
	public static WgsArticle fillArticle(CollectionArticle article){
		WgsArticle wgsArticle=new WgsArticle();
		wgsArticle.setCaicount(0);
		wgsArticle.setCategoryid(0);
		wgsArticle.setCategoryName(article.getChannelName()==null?"":article.getChannelName());
		wgsArticle.setCollectioncount(0);
		wgsArticle.setCommentcount(0);
		wgsArticle.setContentlen(article.getArticle()==null?0:article.getArticle().length());
		wgsArticle.setContenttype(0);
		wgsArticle.setCoverimgs(article.getCoversURL()==null?"[]":article.getCoversURL());
		wgsArticle.setCreatetime(new Date());
		wgsArticle.setDingcount(0);
		wgsArticle.setFromid(0);
		wgsArticle.setFromname(article.getFromName()==null?"":article.getFromName());
		wgsArticle.setImgshowtype(article.isCoverIsWidePicture()?1:0);
		wgsArticle.setIntro(article.getIntroduce()==null?"":article.getIntroduce());
		wgsArticle.setMark(0);
		wgsArticle.setOriginalid(article.getUniqueFlag()==null?"":article.getUniqueFlag());
		wgsArticle.setOriginaltitle(article.getSubject()==null?"":article.getSubject());
		wgsArticle.setOriginalurl(article.getOrignalURL()==null?"":article.getOrignalURL());
		wgsArticle.setOriginalContent(article.getArticle()==null?"":article.getArticle());
		wgsArticle.setPlatformname(article.getPlatformName()==null?"":article.getPlatformName());
		wgsArticle.setPlatformid(article.getPlatformID()==null?0:article.getPlatformID());
		wgsArticle.setPublisherid(0);
		wgsArticle.setPublishericon(article.getAuthorAvatar()==null?"":article.getAuthorAvatar());
		wgsArticle.setPublishername(article.getAuthor()==null?"":(article.getAuthor().length()>32?article.getAuthor().substring(0,30):article.getAuthor()));
		if(article.getPostTime()!=null&&DateUtil.isValidDate(article.getPostTime())){
			Date date;
			try {
				date=DateUtil.str2Date(article.getPostTime(), "yyyy-MM-dd");
			} catch (Exception e) {
				date=new Date();
			}
			wgsArticle.setShowtime(date);
		}
		else{
			wgsArticle.setShowtime(new Date());
		}
		wgsArticle.setSourcetype(article.getSourceType()==null?0:article.getSourceType());
		wgsArticle.setStatus(WgsConstants.ArticleStatus_Normal);
		wgsArticle.setTags(article.getTags()==null?"[]":article.getTags());
		wgsArticle.setTitle(article.getSubject()==null?"":article.getSubject());
		wgsArticle.setUniqueflag(article.getUniqueFlag()==null?"":article.getUniqueFlag());
		wgsArticle.setUscore(0);
		wgsArticle.setViewcount(0);
		wgsArticle.setWeight(0);
		wgsArticle.setSharecount(0);
		wgsArticle.setContentPic(article.getContentPic()==null?"[]":article.getContentPic());
		wgsArticle.setMaterials(article.getMaterials()==null?"{}":article.getMaterials());
		return wgsArticle;
		
	}
}
