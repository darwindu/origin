package org.world.origin.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 整数类型公用类
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年9月8日
 * *********************************************
 * </pre>
 */
public class JavaLongUtil {

	private static final Logger log = Log.get();
	
	/**
	 * 字符串转换整数
	 * @date 2017年9月8日
	 * @author darwin du
	 * @param s
	 * @return
	 */
	public static Integer strToInt(String s) {
		
		Integer i = -1;
		if(StringUtils.isBlank(s)) {
			return i;
		}
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
			log.error("+++++++++字符串转换整数异常", e);
		}
		return i;
	}
	
	/**
	 * 字符串转换整数
	 * @date 2017年9月8日
	 * @author darwin du
	 * @param s
	 * @return
	 */
	public static Long strToLong(String s) {
		
		Long i = -1L;
		if(StringUtils.isBlank(s)) {
			return i;
		}
		try {
			i = Long.valueOf(s);
		} catch (NumberFormatException e) {
			log.error("+++++++++字符串转换整数异常", e);
		}
		return i;
	}
	
	public static void main(String[] args) {
		String s = "1.1";
		System.out.println(strToLong(s));
	}
}
