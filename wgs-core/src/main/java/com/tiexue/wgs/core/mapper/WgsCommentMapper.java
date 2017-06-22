package com.tiexue.wgs.core.mapper;

import com.tiexue.wgs.core.entity.WgsComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WgsCommentMapper {
    @Delete({
        "delete from WgsComment",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into WgsComment (Id, ArticleId, ",
        "PublisherId, PublisherName, ",
        "PublisherIcon, TopTargetCommentId, ",
        "TargetCommentId, TargetUserId, ",
        "TargetUserName, DingCount, ",
        "CaiCount, CommentCount, ",
        "Status, ShowTime, ",
        "CreateTime, Mark, ",
        "Weight, Flag, Content, ",
        "Imgs)",
        "values (#{id,jdbcType=INTEGER}, #{articleid,jdbcType=INTEGER}, ",
        "#{publisherid,jdbcType=INTEGER}, #{publishername,jdbcType=VARCHAR}, ",
        "#{publishericon,jdbcType=VARCHAR}, #{toptargetcommentid,jdbcType=INTEGER}, ",
        "#{targetcommentid,jdbcType=INTEGER}, #{targetuserid,jdbcType=INTEGER}, ",
        "#{targetusername,jdbcType=VARCHAR}, #{dingcount,jdbcType=INTEGER}, ",
        "#{caicount,jdbcType=INTEGER}, #{commentcount,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{showtime,jdbcType=TIMESTAMP}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{mark,jdbcType=INTEGER}, ",
        "#{weight,jdbcType=INTEGER}, #{flag,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR}, ",
        "#{imgs,jdbcType=LONGVARCHAR})"
    })
    int insert(WgsComment record);

    int insertSelective(WgsComment record);

    @Select({
        "select",
        "Id, ArticleId, PublisherId, PublisherName, PublisherIcon, TopTargetCommentId, ",
        "TargetCommentId, TargetUserId, TargetUserName, DingCount, CaiCount, CommentCount, ",
        "Status, ShowTime, CreateTime, Mark, Weight, Flag, Content, Imgs",
        "from WgsComment",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    WgsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsComment record);

    @Update({
        "update WgsComment",
        "set ArticleId = #{articleid,jdbcType=INTEGER},",
          "PublisherId = #{publisherid,jdbcType=INTEGER},",
          "PublisherName = #{publishername,jdbcType=VARCHAR},",
          "PublisherIcon = #{publishericon,jdbcType=VARCHAR},",
          "TopTargetCommentId = #{toptargetcommentid,jdbcType=INTEGER},",
          "TargetCommentId = #{targetcommentid,jdbcType=INTEGER},",
          "TargetUserId = #{targetuserid,jdbcType=INTEGER},",
          "TargetUserName = #{targetusername,jdbcType=VARCHAR},",
          "DingCount = #{dingcount,jdbcType=INTEGER},",
          "CaiCount = #{caicount,jdbcType=INTEGER},",
          "CommentCount = #{commentcount,jdbcType=INTEGER},",
          "Status = #{status,jdbcType=INTEGER},",
          "ShowTime = #{showtime,jdbcType=TIMESTAMP},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "Mark = #{mark,jdbcType=INTEGER},",
          "Weight = #{weight,jdbcType=INTEGER},",
          "Flag = #{flag,jdbcType=VARCHAR},",
          "Content = #{content,jdbcType=VARCHAR},",
          "Imgs = #{imgs,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WgsComment record);
}