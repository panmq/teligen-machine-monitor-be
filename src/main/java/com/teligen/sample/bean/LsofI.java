package com.teligen.sample.bean;

public class LsofI {

	private String command;

	private String pid;

	private String user;

	private String fd;

	private String type;

	private String device;

	private String sizeOff;

	private String node;

	private String name;

	public LsofI(String command, String pid, String user, String fd, String type, String device, String sizeOff,
			String node, String name) {
		super();
		this.command = command;
		this.pid = pid;
		this.user = user;
		this.fd = fd;
		this.type = type;
		this.device = device;
		this.sizeOff = sizeOff;
		this.node = node;
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFd() {
		return fd;
	}

	public void setFd(String fd) {
		this.fd = fd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSizeOff() {
		return sizeOff;
	}

	public void setSizeOff(String sizeOff) {
		this.sizeOff = sizeOff;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LsofI [command=" + command + ", pid=" + pid + ", user=" + user + ", fd=" + fd + ", type=" + type
				+ ", device=" + device + ", sizeOff=" + sizeOff + ", node=" + node + ", name=" + name + "]";
	}

}
