package com.ccnu.xy.cf.usercf;

import java.util.ArrayList;
import java.util.Comparator;

public class UserMap {
	
	private Integer userid;
	private ArrayList<UserRelate> userinterest = new ArrayList<>();
	
	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public ArrayList<UserRelate> getUserinterest() {
		return userinterest;
	}
	
	public void setUserinterest(ArrayList<UserRelate> userinterest) {
		this.userinterest = userinterest;
	}
	
	public void sort() {
		userinterest.sort(new Comparator<UserRelate>() {
			public int compare(UserRelate u1, UserRelate u2) {
				if (u1.getRelate() > u2.getRelate()) {
					return -1;
				}
				else if (u1.getRelate() < u2.getRelate()){
					return 1;
				}
				else {
					return 0;
				}
			}
		});
	}
	
	
}
