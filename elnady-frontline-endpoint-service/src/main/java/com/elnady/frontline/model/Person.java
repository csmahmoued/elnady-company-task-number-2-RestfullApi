package com.elnady.frontline.model;


public class Person {

	private int id;	
	private String personName;
	private String personEmail;
	private String personPhone;
	
	public Person(){}
	

	/** person constructor for adding new person object */
	public Person(int id, String personName, String personEmail, String personPhone) {
		this.id = id;
		this.personName = personName;
		this.personEmail = personEmail;
		this.personPhone = personPhone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getPersonEmail() {
		return personEmail;
	}


	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}


	public String getPersonPhone() {
		return personPhone;
	}


	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	
	
	

}
