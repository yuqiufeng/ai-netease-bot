package com.yuqiufeng.aineteasebot.vo.apply;

import com.alibaba.fastjson.JSON;
import com.yuqiufeng.aineteasebot.vo.base.BotResult;

/**
 *	apply接口返回对象
 */
public class ApplyBotResult extends BotResult {
	
	//token
	private String ret_result;
	
	public ApplyBotResult() {}

	public ApplyBotResult(int ret_code, String ret_msg) {
		super(ret_code, ret_msg);
	}

	public ApplyBotResult(int ret_code,String ret_msg,String ret_result){
		super(ret_code, ret_msg);
		this.ret_result = ret_result;
	}
	
	public String getRet_result() {
		return ret_result;
	}

	public void setRet_result(String ret_result) {
		this.ret_result = ret_result;
	}

	public static void main(String[] args) {
		String json = "";
		
		ApplyBotResult obj = new ApplyBotResult(1000,"ok","tokenStr");
		
		json = JSON.toJSONString(obj);
		
		System.out.println(json);
		
		Object o = JSON.parseObject(json);
		
		ApplyBotResult o2 = JSON.parseObject(json,ApplyBotResult.class);
		
		System.out.println(o2);
		
	}

}
