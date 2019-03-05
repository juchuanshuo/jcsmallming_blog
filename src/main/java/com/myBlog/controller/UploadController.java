package com.myBlog.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myBlog.util.UploadUtil;

/**
 * ÉÏ´«¿ØÖÆÆ÷
 */
@Controller

public class UploadController {

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
		return UploadUtil.upload(file, request);
	}

}