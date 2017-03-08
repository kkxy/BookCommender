package com.ccnu.xy.cf.itemcf;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

import com.ccnu.xy.cf.base.UtoI;


public class ItoI {
	private ArrayList<UtoI> utou = new ArrayList<>(); 			// purchased log of all user
	private ArrayList <ItemRelate> itoi = new ArrayList<>();	// relate matrix of all user
	private ArrayList <ItemNum> itnum = new ArrayList<>();		// book stat
	private ArrayList <UtoP> utop = new ArrayList<>();			// recommended book for all user
  
	public ArrayList<ItemNum> getItnum() {
		return itnum;
	}

	public void setItnum(ArrayList<ItemNum> itnum) {
		this.itnum = itnum;
	}
	
	public ArrayList<ItemRelate> getItoi() {
		return itoi;
	}

	public void setItoi(ArrayList<ItemRelate> itoi) {
		this.itoi = itoi;
	}
	
	public ArrayList<UtoI> getUtou() {
		return utou;
	}

	public void setUtou(ArrayList<UtoI> utou) {
		this.utou = utou;
	}

	public ArrayList<UtoP> getUtop() {
		return utop;
	}

	public void setUtop(ArrayList<UtoP> utop) {
		this.utop = utop;
	}

	
	/*
	 * �ҵ���Ʒi����Ʒj����Ʒ��ϵ�����е�λ�ã�û���ҵ�����-1
	 */
	private Integer findlocate(Integer itemi, Integer itemj) {
		for (int i = 0; i < itoi.size(); i++) {
			ItemRelate ir = itoi.get(i);
			if (ir.getItemi() == itemi && ir.getItemj() == itemj) {
				return i;
			}
		}
		return -1;//δ�ҵ���Ʒ֮�����ϵ
	}
	
	/*
	 * ������Ʒi����Ʒj�Ĺ�ͬ�û�������
	 */
	private void setrelate(Integer itemi, Integer itemj) {
		Integer locate = findlocate(itemi, itemj);
		if (locate != -1) {
			itoi.get(locate).setRelate(itoi.get(locate).getRelate() + 1);
		}
		else {
			ItemRelate ir = new ItemRelate();
			ir.setItemi(itemi);
			ir.setItemj(itemj);
			ir.setRelate(1);
			itoi.add(ir);
		}
	}
	
	/*
	 * ������Ʒid����
	 */
	private void sortRelate() {
		itoi.sort(new Comparator<ItemRelate> () {
			public int compare(ItemRelate I1, ItemRelate I2) {
				if (I1.getItemi() > I2.getItemi()) {
					return 1;
				}
				else if (I1.getItemi() < I2.getItemi()) {
					return -1;
				}
				else {
					if (I1.getItemj() > I2.getItemj()) {
						return 1;
					}
					else if (I1.getItemj() < I2.getItemj()) {
						return -1;
					}
					else {
						return 0;
					}
				}
			}
		});
	}
	
	/*
	 * ����������Ʒ�����ƶ�
	 */
	private void computeSimilarity() {
		for (int i = 0; i < itoi.size(); i++) {
			ItemRelate ir = itoi.get(i);
			Integer numi = 0;//����i��Ʒ������
			Integer numj = 0;//����j��Ʒ������
			boolean findi = false;//�ҵ���Ʒi�Ĺ�������
			boolean findj = false;//�ҵ���Ʒj�Ĺ�������
			for (int j = 0; j < itnum.size(); j++) {
				ItemNum itemnum = itnum.get(j); 
				if (ir.getItemi() == itemnum.getItem()) {
					numi = itemnum.getNum();
					findi = true;
				}
				if (ir.getItemj() == itemnum.getItem()) {
					numj = itemnum.getNum();
					findj = true;
				}
				
				if (findi && findj) {
					double w = (1.0) * ir.getRelate() / Math.sqrt(numi * numj);//������Ʒi����Ʒj�����ƶ�
					int locate = this.findlocate(ir.getItemi(), ir.getItemj());
					itoi.get(locate).setSimilarity(w);
					break;
				}	
			}
		}
	}
	
	
	
