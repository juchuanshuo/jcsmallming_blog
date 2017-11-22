package com.myBlog.Dao;

import com.myBlog.domain.ContentType;
import com.myBlog.domain.ContentTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentTypeMapper {
    long countByExample(ContentTypeExample example);

    int deleteByExample(ContentTypeExample example);

    int deleteByPrimaryKey(Integer contentType);

    int insert(ContentType record);

    int insertSelective(ContentType record);

    List<ContentType> selectByExample(ContentTypeExample example);

    ContentType selectByPrimaryKey(Integer contentType);

    int updateByExampleSelective(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByExample(@Param("record") ContentType record, @Param("example") ContentTypeExample example);

    int updateByPrimaryKeySelective(ContentType record);

    int updateByPrimaryKey(ContentType record);

	List<ContentType> selectAll();
}