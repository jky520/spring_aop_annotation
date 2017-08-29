package com.hx.spring.log;

import java.util.Date;

public class Logger {

	public static void info(String info) {
		// 日志得添加日期和所在行等等信息
		System.out.println(new Date() + "------------>" + info);
	}
}
