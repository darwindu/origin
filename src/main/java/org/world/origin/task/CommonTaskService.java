package org.world.origin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.world.origin.domain.PageData;
import org.world.origin.service.global.GlobalJobService;
import org.world.origin.util.DateUtil;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月24日
 * *********************************************
 * </pre>
 */
@Service
public class CommonTaskService {

	@Autowired
	private GlobalJobService globalJobService;
	
	@Transactional
	public PageData update(String jobCode) {
		
		PageData pd = new PageData();
		pd.put("currInterval", System.currentTimeMillis());
		pd.put("preStartDt", DateUtil.getCurrentDate());
		pd.put("jobCode", jobCode);
		
		return globalJobService.update(pd);
	}
}
