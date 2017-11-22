package com.myBlog.Dao;

import com.myBlog.domain.Gender;
import com.myBlog.domain.GenderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GenderMapper {
    long countByExample(GenderExample example);

    int deleteByExample(GenderExample example);

    int deleteByPrimaryKey(Integer gender);

    int insert(Gender record);

    int insertSelective(Gender record);

    List<Gender> selectByExample(GenderExample example);

    Gender selectByPrimaryKey(Integer gender);

    int updateByExampleSelective(@Param("record") Gender record, @Param("example") GenderExample example);

    int updateByExample(@Param("record") Gender record, @Param("example") GenderExample example);

    int updateByPrimaryKeySelective(Gender record);

    int updateByPrimaryKey(Gender record);
}