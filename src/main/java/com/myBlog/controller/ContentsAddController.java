package com.myBlog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myBlog.Dao.ContentMapper;
import com.myBlog.Dao.ContentTypeMapper;
import com.myBlog.Dao.SequenceMapper;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;

@Controller
@RequestMapping(value = "/add", method = RequestMethod.GET)
public class ContentsAddController {

	@Resource
	private ContentMapper contentMapper;
	@Resource
	private ContentTypeMapper contentTypeMapper;
	@Resource
	private SequenceMapper sequenceMapper;

	@RequestMapping()
	@ResponseBody
	public Map<String, Object> add(Content model, HttpServletRequest request) {
		Map<String, Object> s = new HashMap<String, Object>();
		model.setContentId(sequenceMapper.getNowId());
		model.setCreateTime(new Date());
		model.setAuthor("ะกร๗");
		model.setContenState(1);
		if (contentMapper.insert(model) > 0) {
			s.put("result", "SUCCESS");
		} else {
			s.put("result", "FAlIUE");
		}
		return s;
	}
	@RequestMapping(value = "/addType", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addType(ContentType model, HttpServletRequest request) {
		Map<String, Object> s = new HashMap<String, Object>();
		if (contentTypeMapper.insert(model) > 0) {
			s.put("result", "SUCCESS");
		} else {
			s.put("result", "FAlIUE");
		}
		return s;
	}
}
