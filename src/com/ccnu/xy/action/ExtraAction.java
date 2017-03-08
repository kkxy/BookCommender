package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.cf.base.UtoI;
import com.ccnu.xy.cf.itemcf.ItemCf;
import com.ccnu.xy.cf.itemcf.ItemNum;
import com.ccnu.xy.cf.itemcf.ItoP;
import com.ccnu.xy.cf.itemcf.UtoP;
import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.dao.BookStatDao;
import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.dao.RecoBookDao;
import com.ccnu.xy.dao.UserDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.BookStat;
import com.ccnu.xy.model.Dict;
import com.ccnu.xy.model.RecoBook;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExtraAction extends ActionSupport {
	private Dict dict;
	private Book book;
	private Map resJson;
	
	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Map getResJson() {
		return resJson;
	}

	public void setResJson(Map resJson) {
		this.resJson = resJson;
	}

	public String getUploadClass() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession(); 
		ActionContext act = ActionContext.getContext();
		DictDao dd = new DictDao();
		
		List<Dict> cl = dd.getAll(session);
		
		act.put("classlist", cl);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String uploadClass() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		DictDao dd = new DictDao();
		
		System.out.println(dict.getTypeid() + dict.getName());
		
		dd.save(session, dict);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getUploadBook() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		DictDao dd = new DictDao();
		
		List<Dict> aclasslist = dd.getByTypeId(session, 1);
		List<Dict> bclasslist = new ArrayList<Dict>();
		if (aclasslist.size() != 0)
			bclasslist = dd.getByTypeId(session, aclasslist.get(0).getItemid());
		List<Dict> cclasslist = new ArrayList<Dict>();
		if (bclasslist.size() != 0)
			cclasslist = dd.getByTypeId(session, bclasslist.get(0).getItemid());
		
		act.put("aclasslist", aclasslist);
		act.put("bclasslist", bclasslist);
		act.put("cclasslist", cclasslist);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getSelectClass() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Integer typeid = new Integer(ServletActionContext.getRequest().getParameter("typeid"));
		Map<String, Object> map = new HashMap<>();
		
		DictDao dd = new DictDao();
		
		List<Dict> res = dd.getByTypeId(session, typeid);
		map.put("classlist", res);
		
		this.setResJson(map);
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String uploadBook() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		BookDao bd = new BookDao();
		
		bd.save(session, getBook());
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String computeRecom() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		RecoBookDao rbd = new RecoBookDao();
		UserDao ud = new UserDao();
		BookStatDao bsd = new BookStatDao();
		
		ArrayList<UtoI> utoilist = new ArrayList<>();
		ArrayList<ItemNum> itemnumlist = new ArrayList<>();
		
		List<User> userlist = ud.getAll(session);
		for (int i = 0; i < userlist.size(); i++) {
			User user = userlist.get(i);
			UtoI utoi = new UtoI();
			
			utoi.setUserid(user.getId());
			
			List<Book> blist = user.getBooklist();
			ArrayList<Integer> bidlist = new ArrayList<>();
			for (int j = 0; j < blist.size(); j++)
				bidlist.add(blist.get(j).getId());
			
			utoi.setItem(bidlist);
			utoilist.add(utoi);
		}
		
		List<BookStat> bslist = bsd.getAll(session);
		for (int i = 0; i < bslist.size(); i++) {
			BookStat bs = bslist.get(i);
			ItemNum in = new ItemNum();
			in.setItem(bs.getBsid());
			in.setNum(bs.getCount());
			itemnumlist.add(in);
		}
		
		ArrayList<UtoP> res = ItemCf.runFromData(utoilist, itemnumlist);
		
		rbd.deleteAll(session);
		
		for (int i = 0; i < res.size(); i++) {
			UtoP utop = res.get(i);
			ArrayList<ItoP> userrecolist = utop.getItemlist();
			for (int j = 0; j < userrecolist.size(); j++) {
				ItoP itop = userrecolist.get(j);
				RecoBook rb = new RecoBook();
				rb.setUserid(utop.getUserid());
				rb.setBookid(itop.getItemid());
				
				rbd.save(session, rb);
			}
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
