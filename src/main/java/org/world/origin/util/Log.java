package org.world.origin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 日志
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月25日
 * *********************************************
 * </pre>
 */
public class Log {

	
	/**日志打印前缀: #########code:{}::msg:{}{}**/
	public final static String TEMPLATE_PRE = "#########code:{}::msg:{}{}";
	
	/**
	 * 获得Logger
	 * @param clazz 日志发出的类
	 * @return Logger
	 */
	public static Logger get(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	/**
	 * 获得Logger
	 * @param name 自定义的日志发出者名称
	 * @return Logger
	 */
	public static Logger get(String name) {
		return LoggerFactory.getLogger(name);
	}

	/**
	 * @return 获得日志，自动判定日志发出者
	 */
	public static Logger get() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return LoggerFactory.getLogger(stackTrace[2].getClassName());
	}

}
