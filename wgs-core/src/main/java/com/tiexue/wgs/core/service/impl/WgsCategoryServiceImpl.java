package com.tiexue.wgs.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiexue.wgs.core.entity.WgsCategory;
import com.tiexue.wgs.core.mapper.WgsCategoryMapper;
import com.tiexue.wgs.core.service.IWgsCategoryService;

@Service("wgscategoryServiceImpl")
public class WgsCategoryServiceImpl implements IWgsCategoryService {
	@Resource
	WgsCategoryMapper wgsCategoryMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return wgsCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WgsCategory record) {
		return wgsCategoryMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsCategory record) {
		return wgsCategoryMapper.insertSelective(record);
	}

	@Override
	public WgsCategory selectByPrimaryKey(Integer id) {
		return wgsCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WgsCategory record) {
		return wgsCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WgsCategory record) {
		return wgsCategoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public WgsCategory getModelByName(String name) {
		return wgsCategoryMapper.getModelByName(name);
	}


}
