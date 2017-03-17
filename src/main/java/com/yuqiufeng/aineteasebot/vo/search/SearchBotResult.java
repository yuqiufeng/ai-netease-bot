package com.yuqiufeng.aineteasebot.vo.search;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.yuqiufeng.aineteasebot.vo.base.BotResult;

/**
 * search接口返回对象
 * @author User_yqf
 *
 */
public class SearchBotResult extends BotResult {
	
	private SearchRetResult ret_result;
	
	public SearchBotResult() {
	}
	public SearchBotResult(int ret_code,String ret_msg,SearchRetResult ret_result) {
		super(ret_code,ret_msg);
		this.ret_result = ret_result;
	}
	
	public SearchRetResult getRet_result() {
		return ret_result;
	}
	public void setRet_result(SearchRetResult ret_result) {
		this.ret_result = ret_result;
	}
	
	public static void main(String[] args) {
//		String sss = "{\"ret_code\":1000,\"ret_msg\":\"search accomplished\",\"ret_result\":{\"query\":\"秋风长得咋样2\",\"match\":[{\"question\":\"秋风长得咋样2\",\"answer\":\"秋风长得很帅\",\"score\":0,\"groupId\":\"1549218\"}],\"answer_type\":\"1\"}}";
//		JSON.parse(sss);
//		JSON.parseObject(sss,SearchBotResult.class);
//		
//		System.out.println();
		
		List<Match> match = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Match m = new Match("question-"+i, "answer-"+i, "score-"+i, "groupId-"+i);
			match.add(m);
		}
		JSON.toJSONString(match);
		SearchRetResult ret_result = new SearchRetResult("query-A", 101, match);
		JSON.toJSONString(ret_result);
		SearchBotResult o = new SearchBotResult(1000,"ok",ret_result);
		
		String json = JSON.toJSONString(o);
		System.out.println(json);
		Object o2 = JSON.parseObject(json);
		
		SearchBotResult o3 = JSON.parseObject(json,SearchBotResult.class);
		System.out.println(1);
		
	}
}
