package com.sj.bean;

import java.util.Date;

public class DonorBean {
	private Integer id;
	private String name;
	private Integer amount;
	private Date ddate;
	private Long number;
	private String address;
	
	
	public String validateFields() {
		if (name == null || !name.matches("[a-z\\sA-Z]{2,}")) {return "Name Must be Greater than 2 Characters!";}
		if (number == null || !number.toString().matches("[0-9]{10}")) {return "Phone Number Must be 10 Digits!";}
		if (address == null || !address.matches("[0-9]{1,5}\\s[A-Z\\sa-z.]{1,20}")) {return "Address Must be in the format <## adress name>";}
		if (amount == null || amount < 1) {return "Cannot Donate Less Than $1.00";}
		return "Success";
	}
	
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "DonorBean [id=" + id + ", name=" + name + ", amount=" + amount + ", ddate=" + ddate + ", number="
				+ number + ", address=" + address + "]";
	}
	
}
