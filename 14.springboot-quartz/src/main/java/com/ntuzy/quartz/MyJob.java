package com.ntuzy.quartz;

import java.util.Date;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ntuzy.service.EmpService;

public class MyJob implements Job {

	@Resource
	EmpService empService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println(new Date());
		empService.save();
	}

}
