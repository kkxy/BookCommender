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
		
		String hql = "delete Dict d where d.id=:id";
		session.createQuery(hql).setParameter("id", id);
		
		session.getTransaction().commit();
	}
	
	public List<Dict> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Dict d";
		List<Dict> res = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return res;
	}
	
	public Dict getByItemId(Session session, int id) {
		session.beginTransaction();
		
		Dict res = session.get(Dict.class, id);
		
		session.getTransaction().commit();
		
		return res;
	}
	
	public List<Dict> getByTypeId(Session session, int id) {
		session.beginTransaction();
		
		String hql = "from Dict d where d.typeid=:typeid";
		List<Dict> res = session.createQuery(hql).setParameter("typeid", id).list();
		
		session.getTransaction().commit();
		
		return res;
	}
}
