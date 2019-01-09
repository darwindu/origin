package org.world.origin.util;

import org.world.origin.domain.PageData;
import org.world.origin.enums.ResultEnum;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月18日
 * *********************************************
 * </pre>
 */
public class ResultUtil {
	
	public static PageData success() {
        return success(null);
    }
	
	public static PageData success(Object object) {
		
		PageData pd = new PageData();
		pd.put(ConstResult.RESULT_CODE, ResultEnum.SUCCESS.getCode());
		pd.put(ConstResult.RESULT_MSG, ResultEnum.SUCCESS.getMsg());
		pd.put(ConstResult.RESULT_DATA, object);
        return pd;
    }

    public static PageData error(String msg, Integer code) {
    	
    	PageData pd = new PageData();
    	pd.put(ConstResult.RESULT_CODE, code);
		pd.put(ConstResult.RESULT_MSG, msg);
        return pd;
    }
}
