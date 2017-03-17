package com.yuqiufeng.aineteasebot;

public enum Token {

	NETEASE;
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	//申请token
	public void applyValue(String prev){
		if (null == value || value == prev) {
			synchronized(this) {
				if (null == value || value == prev) {
					//调用网易token申请接口	赋值给value	TODO
					
				}
			}
		}
	}
}
