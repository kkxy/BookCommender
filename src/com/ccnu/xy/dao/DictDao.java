package com.ccnu.xy.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.xy.model.Dict;

public class DictDao {
	public void save(Session session, Dict d) {
		session.beginTransaction();
		
		session.save(d);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Dict d) {
		session.beginTransaction();
		
		session.update(d);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Dict d where d.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public List<Dict> getByItemId(Session session, int id) {
		session.beginTransaction();
		
		String hql = "from Dict d where d.itemid=?";
		List<Dict> res = session.createQuery(hql).setParameter(0, id).list();
		
		session.getTransaction().commit();
		
		return res;
	}
	
	public List<Dict> getByTypeId(Session session, int id) {
		session.beginTransaction();
		
		String hql = "from Dict d where d.typeid=?";
		List<Dict> res = session.createQuery(hql).setParameter(0, id).list();
		
		session.getTransaction().commit();
		
		return res;
	}
}
