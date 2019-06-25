package com.ntuzy.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule {

	// 每隔三秒执行一次
	@Scheduled(cron = "0/3 * * * * ?")
	public void test1() {
		System.out.println("执行任务" + new Date());
	}

}
