package com.teligen.sample.bean;

/**
 * 因为各个操作系统上的命令有差异，所以停用
 * @author panminqiang
 *
 */
@Deprecated
public class Netstat {

	private String protocal;

	private String localAddr;

	private String extAddr;

	private String status;
	
	private String pid;

	public Netstat(String protocal, String localAddr, String extAddr, String status, String pid) {
		super();
		this.protocal = protocal;
		this.localAddr = localAddr;
		this.extAddr = extAddr;
		this.status = status;
		this.pid = pid;
	}

	public String getProtocal() {
		return protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	public String getLocalAddr() {
		return localAddr;
	}

	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	public String getExtAddr() {
		return extAddr;
	}

	public void setExtAddr(String extAddr) {
		this.extAddr = extAddr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Netstat [protocal=" + protocal + ", localAddr=" + localAddr + ", extAddr=" + extAddr + ", status="
				+ status + ", pid=" + pid + "]";
	}

}
