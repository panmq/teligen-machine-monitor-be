package com.teligen.sample.bean;

import org.hyperic.sigar.FileSystem;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Swap;

public class SysInfo {

	// 用户名
	private String userName;

	// 用户的主目录
	private String userHome;

	// 用户的当前工作目录
	private String userDir;

	// 计算机名
	private String computerName;

	// 计算机域名
	private String userDomain;

	// 本地ip地址
	private String ip;

	// 本地主机名
	private String hostName;

	// 操作系统的名称
	private String osName;

	// 操作系统的构架
	private String osArch;

	// 操作系统的版本
	private String osVersion;

	// JVM可以使用的总内存
	private long totalMemory;

	// JVM可以使用的剩余内存
	private long freeMemory;

	// JVM可以使用的处理器个数
	private int availableProcessors;

	// Java的运行环境版本
	private String javaVersion;

	// Java的运行环境供应商
	private String javaVendor;

	// Java供应商的URL
	private String javaVendorUrl;

	// Java的安装路径
	private String javaHome;

	// Java的虚拟机规范版本
	private String jvmSpecVersion;

	// Java的虚拟机规范供应商
	private String jvmSpecVendor;

	// Java的虚拟机规范名称
	private String jvmSpecName;

	// Java的虚拟机实现版本
	private String jvmVersion;

	// Java的虚拟机实现供应商
	private String jvmVendor;

	// Java的虚拟机实现名称
	private String jvmName;

	// Java运行时环境规范版本
	private String javaSpecVersion;

	// Java运行时环境规范供应商
	private String javaSpecVender;

	// Java运行时环境规范名称
	private String javaSpecName;

	// Java的类格式版本号
	private String javaClassVersion;

	// Java的类路径
	private String javaClassPath;

	// 加载库时搜索的路径列表
	private String javaLibPath;

	// 默认的临时文件路径
	private String javaIoTmpDir;

	// 一个或多个扩展目录的路径
	private String javaExtDirs;

	// 文件分隔符
	private String fileSeparator;

	// 路径分隔符
	private String pathSeparator;

	// 行分隔符
	private String lineSeparator;

	private List<CpuInfo> cpuInfoList;

	private List<CpuPerc> cpuPercList;

	private Mem mem;

	private Swap swap;

	private List<FileSystem> fileSystemList;

	private List<FileSystemUsage> fileSystemUsageList;