	/*
	 * ��ȡ������Ʒ����
	 */
	private HashSet<Integer> getItemList() {
		HashSet<Integer> itemlist = new HashSet<>();
		for (int i = 0; i < utou.size(); i++) {
			UtoI utoi = utou.get(i);
			ArrayList<Integer> item = utoi.getItem();
			for (int j = 0; j < item.size(); j++) {
				itemlist.add(item.get(j));
			}
		}
		return itemlist;
	}
	
	/*
	 * ��ȡ�û�δ������Ʒ����
	 */
	private ArrayList<Integer> getToBuy(UtoI utoi) {
		ArrayList<Integer> tobuy = new ArrayList<>();
		HashSet<Integer> allitem = this.getItemList();
		HashSet<Integer> item = new HashSet<>();
		for(int i = 0; i < utoi.getItem().size(); i++) {
			item.add(utoi.getItem().get(i));
		}
		for (Integer i:allitem) {
			if (!item.contains(i)) {
				tobuy.add(i);
			}
		}
		
		return tobuy;
	}
	
	/*
	 * ����δ������Ʒ��û�����Ʒ����Ȥ��
	 */
	private double getInterest(Integer itemid, UtoI utoi) {
		double interest = 0;
		HashSet<Integer> item = new HashSet<>();
		ArrayList<Integer> tobuy = this.getToBuy(utoi);
		for (int i = 0; i < tobuy.size(); i++) {
			for (int j = 0; j < itoi.size(); j++) {
				ItemRelate itemrelate = itoi.get(j);
				if (tobuy.get(i) == itemrelate.getItemi() && !item.contains(itemrelate.getItemj())) {
					interest += itemrelate.getSimilarity();
				}
			}
		}
		return interest;
	}
	

	/*
	 * ��������
	 */
	public void inFromPath(String path){
		try{
			File f = new File(path);
			if (!f.exists()) {
				System.out.println("file not found!");
				return;
			}
			Scanner s = new Scanner(f);
			while(s.hasNextLine()) {
				int userid = s.nextInt();
				int num = s.nextInt();
				ArrayList<Integer> itemlist = new ArrayList<>();
				UtoI utoi = new UtoI();
				for (int i = 0; i < num; i++) {
					int itemid = s.nextInt();
					itemlist.add(itemid);
				}
				
				utoi.setUserid(userid);
				utoi.setItem(itemlist);
				utou.add(utoi);
				
				for (int i = 0; i < itemlist.size(); i++) {
					for (int j = 0; j < itemlist.size(); j++) {
						this.setrelate(itemlist.get(i), itemlist.get(j));
					}
				}
				
			}
			s.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ����û��Ƽ���Ʒ�б�
	 */
	public ArrayList<UtoP> result() {
		
		this.sortRelate();
		this.computeSimilarity();
		
		for (int i = 0; i < utou.size(); i++) {
			//��ȡ�û�δ������Ʒ����
			UtoI utoi = utou.get(i);
			ArrayList<Integer> tobuy = this.getToBuy(utoi);
			
			//����û����ܹ�����Ʒ����
			UtoP userprefer = new UtoP();
			userprefer.setUserid(utoi.getUserid());
			ArrayList<ItoP> itoplist = new ArrayList<>();
			
			for (int j = 0; j < tobuy.size(); j++) {
				Integer itemid = tobuy.get(j);
				double interest = this.getInterest(itemid, utoi);
				if (interest > 0) {
					ItoP itop = new ItoP();
					itop.setItemid(itemid);
					itop.setRecommend(interest);
					itoplist.add(itop);
				}
			}
			userprefer.setItemlist(itoplist);
			userprefer.sort();
			utop.add(userprefer);
			
		}
		return utop;
	}
}
