package com.myBlog.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.myBlog.domain.User;
import com.myBlog.service.UserService;
import com.myBlog.serviceImpl.UserServiceImpl;

/**
 * 用户控制器 1.负责管理员登陆功能 2.负责后台用户管理功能
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Resource
	UserService service;

	/**
	 * 登陆管理
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(User model, HttpSession session) throws Exception {
		boolean isSuccess = service.login(model, session);
		if (isSuccess) {
			return new ModelAndView("redirect:/admin_for_jcs/indexview");
		} else {
			return new ModelAndView("login/login");
		}
	}

	/**
	 * 按指定的页数以及每页数据条数返回用户信息
	 * 
	 * @param pn
	 * @param row
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo list(@RequestParam(value = "page", defaultValue = "1") Integer pn,
			@RequestParam(value = "row", defaultValue = "30") Integer row) {
		PageInfo page = service.getPage(pn, row);
		return page;
	}

	/**
	 * 通过用户名搜索用户数据
	 * 
	 * @param pn
	 * @param userName
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	public PageInfo search(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "userName") String userName) {
		PageInfo page = service.search(pn, userName);
		return page;
	}

	/**
	 * 返回用户列表的页面
	 * 
	 * @return
	 */
	@RequestMapping("/user-list")
	public ModelAndView addList() {
		return new ModelAndView("user/user-list");
	}

	/**
	 * 添加新用户的页面
	 * 
	 * @return
	 */
	@RequestMapping("/user-add")
	public ModelAndView user_add() {
		return new ModelAndView("user/user-add");
	}

	/**
	 * 编辑用户信息的页面
	 * 
	 * @return
	 */
	@RequestMapping("/user-edit")
	public ModelAndView user_edit() {
		return new ModelAndView("user/user-edit");
	}

	/**
	 * 添加用户
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public Map<String, Object> addUser(User model) throws Exception {
		Map<String, Object> result = service.addUser(model);
		return result;
	}

	/**
	 * 通过用户id获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User getuser(@PathVariable("id") int id) {
		User result = service.getUserById(id);
		return result;
	}

	/**
	 * 通过id编辑用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> edit(User user) {
		Map<String, Object> result = service.editUser(user);
		return result;
	}

	/**
	 * 通过id删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") int id) {
		Map<String, Object> result = service.deleteUserById(id);
		return result;
	}

}