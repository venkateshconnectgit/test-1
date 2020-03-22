package com.yt.backendbeta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="price")
public class Price {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(updatable=false,nullable = false)
   private int id;
   private String courseOrPackage;
   private int price;
   private int percentTax;
   private int totalTax;
   private int finalPrice;
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCourseOrPackage() {
	return courseOrPackage;
}
public void setCourseOrPackage(String course) {
	this.courseOrPackage = course;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPercentTax() {
	return percentTax;
}
public void setPercentTax(int percentTax) {
	this.percentTax = percentTax;
}
public int getTotalTax() {
	return totalTax;
}
public void setTotalTax(int totalTax) {
	this.totalTax = totalTax;
}
public int getFinalPrice() {
	return finalPrice;
}
public void setFinalPrice(int finalPrice) {
	this.finalPrice = finalPrice;
}
@Override
public String toString() {
	return "Price [id=" + id + ", course=" + courseOrPackage + ", price=" + price + ", percentTax=" + percentTax + ", totalTax="
			+ totalTax + ", finalPrice=" + finalPrice + "]";
}
   
   
}
