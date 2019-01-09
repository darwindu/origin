package org.world.origin.service.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.world.origin.dao.BizDaoSupport;
import org.world.origin.domain.PageData;
import org.world.origin.exception.BizException;
import org.world.origin.exception.DaoException;

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
public class DemoService {

	@Autowired
	private BizDaoSupport bizDaoSupport;
	
	@Autowired
	private Demo1Service demo1Service;
	
	@Autowired
	private DemoService demoService;
	
	/**
	 * 回滚事务和不回滚事务[rollbackFor, noRollbackFor]
	 * @date 2017年11月22日
	 * @author darwin du
	 * @param demo 非事务方法调用事务方法的时候，没用用代理话，事务是失效；
	 * @param demo1
	 * @param updateDemo
	 */
	//@Transactional(noRollbackFor = DaoException.class)
	public void saveBiz(PageData demo, PageData demo1, PageData updateDemo) {
		
		//保存demo demo1
		demoService.saveDemo12(demo, demo1);
		//更新demo
		demoService.updateDemo(updateDemo);
	}
	
	public void save1Biz(PageData demo, PageData demo1, PageData updateDemo) {
		//保存demo demo1
		demoService.saveDemo12(demo, demo1);
		//更新demo
		this.updateDemo(updateDemo);
	}
	
	@Transactional
	public void saveDemo12(PageData demo, PageData demo1) {
		
		//保存demo
		PageData pdResult = this.save(demo);
		Integer code = (Integer) pdResult.get("code");
		System.out.println("++++code=" + code);
		if(code != 0) {
			throw new BizException("保存数据异常");
		}
		
		//保存demo1
		PageData pdResult1 = demo1Service.save(demo1);
		Integer code1 = (Integer) pdResult1.get("code");
		System.out.println("++++code1=" + code1);
		if(code1 != 0) {
			throw new BizException("保存数据异常");
		}
	}
	
	@Transactional
	public void updateDemo(PageData updateDemo) {
		//更新demo
		PageData pdUpdate = this.update(updateDemo);
		Integer updateCode = (Integer) pdUpdate.get("code");
		System.out.println("++++updateCode=" + updateCode);
		if(updateCode != 0) {
			throw new DaoException("更新数据异常");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PageData> findList() {
		return (List<PageData>) bizDaoSupport.bizFindForList("DemoMapper.findList", null);
	}
	
	public PageData find(PageData pd) {
		return (PageData) bizDaoSupport.bizFindForObject("DemoMapper.find", pd);
	}
	
	@Transactional
	public PageData update(PageData pd) {
    	return (PageData) bizDaoSupport.bizUpdate("DemoMapper.update", pd);
	}
	
	@Transactional
	public PageData save(PageData pd) {
    	return (PageData) bizDaoSupport.bizSave("DemoMapper.save", pd);
	}
}
