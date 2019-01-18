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
 * �ϴ�������
 */
@Controller

public class UploadController {

	@RequestMapping("/upload")
	@ResponseBody
	public String test(MultipartFile file, HttpServletRequest request) throws IOException {
		// �������ݿ��·��
		// �����ļ�����ı���·��
		String localPath = request.getServletContext().getRealPath("/") + "resource" + File.separator + "tiniImg"
				+ File.separator + "";
		;
		// ���� �ļ���
		String filename = new Date().getTime() + "";
		// ����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���
		String contentType = file.getContentType();
		// ����ļ���׺��
		String suffixName = contentType.substring(contentType.indexOf("/") + 1);
		// �õ� �ļ���
		filename = filename + "." + suffixName;
		System.out.println(filename);
		File f = new File(localPath + filename);
		System.out.println(f.getAbsolutePath());
		// �ļ�����·��
		file.transferTo(new File(localPath + filename));
		return "/resource/tiniImg/" + filename;
		/*
		 * System.out.println("comming!"); String path = ""+Dir.path+"";
		 * System.out.println("path>>" + path); String fileName =
		 * file.getOriginalFilename(); System.out.println("fileName>>" +
		 * fileName); File dir = new File(path, fileName);
		 * System.out.println("dir.exists()>>" + dir.exists()); if
		 * (!dir.exists()) { dir.mkdirs(); } System.out.println("dir.exists()>>"
		 * + dir.exists()); // MultipartFile�Դ��Ľ������� file.transferTo(dir); return
		 * fileName;
		 */
	}

}