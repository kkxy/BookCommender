package com.ccnu.xy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_recobook")
public class RecoBook {
	@Id
	private RecoBookBase recobookbase;

	public RecoBookBase getRecobookbase() {
		return recobookbase;
	}

	public void setRecobookbase(RecoBookBase recobookbase) {
		this.recobookbase = recobookbase;
	}
	
	
}
