package com.myBlog.Dao;

import com.myBlog.domain.UserSequence;
import com.myBlog.domain.UserSequenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSequenceMapper {
    long countByExample(UserSequenceExample example);

    int deleteByExample(UserSequenceExample example);

    int deleteByPrimaryKey(String name);

    int insert(UserSequence record);

    int insertSelective(UserSequence record);

    List<UserSequence> selectByExample(UserSequenceExample example);

    UserSequence selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") UserSequence record, @Param("example") UserSequenceExample example);

    int updateByExample(@Param("record") UserSequence record, @Param("example") UserSequenceExample example);

    int updateByPrimaryKeySelective(UserSequence record);

    int updateByPrimaryKey(UserSequence record);
    
    Integer getNowId();
}