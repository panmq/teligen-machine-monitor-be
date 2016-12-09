package com.teligen.sample.util;

public class StringUtils {

	public static double parseDouble(String str) {
		if (str.isEmpty() || "-".equals(str)) {
			return 0;
		} else {
			return Double.parseDouble(str);
		}
	}

	public static int parseInt(String str) {
		if (str.isEmpty() || "-".equals(str)) {
			return 0;
		} else {
			return Integer.parseInt(str);
		}
	}

}
