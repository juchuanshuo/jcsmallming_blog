package com.myBlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class TestController {
	@RequestMapping
	@ResponseBody
	public Map<String, Object> add() {
		Map<String,Object> s  =new HashMap<String, Object>();
		s.put("1","2");
		return s;
	}
}
