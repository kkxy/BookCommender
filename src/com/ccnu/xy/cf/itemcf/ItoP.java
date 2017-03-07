package com.ccnu.xy.cf.itemcf;

/*
 * 计算某物品对itemid物品的相似度
 */
public class ItoP {
	private Integer itemid;//物品id
	private double recommend;//相似度
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public double getRecommend() {
		return recommend;
	}
	public void setRecommend(double recommend) {
		this.recommend = recommend;
	}
	
}
