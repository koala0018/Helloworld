package com.oracle.vo;

import java.util.Date;

public class News {

	private int nid;
	private String title;
	private String author;
	private Date pubdate;
	private String content;
	private int lockflag;
	public News(){}
	
	public News(int nid, String title, String author, Date pubdate, String content, int lockflag) {
		super();
		this.nid = nid;
		this.title = title;
		this.author = author;
		this.pubdate = pubdate;
		this.content = content;
		this.lockflag = lockflag;
	}

	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLockflag() {
		return lockflag;
	}
	public void setLockflag(int lockflag) {
		this.lockflag = lockflag;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", author=" + author + ", pubdate=" + pubdate + ", content="
				+ content + ", lockflag=" + lockflag + "]";
	}
	
}
