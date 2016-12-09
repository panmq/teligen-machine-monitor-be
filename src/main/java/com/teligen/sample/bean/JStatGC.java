package com.teligen.sample.bean;

public class JStatGC {

	// 年轻代中第一个survivor（幸存区）的容量 （字节）
	private double s0c;

	// 年轻代中第二个survivor（幸存区）的容量 （字节）
	private double s1c;

	// 年轻代中第一个survivor（幸存区）目前已使用空间 （字节）
	private double s0u;

	// 年轻代中第二个survivor（幸存区）目前已使用空间 （字节）
	private double s1u;

	// 年轻代中Eden（伊甸园）的容量（字节）
	private double ec;

	// 年轻代中Eden（伊甸园）目前已使用空间 （字节）
	private double eu;

	// Old（年老代）的容量（字节）
	private double oc;

	// Old（年老代）目前已使用空间（字节）
	private double ou;

	// 永久代容量
	private double mc;

	// 永久代使用量
	private double mu;

	// 压缩类空间大小
	private double ccsc;

	// 压缩类空间使用大小
	private double ccsu;

	// 采样的年轻代GC次数
	private int ygc;

	// 采样的年轻代GC所用时间（s）
	private double ygct;

	// 采样的old代（全GC）GC次数
	private int fgc;

	// 采样的old代（全GC）GC所用时间（s）
	private double fgct;

	// 采样的GC用的总时间（s）
	private double gct;
	
	// for jdk7
	public JStatGC(double s0c, double s1c, double s0u, double s1u, double ec, double eu, double oc, double ou,
			int ygc, double ygct, int fgc, double fgct, double gct) {
		super();
		this.s0c = s0c;
		this.s1c = s1c;
		this.s0u = s0u;
		this.s1u = s1u;
		this.ec = ec;
		this.eu = eu;
		this.oc = oc;
		this.ou = ou;
		this.ygc = ygc;
		this.ygct = ygct;
		this.fgc = fgc;
		this.fgct = fgct;
		this.gct = gct;
	}

	// for jdk8
	public JStatGC(double s0c, double s1c, double s0u, double s1u, double ec, double eu, double oc, double ou,
			double mc, double mu, double ccsc, double ccsu, int ygc, double ygct, int fgc, double fgct, double gct) {
		super();
		this.s0c = s0c;
		this.s1c = s1c;
		this.s0u = s0u;
		this.s1u = s1u;
		this.ec = ec;
		this.eu = eu;
		this.oc = oc;
		this.ou = ou;
		this.mc = mc;
		this.mu = mu;
		this.ccsc = ccsc;
		this.ccsu = ccsu;
		this.ygc = ygc;
		this.ygct = ygct;
		this.fgc = fgc;
		this.fgct = fgct;
		this.gct = gct;
	}

	public double getS0c() {
		return s0c;
	}

	public void setS0c(double s0c) {
		this.s0c = s0c;
	}

	public double getS1c() {
		return s1c;
	}

	public void setS1c(double s1c) {
		this.s1c = s1c;
	}

	public double getS0u() {
		return s0u;
	}

	public void setS0u(double s0u) {
		this.s0u = s0u;
	}

	public double getS1u() {
		return s1u;
	}

	public void setS1u(double s1u) {
		this.s1u = s1u;
	}

	public double getEc() {
		return ec;
	}

	public void setEc(double ec) {
		this.ec = ec;
	}

	public double getEu() {
		return eu;
	}

	public void setEu(double eu) {
		this.eu = eu;
	}

	public double getOc() {
		return oc;
	}

	public void setOc(double oc) {
		this.oc = oc;
	}

	public double getOu() {
		return ou;
	}

	public void setOu(double ou) {
		this.ou = ou;
	}

	public double getMc() {
		return mc;
	}

	public void setMc(double mc) {
		this.mc = mc;
	}

	public double getMu() {
		return mu;
	}

	public void setMu(double mu) {
		this.mu = mu;
	}

	public double getCcsc() {
		return ccsc;
	}

	public void setCcsc(double ccsc) {
		this.ccsc = ccsc;
	}

	public double getCcsu() {
		return ccsu;
	}

	public void setCcsu(double ccsu) {
		this.ccsu = ccsu;
	}

	public int getYgc() {
		return ygc;
	}

	public void setYgc(int ygc) {
		this.ygc = ygc;
	}

	public double getYgct() {
		return ygct;
	}

	public void setYgct(double ygct) {
		this.ygct = ygct;
	}

	public int getFgc() {
		return fgc;
	}

	public void setFgc(int fgc) {
		this.fgc = fgc;
	}

	public double getFgct() {
		return fgct;
	}

	public void setFgct(double fgct) {
		this.fgct = fgct;
	}

	public double getGct() {
		return gct;
	}

	public void setGct(double gct) {
		this.gct = gct;
	}

	@Override
	public String toString() {
		return "JStatGC [s0c=" + s0c + ", s1c=" + s1c + ", s0u=" + s0u + ", s1u=" + s1u + ", ec=" + ec + ", eu=" + eu
				+ ", oc=" + oc + ", ou=" + ou + ", mc=" + mc + ", mu=" + mu + ", ccsc=" + ccsc + ", ccsu=" + ccsu
				+ ", ygc=" + ygc + ", ygct=" + ygct + ", fgc=" + fgc + ", fgct=" + fgct + ", gct=" + gct + "]";
	}

}
