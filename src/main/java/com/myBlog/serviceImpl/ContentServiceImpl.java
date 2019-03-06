package com.myBlog.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
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
import com.myBlog.Dao.TypeSequenceMapper;
import com.myBlog.domain.Content;
import com.myBlog.domain.ContentType;
import com.myBlog.service.ContentService;

/**
 * @author jcs
 * @date 2019年3月5日-下午4:01:53
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {
	@Resource
	private ContentMapper contentMapper;
	@Resource
	private ContentTypeMapper contentTypeMapper;
	@Resource
	private SequenceMapper sequenceMapper;
	@Resource
	private TypeSequenceMapper typeSequenceMapper;

	public Content getContentById(int id) {
		String date;
		Content result = contentMapper.selectByPrimaryKey(id);
		date = result.getCreateTime().toLocaleString();
		result.setDate(date);
		ContentType type = contentTypeMapper.selectByPrimaryKey(result.getContentType());
		result.setTypeName(type.getTypeName());
		return result;
	}

	public PageInfo list(Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Content> content = contentMapper.getAll();
		String date;
		for (int i = 0; i < content.size(); i++) {
			date = content.get(i).getCreateTime().toLocaleString();
			content.get(i).setDate(date);
		}
		PageInfo page = new PageInfo(content, 5);
		return page;
	}

	public Map<String, Object> add(Content model, HttpServletRequest request) {
		Map<String, Object> s = new HashMap<String, Object>();
		model.setContentId(sequenceMapper.getNowId());
		model.setCreateTime(new Date());
		model.setAuthor("小明");
		model.setPageviews(0);
		model.setContenState(1);
		if (contentMapper.insert(model) > 0) {
			s.put("result", "SUCCESS");
		} else {
			s.put("result", "FAlIUE");
		}
		return s;
	}

	public Map<String, Object> addType(ContentType model, HttpServletRequest request) {
		Map<String, Object> s = new HashMap<String, Object>();
		model.setContentType(typeSequenceMapper.getNowId());
		if (contentTypeMapper.insert(model) > 0) {
			s.put("result", "SUCCESS");
		} else {
			s.put("result", "FAlIUE");
		}
		return s;
	}

	public PageInfo typelist(Integer pn) {
		PageHelper.startPage(pn, 5);
		List<ContentType> contentType = contentTypeMapper.selectAll();
		PageInfo page = new PageInfo(contentType, 5);
		return page;
	}

	public Map<String, Object> delete(String id) {
		int count = contentMapper.deleteById(id);
		Map<String, Object> result = new HashMap<String, Object>();
		if (count != 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}

	public Map<String, Object> edit(Content content) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = contentMapper.updateByPrimaryKeySelective(content);
		if (a > 0) {
			result.put("re", "修改成功");
		} else {
			result.put("re", "修改失败");
		}
		return result;
	}

	@Override
	public Map<String, Object> getNear(Integer id) {
		// TODO Auto-generated method stub
		Content last = contentMapper.selectLast(id);
		Content next = contentMapper.selectNext(id);
		Map<String, Object> result = new HashMap<>();
		result.put("last", last);
		result.put("next", next);
		return result;
	}
}
