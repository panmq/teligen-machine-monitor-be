package com.teligen.sample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.teligen.sample.bean.AppInfo;
import com.teligen.sample.service.CmdOutputHandler;

public class CmdUtils {

	// 获取当前JVM的所有进程. 也可使用jcmd
	public static String CMD_JPS = "jps -l";
	
	// 获取当前系统的端口使用情况（因为各个操作系统上的命令有差异，所以停用） 
	public static String CMD_NETSTAT = "netstat -ano";
	
	// 查看远程已打开的网络连接（服务为LISTEN类型） 
	public static String CMD_LSOF_I = "lsof -i";

	// jinfo flags <PID> 查看虚拟机参数
	public static String CMD_JINFO_FLAGS = "jinfo -flags ";
	
	// jstack <PID> 通过线程Dump分析卡死原因。 也可使用 jcmd <PID> Thread.print
	public static String CMD_JSTACK = "jstack ";
	
	// Java堆的Dump，可用VisualVM或者用jmc的JOverflow插件打开
	public static String CMD_GC_HEAP_DUMP = "jcmd <PID> GC.heap_dump ";

	// jmap -histo:live <PID> 分析堆中存活对象排行。 也可使用 jcmd <PID> GC.class_histogram
	public static String CMD_JMAP = "jmap -histo:live ";

	// jstat -gc <PID> 1000 1 以一秒为采样周期，输出一次内存及GC的统计信息
	public static String CMD_JSTAT_GC = "jstat -gc <PID> <SIIS> 1";

	// pidstat --u -r -d 1 1 以一秒为采样周期，输出所有PID的CPU,内存和IO使用统计信息（Linux 才有）
	public static String CMD_PIDSTAT = "pidstat -u -r -d 1 1";

	// pidstat -u -p <PID> 输出一次CPU使用统计信息（Linux 才有）
	public static String CMD_PIDSTAT_U = "pidstat -u -p <PID>";

	// pidstat -r -p <PID> 输出一次内存使用统计信息（Linux 才有）
	public static String CMD_PIDSTAT_R = "pidstat -r -p <PID>";

	// pidstat -d -p <PID> 输出一次IO使用统计信息（Linux 才有）
	public static String CMD_PIDSTAT_D = "pidstat -d -p <PID>";
	
	// jinfo -flag +PrintGCDetails <PID>开启进程的GC日志
	public static String CMD_JINFO_FLAG_PRINT_GC_DETAILS_ON = "jinfo -flag +PrintGCDetails ";

	// jinfo -flag +PrintGC <PID>开启进程的GC日志
	public static String CMD_JINFO_FLAG_PRINT_GC_ON = "jinfo -flag +PrintGC ";
	
	// jinfo -flag -PrintGCDetails <PID>关闭进程的GC日志
	public static String CMD_JINFO_FLAG_PRINT_GC_DETAILS_OFF = "jinfo -flag -PrintGCDetails ";

	// jinfo -flag -PrintGC <PID>关闭进程的GC日志
	public static String CMD_JINFO_FLAG_PRINT_GC_OFF = "jinfo -flag -PrintGC ";
	
	// 使用jcmd <PID> help能够获取jvm进程诊断命令

	public static String getSysOutputFromCmd(String cmd) {
		return getSysOutputFromCmd(cmd, null);
	}

	public static String getSysOutputFromCmd(String cmd, CmdOutputHandler handler) {
		return getSysOutputFromCmd(cmd, handler, null);
	}

	public static String getSysOutputFromCmd(String cmd, CmdOutputHandler handler, AppInfo appInfo) {
		StringBuffer sb = new StringBuffer();
		String output = "";
		Process pro = null;
		BufferedReader buf = null;
		try {
			pro = Runtime.getRuntime().exec(cmd);
			buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			for (int i = 0; (output = buf.readLine()) != null; i++) {
				sb.append(output).append(System.getProperty("line.separator"));
				if (appInfo != null) {
					handler.handle(output, i, appInfo);
				} else if (handler != null) {
					handler.handle(output, i);
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			try {
				if (buf != null) {
					buf.close();
					pro.destroy();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}

}
