package org.world.origin.service.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.world.origin.OriginApplicationTests;
import org.world.origin.domain.PageData;
import org.world.origin.service.demo.Demo1Service;
import org.world.origin.service.demo.DemoService;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年11月22日
 * *********************************************
 * </pre>
 */
public class DemoServiceTest extends OriginApplicationTests {

	@Autowired
	private DemoService demoService;
	
	@Autowired
	private Demo1Service demo1Service;
	
	@Test
	public void test() {
	
		PageData demo = new PageData();
		demo.put("id", "2");
		demo.put("key", "2");
		demo.put("value", "b");
		
		PageData demo1 = new PageData();
		demo1.put("id", "2");
		demo1.put("key", "2");
		demo1.put("value", "b");
		
		PageData updateDemo = new PageData();
		updateDemo.put("id", "6");
		updateDemo.put("key", "1");
		updateDemo.put("value", "b");
		
		//demoService.saveBiz(demo, demo1, updateDemo);
		//demoService.save1Biz(demo, demo1, updateDemo);
		
		//保存demo demo1
		//demoService.saveDemo12(demo, demo1);
		//更新demo
		//demoService.updateDemo(updateDemo);
		
		this.save1Biz(demo, demo1, updateDemo);
	}
	
	public void save1Biz(PageData demo, PageData demo1, PageData updateDemo) {
		//保存demo demo1
		demoService.saveDemo12(demo, demo1);
		//更新demo
		demoService.updateDemo(updateDemo);
	}

}
