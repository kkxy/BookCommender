package com.ccnu.xy.dao;

import org.hibernate.Session;

import com.ccnu.xy.model.BookStat;

public class BookStatDao {
	public void save(Session session, BookStat bs) {
		session.beginTransaction();
		
		session.save(bs);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, BookStat bs) {
		session.beginTransaction();
		
		session.update(bs);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete BookStat bs where bs.id=?";
		session.createQuery(hql).setParameter(0, id);
		
		session.getTransaction().commit();
	}
	
	public BookStat get(Session session, int id) {
		session.beginTransaction();
		
		BookStat bs = session.get(BookStat.class, id);
		
		session.getTransaction().commit();
		return bs;
	}
}
