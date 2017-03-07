package com.ccnu.xy.cf.usercf;

import java.util.ArrayList;

public class UtoI {
	
	private Integer userid;//用户id
	private ArrayList<Integer> item = new ArrayList<>();//物品列表
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public ArrayList<Integer> getItem() {
		return item;
	}
	public void setItem(ArrayList<Integer> item) {
		this.item = item;
	}
	public void addItem(Integer it) {
		item.add(it);
	}
	
	public void out() {
		System.out.print(userid + " ");
		for(int i = 0; i < item.size(); i++) {
			System.out.print(item.get(i) + " ");
		}
		System.out.println();
	}
	
}
