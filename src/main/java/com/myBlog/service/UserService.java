package com.myBlog.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.myBlog.domain.User;

/**
 * @author jcs
 * @date 2019年3月5日-下午2:20:18
 */
public interface UserService {

	/**
	 * 登陆管理
	 */
	public boolean login(User model, HttpSession session) throws Exception;

	/**
	 * 按指定的页数以及每页数据条数返回用户信息
	 * 
	 * @param pn
	 * @param row
	 * @return
	 */
	public PageInfo getPage(Integer pn, Integer row);

	/**
	 * 通过用户名搜索用户数据
	 * 
	 * @param pn
	 * @param userName
	 * @return
	 */
	public PageInfo search(Integer pn, String userName);

	/**
	 * 添加用户
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addUser(User model) throws Exception;

	/**
	 * 通过用户id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);

	/**
	 * 通过id编辑用户信息
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> editUser(User user);

	/**
	 * 通过id删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteUserById(int id);
}
