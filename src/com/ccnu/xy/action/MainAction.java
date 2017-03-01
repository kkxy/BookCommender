package com.ccnu.xy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ccnu.xy.dao.DictDao;
import com.ccnu.xy.model.Book;
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
		
		if (classtype != null && classtype.equals("bc") && typeid != null) {
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
