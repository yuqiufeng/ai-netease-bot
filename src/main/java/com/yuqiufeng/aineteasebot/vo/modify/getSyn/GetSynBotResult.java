package com.yuqiufeng.aineteasebot.vo.modify.getSyn;

import java.util.List;

import com.yuqiufeng.aineteasebot.vo.base.BotResult;

public class GetSynBotResult extends BotResult{

	private List<List<String>> ret_result;

	public List<List<String>> getRet_result() {
		return ret_result;
	}

	public void setRet_result(List<List<String>> ret_result) {
		this.ret_result = ret_result;
	}
	
	
}
