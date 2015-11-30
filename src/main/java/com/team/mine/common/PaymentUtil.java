package com.team.mine.common;

import com.allinpay.ets.client.RequestOrder;
import com.team.mine.domain.Payment;

public class PaymentUtil {

	/**
	 * 通联支付接口参数封装
	 * @param now
	 * @param serverUrl
	 * @param payerTelephone
	 * @param payerEmail
	 * @param payerName
	 * @param itemId
	 * @param key
	 * @param version
	 * @param language
	 * @param inputCharset
	 * @param merchantId
	 * @param pickupUrl
	 * @param receiveUrl
	 * @param payType
	 * @param signType
	 * @param tradeNature
	 * @param orderNo
	 * @param orderAmount
	 * @param orderDatetime
	 * @param orderCurrency
	 * @param orderExpireDatetime
	 * @param payerIDCard
	 * @param pid
	 * @param productName
	 * @param productId
	 * @param productNum
	 * @param productPrice
	 * @param productDesc
	 * @param ext1
	 * @param ext2
	 * @param extTL
	 * @param issuerId
	 * @param pan
	 * @param certPath 证书路径
	 * @return
	 */
	public static RequestOrder setRequestOrder(String now,String serverUrl,String payerTelephone,String payerEmail,String payerName,String itemId,
			String key ,String version,String language,String inputCharset,String merchantId ,String pickupUrl ,
			String receiveUrl,String payType ,String signType ,String tradeNature,String orderNo,String orderAmount,
			String orderDatetime ,String orderCurrency,String orderExpireDatetime ,String payerIDCard,String pid ,String productName ,String productId,String productNum,
			String productPrice ,String productDesc,String ext1 ,String ext2 ,String extTL,String issuerId ,String pan,String certPath
	){
		// 若直连telpshx渠道，payerTelephone、payerName、payerIDCard、pan四个字段不可为空
				// 其中payerIDCard、pan需使用公钥加密（PKCS1格式）后进行Base64编码
				/*
				 * if(null!=payerIDCard&&!"".equals(payerIDCard)){ try{ payerIDCard =
				 * SecurityUtil.encryptByPublicKey("C:\\TLCert-test.cer", payerIDCard);
				 * //payerIDCard =
				 * SecurityUtil.encryptByPublicKey("/opt/conf/TLCert.cer", payerIDCard);
				 * }catch(Exception e){ e.printStackTrace(); } }
				 */
				if (null != pan && !"".equals(pan)) {
					try {
						pan = com.allinpay.ets.client.SecurityUtil.encryptByPublicKey(certPath, pan);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				// 构造订单请求对象，生成signMsg。
				RequestOrder requestOrder = new RequestOrder();
				if (null != inputCharset && !"".equals(inputCharset)) {
					requestOrder.setInputCharset(Integer.parseInt(inputCharset));
				}
				requestOrder.setPickupUrl(pickupUrl);
				requestOrder.setReceiveUrl(receiveUrl);
				requestOrder.setVersion(version);
				if (null != language && !"".equals(language)) {
					requestOrder.setLanguage(Integer.parseInt(language));
				}
				requestOrder.setSignType(Integer.parseInt(signType));
				requestOrder.setPayType(Integer.parseInt(payType));
				requestOrder.setIssuerId(issuerId);
				requestOrder.setMerchantId(merchantId);
				requestOrder.setPayerName(payerName);
				requestOrder.setPayerEmail(payerEmail);
				requestOrder.setPayerTelephone(payerTelephone);
				requestOrder.setPayerIDCard(payerIDCard);
				requestOrder.setPid(pid);
				requestOrder.setOrderNo(orderNo);
				requestOrder.setOrderAmount(Long.parseLong(orderAmount));
				requestOrder.setOrderCurrency(orderCurrency); // 默认为人民币;0,156表示人民币;344表示港币;840表示美元
				requestOrder.setOrderDatetime(orderDatetime);
				requestOrder.setOrderExpireDatetime(orderExpireDatetime);
				requestOrder.setProductName(productName);
				if (null != productPrice && !"".equals(productPrice)) {
					requestOrder.setProductPrice(Long.parseLong(productPrice));
				}
				if (null != productNum && !"".equals(productNum)) {
					requestOrder.setProductNum(Integer.parseInt(productNum));
				}
				requestOrder.setProductId(productId);
				requestOrder.setProductDesc(productDesc);
				requestOrder.setExt1(ext1);
				requestOrder.setExt2(ext2);
				requestOrder.setExtTL(extTL);// 通联商户拓展业务字段，在v2.2.0版本之后才使用到的，用于开通分账等业务
				requestOrder.setPan(pan);
				requestOrder.setTradeNature(tradeNature);
				requestOrder.setKey(key); // key为MD5密钥，密钥是在通联支付网关会员服务网站上设置。
				return requestOrder;
	}
	
	
	public static RequestOrder payInfoToRequestOrder(Payment pay){
		RequestOrder order = new RequestOrder();
		order.setOrderNo(pay.orderNo);
		order.setPayType(pay.payType);
		order.setLanguage(pay.language);
		order.setMerchantId(pay.merchantId);
		order.setOrderAmount(pay.payAmount.longValue()*100);
		order.setOrderAmount(pay.orderAmount.longValue()*100);
		order.setProductDesc(pay.description);
		order.setOrderCurrency(pay.orderCurrency);
		order.setOrderDatetime(pay.orderDatetime);
		order.setVersion(pay.version);
		order.setSignType(pay.signType);
		order.setInputCharset(pay.inputCharset);
		order.setTradeNature(pay.tradeNature.getTradeNature());
		order.setSignMsg(pay.signMsg);
		order.setExt1(pay.ext1);
		order.setExt2(pay.ext2);
		return order;
	}

}
