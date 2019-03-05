package com.myBlog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myBlog.Dao.ContentMapper;
import com.myBlog.service.CountService;

/**
 * @author jcs
 *
 *         ÎÄÕÂÔÄ¶ÁÊý¼ÇÂ¼
 */
@Controller
@RequestMapping(value = "/count")
public class CountController {
	@Resource
	private CountService countService;

	@ResponseBody
	@RequestMapping("/content")
	public String countContent(@RequestParam(value = "contentId", defaultValue = "1") String contentId,
			HttpSession session) throws Exception {
		countService.countContent(contentId, session);
		return null;
	}

}