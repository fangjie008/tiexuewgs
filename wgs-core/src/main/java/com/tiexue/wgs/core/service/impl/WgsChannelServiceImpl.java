package com.tiexue.wgs.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.WStringSeqHelper;
import org.springframework.stereotype.Service;

import com.tiexue.wgs.core.dto.WgsArticleDto;
import com.tiexue.wgs.core.dto.WgsChannelDto;
import com.tiexue.wgs.core.entity.WgsChannel;
import com.tiexue.wgs.core.mapper.WgsChannelMapper;
import com.tiexue.wgs.core.service.IWgsChannelService;

@Service("iWgsChannelService")
public class WgsChannelServiceImpl implements IWgsChannelService{

	@Resource
	WgsChannelMapper wgsChannelMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return wgsChannelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(WgsChannel record) {
		return wgsChannelMapper.insert(record);
	}

	@Override
	public int insertSelective(WgsChannel record) {
		return wgsChannelMapper.insertSelective(record);
	}

	@Override
	public WgsChannel selectByPrimaryKey(Integer id) {
		return wgsChannelMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WgsChannel record) {
		return wgsChannelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WgsChannel record) {
		return wgsChannelMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据Type获取频道信息列表
	 */
	@Override
	public List<WgsChannelDto> getListByType(Integer status, Integer type) {
		List<WgsChannelDto> wgsChannelDtos=new ArrayList<WgsChannelDto>();
		List<WgsChannel> wgsChannels= wgsChannelMapper.getListByType(status, type);
		if(wgsChannels==null)
			return null;
		for (WgsChannel wgsChannel : wgsChannels) {
			WgsChannelDto wgsChannelDto=new WgsChannelDto();
			wgsChannelDto=toWgsChannelDto(wgsChannel);
			wgsChannelDtos.add(wgsChannelDto);
		}
		return wgsChannelDtos;
	}
	
	
	@Override
	public WgsChannelDto getModelbyId(Integer id) {
		WgsChannel wgsChannel= wgsChannelMapper.selectByPrimaryKey(id);
		return toWgsChannelDto(wgsChannel);
	}
	
	/**
	 * 转化成WgsArticleDto
	 * @param wgsArticle
	 * @return
	 */
	@SuppressWarnings("unused")
	private WgsChannelDto toWgsChannelDto(WgsChannel wgsChannel){
		WgsChannelDto wgsChannelDto=new WgsChannelDto();
		 if(wgsChannel==null)
			 return null;
		 wgsChannelDto.setCoverimg(wgsChannel.getCoverimg()==null?"":wgsChannel.getCoverimg());
		 wgsChannelDto.setId(wgsChannel.getId()==null?0:wgsChannel.getId());
		 wgsChannelDto.setIntro(wgsChannel.getIntro()==null?"":wgsChannel.getIntro());
		 wgsChannelDto.setMark(wgsChannel.getMark()==null?0:wgsChannel.getMark());
		 wgsChannelDto.setName(wgsChannel.getName()==null?"":wgsChannel.getName());
		 wgsChannelDto.setStatus(wgsChannel.getStatus()==null?0:wgsChannel.getStatus());
		 wgsChannelDto.setType(wgsChannel.getType()==null?0:wgsChannel.getType());
		 return wgsChannelDto;
	}

	

}
