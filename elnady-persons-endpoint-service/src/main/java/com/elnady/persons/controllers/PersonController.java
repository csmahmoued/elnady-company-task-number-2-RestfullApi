package com.elnady.persons.controllers;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elnady.persons.model.Person;
import com.elnady.persons.repository.PersonRepository;
import com.elnady.persons.service.PersonService;

/** this class to mange endpoint mapping of person apis*/
@RestController
public class PersonController {

	private PersonService personService;
	
	@Autowired
	private PersonRepository pr;
	

	/** this construct to inject personService object by construct injection method*/
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	/** this url return all person as json object list */
	@GetMapping("/persons")
	public List<Person> allPersons(){
		return personService.getAllPersons();
	}

	/** this url add new object of person by post method*/
	@PostMapping("/persons")
	public ResponseEntity<Person> saveNewPerson(@RequestBody Person person) {
			personService.addNewPerson(person);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/** this url delete  object of person by delete method*/	
	@DeleteMapping("persons/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable int id){
		personService.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("persons/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id){
		return new ResponseEntity<>(personService.getPersonById(id),HttpStatus.OK);
	} 
	
	@PutMapping("/persons/{id}")
	public ResponseEntity<Void> updatePerson(@RequestBody Person person,@PathVariable int id){
		pr.findById(id).map(p->{
				p.setId(id);
				p.setPersonEmail(person.getPersonEmail());
				p.setPersonName(person.getPersonName());
				p.setPersonPhone(person.getPersonPhone());
				return pr.save(p);
		}).orElseGet(()->{
			person.setId(id);
			return pr.save(person);
		});
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
}
