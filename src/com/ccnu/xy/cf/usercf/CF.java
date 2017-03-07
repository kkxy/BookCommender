package com.ccnu.xy.cf.usercf;

import java.util.ArrayList;
import java.util.HashSet;

class CF {
	private ArrayList<UtoI> result = new ArrayList<>();
	
	public void process(UtoU utou) {
		ArrayList<UserMap> umlist = utou.getUsermap();
		ArrayList<UtoI> utoilist = utou.getUtou();
		
		for (int i = 0; i < umlist.size(); i++) {
			UtoI utoi = utoilist.get(i);
			UserMap um = umlist.get(i);
			
			
			Integer userid = um.getUserid();
			UtoI usertoitem = new UtoI();
			usertoitem.setUserid(userid);
			HashSet<Integer> useritem = new HashSet<>();
			
			ArrayList<Integer> it = utoi.getItem();
			for (int j = 0; j < it.size(); j++) {
				useritem.add(it.get(j));
			}
			
			HashSet<Integer> itemall = new HashSet<>();
			ArrayList<UserRelate> ur = um.getUserinterest();
			for (int j = 0; j < ur.size(); j++) {
				Integer friendid = ur.get(j).getUserid();
				ArrayList<Integer> frienditem = utou.finditem(friendid); 
				for (int k = 0; k < frienditem.size(); k++) {
					if (!useritem.contains(frienditem.get(k))) {
						itemall.add(frienditem.get(k));
					}
				}
			}
			
			for (Integer j: itemall) {
				usertoitem.addItem(j);
			}
			
			result.add(usertoitem);
		}
	}
	
	public void usercf(Integer userid) {
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getUserid() == userid) {
				System.out.print(userid + ": ");
				ArrayList<Integer> item = result.get(i).getItem();
				for (int j = 0; j < item.size(); j++) {
					System.out.print(item.get(j) + " ");
				}
			}
		}
	}
}
