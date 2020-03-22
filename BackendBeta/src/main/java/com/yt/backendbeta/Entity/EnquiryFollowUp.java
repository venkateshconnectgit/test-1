package com.yt.backendbeta.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="enquiry_followup")
public class EnquiryFollowUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,updatable=false)
	private int id;
	@OneToOne//TODO cascade on delete yet to be  applied
	private Enquiry enquiryId;
	private LocalDate followUpDate;
	private String caller;
	private int status;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Enquiry getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Enquiry enquiryId) {
		this.enquiryId = enquiryId;
	}
	public LocalDate getFollowUpDate() {
		return followUpDate;
	}
	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "EnquiryFollowUp [id=" + id + ", enquiryId=" + enquiryId + ", followUpDate=" + followUpDate + ", caller="
				+ caller + ", status=" + status + ", comments=" + comments + "]";
	}
	
	
}
