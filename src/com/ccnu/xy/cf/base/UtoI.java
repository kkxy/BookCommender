package com.ccnu.xy.cf.base;

import java.util.ArrayList;

public class UtoI {
	
	private Integer userid;//�û�id
	private ArrayList<Integer> item = new ArrayList<>();//��Ʒ�б�
	
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
