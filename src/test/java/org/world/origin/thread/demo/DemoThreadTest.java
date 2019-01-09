package org.world.origin.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.world.origin.OriginApplicationTests;
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
 *  1      Create   	 darwin du       2017年11月22日
 * *********************************************
 * </pre>
 */
public class DemoThreadTest extends OriginApplicationTests {

	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	
	@Test
	public void test() {
		
		threadPoolTaskExecutor.execute(new Thread() {
			@Override
			public void run() {
				System.out.println("thread:hello world");
			}
		});
		
		threadPoolTaskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable:hello world");
			}
		});
		
		Future<String> future = (Future<String>) threadPoolTaskExecutor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "hello world";
			}
			
		});
		System.out.println("future:" + future);
	}
	

	public ThreadLocal<PageData> USER_CONTEXT_THREAD_LOCAL = new ThreadLocal<PageData>();
	@Test
	public void test1() {
		PageData pd = USER_CONTEXT_THREAD_LOCAL.get();
		System.out.println("####" + pd);
	}
}
