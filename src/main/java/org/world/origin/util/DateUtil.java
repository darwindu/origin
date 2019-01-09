package org.world.origin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 日期工具类
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月25日
 * *********************************************
 * </pre>
 */
public class DateUtil {

	
	/**日期格式：yyyy-MM-dd HH:mm:ss**/
	public final static String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	
	/**日期格式：yyyyMMddHHmmss**/
	public final static String YMDHMS_SIMPLE = "yyyyMMddHHmmss";
	
	/**日期格式：yyyyMMdd**/
	public final static String YMD_SIMPLE = "yyyyMMdd";
	
	/**日期格式：yyMMdd**/
	public final static String YMD_SIMPLE_0 = "yyMMdd";
	
	/**
	 * 获取当前时间
	 * @date 2017年7月25日
	 * @author darwin du
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}
	
	/**
	 * 通过时间戳获取指定时间
	 * @date 2017年7月25日
	 * @author darwin du
	 * @param time
	 * @return
	 */
	public static Date getAppointDate(long time) {
		return new Date(time);
	}
	
	/**
	 * 日期转换字符串
	 * @date 2017年8月1日
	 * @author darwin du
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		if(date == null || StringUtils.isBlank(format)) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 获取与当前时间的时间差
	 * @date 2017年9月13日
	 * @author darwin du
	 * @param beginTime 开始时间 单位：毫秒
	 * @return
	 */
	public static long getDiffTimes(long beginTime) {
		return System.currentTimeMillis() - beginTime;
	}
	
}
