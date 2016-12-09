package com.teligen.sample.service;

import java.util.List;

import com.teligen.sample.bean.AppInfo;

public interface AppService {

	void refreshAppInfo();
	
	void refreshAppInfoList();

	List<AppInfo> getAppInfoList();
	
	String dumpThreads(String pid);
	
	String dumpHeap(String pid);
	
	String rankInstances(String pid);
	
	String enableGC(String pid);
	
	String disableGC(String pid);
	
}
