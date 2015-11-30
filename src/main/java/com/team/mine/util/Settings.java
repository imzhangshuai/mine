package com.team.mine.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Settings {

	@Value("${cdn}")
	private  String cdn;
	
	@Value("${pay.serverUrl}")
	private  String serverUrl; //
	
	@Value("${pay.merchantId}")
	private  String merchantId; //
	
	@Value("${pay.pickupUrl}")
	private  String pickupUrl ; //
	
	@Value("${pay.receiveUrl}")
	private  String receiveUrl; //
	
	@Value("${pay.version}")
	private  String version; //
	
	@Value("${pay.language}")
	private  String language; //
	
	@Value("${pay.inputCharset}")
	private  String inputCharset; //
	
	@Value("${pay.payType}")
	private  String payType; //
	
	@Value("${pay.signType}")
	private  String signType; //
	
	@Value("${pay.tradeNature}")
	private  String tradeNature; // GOODS表示实物类型，SERVICES表示服务类型
	
	@Value("${pay.key}")
	private  String key; // signMsg 签名key
	
	@Value("${pay.orderExpireDatetime}")
	private  String orderExpireDatetime ; // 订单过期时间
	
	@Value("${pay.certPath}")
	private  String certPath; // 证书目录
	
	@Value("${pay.orderCurrency}")
	private  String orderCurrency ; // 支付币种
	
	@Value("${pay.receiveHost}")
	private  String receiveHost; // 回调域名

	@Value("${pay.selectItemControl}")
	public  String selectItemControl; //会员购买入口控制

 	
    
	public String getCdn() {
		return cdn;
	}
	public void setCdn(String cdn) {
		this.cdn = cdn;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getPickupUrl() {
		return pickupUrl;
	}
	public void setPickupUrl(String pickupUrl) {
		this.pickupUrl = pickupUrl;
	}
	public String getReceiveUrl() {
		return receiveUrl;
	}
	public void setReceiveUrl(String receiveUrl) {
		this.receiveUrl = receiveUrl;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getInputCharset() {
		return inputCharset;
	}
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getTradeNature() {
		return tradeNature;
	}
	public void setTradeNature(String tradeNature) {
		this.tradeNature = tradeNature;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOrderExpireDatetime() {
		return orderExpireDatetime;
	}
	public void setOrderExpireDatetime(String orderExpireDatetime) {
		this.orderExpireDatetime = orderExpireDatetime;
	}
	public String getCertPath() {
		return certPath;
	}
	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}
	public String getOrderCurrency() {
		return orderCurrency;
	}
	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}
	public String getReceiveHost() {
		return receiveHost;
	}
	public void setReceiveHost(String receiveHost) {
		this.receiveHost = receiveHost;
	}
	public String getSelectItemControl() {
		return selectItemControl;
	}
	public void setSelectItemControl(String selectItemControl) {
		this.selectItemControl = selectItemControl;
	}
	
}
