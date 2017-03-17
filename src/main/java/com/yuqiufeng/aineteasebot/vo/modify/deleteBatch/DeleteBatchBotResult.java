package com.yuqiufeng.aineteasebot.vo.modify.deleteBatch;

import java.util.List;
import java.util.Map;

import com.yuqiufeng.aineteasebot.vo.base.BotResult;

public class DeleteBatchBotResult extends BotResult{

	private List<Map<String, Object>> ret_result;

	public List<Map<String, Object>> getRet_result() {
		return ret_result;
	}

	public void setRet_result(List<Map<String, Object>> ret_result) {
		this.ret_result = ret_result;
	}

	
}
