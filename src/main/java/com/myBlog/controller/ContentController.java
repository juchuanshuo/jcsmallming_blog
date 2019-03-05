package com.myBlog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myBlog.Dao.ContentMapper;
import com.myBlog.Dao.ContentTypeMapper;
import com.myBlog.Dao.SequenceMapper;
import com.myBlog.Dao.TypeSequenceMapper;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;
import com.myBlog.service.ContentService;

/**
 * @author jcs
 * @date 2019年3月5日-下午4:00:34
 */

@Controller
@RequestMapping(value = "/content")
public class ContentController {

	@Resource
	ContentService contentService;

	/**
	 * 返回文章主体页面，附带的id是用来查文章的
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getPage(@RequestParam("id") int id) {
		return new ModelAndView("blog/blog");
	}

	/**
	 * 通过id查找实际的文章
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getContent/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Content getById(@PathVariable("id") int id) {
		Content result = contentService.getContentById(id);
		return result;
	}

	/**
	 * 返回指定页数的文章页，默认返回第一页
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo list(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageInfo page = contentService.list(pn);
		return page;
	}
	// 以上三个文章相关的方法是前台后都需要用到的

	/**
	 * 新增文章
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> add(Content model, HttpServletRequest request) {
		Map<String, Object> s = contentService.add(model, request);
		return s;
	}

	/**
	 * 新增文章类型
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addType(ContentType model, HttpServletRequest request) {
		Map<String, Object> s = contentService.addType(model, request);
		return s;
	}

	/**
	 * 返回指定页数的文章类型信息，默认返回第一页
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping(value = "/typeList", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo typelist(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageInfo page = contentService.typelist(pn);
		return page;
	}

	/**
	 * 删除文章
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") String id) {
		Map<String, Object> result = contentService.delete(id);
		return result;
	}

	/**
	 * 编辑文章
	 * 
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/edit/{contentId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> edit(Content content) {
		Map<String, Object> result = contentService.edit(content);
		return result;
	}

}
