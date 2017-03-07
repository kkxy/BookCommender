package com.ccnu.xy.cf.usercf;

public class UserRelate {
	
	private Integer userid;
	private double relate;
	
	public UserRelate() {
		
	}
	
	public UserRelate(Integer userid, double relate) {
		this.userid = userid;
		this.relate = relate;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public double getRelate() {
		return relate;
	}
	public void setRelate(double relate) {
		this.relate = relate;
	}
	
}
