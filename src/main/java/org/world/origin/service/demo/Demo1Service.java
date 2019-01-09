package org.world.origin.service.demo;

import java.util.List;

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
public class Demo1Service {

	@Autowired
	private BizDaoSupport bizDaoSupport;
	
	
	public PageData find(PageData pd) {
		return (PageData) bizDaoSupport.bizFindForObject("Demo1Mapper.find", pd);
	}
	
	@SuppressWarnings("unchecked")
	public List<PageData> findList() {
		return (List<PageData>) bizDaoSupport.bizFindForList("Demo1Mapper.findList", null);
	}
	
	@Transactional
	public PageData update(PageData pd) {
    	return (PageData) bizDaoSupport.bizUpdate("Demo1Mapper.update", pd);
	}
	
	@Transactional
	public PageData save(PageData pd) {
    	return (PageData) bizDaoSupport.bizSave("Demo1Mapper.save", pd);
	}
}
