package com.myBlog.Dao;

import com.myBlog.domain.Content;
import com.myBlog.domain.ContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
	long countByExample(ContentExample example);

	int deleteByExample(ContentExample example);

	int deleteByPrimaryKey(Integer contentId);

	int insert(Content record);

	int insertSelective(Content record);

	List<Content> selectByExampleWithBLOBs(ContentExample example);

	List<Content> selectByExample(ContentExample example);

	Content selectByPrimaryKey(Integer contentId);

	int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

	int updateByPrimaryKeySelective(Content record);

	int updateByPrimaryKeyWithBLOBs(Content record);

	int updateByPrimaryKey(Content record);

	List<Content> getAll();

	int deleteById(String id);

	int updateCount(String id);

	Content selectLast(Integer contentId);

	Content selectNext(Integer contentId);
}