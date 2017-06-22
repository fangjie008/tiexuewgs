package com.tiexue.wgs.core.mapper;

import com.tiexue.wgs.core.entity.WgsArticleSub;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface WgsArticleSubMapper {
    @Insert({
        "insert into WgsArticleSub (Id, OriginalContent)",
        "values (#{id,jdbcType=INTEGER}, #{originalcontent,jdbcType=LONGVARCHAR})"
    })
    int insert(WgsArticleSub record);

    int insertSelective(WgsArticleSub record);
    
    @Select({" select Id, OriginalContent from WgsArticleSub ",
    	" where Id=#{id}"})
    @ResultMap("BaseResultMap")
    WgsArticleSub select(@Param("id")Integer id);
}