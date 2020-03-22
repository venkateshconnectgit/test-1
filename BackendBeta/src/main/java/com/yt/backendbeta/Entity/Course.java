package com.yt.backendbeta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable=false,nullable=false)
	private int id;
	private String courseName;
	private String courseSyllabus;

	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}	

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSyllabus() {
		return courseSyllabus;
	}
	public void setCourseSyllabus(String courseSyllabus) {
		this.courseSyllabus = courseSyllabus;
	}
	@Override
	public String toString() {
		return "Course [id=" + id +", courseName=" + courseName + ", courseSyllabus="
				+ courseSyllabus  + "]";
	}


	
	
}
