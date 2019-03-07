package com.myBlog.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author jcs
 * @date 2019年3月7日-上午10:51:30
 */
public class InfoUtil {
	public static Map<String, Object> getRunTime() throws IOException, ParseException {
		Map<String, Object> result = new HashMap<>();
		InputStream in = InfoUtil.class.getClassLoader().getResourceAsStream("blog.properties");
		Properties prop = new Properties();
		prop.load(in);
		String time = prop.getProperty("startTime");
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dateNow = new Date();
		long between = dateNow.getTime() - simpleFormat.parse(time).getTime();

		int days = (int) (between / (1000 * 60 * 60 * 24));
		long exceptDay = between % (1000 * 60 * 60 * 24);
		int hours = (int) (exceptDay / (1000 * 60 * 60));
		long exceptHour = exceptDay % (1000 * 60 * 60);
		int minutes = (int) (exceptHour / (1000 * 60));
		long exceptMinutes = exceptHour % (1000 * 60);
		int seconds = (int) (exceptMinutes / 1000);
		in.close();
		result.put("days", days);
		result.put("hours", hours);
		result.put("minutes", minutes);
		result.put("seconds", seconds);
		return result;
	}
}
