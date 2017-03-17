package com.yuqiufeng.aineteasebot.vo.base;

//网易机器人接口的返回对象
public class BotResult {

	//状态码
	private int ret_code;
	//状态码描述
	private String ret_msg;

	public BotResult(){}
	
	public BotResult(int ret_code,String ret_msg) {
		this.ret_code = ret_code;
		this.ret_msg = ret_msg;
	}
	
	
	public int getRet_code() {
		return ret_code;
	}

	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}
	
	
}
