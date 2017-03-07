package com.ccnu.xy.cf.itemcf;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * 计算某用户的推荐物品列表
 */
public class UtoP {
	private Integer userid; //用户id
	private ArrayList<ItoP> itemlist; //用户推荐列表
	
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
	//按照相似度从大到小排序
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
