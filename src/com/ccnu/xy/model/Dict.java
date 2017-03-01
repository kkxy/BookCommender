package com.ccnu.xy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_dict")
public class Dict {
	private int typeid;			// 高级id
	private int itemid;			// 低级id
	private String name;		// 低级名称
	
	public int getTypeid() {
		return typeid;
	}
	
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getItemid() {
		return itemid;
	}
	
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

