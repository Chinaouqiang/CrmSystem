package com.crm.tools;

public class StringUtils {
	private StringUtils() {
	}

	public static boolean isBlank(String s) {
		boolean b = false;
		if (null == s || s.trim().equals("")) {
			b = true;
		}
		return b;
	}
	
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

}
