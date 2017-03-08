package com.ccnu.xy.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RecoBookBase implements Serializable{
	private int userid;
	private int bookid;
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
}
