package com.qa.qaDafneBoutiqueHotel.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.qaDafneBoutiqueHotel.model.DafneReservations;
import com.qa.qaDafneBoutiqueHotel.repo.Repo;


	@SpringBootTest
	@AutoConfigureMockMvc
	@Sql(scripts = {"classpath:dafne_boutique_hotel-schema.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD) // prepopulate our H2
	
	// DB
	
	@ActiveProfiles("test") // run this test class on the db in the application-test.properties
	public class ControllerTest {
	
		@Autowired
		private MockMvc mock; //to mock the requests
		@Autowired
		private ObjectMapper map; // interprets JSON
		
		@Test
		void testCreate() throws Exception {
			// -- request
			// type, url, body
			//body - JSON -OBject
			
		DafneReservations create = new DafneReservations("suite1", "bedsize1", 100, false); 
		// Object; convert into JSON
		String createJson = this.map.writeValueAsString(create); 
		//build up the mock request
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON);
		// response. Body with Id
		DafneReservations saved = new DafneReservations (4L, "suite1", "bedsize1", 100, false); 
		// convert into JSON String
		String savedJSON = this.map.writeValueAsString(saved); 
		// test response is correct (status + body). Status 201 created
		ResultMatcher matchStatus = status().isCreated(); 
		// test response body
		ResultMatcher matchBody = content().json(savedJSON);
		// perform the test
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
		}
		@Test
		void readTest() throws Exception {
			// db values
			DafneReservations a = new DafneReservations(1L, "suite1", "bedsize1", 100, false);
			DafneReservations b = new DafneReservations(2L, "suite2", "bedsize2", 120, false);
			DafneReservations c = new DafneReservations(3L, "suite3", "bedsize3", 150, true);
			
			// store in List
			List<DafneReservations> db = List.of(a, b, c);
			// Convert to JSON
			String dbJSON = this.map.writeValueAsString(db);
			// build request
		RequestBuilder mockReq = get("/readAll");
		
			// Response
		ResultMatcher status = status().isOk();
		ResultMatcher body = content().json(dbJSON);
		// test
		this.mock.perform(mockReq).andExpect(body).andExpect(status);
		
		}
		
		@Test
		void testDelete() throws Exception {
			// --request  - type - delete, path param -id, url
			Long id = 1L;
			RequestBuilder mockRequest = delete("/delete/?id-" + id);
			// -- response - status, boolean-body
			// body (JSON with id)
			
			DafneReservations deleted = new DafneReservations (2L, "suite2", "bedsize2", 120, true);
			// convert into JSON String
			
			String deletedJSON = this.map.writeValueAsString(deleted);
			// test
			ResultMatcher status = status().isOk();
			ResultMatcher body = content().json(deletedJSON);
			this.mock.perform(mockRequest).andExpect(body).andExpect(status);
		}
		
		@Test
		void testRemove() throws Exception {
			// -- request - type- delete, path param -id, url
			Long id = 1L;
			RequestBuilder mockRequest = delete("/remove/?id="+id);
			
			// response - status, bo0lean-body
			
			ResultMatcher status = status().isOk();
			ResultMatcher body = content().string("true");
			
			// --- test
			this.mock.perform(mockRequest).andExpect(body).andExpect(status);
			
			}
	
	
		
		
		}
		
	