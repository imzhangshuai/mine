package com.team.mine.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 发送短信工具类
 * 
 */
public class SMSUtil {


	/**
	 * 发送短信
	 * 
	 * @param mobile
	 * @param content
	 * @param info
	 */
	public static void sendSMS(String mobile, String content,String sms_uid, String sms_pwd , ResultInfo info) {
		info.clear();

		if (StringUtils.isEmpty(content)) {
			info.set(-1, "请输入短信内容！");
			return;
		}

		String resultStr = "";
		int resultCode = 0;

		try {
			resultStr = postSendSMS(sms_uid, sms_pwd, mobile, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultStr.contains(SmsStatus.send_success.code + "")) {
			resultCode = SmsStatus.send_success.code;
		}
		 info.set(resultCode>0?1:0,resultCode>0?"短信发送成功,请注意查收":"短信发送失败...错误代码："+resultStr);
	}

	/**
	 * 发送校验码
	 * 
	 * @param mobile
	 * @param info
	 */
	public static void sendCode(HttpServletRequest request,String mobile, String sms_uid,String sms_pwd,ResultInfo info) {
		info.clear();
		int randomCode = new Random().nextInt(899999) + 100000;// 6位
		String content = "尊敬的客户您好，欢迎使用323尚趋势科技产品" + "，您的验证码是:" + randomCode + "，有效期10分钟。";
		String resultStr = "";

		try {
			resultStr = postSendSMS(sms_uid, sms_pwd, mobile, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean isSendSuccess = resultStr.contains(SmsStatus.send_success.code+"");
		if(isSendSuccess){
			request.getSession().setAttribute(mobile+SysConstants.REG_SMS_CACHE, randomCode + "");
		}
		info.set( isSendSuccess? 1 : 0, isSendSuccess ? "短信验证码发送成功,请注意查收" : "短信发送失败...错误代码："+resultStr );
	}

	/**
	 * post方式请求短信平台 发送短信
	 * @param uid 		用户账号
	 * @param pwd		MD5位32密码
	 * @param mobile	号码
	 * @param content	内容
	 * @return
	 * @throws Exception
	 */
	public static String postSendSMS(String uid, String pwd, String mobile, String content) throws Exception {
		// http://api.cnsms.cn/?ac=send&uid=用户账号&pwd=MD5位32密码&mobile=号码&content=内容
		String parameterData = "ac=send&uid=" + uid + "&pwd=" + pwd + "&mobile=" + mobile + "&content=" + content 
				+ "&encode=utf8";

		URL localURL = new URL("http://api.cnsms.cn/");
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));

		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		try {
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);

			outputStreamWriter.write(parameterData.toString());
			outputStreamWriter.flush();

			if (httpURLConnection.getResponseCode() >= 300) {
				throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
			}

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}
		}
		return resultBuffer.toString();
	}

	public static void main(String[] args) throws Throwable {
//		System.out.println(postSendSMS("118308", "59e6d2a908c8399df5781c505ccc3856", "13728878827", "123123qwe"));
	}
	
}
