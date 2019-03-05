package com.myBlog.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myBlog.Dao.SequenceMapper;
import com.myBlog.Dao.UserMapper;
import com.myBlog.domain.User;
import com.myBlog.service.UserService;
import com.myBlog.util.MD5Util;

/**
 * @author jcs
 * @date 2019年3月5日-下午2:20:59
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userDao;
	@Resource
	private SequenceMapper sequenceMapper;

	public boolean login(User model, HttpSession session) throws Exception {
		model.setPassWord(MD5Util.md5(model.getPassWord(), null));
		User user = userDao.findByUserName(model.getUserName(), model.getPassWord());
		if (user != null) {
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}

	public PageInfo getPage(Integer pn, Integer row) {
		PageHelper.startPage(pn, 5);
		List<User> user = userDao.getAll();
		PageInfo page = new PageInfo(user, row);
		return page;
	}

	public PageInfo search(Integer pn, String userName) {
		PageHelper.startPage(pn, 5);
		List<User> user;
		if ("" != userName) {
			user = userDao.getByName(userName);
		} else {
			user = userDao.getAll();
		}
		PageInfo page = new PageInfo(user, 5);
		return page;
	}

	public Map<String, Object> addUser(User model) throws Exception {
		model.setUserId(sequenceMapper.getNowId());
		model.setPassWord(MD5Util.md5(model.getPassWord(), null));
		model.setPermission(1);
		int count = userDao.insert(model);
		Map<String, Object> result = new HashMap<String, Object>();
		if (count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}

	public User getUserById(int id) {
		String date;
		User result = userDao.selectByPrimaryKey(id);
		return result;
	}

	public Map<String, Object> editUser(User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = userDao.updateByPrimaryKeySelective(user);
		if (a != 0) {
			result.put("re", "success");
		} else {
			result.put("re", "fail");
		}
		return result;
	}

	public Map<String, Object> deleteUserById(int id) {
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
