package com.example.survey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Entry {
    
    private @Id @GeneratedValue Long id; // used as primary key for db
    private String first;
    private String last;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String telephone;
    private String email;
    private String date;
    private String [] likes;
    private String interest;
    private String recommend;
    
    Entry() {}

    Entry(String first, String last, String street, String city,
            String state, String zip, String telephone, String email,
            String date, String [] likes, String interest, String recommend) {
        
        this.first = first;
        this.last = last;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
        this.date = date;
        this.likes = likes;
        this.interest = interest;
        this.recommend = recommend;

    }

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