package com.tiexue.wgs.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiexue.wgs.core.entity.WgsComment;
import com.tiexue.wgs.core.mapper.WgsCommentMapper;
import com.tiexue.wgs.core.service.IWgsCommentService;

@Service("iWgsCommentService")
public class WgsCommentServiceImpl implements IWgsCommentService {

	@Resource 
	WgsCommentMapper wgsCommentMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return wgsCommentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WgsComment record) {
		return wgsCommentMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsComment record) {
		return wgsCommentMapper.insertSelective(record);
	}

	@Override
	public WgsComment selectByPrimaryKey(Integer id) {
		return wgsCommentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WgsComment record) {
		return wgsCommentMapper.updateByPrimaryKeySelective(record);
	}


	@Override
	public int updateByPrimaryKey(WgsComment record) {
		return wgsCommentMapper.updateByPrimaryKey(record);
	}


}
