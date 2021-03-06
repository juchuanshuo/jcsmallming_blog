package com.myBlog.Dao;

import com.myBlog.domain.User;
import com.myBlog.domain.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User findByUserName(String userName, String passWord);

	List<User> getAll();

	List<User> getByName(String userName);

	int deleteById(int id);
}