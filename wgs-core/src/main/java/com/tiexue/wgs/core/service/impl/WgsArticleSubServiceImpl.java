package com.tiexue.wgs.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiexue.wgs.core.entity.WgsArticleSub;
import com.tiexue.wgs.core.mapper.WgsArticleSubMapper;
import com.tiexue.wgs.core.service.IWgsArticleSubService;
@Service("iWgsArticleSubService")
public class WgsArticleSubServiceImpl implements IWgsArticleSubService {

	@Resource 
	WgsArticleSubMapper wgsArticleSubMapper;
	
	@Override
	public int insert(WgsArticleSub record) {
		return wgsArticleSubMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsArticleSub record) {
		return wgsArticleSubMapper.insertSelective(record);
	}

	@Override
	public WgsArticleSub select(Integer id) {
		return wgsArticleSubMapper.select(id);
	}



}
