package com.ntuzy.demo.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务业务类
 * @author IamZY
 *
 */
@Component
public class TestTask {

	/**
	 * 每2秒执行一次
	 */
//	@Scheduled(fixedRate=2000)
//	@Scheduled(cron="*/1* * * * *")
	public void test() {
		System.out.println("当前时间 "+new Date());
	}
	
	
	
	
}
