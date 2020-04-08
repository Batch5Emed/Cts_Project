package com.app.pojos;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name = "UserT")
public class User {
 private Integer userId;
 String userNanme;
 String email;
 String password;
 String contact;
 String specialisation;
 String gender;
 String appstatus;
 List<Appointment> app;
 Role userType;
 
 
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserNanme() {
	return userNanme;
}
public void setUserNanme(String userNanme) {
	this.userNanme = userNanme;
}


public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Role getUserType() {
	return userType;
}
public void setUserType(Role userType) {
	this.userType = userType;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getSpecialisation() {
	return specialisation;
}
public String getAppstatus() {
	return appstatus;
}
public void setAppstatus(String appstatus) {
	this.appstatus = appstatus;
}
public void setSpecialisation(String specialisation) {
	this.specialisation = specialisation;
}

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
public List<Appointment> getApp() {
	return app;
}
public void setApp(List<Appointment> app) {
	this.app = app;
}




 
 
 
 

}
