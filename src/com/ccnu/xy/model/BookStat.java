package com.ccnu.xy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="t_bookstat")
public class BookStat {
	
	@Id
	@GenericGenerator(name="foreignKey", strategy="foreign", parameters=@Parameter(name="property", value="book"))
	@GeneratedValue(generator="foreignKey", strategy=GenerationType.AUTO)
	private int bsid;
	private int count;
	
	@OneToOne(targetEntity=Book.class, cascade={CascadeType.ALL}, mappedBy="bookstat")
	@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
	private Book book;
	
	public int getBsid() {
		return bsid;
	}

	public void setBsid(int bsid) {
		this.bsid = bsid;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
