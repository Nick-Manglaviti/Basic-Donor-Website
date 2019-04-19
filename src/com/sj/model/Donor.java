package com.sj.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sj
 *
 */
@Entity
@Table(name="Donor")
public class Donor implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "d_id")
	private Integer d_id;
	
	@Column(name="d_name")
	private String d_name;
	
	@Column(name="d_address")
	private String d_address;
	
	@Column(name="d_amount")
	private Integer amod_amount;
	
	@Column(name="d_date")
	private Date d_date;
	
	@Column(name="d_number")
	private Long d_number;

	
	
	public Date getD_Date() {
		return d_date;
	}
	public void setD_Date(Date d_date) {
		this.d_date = d_date;
	}
	public Integer getD_Id() {
		return d_id;
	}
	public void setD_Id(Integer empId) {
		this.d_id = empId;
	}
	public String getD_Name() {
		return d_name;
	}
	public void setD_Name(String empName) {
		this.d_name = empName;
	}
	public String getD_Address() {
		return d_address;
	}
	public void setD_Address(String empAddress) {
		this.d_address = empAddress;
	}
	public Integer getD_Amount() {
		return amod_amount;
	}

	public void setD_Amount(Integer amount) {
		this.amod_amount = amount;
	}

	public Long getD_Number() {
		return d_number;
	}
	public void setD_Number(Long empNumber) {
		this.d_number = empNumber;
	}
}
