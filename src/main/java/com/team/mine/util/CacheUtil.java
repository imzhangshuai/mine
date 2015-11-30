package com.team.mine.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.team.mine.common.SysConstants;
import com.team.mine.domain.UserAccount;
import com.team.mine.service.UserService;

public class CacheUtil {

	/** 图片验证码缓存时长 */
	public static final String VERIFY_CODE_CACHE_TIME = "1mn";

	/** 短信验证码缓存时长 */
	public static final String SMS_CODE_CACHE_TIME = "10mn";

	/** 用户登录会话时长 */
	public static final String USR_LOGIN_CACHE_TIME = "30mn";
	
	static UserService userService;
	
	public void setUserService(UserService userService) {
		CacheUtil.userService = userService;
	}

	/***
	 * 获得当前缓存中的user
	 * 
	 * @author ZhangShuai
	 * @version 1.0
	 * @created 2015年5月23日 下午4:28:08
	 * @return
	 */
	public static UserAccount getCurrUserAccount(HttpServletRequest request) {
		/* 定时任务下，无法获取当前登陆用户 */
		if (request.getSession() == null) {

			return null;
		}
		String encryString = request.getSession().getId();
		if (StringUtils.isBlank(encryString)) {
			return null;
		}
		
		Object obj=request.getSession().getAttribute(encryString+SysConstants.LOGIN_CACHE_AFTFIX);

		return obj == null ? null: (UserAccount)obj;

		// 被管理员锁定，退出登陆
		// if (user.isLocked) {
		// user.removeCurrUser();
		//
		// return null;
		// }

	}

	/**
	 * 设置缓存中当前用户的信息
	 * 
	 * @param user
	 */
	public static void setCurrentUser(HttpServletRequest request,UserAccount user) {
		request.getSession().setAttribute(request.getSession().getId()+SysConstants.LOGIN_CACHE_AFTFIX, user);
	}

	/***
	 * 更新当前用户缓存
	 */
	public static void updateCurrentUser(HttpServletRequest request) {
		UserAccount user = userService.findById(getCurrUserAccount(request).getAccountId());
		request.getSession().setAttribute(SysConstants.LOGIN_CACHE_AFTFIX, user);
	}

	/**
	 * 删除缓存
	 * 
	 * @param key
	 */
	public static void remove(HttpServletRequest request,String key) {
		request.getSession().removeAttribute(key);
	}

}
