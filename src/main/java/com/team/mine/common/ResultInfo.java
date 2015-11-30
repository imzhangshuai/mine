package com.team.mine.common;

import java.io.Serializable;
import java.util.Map;

/**
 * 结果提示信息
 * @author ZhangShuai
 *
 */
@SuppressWarnings("serial")
public class ResultInfo implements Serializable {

	/**代码*/
	public int code;
	
	/**提示信息*/
	public String msg;
	
	/**其他数据*/
	public Map<String,Object> data;
	
	public ResultInfo(){
		
	}
	public ResultInfo(int code,String msg){
		set(code,msg);
	}
	
	public void set(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public void set(int code,String msg,Map<String,Object>data){
		this.code=code;
		this.msg=msg;
		this.data=data;
	}
	
	public void clear(){
		this.code=0;
		this.msg="";
		this.data=null;
	}
}
