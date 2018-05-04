package com.wt.util;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.wt.action.TimeAction;
import com.wt.po.DataflowDAO;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTimerTask {
	
	static TimeAction ta=new TimeAction();

	//便于观察每5秒执行一次，以后要改成60秒
    @SuppressWarnings("deprecation")
	@Scheduled(cron = "*/5 * * * * ?")
    //@Scheduled(fixedDelay = 5000)
    public void demoServiceMethod() {//已经修复执行两次的问题
    	try {
			ta.dotime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Method executed at every 5 seconds. Current time is :: " + (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    }
}
