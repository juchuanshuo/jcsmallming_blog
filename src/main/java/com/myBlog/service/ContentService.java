package com.myBlog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;

/**
 * @author jcs
 * @date 2019年3月5日-下午4:01:27
 */
public interface ContentService {

	/**
	 * 通过id查找实际的文章
	 * 
	 * @param id
	 * @return
	 */
	public Content getContentById(int id);

	/**
	 * 返回指定页数的文章页，默认返回第一页
	 * 
	 * @param pn
	 * @return
	 */
	public PageInfo list(Integer pn);
	// 以上三个文章相关的方法是前台后都需要用到的

	/**
	 * 新增文章
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	public Map<String, Object> add(Content model, HttpServletRequest request);

	/**
	 * 新增文章类型
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	public Map<String, Object> addType(ContentType model, HttpServletRequest request);

	/**
	 * 返回指定页数的文章类型信息，默认返回第一页
	 * 
	 * @param pn
	 * @return
	 */
	public PageInfo typelist(Integer pn);

	/**
	 * 删除文章
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> delete(String id);

	/**
	 * 编辑文章
	 * 
	 * @param content
	 * @return
	 */
	public Map<String, Object> edit(Content content);
}
