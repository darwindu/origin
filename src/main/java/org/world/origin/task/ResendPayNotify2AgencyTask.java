package org.world.origin.task;

import java.text.MessageFormat;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.world.origin.cache.Demo1Cache;
import org.world.origin.cache.DemoCache;
import org.world.origin.domain.PageData;
import org.world.origin.util.ConstJob;
import org.world.origin.util.Log;

import com.alibaba.fastjson.JSON;

/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: 重发支付通知给聚合支付商定时任务
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月24日
 * *********************************************
 * </pre>
 */
@Component
@Lazy(false)
public class ResendPayNotify2AgencyTask {

	private static final Logger log = Log.get();
	
	@Autowired
	private CommonTaskService commonTaskService;
	@Autowired
	private DemoCache demoCache;
	@Autowired
	private Demo1Cache demo1Cache;
	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * 每3秒执行一次
	 * @date 2017年7月24日
	 * @author darwin du
	 */
	//@Scheduled(cron = "0/3 * * * * *") 
    public void execute() {
		
		PageData pd1 = demoCache.getDemo(1);
		System.out.println("++++++++++pd1:" + pd1);
		Cache cache = cacheManager.getCache("demo");
		System.out.println("++++++++++demo:" + JSON.toJSONString(cache));
		
		Map<Integer, Object> map = demo1Cache.getDemoAll();
		System.out.println("++++++++++map:" + map);
		Cache demo1 = cacheManager.getCache("demo1");
		System.out.println("++++++++++demo1:" + JSON.toJSONString(demo1));
		
		log.debug("++++++++++【准备】抢占资源:支付结果通知失败重发任务【JOB_RESEND_PAY_FAIL】");
		//节点抢占资源，谁最先更新执行时间，资源归谁
		PageData pdResult = commonTaskService.update(ConstJob.JOB_RESEND_PAY_FAIL);
		int index = (int) pdResult.get("index");
		
		log.debug(MessageFormat.format("++++++++++【{0}】抢占资源：", index > 0 ? "成功" : "失败") + index);
		if(index > 0) {
			/*
			long length = 0;
			log.debug("++++++++++【开始】执行定时任务:支付结果通知失败重发任务【JOB_RESEND_PAY_FAIL】");
			List<PageData> list = resendPayNotify2AgencyTaskService.findProcessList();
			long size = (list == null) ? 0L : list.size();
			
			if(list != null && list.size() > 0) {
				
				for(PageData pd : list) {
					//每条记录一个事务
					long lockIndex = resendPayNotify2AgencyTaskService.updateRecordResend(pd);
					if(lockIndex > 0) {
						length ++ ;
					}
				}
			}
			log.debug("++++++++++【结束】执行定时任务:支付结果通知失败重发任务【JOB_RESEND_PAY_FAIL】；需处理记录数， " + size + "；已处理记录数：" + length);*/
		}
		
    }
}
