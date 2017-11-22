package com.myBlog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myBlog.Dao.GenderMapper;
import com.myBlog.Dao.UserMapper;
import com.myBlog.domain.Gender;
import com.myBlog.domain.User;

/**
 * 管理员控制器
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Resource
    private UserMapper userDao;

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
    
    
    @RequestMapping("/article_add")
    public ModelAndView article_add() {
        return new ModelAndView("content/article-add");
    }
    
    @RequestMapping("/article_edit")
    public ModelAndView article_edit() {
        return new ModelAndView("content/article-edit");
    }
    
    @RequestMapping(value="/login",method = RequestMethod.POST)  
    public ModelAndView login(User model,HttpSession session) {  
    	User user = userDao.findByUserName(model.getUserName(),model.getPassWord());
        if(user!=null){  
            session.setAttribute("user",user);  
            return new ModelAndView("redirect:/admin/indexview");            
        }  
        //request.setAttribute("error", "用户名或密码错误");  
        return new ModelAndView("login/login"); 
    }  
}