package com.tiexue.wgs.core.mapper;

import com.tiexue.wgs.core.entity.WgsChannel;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WgsChannelMapper {
    @Delete({
        "delete from WgsChannel",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into WgsChannel (Id, Name, ",
        "Intro, CoverImg, ",
        "Mark, Status, Type, ",
        "CreateTime)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{coverimg,jdbcType=VARCHAR}, ",
        "#{mark,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(WgsChannel record);

    int insertSelective(WgsChannel record);

    @Select({
        "select",
        "Id, Name, Intro, CoverImg, Mark, Status, Type, CreateTime",
        "from WgsChannel",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    WgsChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsChannel record);

    @Update({
        "update WgsChannel",
        "set Name = #{name,jdbcType=VARCHAR},",
          "Intro = #{intro,jdbcType=VARCHAR},",
          "CoverImg = #{coverimg,jdbcType=VARCHAR},",
          "Mark = #{mark,jdbcType=INTEGER},",
          "Status = #{status,jdbcType=INTEGER},",
          "Type = #{type,jdbcType=INTEGER},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WgsChannel record);
    
    
    @Select({
        "select",
        "Id, Name, Intro, CoverImg, Mark, Status, Type, CreateTime",
        "from WgsChannel",
        "where Status=#{status} and Type=#{type}"
    })
    @ResultMap("BaseResultMap")
    List<WgsChannel> getListByType(@Param("status")Integer status,@Param("type")Integer type);
}