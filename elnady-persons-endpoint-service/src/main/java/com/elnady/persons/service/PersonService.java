package com.elnady.persons.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elnady.persons.model.Person;
import com.elnady.persons.repository.PersonRepository;

@Service
public class PersonService {

	
	private PersonRepository personRepository;
	
	/** this contructor to inject personRepository by contructor injection*/
	public PersonService(PersonRepository personRepository) {
		this.personRepository=personRepository;
	}
	
	
	/** this method take person object as permeter and return saved object*/
	public Person addNewPerson(Person person ) {
		return personRepository.save(person);
	}
	
	
	/** this method return all persons in database as json object list */
	public List<Person> getAllPersons(){
		return  personRepository.findAll();
	}
	
	/** this method take person id as permeter and delte it .*/
	public void deletePerson(int personId) {
		personRepository.deleteById(personId);
	}
	
	
	public Person getPersonById(int id) {
		return personRepository.findById(id).get();
	}
	
		
	
	
	
	
	
}
