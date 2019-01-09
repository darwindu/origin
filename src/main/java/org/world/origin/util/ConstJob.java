package org.world.origin.util;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 定时任务常量
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月24日
 * *********************************************
 * </pre>
 */
public class ConstJob {

	/**支付结果通知失败重发：JOB_RESEND_PAY_FAIL**/
	public final static String JOB_RESEND_PAY_FAIL = "JOB_RESEND_PAY_FAIL";
	
	/**清算通知给ALS重发：JOB_RESEND_PAY_CLEARING_TO_ALS**/
	public final static String JOB_RESEND_PAY_CLEARING_TO_ALS = "JOB_RESEND_PAY_CLEARING_TO_ALS";
	
	/**发起场切：JOB_RECON**/
	public final static String JOB_RECON = "JOB_RECON";
}
