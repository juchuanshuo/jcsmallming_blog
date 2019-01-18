package com.myBlog.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传控制器
 */
@Controller

public class UploadController {

	@RequestMapping("/upload")
	@ResponseBody
	public String test(MultipartFile file, HttpServletRequest request) throws IOException {
		// 保存数据库的路径
		// 定义文件保存的本地路径
		String localPath = request.getServletContext().getRealPath("/") + "resource" + File.separator + "tiniImg"
				+ File.separator + "";
		;
		// 定义 文件名
		String filename = new Date().getTime() + "";
		// 获得文件类型（可以判断如果不是图片，禁止上传）
		String contentType = file.getContentType();
		// 获得文件后缀名
		String suffixName = contentType.substring(contentType.indexOf("/") + 1);
		// 得到 文件名
		filename = filename + "." + suffixName;
		System.out.println(filename);
		File f = new File(localPath + filename);
		System.out.println(f.getAbsolutePath());
		// 文件保存路径
		file.transferTo(new File(localPath + filename));
		return "/resource/tiniImg/" + filename;
		/*
		 * System.out.println("comming!"); String path = ""+Dir.path+"";
		 * System.out.println("path>>" + path); String fileName =
		 * file.getOriginalFilename(); System.out.println("fileName>>" +
		 * fileName); File dir = new File(path, fileName);
		 * System.out.println("dir.exists()>>" + dir.exists()); if
		 * (!dir.exists()) { dir.mkdirs(); } System.out.println("dir.exists()>>"
		 * + dir.exists()); // MultipartFile自带的解析方法 file.transferTo(dir); return
		 * fileName;
		 */
	}

}