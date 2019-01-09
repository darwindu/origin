package org.world.origin.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulingConfiguration implements SchedulingConfigurer {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.scheduling.annotation.SchedulingConfigurer#configureTasks(org.
     * springframework.scheduling.config.ScheduledTaskRegistrar)
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(schedulingTaskExecutor());

    }

    @Bean(destroyMethod = "shutdown", name = "schedulingTaskExecutor")
    public Executor schedulingTaskExecutor() {
        //return Executors.newScheduledThreadPool(2);
    	//924版本通知重发支付通知失败定时任务线程池增加到10
        return Executors.newScheduledThreadPool(10);
    }

}
