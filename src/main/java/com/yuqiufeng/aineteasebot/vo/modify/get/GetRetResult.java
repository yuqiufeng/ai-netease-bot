package com.yuqiufeng.aineteasebot.vo.modify.get;

import java.util.List;

public class GetRetResult {

	private String cursor;
	
	private List<Data> data;

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	
	
}
