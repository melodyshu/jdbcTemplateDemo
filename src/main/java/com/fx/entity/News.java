package com.fx.entity;

public class News {

	private String type;
	private String img;
	private String newsTitle;
	private String newsTime;
	private String newsSpan;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsTime() {
		return newsTime;
	}
	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}
	public String getNewsSpan() {
		return newsSpan;
	}
	public void setNewsSpan(String newsSpan) {
		this.newsSpan = newsSpan;
	}
	@Override
	public String toString() {
		return "News [type=" + type + ", img=" + img + ", newsTitle=" + newsTitle + ", newsTime=" + newsTime
				+ ", newsSpan=" + newsSpan + "]";
	}
	
	
}
