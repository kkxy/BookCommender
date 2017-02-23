package com.ccnu.xy.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ccnu.xy.model.User;

public class UserDao {
	public boolean check(Session session, String loginname, String password) {
		session.beginTransaction();
		
		boolean pass = false;
		String hql = "from User u where u.loginname=? and u.password=?";
		Query q = session.createQuery(hql).setParameter(0, loginname).setParameter(1, password);
		if (q != null)
			pass = true;
		
		session.getTransaction().commit();
		return pass;
	}
	
	public boolean checkLoginname(Session session, String loginname) {
		session.beginTransaction();
		
		boolean pass = true;
		String hql = "from User u where u.loginname=?";
		Query q = session.createQuery(hql).setParameter(0, loginname);
		if (q != null)
			pass = false;
		
		session.getTransaction().commit();
		return pass;
	}
	
	public void save(Session session, User u) {
		session.beginTransaction();
		
		session.save(u);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, User u) {
		session.beginTransaction();
		
		session.update(u);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete User u where u.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public User getByLoginname(Session session, String loginname) {
		session.beginTransaction();
		
		String hql = "from User u where u.loginname=?";
		User u = (User)session.createQuery(hql).setParameter(0, loginname);
		u.setPassword("");
		
		session.getTransaction().commit();
		return u;
	}
	
	public User getById(Session session, int id) {
		session.beginTransaction();
		
		User u = session.get(User.class, id);
		u.setPassword("");
		
		session.getTransaction().commit();
		return u;
	}
}
