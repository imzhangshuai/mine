package com.team.mine.common;

public class RegExpHelper {

	/**大陆手机号码正则**/
	public static final String MOBILE_REGEXP = "^(1[3-8]{1}\\d{1})(\\d{4})(\\d{4})";

	/**
	 * 手机号格式验证
	 * @param mobile
	 * @return
	 */
	public static boolean regMobile(String mobile) {
		if (null != mobile) {
			return mobile.matches(MOBILE_REGEXP);
		}
		return false;
	}

	/***
	 * 手机号码中间四位隐藏
	 * @param mobile
	 * @return
	 */
	public static String mixMiddleMobile(String mobile) {
		if (regMobile(mobile)) {
			return mobile.replaceAll(MOBILE_REGEXP, "$1****$3");
		}
		return "";
	}

//	
//	public static void main(String[] args) {
//		System.out.println(mixMiddleMobile("13234554555"));
//	}
}
