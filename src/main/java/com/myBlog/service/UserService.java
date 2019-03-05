package com.myBlog.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.myBlog.domain.User;

/**
 * @author jcs
 * @date 2019��3��5��-����2:20:18
 */
public interface UserService {

	/**
	 * ��½����
	 */
	public boolean login(User model, HttpSession session) throws Exception;

	/**
	 * ��ָ����ҳ���Լ�ÿҳ�������������û���Ϣ
	 * 
	 * @param pn
	 * @param row
	 * @return
	 */
	public PageInfo getPage(Integer pn, Integer row);

	/**
	 * ͨ���û��������û�����
	 * 
	 * @param pn
	 * @param userName
	 * @return
	 */
	public PageInfo search(Integer pn, String userName);

	/**
	 * ����û�
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addUser(User model) throws Exception;

	/**
	 * ͨ���û�id��ȡ�û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);

	/**
	 * ͨ��id�༭�û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> editUser(User user);

	/**
	 * ͨ��idɾ���û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteUserById(int id);
}
