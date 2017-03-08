package com.ccnu.xy.cf.itemcf;

import java.util.ArrayList;

import com.ccnu.xy.cf.base.UtoI;

public class ItemCf {
	public static ArrayList<UtoP> runFromData(ArrayList<UtoI> utoilist, ArrayList<ItemNum> itemnumlist) {
		ItoI itoi = new ItoI();
		
		itoi.setUtou(utoilist);
		itoi.setItnum(itemnumlist);
		
		ArrayList<UtoP> res = itoi.result();
		
		return res;
	}
	
	public static ArrayList<UtoP> runFromPath(String path) {
//		String path = "e://workspace/CF/src/xy/data.txt";
		ArrayList<ItemNum> itemnum = new ArrayList<>();
		
		ItemNum in1 = new ItemNum();
		in1.setItem(1);
		in1.setNum(3);
		itemnum.add(in1);
		ItemNum in2 = new ItemNum();
		in2.setItem(2);
		in2.setNum(3);
		itemnum.add(in2);
		ItemNum in3 = new ItemNum();
		in3.setItem(3);
		in3.setNum(2);
		itemnum.add(in3);
		
		ItoI itemtoitem = new ItoI();
		
		//��������
		itemtoitem.setItnum(itemnum);
		itemtoitem.inFromPath(path);
		
		ArrayList<UtoP> utoplist = itemtoitem.result();
		
		for (int i = 0; i < utoplist.size(); i++) {
			UtoP utop = utoplist.get(i);
//			if (utop.getUserid() == 4) {
				System.out.print(utop.getUserid() + " ");
				System.out.println("�Ƽ��б�Ϊ��" + utop.getItemlist().size());
				for (int j = 0; j < utop.getItemlist().size(); j++) {
					System.out.print(utop.getItemlist().get(j).getItemid() + " ");
				}
				System.out.println();
				
//			}
		}
		
		return utoplist;
	}

	
}
