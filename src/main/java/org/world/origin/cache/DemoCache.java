package org.world.origin.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.world.origin.domain.PageData;
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
 *  1      Create   	 darwin du       2017年12月7日
 * *********************************************
 * </pre>
 */
@Component
public class DemoCache {
	
	public final static String CACHE_NAME = "demo";

	@Autowired
	private DemoService demoService;
	
	private Map<Integer, Object> demoMap;
	
	@PostConstruct
	public void init(){
		
		List<PageData> list = demoService.findList();
		if(list != null && list.size() > 0) {
			
			demoMap = new HashMap<Integer, Object>();
			for(PageData pd : list) {
				demoMap.put(Integer.valueOf(pd.getString("id")), pd);
			}
		}
		System.out.println("########cache：" + demoMap);
	}
	
	@Cacheable(value=CACHE_NAME)
	public PageData getDemo(Integer id) {
		System.out.println("hello:" + id);
		this.init();
		return (PageData) demoMap.get(id);
	}
	
	@CachePut
	public PageData getDemoPut(Integer id, String username) {
		System.out.println("helloPut:" + id);
		return (PageData) demoMap.get(id);
	}
	
	@CacheEvict
	public void remove(Integer id) {
		demoMap.remove(id);
	}
	
	
}