	private List<NetInterfaceConfig> netInterfaceConfigList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	public String getUserDir() {
		return userDir;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public long getFreeMemory() {
		return freeMemory;
	}

	public void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

	public int getAvailableProcessors() {
		return availableProcessors;
	}

	public void setAvailableProcessors(int availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getJavaVendor() {
		return javaVendor;
	}

	public void setJavaVendor(String javaVendor) {
		this.javaVendor = javaVendor;
	}

	public String getJavaVendorUrl() {
		return javaVendorUrl;
	}

	public void setJavaVendorUrl(String javaVendorUrl) {
		this.javaVendorUrl = javaVendorUrl;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	public String getJvmSpecVersion() {
		return jvmSpecVersion;
	}

	public void setJvmSpecVersion(String jvmSpecVersion) {
		this.jvmSpecVersion = jvmSpecVersion;
	}

	public String getJvmSpecVendor() {
		return jvmSpecVendor;
	}

	public void setJvmSpecVendor(String jvmSpecVendor) {
		this.jvmSpecVendor = jvmSpecVendor;
	}

	public String getJvmSpecName() {
		return jvmSpecName;
	}

	public void setJvmSpecName(String jvmSpecName) {
		this.jvmSpecName = jvmSpecName;
	}

	public String getJvmVersion() {
		return jvmVersion;
	}

	public void setJvmVersion(String jvmVersion) {
		this.jvmVersion = jvmVersion;
	}

	public String getJvmVendor() {
		return jvmVendor;
	}

	public void setJvmVendor(String jvmVendor) {
		this.jvmVendor = jvmVendor;
	}

	public String getJvmName() {
		return jvmName;
	}

	public void setJvmName(String jvmName) {
		this.jvmName = jvmName;
	}

	public String getJavaSpecVersion() {
		return javaSpecVersion;
	}

	public void setJavaSpecVersion(String javaSpecVersion) {
		this.javaSpecVersion = javaSpecVersion;
	}

	public String getJavaSpecVender() {
		return javaSpecVender;
	}

	public void setJavaSpecVender(String javaSpecVender) {
		this.javaSpecVender = javaSpecVender;
	}

	public String getJavaSpecName() {
		return javaSpecName;
	}

	public void setJavaSpecName(String javaSpecName) {
		this.javaSpecName = javaSpecName;
	}

	public String getJavaClassVersion() {
		return javaClassVersion;
	}

	public void setJavaClassVersion(String javaClassVersion) {
		this.javaClassVersion = javaClassVersion;
	}

	public String getJavaClassPath() {
		return javaClassPath;
	}

	public void setJavaClassPath(String javaClassPath) {
		this.javaClassPath = javaClassPath;
	}

	public String getJavaLibPath() {
		return javaLibPath;
	}

	public void setJavaLibPath(String javaLibPath) {
		this.javaLibPath = javaLibPath;
	}

	public String getJavaIoTmpDir() {
		return javaIoTmpDir;
	}

	public void setJavaIoTmpDir(String javaIoTmpDir) {
		this.javaIoTmpDir = javaIoTmpDir;
	}

	public String getJavaExtDirs() {
		return javaExtDirs;
	}

	public void setJavaExtDirs(String javaExtDirs) {
		this.javaExtDirs = javaExtDirs;
	}

	public String getFileSeparator() {
		return fileSeparator;
	}

	public void setFileSeparator(String fileSeparator) {
		this.fileSeparator = fileSeparator;
	}

	public String getPathSeparator() {
		return pathSeparator;
	}

	public void setPathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
	}

	public String getLineSeparator() {
		return lineSeparator;
	}

	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	public List<CpuInfo> getCpuInfoList() {
		return cpuInfoList;
	}

	public void setCpuInfoList(List<CpuInfo> cpuInfoList) {
		this.cpuInfoList = cpuInfoList;
	}

	public List<CpuPerc> getCpuPercList() {
		return cpuPercList;
	}

	public void setCpuPercList(List<CpuPerc> cpuPercList) {
		this.cpuPercList = cpuPercList;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Swap getSwap() {
		return swap;
	}

	public void setSwap(Swap swap) {
		this.swap = swap;
	}

	public List<FileSystem> getFileSystemList() {
		return fileSystemList;
	}

	public void setFileSystemList(List<FileSystem> fileSystemList) {
		this.fileSystemList = fileSystemList;
	}

	public List<FileSystemUsage> getFileSystemUsageList() {
		return fileSystemUsageList;
	}

	public void setFileSystemUsageList(List<FileSystemUsage> fileSystemUsageList) {
		this.fileSystemUsageList = fileSystemUsageList;
	}

	public List<NetInterfaceConfig> getNetInterfaceConfigList() {
		return netInterfaceConfigList;
	}

	public void setNetInterfaceConfigList(List<NetInterfaceConfig> netInterfaceConfigList) {
		this.netInterfaceConfigList = netInterfaceConfigList;
	}

	@Override
	public String toString() {
		return "SysInfo [userName=" + userName + ", userHome=" + userHome + ", userDir=" + userDir + ", computerName="
				+ computerName + ", userDomain=" + userDomain + ", ip=" + ip + ", hostName=" + hostName + ", osName="
				+ osName + ", osArch=" + osArch + ", osVersion=" + osVersion + ", totalMemory=" + totalMemory
				+ ", freeMemory=" + freeMemory + ", availableProcessors=" + availableProcessors + ", javaVersion="
				+ javaVersion + ", javaVendor=" + javaVendor + ", javaVendorUrl=" + javaVendorUrl + ", javaHome="
				+ javaHome + ", jvmSpecVersion=" + jvmSpecVersion + ", jvmSpecVendor=" + jvmSpecVendor
				+ ", jvmSpecName=" + jvmSpecName + ", jvmVersion=" + jvmVersion + ", jvmVendor=" + jvmVendor
				+ ", jvmName=" + jvmName + ", javaSpecVersion=" + javaSpecVersion + ", javaSpecVender=" + javaSpecVender
				+ ", javaSpecName=" + javaSpecName + ", javaClassVersion=" + javaClassVersion + ", javaClassPath="
				+ javaClassPath + ", javaLibPath=" + javaLibPath + ", javaIoTmpDir=" + javaIoTmpDir + ", javaExtDirs="
				+ javaExtDirs + ", fileSeparator=" + fileSeparator + ", pathSeparator=" + pathSeparator
				+ ", lineSeparator=" + lineSeparator + ", cpuInfoList=" + cpuInfoList + ", cpuPercList=" + cpuPercList
				+ ", mem=" + mem + ", swap=" + swap + ", fileSystemList=" + fileSystemList + ", fileSystemUsageList="
				+ fileSystemUsageList + ", netInterfaceConfigList=" + netInterfaceConfigList + "]";
	}

}
