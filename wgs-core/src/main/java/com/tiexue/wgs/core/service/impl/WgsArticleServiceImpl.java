package com.tiexue.wgs.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tiexue.wgs.core.entity.WgsArticle;
import com.tiexue.wgs.core.entity.WgsArticleSub;
import com.tiexue.wgs.core.entity.WgsCategory;
import com.tiexue.wgs.core.entity.WgsConstants;
import com.tiexue.wgs.core.mapper.WgsArticleMapper;
import com.tiexue.wgs.core.mapper.WgsArticleSubMapper;
import com.tiexue.wgs.core.mapper.WgsCategoryMapper;
import com.tiexue.wgs.core.service.IWgsArticleService;
import com.tiexue.wgs.core.service.IWgsArticleSubService;
import com.tiexue.wgs.core.service.IWgsCategoryService;

@Service("wgsArticleServiceImpl")
public class WgsArticleServiceImpl implements IWgsArticleService {
	// 日志
	private Logger logger = Logger.getLogger(WgsArticleServiceImpl.class);
	@Resource
	WgsArticleMapper wgsArticleMapper;
	@Resource
	IWgsArticleSubService iWgsArticleSubService;
	@Resource
	IWgsCategoryService iWgsCategoryService;
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
			//根据分类名称获取分类Id
			if(wgsArticle.getCategoryName()!=null&&!wgsArticle.getCategoryName().isEmpty()){
				WgsCategory wgsCategory= iWgsCategoryService.getModelByName(wgsArticle.getCategoryName());
				if(wgsCategory!=null)
					wgsArticle.setCategoryid(wgsCategory.getId()==null?0:wgsCategory.getId());
			}
		    int insertNum=insert(wgsArticle);
		    if(wgsArticle.getId()>0){
		    	WgsArticleSub wgsArticleSub=new WgsArticleSub();
		    	wgsArticleSub.setId(wgsArticle.getId());
		    	wgsArticleSub.setOriginalcontent(wgsArticle.getOriginalContent());
		    	wgsArticleSub.setContentpic(wgsArticle.getContentPic());
		    	wgsArticleSub.setMaterials(wgsArticle.getMaterials());
		    	insertNum=iWgsArticleSubService.insert(wgsArticleSub);
		    	return insertNum;
		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
			//必须抛出异常 否则事务就不能正常执行
			throw e;
		}
		return 0;
	}

	@Override
	public List<WgsArticle> getList(String categorys, Integer pageNo, Integer pageSize) {
		String strWhere=" status="+WgsConstants.ArticleStatus_Normal;
		if(categorys!=null&&!"".equals(categorys)){
			strWhere +=" and CategoryId in ("+categorys+")";
		}
		return wgsArticleMapper.getList(strWhere, pageNo, pageSize);
	}

	@Override
	public int getCount(String categorys) {
		String strWhere=" status="+WgsConstants.ArticleStatus_Normal;
		if(categorys!=null&&!"".equals(categorys)){
			strWhere +=" and CategoryId in ("+categorys+")";
		}
		return wgsArticleMapper.getCount(strWhere);
	}
	@Override
	public WgsArticle getDetail(int id){
		WgsArticle wgsArticle;
		wgsArticle=wgsArticleMapper.getModel(id);
		if(wgsArticle!=null){
			WgsArticleSub wgsArticleSub= iWgsArticleSubService.select(id);
			if(wgsArticleSub!=null){
				wgsArticle.setOriginalContent(wgsArticleSub.getOriginalcontent());
				wgsArticle.setContentPic(wgsArticleSub.getContentpic());
				wgsArticle.setMaterials(wgsArticleSub.getMaterials());
			}
		}
		return wgsArticle;
	}

}
