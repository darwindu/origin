package org.world.origin.dao;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年9月15日
 * *********************************************
 * </pre>
 */
public interface IDbHandler {

	
	/**
	 * 执行sql
	 * @date 2017年9月15日
	 * @author darwin du
	 * @param str 调取mybatis配置文件
	 * @param obj 输入参数
	 * @return
	 */
	int executeSql(String str, Object obj);
}
