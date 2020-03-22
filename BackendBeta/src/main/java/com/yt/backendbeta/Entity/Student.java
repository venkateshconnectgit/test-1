package com.yt.backendbeta.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false,updatable=false)
	private int id;
	@Column(name="student_id",nullable=false,updatable=false)
	private String studentId;
	@Column(nullable=false)
	private String name;
	@OneToOne//TODO cascade on delete yet to be  applied
	private Registration regdId;
	@OneToMany//TODO cascade on delete yet to be  applied
	private List<Batch> batch = new ArrayList<Batch>();
	private int batchStatus;
	private String coursesCompleted;//multivalued attribute for reference
	private int batchReassigned;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Registration getRegdId() {
		return regdId;
	}
	public void setRegdId(Registration regdId) {
		this.regdId = regdId;
	}
	public List<Batch> getBatch() {
		return batch;
	}
	public void setBatch(List<Batch> batch) {
		this.batch = batch;
	}
	public int getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(int batchStatus) {
		this.batchStatus = batchStatus;
	}
	public String getCoursesCompleted() {
		return coursesCompleted;
	}
	public void setCoursesCompleted(String coursesCompleted) {
		this.coursesCompleted = coursesCompleted;
	}
	public int getBatchReassigned() {
		return batchReassigned;
	}
	public void setBatchReassigned(int batchReassigned) {
		this.batchReassigned = batchReassigned;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", student_id=" + studentId + ", name=" + name + ", regd_id=" + regdId + ", batch="
				+ batch + ", batch_status=" + batchStatus + ", courses_completed=" + coursesCompleted
				+ ", batch_reassigned=" + batchReassigned + "]";
	}
	


}
