package org.world.origin.cache;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.world.origin.OriginApplicationTests;
import org.world.origin.cache.DemoCache;
import org.world.origin.domain.PageData;

import com.alibaba.fastjson.JSON;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description:
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年12月7日
 * *********************************************
 * </pre>
 */
public class DemoCacheTest extends OriginApplicationTests {

	@Autowired
	private DemoCache demoCache;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Test
	public void testGetDemo() {
		
		Collection<String> cache1 = cacheManager.getCacheNames();
		System.out.println("+++++cache1:" + JSON.toJSONString(cache1));
		
		PageData pd1 = demoCache.getDemo(5);
		System.out.println("pd1:" + pd1);
		PageData pd2 = demoCache.getDemo(5);
		System.out.println("pd2:" + pd2);
		
		//PageData pd4 = demoCache.getDemoPut(6, "helloworld");
		//System.out.println("pd4:" + pd4);
		
		System.out.println("---------------");
		Cache cache = cacheManager.getCache("demo");
		System.out.println("pd3:" + JSON.toJSONString(cache));
		
		//PageData pd4 = demoCache.getDemoPut(6);
		//System.out.println("pd4:" + pd4);
	}

}
