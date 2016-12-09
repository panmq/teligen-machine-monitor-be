package com.teligen.sample.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "businessProps")
@Component
public class YmlConfig {

	private String outputPath;

	private int statIntervalInSec;

	private List<AppInfo> appInfoList = new ArrayList<AppInfo>();

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public int getStatIntervalInSec() {
		return statIntervalInSec;
	}

	public void setStatIntervalInSec(int statIntervalInSec) {
		this.statIntervalInSec = statIntervalInSec;
	}

	public List<AppInfo> getAppInfoList() {
		return appInfoList;
	}

	public void setAppInfoList(List<AppInfo> appInfoList) {
		this.appInfoList = appInfoList;
	}

	@Override
	public String toString() {
		return "YmlConfig [outputPath=" + outputPath + ", statIntervalInSec=" + statIntervalInSec + ", appInfoList="
				+ appInfoList + "]";
	}

}
