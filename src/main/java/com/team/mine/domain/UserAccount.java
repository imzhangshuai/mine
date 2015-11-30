/***********************************************************************
 * Module:  UserAccount.java
 * Author:  ZhangShuai
 * Purpose: Defines the Class UserAccount
 ***********************************************************************/
package com.team.mine.domain;

@SuppressWarnings("serial")
public class UserAccount implements java.io.Serializable {

	/** 用户ID */
	private Integer accountId;

	/** 用户登录名(手机号或身份证) */
	private java.lang.String accountName;

	/** 用户登录密码 */
	private java.lang.String password;

	/** 用户状态,ENABLED:启用;BLACKLIST:黑名单;DISABLED:停用; */
	private UserStatus status;

	/** 交易密码(不能与登录密码同) */
	private java.lang.String tradePassword;

	/** 创建时间 */
	private java.util.Date createTime;

	/** 最后登录时间 */
	private java.util.Date latestLoginTime;

	/** 昵称 */
	private java.lang.String nickName;

	/** 用户头像 */
	private java.lang.String userPhoto;

	/** 最大登录数 */
	private int maxLogin;

	/** 用户会员等级 */
	private Integer vipLevel;

	/** 会员过期时间 */
	private java.util.Date vipInvalidTime;
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public java.lang.String getAccountName() {
		return accountName;
	}

	public void setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public java.lang.String getTradePassword() {
		return tradePassword;
	}

	public void setTradePassword(java.lang.String tradePassword) {
		this.tradePassword = tradePassword;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getLatestLoginTime() {
		return latestLoginTime;
	}

	public void setLatestLoginTime(java.util.Date latestLoginTime) {
		this.latestLoginTime = latestLoginTime;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	public java.lang.String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(java.lang.String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public int getMaxLogin() {
		return maxLogin;
	}

	public void setMaxLogin(int maxLogin) {
		this.maxLogin = maxLogin;
	}

	public Integer getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public java.util.Date getVipInvalidTime() {
		return vipInvalidTime;
	}

	public void setVipInvalidTime(java.util.Date vipInvalidTime) {
		this.vipInvalidTime = vipInvalidTime;
	}

}