package com.nest.entity;

public class ShowEntity extends Entity{
	private String title;
	private String content;
	
	public ShowEntity (String title, String content){
		this.content = content;
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
