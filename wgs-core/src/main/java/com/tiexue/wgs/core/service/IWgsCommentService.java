package com.tiexue.wgs.core.service;

import com.tiexue.wgs.core.entity.WgsComment;


public interface IWgsCommentService {

    int deleteByPrimaryKey(Integer id);


    int insert(WgsComment record);

    int insertSelective(WgsComment record);

    WgsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsComment record);
    
    int updateByPrimaryKey(WgsComment record);
}