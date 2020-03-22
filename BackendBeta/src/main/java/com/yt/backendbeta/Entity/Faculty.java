package com.yt.backendbeta.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false,updatable=false)
	private int id;
	@Column(name="faculty_id",nullable=false)
	private String facultyId;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String number;
	@Column(nullable=false)
	private String email;
	private String gender;
	private int age;
	@OneToMany//cascade on delete yet to be  applied
	private List<Course> course = new ArrayList<Course>();
	private String qualification;
	@Column(nullable=false)
	private Date hireDate;
	private Date resignDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getResignDate() {
		return resignDate;
	}
	public void setResignDate(Date resignDate) {
		this.resignDate = resignDate;
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", faculty_id=" + facultyId + ", name=" + name + ", number=" + number + ", email="
				+ email + ", gender=" + gender + ", age=" + age + ", course=" + course + ", qualification="
				+ qualification + ", hire_date=" + hireDate + ", resig_date=" + resignDate + "]";
	}
	
	
	
}
