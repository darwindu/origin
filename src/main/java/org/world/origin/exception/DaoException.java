package org.world.origin.exception;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月17日
 * *********************************************
 * </pre>
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable cause) {
		super(message,cause);
	}

}
