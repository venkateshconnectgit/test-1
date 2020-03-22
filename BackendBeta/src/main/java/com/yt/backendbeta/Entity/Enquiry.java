package com.yt.backendbeta.Entity;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="enquiry")
public class Enquiry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false,updatable=false)
	private int id;
	private String name;
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;
	private String email;
	@Column(name="enquired_date",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date enquiredDate;
	@Column(name="enquired_about")
	private String enquiredAbout;
	private String remarks;
	private String source;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnquiredDate() {
		return enquiredDate;
	}
	public void setEnquiredDate(Date enquiredDate) {
		this.enquiredDate = enquiredDate;
	}
	public String getEnquiredbout() {
		return enquiredAbout;
	}
	public void setEnquiredbout(String enquiredbout) {
		this.enquiredAbout = enquiredbout;
	}
	public String getComment() {
		return remarks;
	}
	public void setComment(String remarks) {
		this.remarks = remarks;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "Enquiry [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", enquiredDate=" + enquiredDate + ", enquiredbout=" + enquiredAbout + ", remarks=" + remarks
				+ ", source=" + source + "]";
	}
	

}
