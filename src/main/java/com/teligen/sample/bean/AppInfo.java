package com.teligen.sample.bean;

import java.util.List;

public class AppInfo {

	public static final String STATUS_NORMAL = "正常";

	public static final String STATUS_ABSENT = "缺席";

	public static final String STATUS_EXTRA = "例外";

	private String pid;

	private String path;

	private String name;

	private String startCmd;

	private String jvmParm;

	private String status;

	private List<LsofI> lsofIList;
	
	private String ports;

	private JStatGC jStatGC;
	
	private PidstatU pidstatU;
	
	private PidstatR pidstatR;
	
	private PidstatD pidstatD;

	public AppInfo() {
		super();
	}

	public AppInfo(String pid, String path, String name, String startCmd, String jvmParm, String status) {
		super();
		this.pid = pid;
		this.path = path;
		this.name = name;
		this.startCmd = startCmd;
		this.jvmParm = jvmParm;
		this.status = status;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartCmd() {
		return startCmd;
	}

	public void setStartCmd(String startCmd) {
		this.startCmd = startCmd;
	}

	public String getJvmParm() {
		return jvmParm;
	}

	public void setJvmParm(String jvmParm) {
		this.jvmParm = jvmParm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LsofI> getLsofIList() {
		return lsofIList;
	}

	public void setLsofIList(List<LsofI> lsofIList) {
		this.lsofIList = lsofIList;
	}

	public String getPorts() {
		return ports;
	}

	public void setPorts(String ports) {
		this.ports = ports;
	}

	public JStatGC getjStatGC() {
		return jStatGC;
	}

	public void setjStatGC(JStatGC jStatGC) {
		this.jStatGC = jStatGC;
	}

	public PidstatU getPidstatU() {
		return pidstatU;
	}

	public void setPidstatU(PidstatU pidstatU) {
		this.pidstatU = pidstatU;
	}

	public PidstatR getPidstatR() {
		return pidstatR;
	}

	public void setPidstatR(PidstatR pidstatR) {
		this.pidstatR = pidstatR;
	}

	public PidstatD getPidstatD() {
		return pidstatD;
	}

	public void setPidstatD(PidstatD pidstatD) {
		this.pidstatD = pidstatD;
	}

	@Override
	public String toString() {
		return "AppInfo [pid=" + pid + ", path=" + path + ", name=" + name + ", startCmd=" + startCmd + ", jvmParm="
				+ jvmParm + ", status=" + status + ", lsofIList=" + lsofIList + ", ports=" + ports + ", jStatGC="
				+ jStatGC + ", pidstatU=" + pidstatU + ", pidstatR=" + pidstatR + ", pidstatD=" + pidstatD + "]";
	}

}
