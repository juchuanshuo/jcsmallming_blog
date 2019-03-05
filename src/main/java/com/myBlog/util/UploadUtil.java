package com.myBlog.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author jcs
 * @date 2019��3��5��-����3:57:44
 */
public class UploadUtil {
	public static String upload(MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// �����ļ�����ı���·��
		String localPath = request.getServletContext().getRealPath("/") + "resource" + File.separator + "tiniImg"
				+ File.separator + "";
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
	}
}
