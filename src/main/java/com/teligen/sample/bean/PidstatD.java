package com.teligen.sample.bean;

public class PidstatD {

	// 每秒进程从磁盘独处的数据量
	private double kbRdPerSec;
	
	// 每秒进程从磁盘独处的数据量
	private double kbWrPerSec;
	
	private double kbCcwrPerSec;

	// 拉起进程对应的命令
	private String command;

	public PidstatD(double kbRdPerSec, double kbWrPerSec, double kbCcwrPerSec, String command) {
		super();
		this.kbRdPerSec = kbRdPerSec;
		this.kbWrPerSec = kbWrPerSec;
		this.kbCcwrPerSec = kbCcwrPerSec;
		this.command = command;
	}

	public double getKbRdPerSec() {
		return kbRdPerSec;
	}

	public void setKbRdPerSec(double kbRdPerSec) {
		this.kbRdPerSec = kbRdPerSec;
	}

	public double getKbWrPerSec() {
		return kbWrPerSec;
	}

	public void setKbWrPerSec(double kbWrPerSec) {
		this.kbWrPerSec = kbWrPerSec;
	}

	public double getKbCcwrPerSec() {
		return kbCcwrPerSec;
	}

	public void setKbCcwrPerSec(double kbCcwrPerSec) {
		this.kbCcwrPerSec = kbCcwrPerSec;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "PidstatD [kbRdPerSec=" + kbRdPerSec + ", kbWrPerSec=" + kbWrPerSec + ", kbCcwrPerSec=" + kbCcwrPerSec
				+ ", command=" + command + "]";
	}

}
