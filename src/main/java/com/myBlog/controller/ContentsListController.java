package com.myBlog.controller;

import java.util.ArrayList;
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
import com.myBlog.Dao.ContentMapper;
import com.myBlog.Dao.ContentTypeMapper;
import com.myBlog.Dao.SequenceMapper;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;

@Controller
@RequestMapping(value = "/list", method = RequestMethod.POST)
public class ContentsListController {

	@Resource
	private ContentMapper contentMapper;
	@Resource
	private SequenceMapper sequenceMapper;
	@Resource
	private ContentTypeMapper contentTypeMapper;

	@RequestMapping()
	@ResponseBody
	public PageInfo list(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Content> content = contentMapper.getAll();
		String date;
		for (int i = 0; i < content.size(); i++) {
			date = content.get(i).getCreateTime().toLocaleString();
			content.get(i).setDate(date);
		}
		;
		PageInfo page = new PageInfo(content, 5);
		return page;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo mainList() {
		PageHelper.startPage(1, 5);
		List<Content> content = contentMapper.getAll();
		String date;
		for (int i = 0; i < content.size(); i++) {
			date = content.get(i).getCreateTime().toLocaleString();
			content.get(i).setDate(date);
		}
		;
		PageInfo page = new PageInfo(content, 5);
		return page;
	}
	
	@RequestMapping(value = "/type", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<ContentType> getType() {
		Map<String, Object> type = new HashMap<String, Object>();
		List<ContentType> list = contentTypeMapper.selectAll();
		ArrayList<ContentType> al = new ArrayList<ContentType>();
		for (ContentType li : list) {
			al.add(li);
		}
		return al;
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getPage(@RequestParam("id") int id) {
		return new ModelAndView("blog/blog");
	}
	
	@RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Content getById(@PathVariable("id") int id) {
		String date;
		Content result = contentMapper.selectByPrimaryKey(id);
		date = result.getCreateTime().toLocaleString();
		result.setDate(date);
		return result;
	}

	@RequestMapping(value = "/getContent/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Content getContent(@PathVariable("id") int id) {
		String date;
		Content result = contentMapper.selectByPrimaryKey(id);
		date = result.getCreateTime().toLocaleString();
		result.setDate(date);
		return result;
	}
	
	@RequestMapping(value = "/edit/{contentId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> edit(Content content) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = contentMapper.updateByPrimaryKeySelective(content);
		result.put("re", a);
		return result;
	}
}
