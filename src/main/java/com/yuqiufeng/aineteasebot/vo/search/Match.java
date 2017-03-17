package com.yuqiufeng.aineteasebot.vo.search;

public class Match implements Comparable<Match>{

	private String question;
	
	private String answer;
	
	private String score;
	
	private String groupId;
	
	public Match() {
	}
	
	public Match(String question,String answer,String score,String groupId){
		this.question = question;
		this.answer = answer;
		this.score = score;
		this.groupId = groupId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	@Override
	public int compareTo(Match o) {
		if (Float.valueOf(this.score) > Float.valueOf(o.score)) {
			return 1;
		}
		return -1;
	};

}
