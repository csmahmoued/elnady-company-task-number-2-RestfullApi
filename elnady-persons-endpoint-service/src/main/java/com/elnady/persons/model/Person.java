package com.elnady.persons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** table of entity person  */

@Entity
public class Person {
	
	/** id of person entity it auto icrease */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** person name attribute of entity of string type*/
	private String personName;

	/** person email attribute of entity of string type*/
	private String personEmail;

	/** person phone attribute of entity of string type*/	
	private String personPhone;
	
	/** constructor of person */
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
