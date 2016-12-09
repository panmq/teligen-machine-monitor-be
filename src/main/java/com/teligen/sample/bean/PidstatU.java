package com.teligen.sample.bean;

public class PidstatU {

	// 进程在用户态运行所占cpu时间比率
	private double usrRatio;

	// 进程在内核态运行所占cpu时间比率
	private double sysRatio;

	// 进程在访客态运行所占cpu时间比率
	private double guestRatio;

	// 进程运行所占cpu时间比率
	private double cpuRatio;
	
	// 指示进程在哪个核运行
	private String cpu;

	// 拉起进程对应的命令
	private String command;

	public PidstatU(double usrRatio, double sysRatio, double guestRatio, double cpuRatio, String cpu, String command) {
		super();
		this.usrRatio = usrRatio;
		this.sysRatio = sysRatio;
		this.guestRatio = guestRatio;
		this.cpuRatio = cpuRatio;
		this.cpu = cpu;
		this.command = command;
	}

	public double getUsrRatio() {
		return usrRatio;
	}

	public void setUsrRatio(double usrRatio) {
		this.usrRatio = usrRatio;
	}

	public double getSysRatio() {
		return sysRatio;
	}

	public void setSysRatio(double sysRatio) {
		this.sysRatio = sysRatio;
	}

	public double getGuestRatio() {
		return guestRatio;
	}

	public void setGuestRatio(double guestRatio) {
		this.guestRatio = guestRatio;
	}

	public double getCpuRatio() {
		return cpuRatio;
	}

	public void setCpuRatio(double cpuRatio) {
		this.cpuRatio = cpuRatio;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "PidstatU [usrRatio=" + usrRatio + ", sysRatio=" + sysRatio + ", guestRatio=" + guestRatio
				+ ", cpuRatio=" + cpuRatio + ", cpu=" + cpu + ", command=" + command + "]";
	}

}
