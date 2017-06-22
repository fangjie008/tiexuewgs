package com.tiexue.wgs.core.service;

import com.tiexue.wgs.core.dto.WgsChannelDto;
import com.tiexue.wgs.core.entity.WgsChannel;

import java.util.List;


public interface IWgsChannelService {

    int deleteByPrimaryKey(Integer id);


    int insert(WgsChannel record);

    int insertSelective(WgsChannel record);


    WgsChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsChannel record);


    int updateByPrimaryKey(WgsChannel record);
    
    WgsChannelDto getModelbyId(Integer id);
    
    List<WgsChannelDto> getListByType(Integer status,Integer type);
}