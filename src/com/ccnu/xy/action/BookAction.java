package com.ccnu.xy.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	
	public String bookclass() throws Exception {
		
		return SUCCESS;
	}
	
	public String booklist() throws Exception {
		
		return SUCCESS;
	}
	
	public String lend() throws Exception {
		
		return SUCCESS;
	}
	
	public String getBookDetail() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		ActionContext act = ActionContext.getContext();
		Integer bookid = new Integer(ServletActionContext.getRequest().getParameter("bookid"));
		User user = (User)act.getSession().get("user");
		
		BookDao bd = new BookDao();
		
		Book book = bd.getById(session, bookid);
		boolean buy = false;
		
		List<Book> booklist = user.getBooklist();
		for (int i = 0; i < booklist.size(); i++) {
			if (booklist.get(i).getId() == book.getId()) {
				buy = true;
				break;
			}
		}
		
		act.put("book", book);
		act.put("buy", buy);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	
}
