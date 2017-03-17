package com.yuqiufeng.aineteasebot.vo.search;

import java.util.List;

public class SearchRetResult {
	
	private String query;
	
	private int answer_type;
	
	private List<Match> match;
	
	public SearchRetResult() {
	}

	public SearchRetResult(String query,int answer_type,List<Match> match) {
		this.query = query;
		this.answer_type = answer_type;
		this.match = match;
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getAnswer_type() {
		return answer_type;
	}

	public void setAnswer_type(int answer_type) {
		this.answer_type = answer_type;
	}

	public List<Match> getMatch() {
		return match;
	}

	public void setMatch(List<Match> match) {
		this.match = match;
	}
	
}
