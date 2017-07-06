package com.tiexue.wgs.core.service;





import com.tiexue.wgs.core.entity.WgsCategory;

public interface IWgsCategoryService {

	    int deleteByPrimaryKey(Integer id);
	    
	    int insert(WgsCategory record);

	    int insertSelective(WgsCategory record);

	    WgsCategory selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(WgsCategory record);

	    int updateByPrimaryKey(WgsCategory record);
	    
	    WgsCategory getModelByName(String name);
}
