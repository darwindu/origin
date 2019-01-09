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
public abstract class DbHandler implements IDbHandler {

	@Override
	public abstract int executeSql(String str, Object obj);

}
