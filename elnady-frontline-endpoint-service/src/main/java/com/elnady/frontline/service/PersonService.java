package com.elnady.frontline.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elnady.frontline.model.Person;

/** this interface use to call persons endpoints by FerigClient interface*/

@FeignClient("elnady-persons-endpoint-service")
public interface PersonService {

	 @RequestMapping(method = RequestMethod.GET,value = "/persons",consumes = "application/json")
	 public List<Person> getAllPersons();
	 
	 @RequestMapping(method = RequestMethod.DELETE,value = "/persons/{id}",consumes = "application/json")
	 public void deletePerson(int id);

	 @RequestMapping(method = RequestMethod.GET,value = "/persons/{id}",consumes = "application/json")
	 public Person getPerson(int id);
	 
	 @RequestMapping(method = RequestMethod.POST,value = "/persons",consumes = "application/json")
	 public Person addNewPerson(Person person);
	 
	
}
