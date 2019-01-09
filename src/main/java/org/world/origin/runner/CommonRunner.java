package org.world.origin.runner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.world.origin.util.Log;
/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 使用SDK发送消息，注册客户端
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年8月11日
 * *********************************************
 * </pre>
 */
@Component
public class CommonRunner implements CommandLineRunner {

	private static final Logger log = Log.get();
	
	@Autowired
    private CacheManager cacheManager;

	
	@Override
	public void run(String... args) throws Exception {
		
		log.info("++++++++++runner start");
        log.info("++++++++++using cache manager: " + cacheManager.getClass().getName());
		log.info("++++++++++runner end");
	}
}
