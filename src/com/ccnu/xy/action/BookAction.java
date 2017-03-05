package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.HashSet;
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
	
	private String itemname;
	
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String searchBook() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		String type = ServletActionContext.getRequest().getParameter("searchtype");
		User user = (User)act.getSession().get("user");
		
		BookDao bd = new BookDao();
		
		ArrayList<Book> booklist = new ArrayList<>();
		ArrayList<Integer> order = new ArrayList<>();
		
		if (type.equals("book")) {
			List<Book> mid = bd.getByName(session, "bookname", "%" + itemname + "%");
			
			booklist.addAll(mid);
		}
		else if (type.equals("author")) {
			List<Book> mid = bd.getByName(session, "author", "%" + itemname + "%");
			
			booklist.addAll(mid);
		}
		
		if (user != null) {
			List<Book> buylist = user.getBooklist();
			for (int i = 0; i < booklist.size(); i++) {
				int bid = booklist.get(i).getId();
				Integer buy = 0;
				for (int j = 0; j < buylist.size(); j++) {
					if (buylist.get(j).getId() == bid) {
						buy = 1;
						break;
					}
				}
				order.add(buy);
			}
			act.put("order", order);
		}
		
		act.put("booklist", booklist);
		session.close();
		sf.close();
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
		
		if (user != null) {
			boolean buy = false;
			
			List<Book> booklist = user.getBooklist();
			for (int i = 0; i < booklist.size(); i++) {
				if (booklist.get(i).getId() == book.getId()) {
					buy = true;
					break;
				}
			}
			
			act.put("buy", buy);
		}
		act.put("book", book);

		session.close();
		sf.close();
		return SUCCESS;
	}
	
	
}
