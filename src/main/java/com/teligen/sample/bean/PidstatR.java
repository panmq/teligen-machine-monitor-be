package com.teligen.sample.bean;

public class PidstatR {

	// 每秒次缺页错误次数（minor page faults），次缺页错误次数意即虚拟内存地址映射成物理内存地址产生的page fault次数
	private double minfltPerSec;

	// 每秒主缺页错误次数（major page faults），当虚拟内存地址映射成物理内存地址时，相应的page在swap中，这样的page
	// fault为major page fault，一般在内存使用紧张时产生
	private double majfltPerSec;

	// 该进程使用的虚拟内存（以kB为单位）
	private int vsz;

	// 该进程使用的物理内存（以kB为单位）
	private int rss;

	// 该进程使用内存的百分比
	private double memRatio;

	// 拉起进程对应的命令
	private String command;

	public PidstatR(double minfltPerSec, double majfltPerSec, int vsz, int rss, double memRatio, String command) {
		super();
		this.minfltPerSec = minfltPerSec;
		this.majfltPerSec = majfltPerSec;
		this.vsz = vsz;
		this.rss = rss;
		this.memRatio = memRatio;
		this.command = command;
	}

	public double getMinfltPerSec() {
		return minfltPerSec;
	}

	public void setMinfltPerSec(double minfltPerSec) {
		this.minfltPerSec = minfltPerSec;
	}

	public double getMajfltPerSec() {
		return majfltPerSec;
	}

	public void setMajfltPerSec(double majfltPerSec) {
		this.majfltPerSec = majfltPerSec;
	}

	public int getVsz() {
		return vsz;
	}

	public void setVsz(int vsz) {
		this.vsz = vsz;
	}

	public int getRss() {
		return rss;
	}

	public void setRss(int rss) {
		this.rss = rss;
	}

	public double getMemRatio() {
		return memRatio;
	}

	public void setMemRatio(double memRatio) {
		this.memRatio = memRatio;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "PidstatR [minfltPerSec=" + minfltPerSec + ", majfltPerSec=" + majfltPerSec + ", vsz=" + vsz + ", rss="
				+ rss + ", memRatio=" + memRatio + ", command=" + command + "]";
	}

}
