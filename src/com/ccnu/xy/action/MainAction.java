package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.dao.BookStatDao;
import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.BookStat;
import com.ccnu.xy.model.Dict;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	public String getIndex() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		String classtype = ServletActionContext.getRequest().getParameter("classtype");
		String typeid = ServletActionContext.getRequest().getParameter("typeid");
		User user = (User)act.getSession().get("user");
		
		ArrayList<Book> booklist = new ArrayList<>();
		ArrayList<Integer> order = new ArrayList<>();
		
		BookDao bd = new BookDao();
		BookStatDao bsd = new BookStatDao();
		
		if (classtype != null && typeid != null) {
			List<BookStat> res = bsd.getByTypeId(session, classtype, new Integer(typeid));
			res.sort(new Comparator<BookStat>() {
				public int compare(BookStat a, BookStat b) {
					return a.getCount() - b.getCount();
				}
			});
			
			for (int i = 0; i < res.size(); i++) {
				Book b = bd.getById(session, res.get(i).getBsid());
				if (b != null)
					booklist.add(b);
			}
			
			act.getSession().put("classtype", classtype);
			act.getSession().put("typeid", typeid);
			act.put("booklist", booklist);
		}
		else {
			List<BookStat> res = bsd.getAll(session);
			res.sort(new Comparator<BookStat>() {
				public int compare(BookStat a, BookStat b) {
					return a.getCount() - b.getCount();
				}
			});
			
			for (int i = 0; i < res.size(); i++) {
				Book b = bd.getById(session, res.get(i).getBsid());
				if (b != null)
					booklist.add(b);
			}
			
			act.getSession().remove("classtype");
			act.getSession().remove("typeid");
			act.put("booklist", booklist);
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
		
		
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
