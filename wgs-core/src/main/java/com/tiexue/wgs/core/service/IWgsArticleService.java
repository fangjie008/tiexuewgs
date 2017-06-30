package com.tiexue.wgs.core.service;


import com.tiexue.wgs.core.entity.WgsArticle;

public interface IWgsArticleService {

	    int deleteByPrimaryKey(Integer id);

	    int insert(WgsArticle record);

	    int insertSelective(WgsArticle record);
	    WgsArticle selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(WgsArticle record);
	    int updateByPrimaryKey(WgsArticle record);
	    WgsArticle getModelByUniqueFlag(String uniqueFlag);
	    
	    int SaveArticle(WgsArticle wgsArticle);
}
