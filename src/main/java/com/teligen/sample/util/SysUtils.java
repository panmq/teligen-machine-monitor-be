package com.teligen.sample.util;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class SysUtils {

	// 1.CPU资源信息
	// a)CPU数量（单位：个）
	public static int getCpuCount() throws SigarException {
		Sigar sigar = new Sigar();
		try {
			return sigar.getCpuInfoList().length;
		} finally {
			sigar.close();
		}
	}

	private static void cpu() throws SigarException {
		Sigar sigar = new Sigar();
		CpuPerc cpuList[] = null;
		CpuInfo infos[] = null;
		try {
			cpuList = sigar.getCpuPercList();
			infos = sigar.getCpuInfoList();
		} catch (SigarException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("cpu count :" + cpuList.length);
		for (int i = 0; i < cpuList.length; i++) {
			CpuInfo info = infos[i];
			System.out.println("第" + (i + 1) + "块CPU信息");
			System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
			System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
			System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
			System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量

			CpuPerc cpu = cpuList[i];
			System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
			System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
			System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
			System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
			System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
			System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
		}
	}

	private static void memory() throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		// 内存总量
		System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
		// 当前内存使用量
		System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
		// 当前内存剩余量
		System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
		Swap swap = sigar.getSwap();
		// 交换区总量
		System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
		// 当前交换区使用量
		System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
		// 当前交换区剩余量
		System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
	}

	private static void disk() throws SigarException {
		Sigar sigar = new Sigar();
		FileSystem fslist[] = sigar.getFileSystemList();
		// String dir = System.getProperty("user.home");// 当前用户文件夹路径
		for (int i = 0; i < fslist.length; i++) {
			System.out.println("/n~~~~~~~~~~" + i + "~~~~~~~~~~");
			FileSystem fs = fslist[i];
			// 分区的盘符名称
			System.out.println("fs.getDevName() = " + fs.getDevName());
			// 分区的盘符名称
			System.out.println("fs.getDirName() = " + fs.getDirName());
			System.out.println("fs.getFlags() = " + fs.getFlags());//
			// 文件系统类型，比如 FAT32、NTFS
			System.out.println("fs.getSysTypeName() = " + fs.getSysTypeName());
			// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
			System.out.println("fs.getTypeName() = " + fs.getTypeName());
			// 文件系统类型
			System.out.println("fs.getType() = " + fs.getType());
			FileSystemUsage usage = null;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
			} catch (SigarException e) {
				if (fs.getType() == 2)
					throw e;
				continue;
			}
			switch (fs.getType()) {
			case 0: // TYPE_UNKNOWN ：未知
				break;
			case 1: // TYPE_NONE
				break;
			case 2: // TYPE_LOCAL_DISK : 本地硬盘
				// 文件系统总大小
				System.out.println(" Total = " + usage.getTotal() + "KB");
				// 文件系统剩余大小
				System.out.println(" Free = " + usage.getFree() + "KB");
				// 文件系统可用大小
				System.out.println(" Avail = " + usage.getAvail() + "KB");
				// 文件系统已经使用量
				System.out.println(" Used = " + usage.getUsed() + "KB");
				double usePercent = usage.getUsePercent() * 100D;
				// 文件系统资源的利用率
				System.out.println(" Usage = " + usePercent + "%");
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
			System.out.println(" DiskReads = " + usage.getDiskReads());
			System.out.println(" DiskWrites = " + usage.getDiskWrites());
		}
		return;
	}

//	public static void main(String[] args) throws Exception {
//		String str = System.getProperty("java.library.path");
//		System.out.println(str);
//
//		cpu();
//		memory();
//		disk();
//	}

}
