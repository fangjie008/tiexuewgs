package com.tiexue.wgs.core.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.entity.WgsArticleSub;
import com.tiexue.wgs.core.mapper.WgsArticleMapper;
import com.tiexue.wgs.core.mapper.WgsArticleSubMapper;
import com.tiexue.wgs.core.service.IWgsArticleService;

@Service("wgsArticleServiceImpl")
public class WgsArticleServiceImpl implements IWgsArticleService {
	// 日志
	private Logger logger = Logger.getLogger(WgsArticleServiceImpl.class);
	@Resource
	WgsArticleMapper wgsArticleMapper;
	@Resource
	WgsArticleSubMapper wgsArticleSubMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return wgsArticleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WgsArticle record) {
		return wgsArticleMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsArticle record) {
		return wgsArticleMapper.insertSelective(record);
	}

	@Override
	public WgsArticle selectByPrimaryKey(Integer id) {
		return wgsArticleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WgsArticle record) {
		return wgsArticleMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(WgsArticle record) {
		return wgsArticleMapper.updateByPrimaryKey(record);
	}

	@Override
	public WgsArticle getModelByUniqueFlag(String uniqueFlag) {
		return wgsArticleMapper.getModelByUniqueFlag(uniqueFlag);
	}

	@Override
	@Transactional
	public int SaveArticle(WgsArticle wgsArticle) {
		
		
		try {
			if(wgsArticle==null)
				return -1;
		    int insertNum=insert(wgsArticle);
		    if(wgsArticle.getId()>0){
		    	WgsArticleSub wgsArticleSub=new WgsArticleSub();
		    	wgsArticleSub.setId(wgsArticle.getId());
		    	wgsArticleSub.setOriginalcontent(wgsArticle.getOriginalContent());
		    	insertNum=wgsArticleSubMapper.insert(wgsArticleSub);
		    	return insertNum;
		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
			//必须抛出异常 否则事务就不能正常执行
			throw e;
		}
		return 0;
	}

}
