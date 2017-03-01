package com.ccnu.xy.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.xy.model.BookStat;

public class BookStatDao {
	public void save(Session session, BookStat b) {
		session.beginTransaction();
		
		session.save(b);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, BookStat b) {
		session.beginTransaction();
		
		session.update(b);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete BookStat bs where bs.id=:id";
		session.createQuery(hql).setParameter("id", id);
		
		session.getTransaction().commit();
	}
	
	public BookStat getById(Session session, int id) {
		session.beginTransaction();
		
		BookStat b = session.get(BookStat.class, id);
		
		session.getTransaction().commit();
		return b;
	}

	public List<BookStat> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from BookStat bs";
		List<BookStat> bslist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return bslist;
	}
	
	public List<BookStat> getByTypeId(Session session, String type, int id) {
		session.beginTransaction();
		
		String hql = "from BookStat bs where bs.book." + type + "type=:id";
		List<BookStat> res = session.createQuery(hql).setParameter("id", id).list();
		
		session.getTransaction().commit();
		return res;
	}
}
