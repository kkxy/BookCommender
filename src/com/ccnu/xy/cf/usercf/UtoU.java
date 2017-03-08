package com.ccnu.xy.cf.usercf;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.ccnu.xy.cf.base.UtoI;

public class UtoU {
	
	private ArrayList<UtoI> utou = new ArrayList<>(); 
	private ArrayList<UserMap> usermap = new ArrayList<>();
	
	public ArrayList<UserMap> getUsermap() {
		return usermap;
	}

	public void setUsermap(ArrayList<UserMap> usermap) {
		this.usermap = usermap;
	}

	public void setUtou(ArrayList<UtoI> utou) {
		this.utou = utou;
	}

	public void in(String path){
		try{
			File f = new File(path);
			if (!f.exists()) {
				System.out.println("file not found!");
				return;
			}
			Scanner s = new Scanner(f);
			while(s.hasNextLine()) {
				UtoI utoi = new UtoI();
				
				int userid = s.nextInt();
				int num = s.nextInt();
				for (int i = 0; i < num; i++) {
					int itemid = s.nextInt();
					utoi.addItem(itemid);
				}
				utoi.setUserid(userid);
				
				utou.add(utoi);
			}
			s.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public ArrayList<UtoI> getUtou() {
		return utou;
	}

	public void out() {
		for (int i = 0; i < utou.size(); i++) {
			utou.get(i).out();
		}
	}
	
	public void userrelate() {
		for (int i = 0; i < utou.size(); i++) {
			
			UserMap um = new UserMap();
			ArrayList<UserRelate> userrelate = new ArrayList<>();
			UtoI useri = utou.get(i);
			um.setUserid(useri.getUserid());
			
			for (int j = 0; j < utou.size(); j++) {
				
				int co = 0;
				double relate;
				UtoI userj = utou.get(j);
				ArrayList<Integer> itemi = useri.getItem();
				ArrayList<Integer> itemj = userj.getItem();
				
				for (int u1 = 0; u1 < itemi.size(); u1++) {
					for (int u2= 0; u2 < itemj.size(); u2++) {
						if (itemi.get(u1) == itemj.get(u2)) {
							co++;
						}
					}
				}
				if (co != 0) {
					relate = (1.0) * co / Math.sqrt(itemi.size() * itemj.size());//���Ҷ���
					UserRelate ur = new UserRelate(userj.getUserid(), relate);
					userrelate.add(ur);
				}
			}
			um.setUserinterest(userrelate);
			um.sort();
			usermap.add(um);
		}
		
//		for (int i = 0; i < usermap.size(); i++) {
//			UserMap um = usermap.get(i);
//			System.out.print(um.getUserid() + " ");
//			ArrayList<UserRelate> ur = um.getUserinterest();
//			for (int j = 0; j < ur.size(); j++) {
//				System.out.print(ur.get(j).getUserid() + ":" + ur.get(j).getRelate() + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public ArrayList<Integer> finditem(Integer uid) {
		for (int i= 0; i < utou.size(); i++) {
			if (utou.get(i).getUserid().equals(uid)) {
				return utou.get(i).getItem();
			}
		}
		return null;
	}
}
