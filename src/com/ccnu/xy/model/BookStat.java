package com.ccnu.xy.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_bookstat")
public class BookStat {
	private int id;			// id
	private int number;		// 总量
	private int left;		// 剩余量
	private int ctype;		// 类别
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Book book;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getLeft() {
		return left;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getCtype() {
		return ctype;
	}
	
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
