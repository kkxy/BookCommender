package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.Dict;
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
		List<Dict> cclasslist = new ArrayList<Dict>();
		
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
}
