package com.elnady.persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elnady.persons.model.Person;
 
/** this is interface to mange person table in database  */

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer>{

}
