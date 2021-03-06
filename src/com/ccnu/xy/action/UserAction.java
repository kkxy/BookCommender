package com.ccnu.xy.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.UserDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		ActionContext act = ActionContext.getContext();
		UserDao ud = new UserDao();
		
		if (ud.check(session, getUser().getLoginname(), getUser().getPassword())) {
			User db_user = ud.getByLoginname(session, getUser().getLoginname());
			
			act.getSession().put("user", db_user);
			session.close();
			sf.close();
			return SUCCESS;
		}
		
		session.close();
		sf.close();
		return ERROR;
	}
	
	public String register() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		UserDao ud = new UserDao();
		
		if (ud.checkLoginname(session, getUser().getLoginname())) {
			System.out.println("save success");
			ud.save(session, getUser());
			
			session.close();
			sf.close();
			return SUCCESS;
		}
		
		session.close();
		sf.close();
		return ERROR;
	}
	
	public String logout() throws Exception {
		ActionContext act = ActionContext.getContext();
		act.getSession().clear();
		
		return SUCCESS;
	}
	
	public String getUserCenter() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		User user = (User)act.getSession().get("user");
		List<Book> buylist = user.getBooklist();
		
		act.put("buylist", buylist);
		session.close();
		sf.close();
		return SUCCESS;
	}
}
