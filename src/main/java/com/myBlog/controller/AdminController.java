package com.myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jcs
 * 
 *         后台主控制器,负责分发后台页面
 */
@Controller
@RequestMapping(value = "/admin_for_jcs")
public class AdminController {
	@RequestMapping
	public String view() {
		return "login/login";
	}

	@RequestMapping("/indexview")
	public String index() {
		return "dashboard/index";
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("dashboard/welcome");
	}

	@RequestMapping("/article_list")
	public ModelAndView addList() {
		return new ModelAndView("content/list");
	}

	@RequestMapping("/type_list")
	public ModelAndView typeList() {
		return new ModelAndView("type/list");
	}

	@RequestMapping("/article_add")
	public ModelAndView article_add() {
		return new ModelAndView("content/article-add");
	}

	@RequestMapping("/type_add")
	public ModelAndView type_add() {
		return new ModelAndView("type/type-add");
	}

	@RequestMapping("/article_edit")
	public ModelAndView article_edit() {
		return new ModelAndView("content/article-edit");
	}
}