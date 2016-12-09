package com.teligen.sample.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.teligen.sample.bean.SysInfo;
import com.teligen.sample.service.SysService;

@Service("sysService")
public class SysServiceImpl implements SysService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private SysInfo sysInfo = new SysInfo();

	{
		Runtime r = Runtime.getRuntime();
		Properties props = System.getProperties();
		Map<String, String> map = System.getenv();
		try {
			InetAddress addr = InetAddress.getLocalHost();
			sysInfo.setHostName(addr.getHostName());
			sysInfo.setIp(addr.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		sysInfo.setUserName(map.get("USERNAME"));
		sysInfo.setComputerName(map.get("COMPUTERNAME"));
		sysInfo.setUserDomain(map.get("USERDOMAIN"));
		sysInfo.setUserHome(props.getProperty("user.home"));
		sysInfo.setUserDir(props.getProperty("user.dir"));
		sysInfo.setTotalMemory(r.totalMemory());
		sysInfo.setFreeMemory(r.freeMemory());
		sysInfo.setAvailableProcessors(r.availableProcessors());
		sysInfo.setJavaVersion(props.getProperty("java.version"));
		sysInfo.setJavaVendor(props.getProperty("java.vendor"));
		sysInfo.setJavaVendorUrl(props.getProperty("java.vendor.url"));
		sysInfo.setJavaHome(props.getProperty("java.home"));
		sysInfo.setJvmSpecVersion(props.getProperty("java.vm.specification.version"));
		sysInfo.setJvmSpecVendor(props.getProperty("java.vm.specification.vendor"));
		sysInfo.setJvmSpecName(props.getProperty("java.vm.specification.name"));
		sysInfo.setJvmVersion(props.getProperty("java.vm.version"));
		sysInfo.setJvmVendor(props.getProperty("java.vm.vendor"));
		sysInfo.setJvmName(props.getProperty("java.vm.name"));
		sysInfo.setJavaSpecVersion(props.getProperty("java.specification.version"));
		sysInfo.setJavaSpecVender(props.getProperty("java.specification.vender"));
		sysInfo.setJavaSpecName(props.getProperty("java.specification.name"));
		sysInfo.setJavaClassVersion(props.getProperty("java.class.version"));
		sysInfo.setJavaClassPath(props.getProperty("java.class.path"));
		sysInfo.setJavaLibPath(props.getProperty("java.library.path"));
		sysInfo.setJavaIoTmpDir(props.getProperty("java.io.tmpdir"));
		sysInfo.setJavaExtDirs(props.getProperty("java.ext.dirs"));
		sysInfo.setOsName(props.getProperty("os.name"));
		sysInfo.setOsArch(props.getProperty("os.arch"));
		sysInfo.setOsVersion(props.getProperty("os.version"));
		sysInfo.setFileSeparator(props.getProperty("file.separator"));
		sysInfo.setPathSeparator(props.getProperty("path.separator"));
		sysInfo.setLineSeparator(props.getProperty("line.separator"));
	}

	@Override
	public SysInfo getSysInfo() {
		Sigar sigar = new Sigar();
		try {
			sysInfo.setCpuInfoList(Arrays.asList(sigar.getCpuInfoList()));
			sysInfo.setCpuPercList(Arrays.asList(sigar.getCpuPercList()));
			sysInfo.setMem(sigar.getMem());
			sysInfo.setSwap(sigar.getSwap());
			sysInfo.setFileSystemList(Arrays.asList(sigar.getFileSystemList()));
			sysInfo.setFileSystemUsageList(new ArrayList());
			for (int i = 0; i < sysInfo.getFileSystemList().size(); i++) {
				FileSystem fs = sysInfo.getFileSystemList().get(i);
				switch (fs.getType()) {
				case 0: // TYPE_UNKNOWN ：未知
					break;
				case 1: // TYPE_NONE
					break;
				case 2: // TYPE_LOCAL_DISK : 本地硬盘
					sysInfo.getFileSystemUsageList().add(sigar.getFileSystemUsage(fs.getDirName()));
					break;
				case 3:// TYPE_NETWORK ：网络
					break;
				case 4:// TYPE_RAM_DISK ：闪存
					break;
				case 5:// TYPE_CDROM ：光驱
					break;
				case 6:// TYPE_SWAP ：页面交换
					break;
				}
			}
			sysInfo.setNetInterfaceConfigList(new ArrayList());
			String[] ifaces = sigar.getNetInterfaceList();
			for (int i = 0; i < ifaces.length; i++) {
				sysInfo.getNetInterfaceConfigList().add(sigar.getNetInterfaceConfig(ifaces[i]));
			}
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return sysInfo;
	}

}
