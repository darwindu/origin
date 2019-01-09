package org.world.origin.util;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 日志告警变量: 系统都默认以OnCritical、OnError、OnWarning作为告警关键字，分别对应IMS的Critical、Major、Warning告警级别。由开发自行区别异常对应的告警级别后输出到日志中
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年8月25日
 * *********************************************
 * </pre>
 */
public class ConstLogWarning {
	
	/**前缀**/
	private final static String PRE = "::keyword:";
	
	/**后缀**/
	private final static String SUF = "::";
	
	
	/**严重：关键字【OnCritical】:映射【Critical】**/
	public final static String ON_CRITICAL = "OnCritical";
	
	/**错误：：关键字【OnError】:映射【Major】**/
	public final static String ON_ERROR = "OnError";
	
	/**警告：：关键字【OnWarning】:映射【Warning】**/
	public final static String ON_WARNING = "OnWarning";
	
	
	
	/**模板：严重：关键字【OnCritical】:映射【Critical】**/
	public final static String ON_CRITICAL_TEMPLATE = PRE + ON_CRITICAL + SUF;
	
	/**模板：错误：：关键字【OnError】:映射【Major】**/
	public final static String ON_ERROR_TEMPLATE = PRE + ON_ERROR + SUF;
	
	/**模板：警告：：关键字【OnWarning】:映射【Warning】**/
	public final static String ON_WARNING_TEMPLATE = PRE + ON_WARNING + SUF;


}
