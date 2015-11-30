package com.team.mine.common;

public enum SmsStatus {

	/***100发送成功*/
	send_success(100,"发送成功"),
	
	/***101验证失败*/
	verify_failed(101,"验证失败"),
	
	/***102短信不足*/
	sms_shortage(102,"短信不足"),
	
	/***103操作失败*/
	operate_failed(103,"操作失败"),
	
	/***105验证失败*/
	illegal_char(104,"验证失败"),
	
	/***105内容过多*/
	content_too_long(105,"内容过多"),
	
	/***106号码太多*/
	mobileNum_too_many(106,"号码太多"),
	
	/***107频率过快*/
	frequency_too_fast(107,"频率过快"),
	
	/***108号码内容空*/
	mobileNum_null(108,"号码内容空"),
	
	/***109帐号冻结*/
	account_freeze(109,"帐号冻结"),
	
	/***110禁止频繁多条发送*/
	deny_send_many_single(110,"禁止频繁多条发送"),
	
	/***111系统暂停发送*/
	sys_stop_send(111,"系统暂停发送"),
	
	/***112号码错误*/
	mobileNum_error(112,"号码错误"),
	
	/***113定时时间格式不对*/
	timer_format_error(113,"定时时间格式不对"),
	
	/***114帐号被锁10分钟*/
	account_locked(114,"帐号被锁10分钟"),
	
	/***115连接失败*/
	connect_failed(115,"连接失败"),
	
	/***116禁止接口发送*/
	deny_interface_send(116,"禁止接口发送"),
	
	/***117绑定ip错误*/
	bind_ip_error(117,"绑定ip错误"),
	
	/***120系统升级*/
	sys_upload(120,"系统升级");
	
	public int code;
	public String text;
	
	SmsStatus(int code,String text){
		this.code=code;
		this.text=text;
	}
	
	/**
	 * 根据code 获取 文本
	 * @param code
	 * @return
	 */
	public static String getText(int code){
		for(SmsStatus status: SmsStatus.values()){
			if(status.code==code){
				return status.text;
			}
		}
		return "";
	}
	
}
