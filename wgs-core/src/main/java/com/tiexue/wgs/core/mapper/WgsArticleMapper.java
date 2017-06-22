package com.tiexue.wgs.core.mapper;

import com.tiexue.wgs.core.entity.WgsArticle;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WgsArticleMapper {
    @Delete({
        "delete from WgsArticle",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into WgsArticle (Id, Title, ",
        "Intro, CoverImgs, ",
        "ImgShowType, ContentType, ",
        "PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, ",
        "DingCount, CaiCount, ",
        "CommentCount, ShareCount, ",
        "CollectionCount, ShowTime, ",
        "CreateTime, Mark, ",
        "Status, SourceType, ",
        "Weight, OriginalId, ",
        "OriginalTitle, OriginalUrl, ",
        "FromId, FromName, ",
        "PlatformId, PlatformName, ",
        "ContentLen, Uscore, ",
        "Tags)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{coverimgs,jdbcType=VARCHAR}, ",
        "#{imgshowtype,jdbcType=INTEGER}, #{contenttype,jdbcType=INTEGER}, ",
        "#{publisherid,jdbcType=INTEGER}, #{publishername,jdbcType=VARCHAR}, ",
        "#{publishericon,jdbcType=VARCHAR}, #{viewcount,jdbcType=INTEGER}, ",
        "#{dingcount,jdbcType=INTEGER}, #{caicount,jdbcType=INTEGER}, ",
        "#{commentcount,jdbcType=INTEGER}, #{sharecount,jdbcType=INTEGER}, ",
        "#{collectioncount,jdbcType=INTEGER}, #{showtime,jdbcType=TIMESTAMP}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{mark,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{sourcetype,jdbcType=INTEGER}, ",
        "#{weight,jdbcType=INTEGER}, #{originalid,jdbcType=VARCHAR}, ",
        "#{originaltitle,jdbcType=VARCHAR}, #{originalurl,jdbcType=VARCHAR}, ",
        "#{fromid,jdbcType=INTEGER}, #{fromname,jdbcType=VARCHAR}, ",
        "#{platformid,jdbcType=INTEGER}, #{platformname,jdbcType=VARCHAR}, ",
        "#{contentlen,jdbcType=INTEGER}, #{uscore,jdbcType=INTEGER}, ",
        "#{tags,jdbcType=LONGVARCHAR})"
    })
    int insert(WgsArticle record);

    int insertSelective(WgsArticle record);

    @Select({
        "select",
        "Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore, ",
        "Tags",
        "from WgsArticle",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    WgsArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsArticle record);

    @Update({
        "update WgsArticle",
        "set Title = #{title,jdbcType=VARCHAR},",
          "Intro = #{intro,jdbcType=VARCHAR},",
          "CoverImgs = #{coverimgs,jdbcType=VARCHAR},",
          "ImgShowType = #{imgshowtype,jdbcType=INTEGER},",
          "ContentType = #{contenttype,jdbcType=INTEGER},",
          "PublisherId = #{publisherid,jdbcType=INTEGER},",
          "PublisherName = #{publishername,jdbcType=VARCHAR},",
          "PublisherIcon = #{publishericon,jdbcType=VARCHAR},",
          "ViewCount = #{viewcount,jdbcType=INTEGER},",
          "DingCount = #{dingcount,jdbcType=INTEGER},",
          "CaiCount = #{caicount,jdbcType=INTEGER},",
          "CommentCount = #{commentcount,jdbcType=INTEGER},",
          "ShareCount = #{sharecount,jdbcType=INTEGER},",
          "CollectionCount = #{collectioncount,jdbcType=INTEGER},",
          "ShowTime = #{showtime,jdbcType=TIMESTAMP},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "Mark = #{mark,jdbcType=INTEGER},",
          "Status = #{status,jdbcType=INTEGER},",
          "SourceType = #{sourcetype,jdbcType=INTEGER},",
          "Weight = #{weight,jdbcType=INTEGER},",
          "OriginalId = #{originalid,jdbcType=VARCHAR},",
          "OriginalTitle = #{originaltitle,jdbcType=VARCHAR},",
          "OriginalUrl = #{originalurl,jdbcType=VARCHAR},",
          "FromId = #{fromid,jdbcType=INTEGER},",
          "FromName = #{fromname,jdbcType=VARCHAR},",
          "PlatformId = #{platformid,jdbcType=INTEGER},",
          "PlatformName = #{platformname,jdbcType=VARCHAR},",
          "ContentLen = #{contentlen,jdbcType=INTEGER},",
          "Uscore = #{uscore,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WgsArticle record);
    
    @Select({"select Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
    "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
    "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
    "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore,Tags ",
    " from WgsArticle Where Status=1 order by CreateTime Desc limit #{pStart},#{pEnd} "
    })
    @ResultMap("BaseResultMap")
    List<WgsArticle> getList(@Param("pStart")Integer pStart,@Param("pEnd")Integer pEnd);
    
    
    @Select({"select Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore,Tags ",
        " from WgsArticle Where Status=1 and SourceType=#{sourceType}  order by #{order}  limit #{pStart},#{pSize}"
        
        })
    @ResultMap("BaseResultMap")
    List<WgsArticle> getListBySourceType(@Param("sourceType")Integer sourceType,@Param("order")String order,@Param("pStart")Integer pStart,@Param("pSize")Integer pSize);
    
    @Select({"select Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore,Tags ",
        " from WgsArticle Where Status=1 and SourceType=#{sourceType}  order by #{order}  "
        
        })
    @ResultMap("BaseResultMap")
    List<WgsArticle> getAllListBySourceType(@Param("sourceType")Integer sourceType,@Param("order")String order);
    
    @Select({"select Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore,Tags ",
        " from WgsArticle Where Status=1 and SourceType in (#{sourceTypes}) order by #{order} "
        })
        @ResultMap("BaseResultMap")
    List<WgsArticle> getAllListBySourceTypes(@Param("sourceTypes")String sourceTypes,@Param("order")String order);
    
    
    @Select({"select Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore,Tags ",
        " from WgsArticle Where Status=1 and SourceType in (#{sourceTypes}) order by #{order}  limit #{pStart},#{pSize}"
        })
        @ResultMap("BaseResultMap")
    List<WgsArticle> getListBySourceTypes(@Param("sourceTypes")String sourceTypes,@Param("order")String order,@Param("pStart")Integer pStart,@Param("pSize")Integer pSize);
    
    
    @Select({
        "select",
        "Id, Title, Intro, CoverImgs, ImgShowType, ContentType, PublisherId, PublisherName, ",
        "PublisherIcon, ViewCount, DingCount, CaiCount, CommentCount, ShareCount, CollectionCount, ",
        "ShowTime, CreateTime, Mark, Status, SourceType, Weight, OriginalId, OriginalTitle, ",
        "OriginalUrl, FromId, FromName, PlatformId, PlatformName, ContentLen, Uscore, ",
        "Tags",
        "from WgsArticle",
        "where Id = #{id,jdbcType=INTEGER} and Status=1 "
    })
    @ResultMap("BaseResultMap")
    WgsArticle getModel(Integer id);
}