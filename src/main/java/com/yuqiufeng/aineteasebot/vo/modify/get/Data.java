package com.yuqiufeng.aineteasebot.vo.modify.get;

import java.util.List;

public class Data {
	
	private int groupId;
	
	private String version;
	
	private String answer;
	
	private List<String> questions;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	
	

}
