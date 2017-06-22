package com.tiexue.wgs.core.service;

import com.tiexue.wgs.core.entity.WgsArticleSub;

public interface IWgsArticleSubService {

    int insert(WgsArticleSub record);

    int insertSelective(WgsArticleSub record);
    
    WgsArticleSub select(Integer id);
}