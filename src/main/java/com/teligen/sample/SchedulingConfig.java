package com.teligen.sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.teligen.sample.service.AppService;
import com.teligen.sample.service.UserService;
import com.teligen.sample.util.CmdUtils;

@Configuration
@EnableScheduling
public class SchedulingConfig {

	private static final SimpleDateFormat dataFormate = new SimpleDateFormat("yyyy-MM-dd MM:mm:ss");
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AppService appSvc;

	@Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
	public void shchedler() {
		logger.info(">>>>>>>>>> scheduled ... " + dataFormate.format(new Date()));
		appSvc.refreshAppInfo();
	}
	
	@Scheduled(cron = "0/60 * * * * ?") // 每分执行一次
	public void checkPID() throws IOException {
		logger.info(">>>>>>>>>> checkPID ... " + dataFormate.format(new Date()));
		appSvc.refreshAppInfoList();
	}

}
