package com.myBlog.service;

import javax.servlet.http.HttpSession;

/** 
* @author jcs
* @date 2019年3月5日-下午5:17:03
*/
public interface CountService {
	public void countContent(String contentId, HttpSession session) throws Exception;
}
