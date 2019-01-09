/**
 * (C) 2014-2016  Group Holding Limited.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 * 
 */
package org.world.origin.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
//@EnableAspectJAutoProxy
public class ApplicationConfigurations {
 
  /**
   * 线程池配置
   * 
   * @date 2017年12月6日
   * @author darwin du
   * @return
   */
  @Bean(name = "threadPoolTaskExecutor")
  public ThreadPoolTaskExecutor setThreadPoolTaskExecutor(
          @Value("${origin.common.threadpool.core-pool-size:48}") int backendCorePoolSize,
          @Value("${origin.common.threadpool.keep-alive-seconds:60}") int backendKeepAliveSeconds,
          @Value("${origin.common.threadpool.max-pool-size:48}") int backendMaxPoolSize,
          @Value("${origin.common.threadpool.queue-capacity:300}") int backendQueueCapacity,
          @Value("${origin.common.threadpool.allow-core-thread-timeout:true}") boolean backendAllowCoreThreadTimeOut,
          @Value("${origin.common.threadpool.await-termination-seconds:60}") int backendAwaitTerminationSeconds,
          @Value("${origin.common.threadpool.wait-for-task-to-complete-on-shutdown:true}") boolean waitForTasksToCompleteOnShutdown) {
	  
	  //MumbleThreadPoolTaskExecutor executor = new MumbleThreadPoolTaskExecutor();
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(backendCorePoolSize);
      executor.setKeepAliveSeconds(backendKeepAliveSeconds);
      executor.setMaxPoolSize(backendMaxPoolSize);
      executor.setQueueCapacity(backendQueueCapacity);
      executor.setAllowCoreThreadTimeOut(backendAllowCoreThreadTimeOut);
      executor.setAwaitTerminationSeconds(backendAwaitTerminationSeconds);
      executor.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
      
      //Reject策略预定义有四种： 
      //(1)ThreadPoolExecutor.AbortPolicy策略，是默认的策略,处理程序遭到拒绝将抛出运行时 RejectedExecutionException。 
      //(2)ThreadPoolExecutor.CallerRunsPolicy策略 ,调用者的线程会执行该任务,如果执行器已关闭,则丢弃. 
      //(3)ThreadPoolExecutor.DiscardPolicy策略，不能执行的任务将被丢弃. 
      //(4)ThreadPoolExecutor.DiscardOldestPolicy策略，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）.
      executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
      return executor;
  }
 
}
