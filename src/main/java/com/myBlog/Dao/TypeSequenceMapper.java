package com.myBlog.Dao;

import com.myBlog.domain.TypeSequence;
import com.myBlog.domain.TypeSequenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeSequenceMapper {
    long countByExample(TypeSequenceExample example);

    int deleteByExample(TypeSequenceExample example);

    int deleteByPrimaryKey(String name);

    int insert(TypeSequence record);

    int insertSelective(TypeSequence record);

    List<TypeSequence> selectByExample(TypeSequenceExample example);

    TypeSequence selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") TypeSequence record, @Param("example") TypeSequenceExample example);

    int updateByExample(@Param("record") TypeSequence record, @Param("example") TypeSequenceExample example);

    int updateByPrimaryKeySelective(TypeSequence record);

    int updateByPrimaryKey(TypeSequence record);
    
    Integer getNowId();
}