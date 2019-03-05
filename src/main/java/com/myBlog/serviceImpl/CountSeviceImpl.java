package com.myBlog.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.myBlog.Dao.ContentMapper;
import com.myBlog.service.CountService;

/**
 * @author jcs
 * @date 2019年3月5日-下午5:17:58
 */
@Service
public class CountSeviceImpl implements CountService {
	@Resource
	private ContentMapper contentDao;

	public void countContent(String contentId, HttpSession session) throws Exception {
		if ("".equals(contentId) || contentId == null) {
			return;
		}
		if (session.getAttribute("content") != null) {
			List<String> content = (List<String>) session.getAttribute("content");
			if (content.contains(contentId)) {
				return;
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
		return;
	}
}
