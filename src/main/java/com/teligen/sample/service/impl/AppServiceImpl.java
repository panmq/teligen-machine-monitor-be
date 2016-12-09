package com.teligen.sample.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.influxdb.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teligen.sample.bean.AppInfo;
import com.teligen.sample.bean.InfluxDBBean;
import com.teligen.sample.bean.JStatGC;
import com.teligen.sample.bean.LsofI;
import com.teligen.sample.bean.Netstat;
import com.teligen.sample.bean.PidstatD;
import com.teligen.sample.bean.PidstatR;
import com.teligen.sample.bean.PidstatU;
import com.teligen.sample.bean.YmlConfig;
import com.teligen.sample.service.AppService;
import com.teligen.sample.service.CmdOutputHandler;
import com.teligen.sample.util.CmdUtils;
import com.teligen.sample.util.StringUtils;

@Service("appService")
public class AppServiceImpl implements AppService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// Map<path, AppInfo>
	private Map<String, AppInfo> jpsMap = new HashMap<String, AppInfo>();

	// Map<pid, List<Netstat>>
	@Deprecated
	private Map<String, List<Netstat>> netstatMap = new HashMap<String, List<Netstat>>();

	// Map<pid, List<Netstat>>
	private Map<String, List<LsofI>> lsofIMap = new HashMap<String, List<LsofI>>();

	private List<AppInfo> appInfoList = new ArrayList<AppInfo>();

	@Autowired
	private YmlConfig ymlConfig;

	@Autowired
	private InfluxDBBean influxDBBean;

	class JpsCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = " ";

		@Override
		public void handle(String output, int lineNum) {
			String[] values = output.split(SEPERATOR);
			AppInfo appInfo = new AppInfo();
			if (values.length > 1) {
				appInfo.setPid(values[0]);
				appInfo.setPath(values[1]);
			} else {
				appInfo.setPid(values[0]);
				// for the null case
				appInfo.setPath(values[0]);
			}
			if (!appInfo.getPath().endsWith("Jps")) {
				jpsMap.put(appInfo.getPath(), appInfo);
			}
		}

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
		}

	}

	/**
	 * 因为各个操作系统上的命令有差异，所以停用
	 * 
	 * @author panminqiang
	 *
	 */
	@Deprecated
	class NetstatCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum) {
			if (lineNum > 3) {
				output = output.substring(2);
				String[] values = output.split(SEPERATOR);
				Netstat netstat = null;
				if ("UDP".equals(values[0])) {
					netstat = new Netstat(values[0], values[1], values[2], "", values[3]);
				} else {
					netstat = new Netstat(values[0], values[1], values[2], values[3], values[4]);
				}
				List<Netstat> netstatList = (List) netstatMap.get(netstat.getPid());
				if (netstatList == null) {
					netstatList = new ArrayList<Netstat>();
				}
				netstatList.add(netstat);
				netstatMap.put(netstat.getPid(), netstatList);
			}
		}

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
		}

	}

	class LsofICmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum) {
			if (lineNum > 0) {
				String[] values = output.split(SEPERATOR);
				LsofI lsofI = null;
				if ("java".equals(values[0])) {
					lsofI = new LsofI(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
							values[7], values[8]);
					List<LsofI> lsofIList = (List) lsofIMap.get(lsofI.getPid());
					if (lsofIList == null) {
						lsofIList = new ArrayList<LsofI>();
					}
					lsofIList.add(lsofI);
					lsofIMap.put(lsofI.getPid(), lsofIList);
				}
			}
		}

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
		}

	}

	class JStatGCCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
			if (lineNum > 0) {
				String[] values = output.split(SEPERATOR);
				JStatGC jStatGC = null;
				if (17 == values.length) { // for jdk8
					jStatGC = new JStatGC(StringUtils.parseDouble(values[0]), StringUtils.parseDouble(values[1]),
							StringUtils.parseDouble(values[2]), StringUtils.parseDouble(values[3]),
							StringUtils.parseDouble(values[4]), StringUtils.parseDouble(values[5]),
							StringUtils.parseDouble(values[6]), StringUtils.parseDouble(values[7]),
							StringUtils.parseDouble(values[8]), StringUtils.parseDouble(values[9]),
							StringUtils.parseDouble(values[10]), StringUtils.parseDouble(values[11]),
							StringUtils.parseInt(values[12]), StringUtils.parseDouble(values[13]),
							StringUtils.parseInt(values[14]), StringUtils.parseDouble(values[15]),
							StringUtils.parseDouble(values[16]));
				} else if (15 == values.length) { // for jdk7
					jStatGC = new JStatGC(StringUtils.parseDouble(values[0]), StringUtils.parseDouble(values[1]),
							StringUtils.parseDouble(values[2]), StringUtils.parseDouble(values[3]),
							StringUtils.parseDouble(values[4]), StringUtils.parseDouble(values[5]),
							StringUtils.parseDouble(values[6]), StringUtils.parseDouble(values[7]),
							StringUtils.parseInt(values[12]), StringUtils.parseDouble(values[13]),
							StringUtils.parseInt(values[14]), StringUtils.parseDouble(values[15]),
							StringUtils.parseDouble(values[16]));
				}
				appInfo.setjStatGC(jStatGC);
			}
		}

		@Override
		public void handle(String output, int lineNum) {
		}

	}

	class PidstatUCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
			if (lineNum > 2) {
				String[] values = output.split(SEPERATOR);
				PidstatU pidstatU = new PidstatU(StringUtils.parseDouble(values[2]), StringUtils.parseDouble(values[3]),
						StringUtils.parseDouble(values[4]), StringUtils.parseDouble(values[5]), values[6], values[7]);
				appInfo.setPidstatU(pidstatU);
			}
		}

		@Override
		public void handle(String output, int lineNum) {
		}

	}

	class PidstatRCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
			if (lineNum > 2) {
				String[] values = output.split(SEPERATOR);
				PidstatR pidstatR = new PidstatR(StringUtils.parseDouble(values[2]), StringUtils.parseDouble(values[3]),
						StringUtils.parseInt(values[4]), StringUtils.parseInt(values[5]),
						StringUtils.parseDouble(values[6]), values[7]);
				appInfo.setPidstatR(pidstatR);
			}
		}

		@Override
		public void handle(String output, int lineNum) {
		}

	}

	class PidstatDCmdHandler implements CmdOutputHandler {

		private final String SEPERATOR = "\\s+";

		@Override
		public void handle(String output, int lineNum, AppInfo appInfo) {
			if (lineNum > 2) {
				String[] values = output.split(SEPERATOR);
				PidstatD pidstatD = new PidstatD(StringUtils.parseDouble(values[2]), StringUtils.parseDouble(values[3]),
						StringUtils.parseDouble(values[4]), values[5]);
				appInfo.setPidstatD(pidstatD);
			}
		}

		@Override
		public void handle(String output, int lineNum) {
		}

	}

	@Override
	public void refreshAppInfo() {
		for (AppInfo appInfo : appInfoList) {
			if (AppInfo.STATUS_NORMAL.equals(appInfo.getStatus()) || AppInfo.STATUS_EXTRA.equals(appInfo.getStatus())) {
				CmdUtils.getSysOutputFromCmd(
						CmdUtils.CMD_JSTAT_GC.replaceAll("<PID>", appInfo.getPid()).replaceAll("<SIIS>",
								String.valueOf(ymlConfig.getStatIntervalInSec() * 1000)),
						new JStatGCCmdHandler(), appInfo);
				// String insertStr = "cpu1,atag=test1
				// host=testServer1,regin=china,value=0.88";
				if (appInfo.getjStatGC() != null) {
					Point point = Point.measurement("jstat_gc").addField("PID", appInfo.getPid())
							.addField("NAME", appInfo.getName())
							// .tag("atag", "test")
							.addField("S0C", appInfo.getjStatGC().getS0c())
							.addField("S1C", appInfo.getjStatGC().getS1c())
							.addField("S0U", appInfo.getjStatGC().getS0u())
							.addField("S1U", appInfo.getjStatGC().getS1u()).addField("EC", appInfo.getjStatGC().getEc())
							.addField("EU", appInfo.getjStatGC().getEu()).addField("OC", appInfo.getjStatGC().getOc())
							.addField("OU", appInfo.getjStatGC().getOu()).addField("MC", appInfo.getjStatGC().getMc())
							.addField("MU", appInfo.getjStatGC().getMu())
							.addField("CCSC", appInfo.getjStatGC().getCcsc())
							.addField("CCSU", appInfo.getjStatGC().getCcsu())
							.addField("YGC", appInfo.getjStatGC().getYgc())
							.addField("YGCT", appInfo.getjStatGC().getYgct())
							.addField("FGC", appInfo.getjStatGC().getYgc())
							.addField("FGCT", appInfo.getjStatGC().getFgct())
							.addField("GCT", appInfo.getjStatGC().getGct()).build();
					influxDBBean.getInfluxDB().write(influxDBBean.getInfluxDBName(), influxDBBean.RETIONSION_POLICY,
							point);
				}

				CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_PIDSTAT_U.replaceAll("<PID>", appInfo.getPid()),
						new PidstatUCmdHandler(), appInfo);
				if (appInfo.getPidstatU() != null) {
					Point point = Point.measurement("pidstat_u").addField("PID", appInfo.getPid())
							.addField("NAME", appInfo.getName())
							// .tag("atag", "test")
							.addField("USRRATIO", appInfo.getPidstatU().getUsrRatio())
							.addField("SYSRATIO", appInfo.getPidstatU().getSysRatio())
							.addField("GUESTRATIO", appInfo.getPidstatU().getGuestRatio())
							.addField("CPURATIO", appInfo.getPidstatU().getCpuRatio())
							.addField("CPU", appInfo.getPidstatU().getCpu())
							.addField("COMMAND", appInfo.getPidstatU().getCommand()).build();
					influxDBBean.getInfluxDB().write(influxDBBean.getInfluxDBName(), influxDBBean.RETIONSION_POLICY,
							point);
				}

				CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_PIDSTAT_R.replaceAll("<PID>", appInfo.getPid()),
						new PidstatRCmdHandler(), appInfo);
				if (appInfo.getPidstatR() != null) {
					Point point = Point.measurement("pidstat_r").addField("PID", appInfo.getPid())
							.addField("NAME", appInfo.getName())
							// .tag("atag", "test")
							.addField("MINFLTPERSEC", appInfo.getPidstatR().getMinfltPerSec())
							.addField("MAJFLTPERSEC", appInfo.getPidstatR().getMajfltPerSec())
							.addField("VSZ", appInfo.getPidstatR().getVsz())
							.addField("RSS", appInfo.getPidstatR().getRss())
							.addField("MEMRATIO", appInfo.getPidstatR().getMemRatio())
							.addField("COMMAND", appInfo.getPidstatR().getCommand()).build();
					influxDBBean.getInfluxDB().write(influxDBBean.getInfluxDBName(), influxDBBean.RETIONSION_POLICY,
							point);
				}

				CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_PIDSTAT_D.replaceAll("<PID>", appInfo.getPid()),
						new PidstatDCmdHandler(), appInfo);
				if (appInfo.getPidstatD() != null) {
					Point point = Point.measurement("pidstat_d").addField("PID", appInfo.getPid())
							.addField("NAME", appInfo.getName())
							// .tag("atag", "test")
							.addField("KBRDPERSEC", appInfo.getPidstatD().getKbRdPerSec())
							.addField("KBWRPERSEC", appInfo.getPidstatD().getKbWrPerSec())
							.addField("KBCCWRPERSEC", appInfo.getPidstatD().getKbCcwrPerSec())
							.addField("COMMAND", appInfo.getPidstatD().getCommand()).build();
					influxDBBean.getInfluxDB().write(influxDBBean.getInfluxDBName(), influxDBBean.RETIONSION_POLICY,
							point);
				}
			}
		}
		// logger.info("appInfoList" + appInfoList.size() +
		// appInfoList.toString());
	}

	// Todo: 可能不同步
	@Override
	public void refreshAppInfoList() {
		jpsMap.clear();
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JPS, new JpsCmdHandler());

		appInfoList.clear();
		for (AppInfo configAppInfo : ymlConfig.getAppInfoList()) {
			boolean flag = false;
			for (AppInfo jpsAppInfo : jpsMap.values()) {
				if (jpsAppInfo.getPath().equals(configAppInfo.getPath())) {
					flag = true;
					AppInfo appInfo = new AppInfo(jpsAppInfo.getPid(), jpsAppInfo.getPath(), configAppInfo.getName(),
							configAppInfo.getStartCmd(), getJvmParm(jpsAppInfo.getPid(), jpsAppInfo.getPath()),
							AppInfo.STATUS_NORMAL);
					appInfoList.add(appInfo);
					break;
				}
			}
			if (flag == false) {
				AppInfo appInfo = new AppInfo("", configAppInfo.getPath(), configAppInfo.getName(),
						configAppInfo.getStartCmd(), "", AppInfo.STATUS_ABSENT);
				appInfoList.add(appInfo);
			}
		}

		lsofIMap.clear();
		for (AppInfo jpsAppInfo : jpsMap.values()) {
			boolean flag = false;
			for (AppInfo appInfo : appInfoList) {
				if (appInfo.getPath().equals(jpsAppInfo.getPath())) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				String name = jpsAppInfo.getPath().contains(".")
						? jpsAppInfo.getPath().substring(jpsAppInfo.getPath().lastIndexOf(".") + 1)
						: jpsAppInfo.getPath();
				AppInfo appInfo = new AppInfo(jpsAppInfo.getPid(), jpsAppInfo.getPath(), name, "",
						getJvmParm(jpsAppInfo.getPid(), jpsAppInfo.getPath()), AppInfo.STATUS_EXTRA);
				appInfoList.add(appInfo);
			}
			CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_LSOF_I, new LsofICmdHandler());
		}

		for (AppInfo appInfo : appInfoList) {
			appInfo.setLsofIList(lsofIMap.get(appInfo.getPid()));
			if (appInfo.getLsofIList() != null) {
				for (LsofI lsofI : appInfo.getLsofIList()) {
					if (appInfo.getPorts() == null) {
						appInfo.setPorts(lsofI.getName());
					} else {
						appInfo.setPorts(appInfo.getPorts() + ", " + lsofI.getName());
					}
				}
			}
		}

		// logger.info("ymlConfig:" + ymlConfig.getAppInfoList().size() +
		// ymlConfig);
		// logger.info("jpsMap:" + jpsMap.size() + jpsMap);
		// logger.info("appInfoList" + appInfoList.size() +
		// appInfoList.toString());
	}

	@Override
	public List<AppInfo> getAppInfoList() {
		return appInfoList;
	}

	@Override
	public String dumpThreads(String pid) {
		return CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JSTACK + pid);
	}

	@Override
	public String dumpHeap(String pid) {
		String outputFile = ymlConfig.getOutputPath() + pid + ".hprof";
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_GC_HEAP_DUMP.replaceAll("<PID>", pid) + outputFile);
		return outputFile;
	}

	@Override
	public String rankInstances(String pid) {
		return CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JMAP + pid);
	}

	private String getJvmParm(String pid, String path) {
		String output = CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JINFO_FLAGS + pid);
		if (output.contains("JVM version is")) {
			output = output.substring(output.indexOf("JVM version is"));
		} else {
			output = "该JVM版本不支持查找启动参数";
		}
		return output;
	}

	@Override
	public String enableGC(String pid) {
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JINFO_FLAG_PRINT_GC_DETAILS_ON + pid);
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JINFO_FLAG_PRINT_GC_ON + pid);
		return "GC (pid=" + pid + ") is enabled";
	}

	@Override
	public String disableGC(String pid) {
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JINFO_FLAG_PRINT_GC_DETAILS_OFF + pid);
		CmdUtils.getSysOutputFromCmd(CmdUtils.CMD_JINFO_FLAG_PRINT_GC_OFF + pid);
		return "GC (pid=" + pid + ") is disabled";
	}

}
