package com.tiexue.wgs.core.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	    /**
	     * 根据条件获取分页的内容
	     * @param categorys 分类id:如果是多个就用逗号分隔.
	     * @param pageNo 页码
	     * @param pageSize 每页数量
	     * @return
	     */
	    List<WgsArticle> getList(String categorys,Integer pageNo,Integer pageSize);
	    
	    /**
	     * 根据查询条件获取文章数量
	     * @param strWhere
	     * @return
	     */
	    int getCount(String strWhere);
	    /**
	     * 获取未删除的文章明细信息
	     * @param id
	     * @return
	     */
	    WgsArticle getDetail(int id);
}
