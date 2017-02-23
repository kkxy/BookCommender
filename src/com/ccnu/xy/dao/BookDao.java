package com.ccnu.xy.dao;

import org.hibernate.Session;

import com.ccnu.xy.model.Book;

public class BookDao {
	public void save(Session session, Book b) {
		session.beginTransaction();
		
		session.save(b);
		
		session.getTransaction().commit();
	}
	
	public void update(Session session, Book b) {
		session.beginTransaction();
		
		session.update(b);
		
		session.getTransaction().commit();
	}
	
	public void delete(Session session, int id) {
		session.beginTransaction();
		
		String hql = "delete Book b where b.id=:id";
		session.createQuery(hql).setParameter("id", id);
		
		session.getTransaction().commit();
	}
	
	public Book getById(Session session, int id) {
		session.beginTransaction();
		
		Book b = session.get(Book.class, id);
		
		session.getTransaction().commit();
		return b;
	}
}
