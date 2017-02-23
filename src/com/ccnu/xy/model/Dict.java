package com.ccnu.xy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_dict")
public class Dict {
	private int itemid;			// 低级id
	private int typeid;			// 高级id
	private String typename;	// 低级名称
	private String itemname;	// 高级名称
	
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
	
	public String getTypename() {
		return typename;
	}
	
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	public String getItemname() {
		return itemname;
	}
	
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
}

