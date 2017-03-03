package com.ccnu.xy.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.dao.UserDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	
	private Map resJson;
	
	public Map getResJson() {
		return resJson;
	}

	public void setResJson(Map resJson) {
		this.resJson = resJson;
	}

	public String cart() throws Exception {
		
		return SUCCESS;
	}
	
	public String putWishCart() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		Integer bookid = new Integer(ServletActionContext.getRequest().getParameter("bookid"));

		BookDao bd = new BookDao();
		UserDao ud = new UserDao();
		
		User user = (User)act.getSession().get("user");
		Book book = bd.getById(session, bookid);
		
		List<User> userlist = book.getUserlist();
		userlist.add(user);
		
		List<Book> booklist = user.getBooklist();
		booklist.add(book);
		
		bd.update(session, book);
		ud.update(session, user);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("result", "success");
		
		this.setResJson(map);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
