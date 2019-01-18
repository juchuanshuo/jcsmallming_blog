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

/**
 * ÓÃ»§¿ØÖÆÆ÷
 */
@Controller
@RequestMapping(value = "/count")
public class CountController {
	@Resource
	private ContentMapper contentDao;

	@ResponseBody
	@RequestMapping("/content")
	public String countContent(@RequestParam(value = "contentId", defaultValue = "1") String contentId,
			HttpSession session) throws Exception {
		if ("".equals(contentId) || contentId == null) {
			return null;
		}
		if (session.getAttribute("content") != null) {
			List<String> content = (List<String>) session.getAttribute("content");
			if (content.contains(contentId)) {
				return null;
			} else {
				contentDao.updateCount(contentId);
				content.add(contentId);
			}
		} else {
			contentDao.updateCount(contentId);
			List<String> content = new ArrayList<>();
			content.add(contentId);
			session.setAttribute("content", content);
		}
		return null;
	}

}