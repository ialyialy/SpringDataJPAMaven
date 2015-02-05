package com.preact;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (name="product")
	public String product;
	@Column (name="category", insertable=false, updatable=false)
	public String category;
	@Column (name="city")
	public String city;
	@Column (name="accountGroup", insertable=false, updatable=false)
	public String accountGroup;
	@Column (name="bookingDate")
	public Date bookingDate;
	@Column (name="amount")
	public long amount;
	@Column (name="currency")
	public String currency;
	
    @ManyToOne 
    @JoinColumns({
        @JoinColumn(name="accountGroup", referencedColumnName="accountGroup"),
        @JoinColumn(name="category", referencedColumnName="category")
    })
	private Account account;

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Sales(String product, String category, String city, String accountGroup, Date bookingDate, long amount, String currency) {
		super();
		this.product = product;
		this.category = category;
		this.city = city;
		this.accountGroup = accountGroup;
		this.bookingDate = bookingDate;
		this.amount = amount;
		this.currency = currency;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAccountGroup() {
		return accountGroup;
	}
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Sales() {
	}
	
	@Override
	public String toString() {
		return "Sales [product=" + product + 
				", category=" + category + 
				", city=" + city +
				", accountGroup=" + accountGroup +
				", bookingDate=" + bookingDate +
				", amount=" + amount +
				", currency=" + currency +
				", accountCode=" + account.getAccountCode()
				+ "]";
	}
}