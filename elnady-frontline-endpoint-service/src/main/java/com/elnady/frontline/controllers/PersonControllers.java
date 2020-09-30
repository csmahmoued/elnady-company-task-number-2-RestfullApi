package com.elnady.frontline.controllers;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elnady.frontline.model.Person;
import com.elnady.frontline.service.PersonService;

@RestController
public class PersonControllers {

	private PersonService personService;

	// this constructor to inject personService by constructor injection methods
	public PersonControllers(PersonService personService) {
		this.personService = personService;
	}
	
	
	/** frontline call person to get all /persons */
	@GetMapping("/frontline")
	public ResponseEntity<List<Person>> allPersons(){
		return new ResponseEntity<>(personService.getAllPersons(),HttpStatus.OK);
	}
	
	/** frontline call person to get one  person by id*/
	@GetMapping("/frontline/{id}")
	public ResponseEntity<Person> personById(@PathVariable int id){
		return new ResponseEntity<>(personService.getPerson(id),HttpStatus.OK);
	}

	/** frontline/{id} call person to delete   person by id from person/id endpoint*/
	@DeleteMapping("/frontline/{id}")	
	public ResponseEntity<Void> delPerson(@PathVariable int id){
		personService.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/frontline")
	public ResponseEntity<Void> addPerson(@RequestBody Person person){
		personService.addNewPerson(person);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
}
