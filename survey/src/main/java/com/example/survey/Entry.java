package com.example.survey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;


@Entity
public class Entry implements Serializable{
    
    private @Id @GeneratedValue Long id; // used as primary key for db
	
	@NotNull
    private String first;

	@NotNull
    private String last;

	@NotNull
    private String street;


	@NotNull
    private String city;
	
	@NotNull
    private String state;


	@NotNull
    private String zip;

	@NotNull
    private String telephone;

	@NotNull
    private String email;

	@NotNull
    private String date;



    private String [] likes;


    private String interest;



    private String recommend;
    


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String [] likes) {
		this.likes = likes;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getRecommend() {
		return recommend;
	}
    
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
}