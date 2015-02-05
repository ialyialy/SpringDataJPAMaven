package com.preact;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column (name="category")
	@Id public String category;
	@Column (name="accountGroup")
	@Id public String accountGroup;
	@Column (name="accountCode")
	public String accountCode;
	
	
	public Account(String category,String accountGroup, String accountCode) {
		super();

		this.category = category;
		this.accountGroup = accountGroup;
		this.accountCode = accountCode;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAccountGroup() {
		return accountGroup;
	}
	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public Account() {
	}
	
}