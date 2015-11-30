package com.team.mine.common;

import java.util.HashMap;
import java.util.Map;

public class SysConstants {

	/** 注册验证短信cache标记常量 */
	public static final String REG_SMS_CACHE = "-reg-sms-cache";

	/** 登录cache标记常量 */
	public static final String LOGIN_CACHE_AFTFIX = "-login-cache";

	/** 管理员登录cache标记常量 */
	public static final String ADMIN_LOGIN_CACHE = "-admin-lgoin-cache";
	
	/** 后台验证码cache标记常量 */
	public static final String ADMIN_VERIFY_CODE_PREFIX = "-admin-verifyCode-cache";

	/** 验证码cache标记常量 */
	public static final String VERIFY_CODE_PREFIX = "-verifyCode-cache";

	/** 验证码cache标记常量 */
	public static final String USR_PAY_TIME_AFTFIX = "-payment";

	/*** 默认收藏夹封面图片 */
	public static final String DEFAULT_FOLDER_IMG = "/public/images/show_pic/folder_pic_01.jpg";

	/*** 默认收藏夹名称 */
	public static final String DEFAULT_FOLDER_NAME = "默认收藏夹";
	
	/*** 默认超级管理员号码 */
	public static final int DEFAULT_ADMIN_GROUP = 88888;

	/*** 购买男装区成功 */
	public static final int PAY_SUCC_MALE = 1;

	/*** 购买男装区成功 */
	public static final int PAY_SUCC_FEMALE = 2;

	/*** 购买男女装区成功 */
	public static final int PAY_SUCC_ALL = 3;

	public static final int PAGE_SIZE = 24;

	/*** 浏览 */
	public static final int POWER_VIEW = 0;

	/*** 下载 */
	public static final int POWER_DOWNLOAD = 1;

	/*** 下载 */
	public static final int POWER_ALL = 2;

	@SuppressWarnings("serial")
	public static final Map<Integer, String> powerMap = new HashMap<Integer, String>() {
		{
			put(POWER_VIEW, "浏览");
			put(POWER_DOWNLOAD, "下载");
			put(POWER_ALL, "全部");
		}
	};
}
