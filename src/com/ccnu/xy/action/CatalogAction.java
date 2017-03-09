package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.BookDao;
import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.dao.RecoBookDao;
import com.ccnu.xy.model.Book;
import com.ccnu.xy.model.Dict;
import com.ccnu.xy.model.RecoBook;
import com.ccnu.xy.model.RecoBookBase;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CatalogAction extends ActionSupport {
	public String getCatalog() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		
		String classtype = (String)act.getSession().get("classtype");
		String typeid = (String)act.getSession().get("typeid");

		List<Dict> aClass = new ArrayList<>();
		List<Dict> bClass = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		
		DictDao dd = new DictDao();
		
		if (classtype != null && typeid != null && !classtype.equals("a")) {
			String nexttype = "", lasttype = "";
			if (classtype.equals("b")) {
				lasttype = "a";
				nexttype = "c";
			}
			else if (classtype.equals("c")) {
				lasttype = "b";
				nexttype = "c";
			}
			
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
			
			act.put("nowtype", classtype);
			act.put("lasttype", lasttype);
			act.put("nexttype", nexttype);
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
			
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
			
			act.put("nowtype", "a");
			act.put("nexttype", "b");
			act.put("bigclass", aClass);
			act.put("smallclass", bClass);
			act.put("count", count);
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getRecoBook() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		ActionContext act = ActionContext.getContext();
		User user = (User)act.getSession().get("user");
		
		RecoBookDao rbd = new RecoBookDao();
		BookDao bd = new BookDao();
		
		List<RecoBook> recobook = rbd.getByUserId(session, user.getId());
		ArrayList<Book> recobooklist = new ArrayList<>();
		ArrayList<Integer> recoorder = new ArrayList<>();
		
		for (int i = 0; i < recobook.size(); i++) {
			RecoBookBase rbb = recobook.get(i).getRecobookbase();
			Book b = bd.getById(session, rbb.getBookid());
			recobooklist.add(b);
		}
		
		List<Book> buylist = user.getBooklist();
		
		for (int i = 0; i < recobooklist.size(); i++) {
			int bid = recobooklist.get(i).getId();
			Integer buy = 0;
			for (int j = 0; j < buylist.size(); j++) {
				if (buylist.get(j).getId() == bid) {
					buy = 1;
					break;
				}
			}
			recoorder.add(buy);
		}
		act.put("recobooklist", recobooklist);
		act.put("recoorder", recoorder);
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
