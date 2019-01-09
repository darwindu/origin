package org.world.origin.service.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.world.origin.dao.BizDaoSupport;
import org.world.origin.domain.PageData;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年8月11日
 * *********************************************
 * </pre>
 */
@Service
public class GlobalJobService {

	@Autowired
	private BizDaoSupport bizDaoSupport;
	
	/**
	 * 抢占资源逻辑：当前时间-上次执行时间>时间间隔，如果更新成功，则抢占资源；否则抢占失败;
	 * @date 2017年7月24日
	 * @author darwin du
	 * @param currInterval 当前时间戳
	 * @param preStartDt 当前时间
	 * @param jobCode 定时任务code
	 * @return
	 */
	@Transactional
	public PageData update(PageData pd) {
    	return (PageData) bizDaoSupport.bizUpdate("GlobalJobMapper.update", pd);
	}
}
