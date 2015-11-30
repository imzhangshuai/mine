package com.team.mine.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOStreamHelper {

	
	/**
	 * input 转 String
	 * @param input
	 * @return
	 */
	public static String inputToString(InputStream input){
		StringBuilder body=new StringBuilder();
		BufferedReader stream= new BufferedReader(new InputStreamReader(input));
		
		String line="";
		try {
			while((line=stream.readLine())!=null){
				body.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body.toString();
	}
	
}
