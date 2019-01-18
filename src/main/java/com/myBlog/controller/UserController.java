package com.myBlog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myBlog.Dao.SequenceMapper;
import com.myBlog.Dao.UserMapper;
import com.myBlog.domain.User;
import com.myBlog.util.MD5Util;

/**
 * ÓÃ»§¿ØÖÆÆ÷
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private UserMapper userDao;
	@Resource
	private SequenceMapper sequenceMapper;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo list(@RequestParam(value = "page", defaultValue = "1") Integer pn,
			@RequestParam(value = "row", defaultValue = "30") Integer row) {
		PageHelper.startPage(pn, 5);
		List<User> user = userDao.getAll();
		PageInfo page = new PageInfo(user, row);
		return page;
	}

	@RequestMapping("/search")
	@ResponseBody
	public PageInfo search(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "userName") String userName) {
		PageHelper.startPage(pn, 5);
		System.out.println(userName);
		List<User> user;
		if ("" != userName) {
			user = userDao.getByName(userName);
		} else {
			user = userDao.getAll();
		}
		PageInfo page = new PageInfo(user, 5);
		return page;
	}

	@RequestMapping("/user-list")
	public ModelAndView addList() {
		return new ModelAndView("user/user-list");
	}

	@RequestMapping("/user-add")
	public ModelAndView user_add() {
		return new ModelAndView("user/user-add");
	}

	@RequestMapping("/user-edit")
	public ModelAndView user_edit() {
		return new ModelAndView("user/user-edit");
	}

	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> add(User model) throws Exception {
		model.setUserId(sequenceMapper.getNowId());
		model.setPassWord(MD5Util.md5(model.getPassWord(), null));
		int count = userDao.insert(model);
		Map<String, Object> result = new HashMap<String, Object>();
		if (count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User getuser(@PathVariable("id") int id) {
		String date;
		User result = userDao.selectByPrimaryKey(id);
		return result;
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> edit(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = userDao.updateByPrimaryKeySelective(user);
		if (a != 0) {
			result.put("re", "success");
		} else {
			result.put("re", "fail");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") int id) {
		int count = userDao.deleteById(id);
		Map<String, Object> result = new HashMap<String, Object>();
		if (count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
}