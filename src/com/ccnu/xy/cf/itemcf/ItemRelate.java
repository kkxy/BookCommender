package com.ccnu.xy.cf.itemcf;

/*
 * ����������Ʒ֮��Ĺ�ϵ
 */
public class ItemRelate {
	private Integer itemi;
	private Integer itemj;
	private Integer relate;//��ͬϲ����Ʒi����Ʒj������
	private double similarity;//��Ʒi����Ʒj�����ƶ�
	
	
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
