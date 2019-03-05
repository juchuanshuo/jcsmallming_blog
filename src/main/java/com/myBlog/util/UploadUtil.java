package com.myBlog.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author jcs
 * @date 2019年3月5日-下午3:57:44
 */
public class UploadUtil {
	public static String upload(MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// 定义文件保存的本地路径
		String localPath = request.getServletContext().getRealPath("/") + "resource" + File.separator + "tiniImg"
				+ File.separator + "";
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
	}
}
