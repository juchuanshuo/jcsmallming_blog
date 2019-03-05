package com.myBlog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;

/**
 * @author jcs
 * @date 2019��3��5��-����4:01:27
 */
public interface ContentService {

	/**
	 * ͨ��id����ʵ�ʵ�����
	 * 
	 * @param id
	 * @return
	 */
	public Content getContentById(int id);

	/**
	 * ����ָ��ҳ��������ҳ��Ĭ�Ϸ��ص�һҳ
	 * 
	 * @param pn
	 * @return
	 */
	public PageInfo list(Integer pn);
	// ��������������صķ�����ǰ̨����Ҫ�õ���

	/**
	 * ��������
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	public Map<String, Object> add(Content model, HttpServletRequest request);

	/**
	 * ������������
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	public Map<String, Object> addType(ContentType model, HttpServletRequest request);

	/**
	 * ����ָ��ҳ��������������Ϣ��Ĭ�Ϸ��ص�һҳ
	 * 
	 * @param pn
	 * @return
	 */
	public PageInfo typelist(Integer pn);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> delete(String id);

	/**
	 * �༭����
	 * 
	 * @param content
	 * @return
	 */
	public Map<String, Object> edit(Content content);
}
