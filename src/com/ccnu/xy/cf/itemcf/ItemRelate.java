package com.ccnu.xy.cf.itemcf;

/*
 * 计算两两物品之间的关系
 */
public class ItemRelate {
	private Integer itemi;
	private Integer itemj;
	private Integer relate;//共同喜欢物品i和物品j的人数
	private double similarity;//物品i和物品j的相似度
	
	
	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}

	public Integer getRelate() {
		return relate;
	}

	public void setRelate(Integer relate) {
		this.relate = relate;
	}

	public Integer getItemi() {
		return itemi;
	}
	
	public void setItemi(Integer itemi) {
		this.itemi = itemi;
	}
	
	public Integer getItemj() {
		return itemj;
	}
	
	public void setItemj(Integer itemj) {
		this.itemj = itemj;
	}
	
	
	
}
