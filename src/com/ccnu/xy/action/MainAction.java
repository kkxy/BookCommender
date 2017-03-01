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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {
	public String getIndex() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		String classtype = ServletActionContext.getRequest().getParameter("classtype");
		String typeid = ServletActionContext.getRequest().getParameter("typeid");
		
		List<Dict> aClass = new ArrayList<>();
		List<Dict> bClass = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		ArrayList<Book> booklist = new ArrayList<>();
		
		DictDao dd = new DictDao();
		BookDao bd = new BookDao();
		BookStatDao bsd = new BookStatDao();
		
		if (classtype != null && typeid != null) {
			String nexttype = "";
			if (classtype.equals("b"))
				nexttype = "c";
			else if (classtype.equals("c"))
				nexttype = "d";
			
			int last = 0;
			count.add(last);
			aClass.add(dd.getByItemId(session, new Integer(typeid)));
			for (int i = 0; i < aClass.size(); i++) {
				Dict d = aClass.get(i);
				List<Dict> res = dd.getByTypeId(session, d.getItemid());
				bClass.addAll(res);
				last += res.size();
				count.add(last);
			}
			
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
			
			act.put("nowtype", classtype);
			act.put("nexttype", nexttype);
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
			act.put("booklist", booklist);
		}
		else {
//			首页导航 1
			aClass = dd.getByTypeId(session, 1);
			int last = 0;
			count.add(last);
			for (int i = 0; i < aClass.size(); i++) {
				Dict d = aClass.get(i);
				List<Dict> res = dd.getByTypeId(session, d.getItemid());
				bClass.addAll(res);
				last += res.size();
				count.add(last);
			}
			
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
			
			act.put("nowtype", "a");
			act.put("nexttype", "b");
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
			act.put("booklist", booklist);
		}
		
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
