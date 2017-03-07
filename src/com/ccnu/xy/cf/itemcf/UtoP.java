package com.ccnu.xy.cf.itemcf;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * ����ĳ�û����Ƽ���Ʒ�б�
 */
public class UtoP {
	private Integer userid; //�û�id
	private ArrayList<ItoP> itemlist; //�û��Ƽ��б�
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public ArrayList<ItoP> getItemlist() {
		return itemlist;
	}
	public void setItemlist(ArrayList<ItoP> itemlist) {
		this.itemlist = itemlist;
	}
	//�������ƶȴӴ�С����
	public void sort() {
		itemlist.sort(new Comparator<ItoP>() {
			public int compare(ItoP I1, ItoP I2) {
				if (I1.getRecommend() < I2.getRecommend()) {
					return 1;
				}
				else if (I1.getRecommend() > I2.getRecommend()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
	}
	
	
	
}
