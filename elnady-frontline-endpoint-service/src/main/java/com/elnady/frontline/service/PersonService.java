package com.elnady.frontline.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elnady.frontline.model.Person;

/** this interface use to call persons endpoints by FerigClient interface*/

@FeignClient("elnady-persons-endpoint-service")
public interface PersonService {

	/** call /persons from persons service */
	 @RequestMapping(method = RequestMethod.GET,value = "/persons",consumes = "application/json")
	 public List<Person> getAllPersons();

		/** call /persons/id from persons service */
	 @RequestMapping("/persons/{id}")
	 public void deletePerson(@PathVariable int id);

		/** call /persons/{id}  from persons service to get person by id */
	 @RequestMapping("/persons/{id}")
	 public Person getPerson(@PathVariable int id);
	 
		/** call /persons{id} from persons service to update service */
	 @RequestMapping("/persons/{id}")
	 public Person updatePerson(@RequestBody Person person,@PathVariable int id);
	 
		/** call /persons from persons service to add new service */
	 @RequestMapping(method = RequestMethod.POST,value = "/persons",consumes = "application/json")
	 public Person addNewPerson(Person person);
	 
	
}
