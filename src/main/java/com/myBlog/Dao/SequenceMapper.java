package com.myBlog.Dao;

import com.myBlog.domain.Sequence;
import com.myBlog.domain.SequenceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SequenceMapper {
	long countByExample(SequenceExample example);

	int deleteByExample(SequenceExample example);

	int deleteByPrimaryKey(String name);

	int insert(Sequence record);

	int insertSelective(Sequence record);

	List<Sequence> selectByExample(SequenceExample example);

	Sequence selectByPrimaryKey(String name);

	int updateByExampleSelective(@Param("record") Sequence record, @Param("example") SequenceExample example);

	int updateByExample(@Param("record") Sequence record, @Param("example") SequenceExample example);

	int updateByPrimaryKeySelective(Sequence record);

	int updateByPrimaryKey(Sequence record);

	Integer getNowId();
}