package com.yuqiufeng.aineteasebot.vo.modify.addBatch;

import java.util.List;

import com.yuqiufeng.aineteasebot.vo.base.BotResult;

public class AddBatchBotResult extends BotResult{

	private List<AddBatchRetResult> ret_result;

	public List<AddBatchRetResult> getRet_result() {
		return ret_result;
	}

	public void setRet_result(List<AddBatchRetResult> ret_result) {
		this.ret_result = ret_result;
	}
	
}
