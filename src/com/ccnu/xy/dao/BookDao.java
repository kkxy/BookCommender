package com.ccnu.xy.dao;

import java.util.List;

import org.hibernate.Session;

import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.BookStat;

public class BookDao {
	public void save(Session session, Book b) {
		session.beginTransaction();
		
		BookStat bs = new BookStat();
		bs.setCount(0);
		
		bs.setBook(b);
		b.setBookStat(bs);
		
		session.save(b);
		session.save(bs);
		
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
	
	
	public List<Book> getByName(Session session, String type, String name) {
		session.beginTransaction();
		
		String hql = "from Book b where b." + type + " like '" + name + "'";
		List<Book> res = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return res;
	}
	
	public List<Book> getAll(Session session) {
		session.beginTransaction();
		
		String hql = "from Book bs";
		List<Book> bslist = session.createQuery(hql).list();
		
		session.getTransaction().commit();
		return bslist;
	}
	
	public List<Book> getByTypeId(Session session, String type, int id) {
		session.beginTransaction();
		
		String hql = "from Book bs where bs.book." + type + "type=:id";
		List<Book> res = session.createQuery(hql).setParameter("id", id).list();
		
		session.getTransaction().commit();
		return res;
	}
}
