package com.ccnu.xy.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.xy.model.RecoBookBase;

public class RecoBookDao {
	public void save(Session session, RecoBookBase b) {
		session.beginTransaction();
			
		session.save(b);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, RecoBookBase b) {
		session.beginTransaction();
		
		session.update(b);
		
		session.getTransaction().commit();
	}
	
	public void deleteAll(Session session) {
		session.beginTransaction();
		
		String hql = "delete RecoBook rb";
		session.createQuery(hql);
		
		session.getTransaction().commit();
	}
	
	public List<RecoBookBase> getByUserId(Session session, int id) {
		session.beginTransaction();
		
		String hql = "from RecoBook rb where rb.userid:userid";
		List<RecoBookBase> res = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return res;
	}
}
