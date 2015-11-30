package com.team.mine.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ClientRequestUtil {

	
	/***
	 * 模拟Post请求
	 * @param url
	 * @param parameterData
	 * @return
	 * @throws Throwable
	 */
	public static String postRequest(String url,String parameterData) throws Throwable{
		URL localURL = new URL(url);
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
	
	
	public static Map<String,Object> paramToMap(String paramData){
		Map<String,Object> map=new HashMap<String,Object>();
		if(paramData.matches(".*=.*[&]{0,}")){
			String params[]=paramData.split("&");
			String paramEntry[]=null;
			for(String param:params){
				if(param.contains("=")){
					paramEntry=param.split("=");
					map.put(paramEntry[0], paramEntry[1]);
				}
			}
		}
		return map;
	}
	
//	public static void main(String[] args) {
//		String parms="abc=1&adfadfa=1";
//		for(Map.Entry<String, Object> entry:paramToMap(parms).entrySet()){
//			System.out.println(entry.getKey()+"\t"+entry.getValue());
//		}
//	}
}
