package com.teligen.sample.service;

import com.teligen.sample.bean.AppInfo;

public interface CmdOutputHandler {
	
	void handle(String output, int lineNum);
	
	void handle(String output, int lineNum, AppInfo appInfo);
	
}
