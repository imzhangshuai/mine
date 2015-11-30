/***********************************************************************
 * Module:  Payment.java
 * Author:  ZhangShuai
 * Purpose: Defines the Class Payment
 ***********************************************************************/
package com.team.mine.domain;

import java.math.BigDecimal;

import com.allinpay.ets.client.RequestOrder;

@SuppressWarnings("serial")
public class Payment implements java.io.Serializable {

	/** 订单编号 */
	public java.lang.String orderNo;

	/** 参考user_account.account_id */
	public int accountId; //

	/** 参考itemType.id */
	public long itemId; //

	/** 支付方式 */
	public int payType = 0;

	/** 语言(1=utf-8) */
	public int language = 1;

	/** 商户号 */
	public java.lang.String merchantId;

	/** 支付金额 */
	public BigDecimal payAmount = BigDecimal.ZERO; //

	/** 订单金额 */
	public BigDecimal orderAmount = BigDecimal.ZERO;

	/** 订单描述 */
	public java.lang.String description;

	/** 支付币种(0,156=RMB;344=港币;840=美元) */
	public java.lang.String orderCurrency = "0";

	/** 订单交易时间 */
	public java.lang.String orderDatetime;

	/** 支付系统版本 */
	public java.lang.String version;

	/** 错误代码 */
	public java.lang.String errorCode; //

	/** 签名类型 */
	public int signType;

	/** 字符集1=utf8 */
	public int inputCharset = 1;

	/** 贸易类型(GOODS=实物,SERVICES=服务) */
	public TradeNature tradeNature;

	/** 支付结果 */
	public java.lang.String payResult; // 1:支付成功

	/** 生成的订单参数链接 */
	public java.lang.String strSrcMsg;

	/** 签名后的摘要 */
	public java.lang.String signMsg;

	public java.lang.String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public java.lang.String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(java.lang.String merchantId) {
		this.merchantId = merchantId;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getOrderCurrency() {
		return orderCurrency;
	}

	public void setOrderCurrency(java.lang.String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}

	public java.lang.String getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(java.lang.String orderDatetime) {
		this.orderDatetime = orderDatetime;
	}

	public java.lang.String getVersion() {
		return version;
	}

	public void setVersion(java.lang.String version) {
		this.version = version;
	}

	public java.lang.String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(java.lang.String errorCode) {
		this.errorCode = errorCode;
	}

	public int getSignType() {
		return signType;
	}

	public void setSignType(int signType) {
		this.signType = signType;
	}

	public int getInputCharset() {
		return inputCharset;
	}

	public void setInputCharset(int inputCharset) {
		this.inputCharset = inputCharset;
	}

	public TradeNature getTradeNature() {
		return tradeNature;
	}

	public void setTradeNature(TradeNature tradeNature) {
		this.tradeNature = tradeNature;
	}

	public java.lang.String getPayResult() {
		return payResult;
	}

	public void setPayResult(java.lang.String payResult) {
		this.payResult = payResult;
	}

	public java.lang.String getStrSrcMsg() {
		return strSrcMsg;
	}

	public void setStrSrcMsg(java.lang.String strSrcMsg) {
		this.strSrcMsg = strSrcMsg;
	}

	public java.lang.String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(java.lang.String signMsg) {
		this.signMsg = signMsg;
	}

	public long getPaymentOrderId() {
		return paymentOrderId;
	}

	public void setPaymentOrderId(long paymentOrderId) {
		this.paymentOrderId = paymentOrderId;
	}

	public java.lang.String getExt1() {
		return ext1;
	}

	public void setExt1(java.lang.String ext1) {
		this.ext1 = ext1;
	}

	public java.lang.String getExt2() {
		return ext2;
	}

	public void setExt2(java.lang.String ext2) {
		this.ext2 = ext2;
	}

	public java.sql.Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(java.sql.Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public java.sql.Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(java.sql.Timestamp payTime) {
		this.payTime = payTime;
	}

	/** 支付系统交易订单号 */
	public long paymentOrderId; //

	/** 扩展字段1 */
	public java.lang.String ext1;

	/** 扩展字段2 */
	public java.lang.String ext2;

	/** 插入时间 */
	public java.sql.Timestamp insertTime;

	/** 支付时间 */
	public java.sql.Timestamp payTime; //

	public Payment() {

	}

	/**
	 * 封装订单基本信息
	 * 
	 * @param order
	 */
	public Payment(RequestOrder order) {
		this.orderNo = order.getOrderNo();
		this.payType = order.getPayType();
		this.language = order.getLanguage();
		this.merchantId = order.getMerchantId();
		this.payAmount = new BigDecimal(order.getOrderAmount() / 100);
		this.orderAmount = new BigDecimal(order.getOrderAmount() / 100);
		this.description = order.getProductDesc();
		this.orderCurrency = order.getOrderCurrency();
		this.orderDatetime = order.getOrderDatetime();
		this.version = order.getVersion();
		this.signType = order.getSignType();
		this.inputCharset = order.getInputCharset();
		this.tradeNature = TradeNature.getTradeNature(order.getTradeNature());
		this.strSrcMsg = order.getSrc();
		this.signMsg = order.getSignMsg();
		this.ext1 = order.getExt1();
		this.ext2 = order.getExt2();
		this.insertTime = new java.sql.Timestamp(System.currentTimeMillis());
	}
}