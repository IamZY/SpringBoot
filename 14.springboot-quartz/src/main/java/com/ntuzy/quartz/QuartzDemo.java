package com.ntuzy.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {

	public static void main(String[] args) throws SchedulerException {

		// 创建job对象
		JobDetail job = JobBuilder.newJob(MyJob.class).build();

		// 创建trigger对象
		/**
		 * 简单 trigger cron trigger cron表达式
		 */
//		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
//				.build();

		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
				.build();
		
		
		// 创建Scheduler
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		
		// 启动Scheduler
		scheduler.start();

	}

}
