package com.elnady.frontline;

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

import com.elnady.frontline.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.elnady.frontline.model.Person;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT )
@AutoConfigureMockMvc
class ElnadyFrontlineEndpointServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	@Test
	public void whenGetAllFrontlineFromPersons() throws Exception {
		Person person=new Person(4,"mahmoud","a@yahoo.com", "0100656595");
						
		List<Person> persons=Arrays.asList(person);
		given(personService.getAllPersons()).willReturn(persons);
		mockMvc.perform(get("/frontline").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].personName",equalTo(person.getPersonName())));
	}
	
	@Test
	public void whenPersonCreatedFromFrontlineEndpoint() throws Exception{
		Person person=new Person();
		person.setId(55);
		person.setPersonName("alo");
		person.setPersonPhone("56565656");
		person.setPersonEmail("cs@yahoo.com");
		given(personService.addNewPerson(Mockito.any(Person.class))).willReturn(person);

		ObjectMapper mapper=new ObjectMapper();
		mockMvc.perform(post("/frontline").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(person)))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void whenPersonDeletedFromFrontLineEndPoint()throws Exception{
		mockMvc.perform(delete("/frontline/2").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
	}
	
	@Test
	public void whenPersonGetByFromFrontLineEndPoint()throws Exception{
		mockMvc.perform(get("/frontline/2").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
