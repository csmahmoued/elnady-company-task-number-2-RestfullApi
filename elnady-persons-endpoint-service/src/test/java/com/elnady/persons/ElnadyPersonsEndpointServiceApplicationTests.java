package com.elnady.persons;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.elnady.persons.model.Person;
import com.elnady.persons.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
class ElnadyPersonsEndpointServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService ps;
	
	@Test
	public void whenGetAllPersons() throws Exception {
		Person person=new Person(4,"mahmoud","a@yahoo.com", "0100656595");
						
		List<Person> persons=Arrays.asList(person);
		given(ps.getAllPersons()).willReturn(persons);
		mockMvc.perform(get("/persons").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].personName",equalTo(person.getPersonName())));
	}
	
	@Test
	public void whenPersonCreated() throws Exception{
		Person person=new Person();
		person.setId(55);
		person.setPersonName("alo");
		person.setPersonPhone("56565656");
		person.setPersonEmail("cs@yahoo.com");
		given(ps.addNewPerson(Mockito.any(Person.class))).willReturn(person);

		ObjectMapper mapper=new ObjectMapper();
		mockMvc.perform(post("/persons").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(person)))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void whenPersonDeleted()throws Exception{
		mockMvc.perform(delete("/persons/2").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}
	
	@Test
	public void whenPersonGetById()throws Exception{
		mockMvc.perform(delete("/persons/2").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	

}
