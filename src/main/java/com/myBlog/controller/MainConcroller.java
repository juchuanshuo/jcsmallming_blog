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
@RequestMapping(value = "/getContentList", method = RequestMethod.POST)
public class MainConcroller {

	@Resource
	private ContentMapper contentMapper;
	@Resource
	private SequenceMapper sequenceMapper;
	@Resource
	private ContentTypeMapper contentTypeMapper;

	@RequestMapping()
	@ResponseBody
	public PageInfo mainList() {
		PageHelper.startPage(1, 5);
		List<Content> content = contentMapper.getAll();
		String date;
		for (int i = 0; i < content.size(); i++) {
			date = content.get(i).getCreateTime().toLocaleString();
			content.get(i).setDate(date);
		}
		PageInfo page = new PageInfo(content, 5);
		return page;
	}
}
