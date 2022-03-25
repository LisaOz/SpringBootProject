package com.qa.qaDafneBoutiqueHotel.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.qaDafneBoutiqueHotel.repo.Repo;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:dafne_boutique_hotel-schema.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)


@ActiveProfiles("test")
public class ServicesTest {
	@Autowired
	private MockMvc mock;
	
	@Test
	void testCreateReservationDB() throws Exception {
		
	}
	
	

}


