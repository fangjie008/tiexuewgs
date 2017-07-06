package com.tiexue.wgs.core.mapper;

import com.tiexue.wgs.core.entity.WgsCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WgsCategoryMapper {
    @Delete({
        "delete from WgsCategory",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into WgsCategory (Id, Name, ",
        "CoverImg, Status, ",
        "Type, Intro, Weight, ",
        "Tags, ParentId, ",
        "CreateTime, Remark)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{coverimg,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{intro,jdbcType=VARCHAR}, #{weight,jdbcType=INTEGER}, ",
        "#{tags,jdbcType=VARCHAR}, #{parentid,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(WgsCategory record);

    int insertSelective(WgsCategory record);

    @Select({
        "select",
        "Id, Name, CoverImg, Status, Type, Intro, Weight, Tags, ParentId, CreateTime, ",
        "Remark",
        "from WgsCategory",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    WgsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WgsCategory record);

    @Update({
        "update WgsCategory",
        "set Name = #{name,jdbcType=VARCHAR},",
          "CoverImg = #{coverimg,jdbcType=VARCHAR},",
          "Status = #{status,jdbcType=INTEGER},",
          "Type = #{type,jdbcType=INTEGER},",
          "Intro = #{intro,jdbcType=VARCHAR},",
          "Weight = #{weight,jdbcType=INTEGER},",
          "Tags = #{tags,jdbcType=VARCHAR},",
          "ParentId = #{parentid,jdbcType=INTEGER},",
          "CreateTime = #{createtime,jdbcType=TIMESTAMP},",
          "Remark = #{remark,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WgsCategory record);
    
    @Select({
        "select",
        "Id, Name, CoverImg, Status, Type, Intro, Weight, Tags, ParentId, CreateTime, ",
        "Remark",
        "from WgsCategory",
        "where Name = #{name,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    WgsCategory getModelByName(@Param("name")String name);
}