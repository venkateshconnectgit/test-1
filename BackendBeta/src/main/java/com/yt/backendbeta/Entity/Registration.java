package com.yt.backendbeta.Entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="registration")
public class Registration {

	//TODO caching yet to be done
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false,nullable=false)
	private int id;
	private String name;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String address;
	private String institute;
	private String qualification;
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Course> course = new ArrayList<Course>();
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Package> pack = new ArrayList<Package>();
 	private int totalFee;
    private int feePaid;	
	private int feeDue;
	private Date registeredDate;
	private int courseCompletionStatus;
	private Date passoutDate;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	public int getFeePaid() {
		return feePaid;
	}
	public void setFeePaid(int feePaid) {
		this.feePaid = feePaid;
	}
	public int getFeeDue() {
		return feeDue;
	}
	public void setFeeDue(int feeDue) {
		this.feeDue = feeDue;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public int getCourseCompletionStatus() {
		return courseCompletionStatus;
	}
	public void setCourseCompletionStatus(int courseCompletionStatus) {
		this.courseCompletionStatus = courseCompletionStatus;
	}
	public Date getPassoutDate() {
		return passoutDate;
	}
	public void setPassoutDate(Date passoutDate) {
		this.passoutDate = passoutDate;
	}

	public List<Package> getPack() {
		return pack;
	}
	public void setPack(List<Package> pack) {
		this.pack = pack;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", institute=" + institute + ", qualification="
				+ qualification + ", course=" + course + ", pack=" + pack + ", totalFee=" + totalFee + ", feePaid="
				+ feePaid + ", feeDue=" + feeDue + ", registeredDate=" + registeredDate + ", courseCompletionStatus="
				+ courseCompletionStatus + ", passoutDate=" + passoutDate + "]";
	}
	
	

	

}
