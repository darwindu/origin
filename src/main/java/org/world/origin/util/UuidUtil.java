package org.world.origin.util;

import java.util.UUID;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: UUID公用方法
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年8月3日
 * *********************************************
 * </pre>
 */
public class UuidUtil {

	/**
	 * 生成UUID
	 * @date 2017年8月6日
	 * @author darwin du
	 * @return
	 */
	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid.replaceAll("-", ""));
		System.out.println(uuid.replace("-", ""));
	}
}

