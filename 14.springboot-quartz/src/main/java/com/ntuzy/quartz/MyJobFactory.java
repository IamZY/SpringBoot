package com.ntuzy.quartz;

import javax.annotation.Resource;

import org.mockito.internal.stubbing.answers.ReturnsElementsOf;
import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component("jobFactory")
public class MyJobFactory extends AdaptableJobFactory {

	@Resource
	private AutowireCapableBeanFactory factory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		
		// 创建job对象
		Object jobInstance = super.createJobInstance(bundle);

		// 把JobInstance放入Spring容器中
		factory.autowireBean(jobInstance);
		
		return jobInstance;
	}

	

}
