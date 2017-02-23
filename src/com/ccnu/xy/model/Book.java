package com.ccnu.xy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name="userid")	
	private User user;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private BookStat bookStat;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BookStat getBookStat() {
		return bookStat;
	}

	public void setBookStat(BookStat bookStat) {
		this.bookStat = bookStat;
	}
}
