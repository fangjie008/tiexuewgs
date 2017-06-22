package com.tiexue.wgs.core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiexue.wgs.core.dto.WgsArticleDto;
import com.tiexue.wgs.core.entity.WgsArticle;


public interface IWgsArticleService {
  
    int deleteByPrimaryKey(Integer id);

  
    int insert(WgsArticle record);

    int insertSelective(WgsArticle record);


    WgsArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsArticle record);

    int updateByPrimaryKey(WgsArticle record);
    
    List<WgsArticleDto> getList(Integer pStart,Integer pEnd);
    
    WgsArticleDto getModel(Integer id);

    /**
     * 按照WgsArticle表中的SourceType获取文章列表
     * @param sourceType
     * @return
     */
    List<WgsArticleDto> getListBySourceType(Integer sourceType,String order,Integer pStart,Integer pSize);
    
    

    /**
     * 按照WgsArticle表中的SourceType获取文章列表
     * @param sourceType
     * @return
     */
    List<WgsArticleDto> getAllListBySourceType(Integer sourceType,String order);
    
    /**
     * 按照WgsArticle表中的多个SourceType获取文章列表
     * @param sourceType
     * @return
     */
    List<WgsArticleDto> getListBySourceTypes(String sourceTypes,String order,Integer pStart,Integer pSize);
    
    
    
    /**
     * 按照WgsArticle表中的多个SourceType获取文章列表
     * @param sourceType
     * @return
     */
    List<WgsArticleDto> getAllListBySourceTypes(String sourceTypes,String order);
}