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
@Table(name="batch_info")
public class Batch {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(updatable=false,nullable=false)
    private int id;	
	@Column(name="batch_id",updatable=false,nullable=false)
	private String batchId;
	@OneToOne//TODO cascade on delete yet to be  applied	
	private Course course;
	@OneToOne//TODO cascade on delete yet to be  applied
	private Faculty faculty;
	private int session;
	private int strength;
	private int attendance;
	private LocalDate startDate;
	private LocalDate expectedCompletionDate;
	private int delay;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getExpectedCompletionDate() {
		return expectedCompletionDate;
	}
	public void setExpectedCompletionDate(LocalDate expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", batchId=" + batchId + ", course=" + course + ", faculty=" + faculty + ", session="
				+ session + ", strength=" + strength + ", attendance=" + attendance + ", startDate=" + startDate
				+ ", expectedCompletionDate=" + expectedCompletionDate + ", delay=" + delay + "]";
	}
	
	
	
}
