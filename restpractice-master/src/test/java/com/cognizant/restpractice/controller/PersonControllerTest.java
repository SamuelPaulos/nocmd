package com.cognizant.restpractice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	public MockMvc mvc;


	@Test
	public void getByIdTest() throws Exception {
		this.mvc.perform(get("/2").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is("2"))).andExpect(jsonPath("$.first_name", is("Merih")))
				.andExpect(jsonPath("$.last_name", is("Gebreyohannes")));
	}

	@Test
	public void getAllPersonInListTest() throws Exception {
		this.mvc.perform(get("http://localhost:8080/all").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is("1")))
				.andExpect(jsonPath("$[0].first_name", is("Merih")))
				.andExpect(jsonPath("$[0].last_name", is("Gebreyohannes")))
				.andExpect(jsonPath("$[1].id", is("2")))
				.andExpect(jsonPath("$[1].first_name", is("Merih")))
				.andExpect(jsonPath("$[1].last_name", is("Gebreyohannes")));
	}



}
