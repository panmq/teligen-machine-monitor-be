package com.teligen.sample.bean;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InfluxDBBean {

	public static String RETIONSION_POLICY = "autogen";

	private InfluxDB influxDB;

	@Value(value = "${influxdb.ip:127.0.0.1}")
	private String influxDBIP;

	@Value(value = "${influxdb.port:8086}")
	private String influxDBPort;

	@Value(value = "${influxdb.username:root}")
	private String influxDBUserName;

	@Value(value = "${influxdb.password:root}")
	private String influxDBPassword;

	@Value(value = "${influxdb.name:monitordb}")
	private String influxDBName;

	public InfluxDB getInfluxDB() {
		if (influxDB == null) {
			influxDB = InfluxDBFactory.connect("http://" + influxDBIP + ":" + influxDBPort, influxDBUserName,
					influxDBPassword);
		}
		return influxDB;
	}

	public void setInfluxDB(InfluxDB influxDB) {
		this.influxDB = influxDB;
	}

	public String getInfluxDBIP() {
		return influxDBIP;
	}

	public void setInfluxDBIP(String influxDBIP) {
		this.influxDBIP = influxDBIP;
	}

	public String getInfluxDBPort() {
		return influxDBPort;
	}

	public void setInfluxDBPort(String influxDBPort) {
		this.influxDBPort = influxDBPort;
	}

	public String getInfluxDBUserName() {
		return influxDBUserName;
	}

	public void setInfluxDBUserName(String influxDBUserName) {
		this.influxDBUserName = influxDBUserName;
	}

	public String getInfluxDBPassword() {
		return influxDBPassword;
	}

	public void setInfluxDBPassword(String influxDBPassword) {
		this.influxDBPassword = influxDBPassword;
	}

	public String getInfluxDBName() {
		return influxDBName;
	}

	public void setInfluxDBName(String influxDBName) {
		this.influxDBName = influxDBName;
	}

}
