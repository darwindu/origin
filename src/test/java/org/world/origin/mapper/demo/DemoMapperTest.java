package org.world.origin.mapper.demo;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.world.origin.OriginApplicationTests;
import org.world.origin.domain.PageData;
import org.world.origin.mapper.demo.DemoMapper;

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
public class DemoMapperTest extends OriginApplicationTests {

	@Autowired
	private DemoMapper demoMapper;
	
	@Test
	public void test() {
		List<PageData> list = demoMapper.find("1");
		System.out.println(list);
	}
	

}
