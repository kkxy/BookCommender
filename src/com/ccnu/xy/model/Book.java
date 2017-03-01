package com.ccnu.xy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;				// id
	private String bookname;	// 书名
	private String author;		// 作者
	private String press;		// 出版社
	private String place;		// 地点
	private String head;		// 图片
	private int atype;			// 类别a
	private int btype;			// 类别b
	private int ctype;			// 类别c
	
	@ManyToMany
	@JoinTable(
			name="t_order",
			joinColumns={@JoinColumn(columnDefinition="bookid")},
			inverseJoinColumns={@JoinColumn(columnDefinition="userid")}
			)
	private List<User> userlist = new ArrayList<>();
	
	@OneToOne(targetEntity=BookStat.class, cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private BookStat bookstat;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBookname() {
		return bookname;
	}
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPress() {
		return press;
	}
	
	public void setPress(String press) {
		this.press = press;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getHead() {
		return head;
	}
	
	public void setHead(String head) {
		this.head = head;
	}

	public int getAtype() {
		return atype;
	}

	public void setAtype(int atype) {
		this.atype = atype;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public BookStat getBookStat() {
		return bookstat;
	}
	
	public void setBookStat(BookStat bookstat) {
		this.bookstat = bookstat;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
}
