package com.ccnu.xy.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.ccnu.xy.model.RecoBookBase;
import com.ccnu.xy.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExtraAction extends ActionSupport {
	private Dict dict;
	private Book book;
	private Map resJson;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
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
		
		System.out.println("delete old data");
		rbd.deleteAll(session);
		
		System.out.println("insert new data");
		for (int i = 0; i < res.size(); i++) {
			UtoP utop = res.get(i);
			ArrayList<ItoP> userrecolist = utop.getItemlist();
			for (int j = 0; j < userrecolist.size(); j++) {
				ItoP itop = userrecolist.get(j);
				RecoBookBase rb = new RecoBookBase();
				rb.setUserid(utop.getUserid());
				rb.setBookid(itop.getItemid());
				
				rbd.save(session, rb);
			}
		}
		System.out.println("insert complete");
		
		session.close();
		sf.close();
		return SUCCESS;
	}
	
	public String getBookFile() throws Exception {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		BookDao bd = new BookDao();
		
		if (getUpload() != null) {
			
			String filename = getUploadFileName();
			String suffix = filename.substring(filename.length() - 3);
			if (suffix.equals("lsx") || suffix.equals("xls")) {
				Workbook wb = null;
				if (suffix.equals("lsx"))
					wb = new XSSFWorkbook(getUpload());
				else 
					wb = new HSSFWorkbook(new FileInputStream(getUpload()));
				
				Sheet st = wb.getSheetAt(0);
				int i = 0;
				for (Row r: st) {
					i++;
					Book b = new Book();
					if (r.getCell(0) == null) {
						continue;
					}
					System.out.println("book:" + r.getCell(0).getStringCellValue());
					System.out.println(r.getCell(1).getStringCellValue());
					String bookname = r.getCell(0).getStringCellValue();
					String author = r.getCell(1).getStringCellValue();
					String press = r.getCell(2).getStringCellValue();
					String place = r.getCell(3).getStringCellValue();
					Integer aclass = new Double(r.getCell(4).getNumericCellValue()).intValue();
					Integer bclass = new Double(r.getCell(5).getNumericCellValue()).intValue();
					Integer cclass = new Double(r.getCell(6).getNumericCellValue()).intValue();
					
					b.setBookname(bookname);
					b.setAuthor(author);
					b.setPress(press);
					b.setPlace(place);
					b.setAtype(aclass);
					b.setBtype(bclass);
					b.setCtype(cclass);
					
					bd.save(session, b);
				}
				
				wb.close();
			}
		}
		
		session.close();
		sf.close();
		return SUCCESS;
	}
}
