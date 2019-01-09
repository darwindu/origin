package org.world.origin.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 异常常量
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年8月2日
 * *********************************************
 * </pre>
 */
public class ConstDb {
	
	/**调用mybatis时，为了支持日志的输出，为mapper增加一个【origin.】路径的前缀**/
	public final static String NAMESPACE_PRE = "origin.";

	/**添加操作**/
	public final static String SAVE = "save";
	/**修改操作**/
	public final static String UPDATE = "update";
	/**删除操作**/
	public final static String DELETE = "delete";
	
	
	
	
	/**pay_trans_record表索引:{"ind_ptr_oa_1", "ind_ptr_bf_2"}**/
	//public static final String[] TABLE_PTR_INDEX = {"ind_ptr_oa_1", "ind_ptr_bf_2"};
	/**索引map配置**/
	public static final Map<String, Object> TABLE_INDEX_MAP = new HashMap<String, Object>();
	static {
		//TABLE_INDEX_MAP.put(TABLE_PTR_INDEX[0], new String[] {PayErrorEnum.ERROR_EXIST_INDEX_ORDER_ID.getCode().toString(), PayErrorEnum.ERROR_EXIST_INDEX_ORDER_ID.getMsg().toString()});
		//TABLE_INDEX_MAP.put(TABLE_PTR_INDEX[1], new String[] {PayErrorEnum.ERROR_EXIST_INDEX_TRANSACTION.getCode().toString(), PayErrorEnum.ERROR_EXIST_INDEX_TRANSACTION.getMsg().toString()});
	}
}
