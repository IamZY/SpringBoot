package com.ntuzy.config;

import org.quartz.spi.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.ntuzy.quartz.MyJob;

@Configuration
public class QuartzConfig {

	/**
	 * 1.创建Job对象
	 */
	@Bean
	public JobDetailFactoryBean getJobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();

		// 关联我们定义Job类
		factory.setJobClass(MyJob.class);

		return factory;
	}

	/**
	 * 2.创建Trigger
	 */
	/*
	 * @Bean public SimpleTriggerFactoryBean
	 * getSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
	 * SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
	 * 
	 * // 关联JobDetail对象 factory.setJobDetail(jobDetailFactoryBean.getObject());
	 * 
	 * // 重复间隔时间（毫秒为单位） factory.setRepeatInterval(5000);
	 * 
	 * // 重复次数 factory.setRepeatCount(4);
	 * 
	 * return factory; }
	 */

	@Bean
	public CronTriggerFactoryBean getSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory = new CronTriggerFactoryBean();

		// 关联JobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());

		factory.setCronExpression("0/3 * * * * ?");

		return factory;
	}

	/**
	 * 3.创建Scheduler对象
	 */
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean(CronTriggerFactoryBean triggerFactoryBean,JobFactory jobFactory) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();

		// 关联trigger
		factory.setTriggers(triggerFactoryBean.getObject());

		// 重新JobFactory
		factory.setJobFactory(jobFactory);

		return factory;
	}

}
