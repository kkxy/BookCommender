package com.ccnu.xy.cf.itemcf;

import java.util.ArrayList;

public class Main {
	public static void main(String arg[]) {
		String path = "e://workspace/CF/src/xy/data.txt";
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
		
		//读入数据
		itemtoitem.setItnum(itemnum);
		itemtoitem.in(path);
		
		ArrayList<UtoP> utoplist = itemtoitem.result();
		
		for (int i = 0; i < utoplist.size(); i++) {
			UtoP utop = utoplist.get(i);
//			if (utop.getUserid() == 4) {
				System.out.print(utop.getUserid() + " ");
				System.out.println("推荐列表为：" + utop.getItemlist().size());
				for (int j = 0; j < utop.getItemlist().size(); j++) {
					System.out.print(utop.getItemlist().get(j).getItemid() + " ");
				}
				System.out.println();
				
//			}
		}
		
	}

	
}
