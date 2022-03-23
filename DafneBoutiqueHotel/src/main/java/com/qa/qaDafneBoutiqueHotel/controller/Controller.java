package com.qa.qaDafneBoutiqueHotel.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.qaDafneBoutiqueHotel.model.DafneReservations;
import com.qa.qaDafneBoutiqueHotel.services.ServiceDB;


@RestController
public class Controller {

	private ServiceDB service;

	public Controller(ServiceDB service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createReservation(@RequestBody DafneReservations reservation) {
		service.createReservationDB(reservation);

		ResponseEntity<String> response = new ResponseEntity<>("Reservation added with ID: " + reservation.getId(),
				HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<DafneReservations> getById(@PathVariable("id") long id) {

		DafneReservations result = service.getById(id);

		ResponseEntity<DafneReservations> response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		return response;

	}

	@GetMapping("/getReservations")
	public ResponseEntity<List<DafneReservations>> getReservation() {
		List<DafneReservations> response = service.getReservation();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		service.remove(id);
		String response = "Reservation of id: " + id + " deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable("id") long id,
			@RequestBody DafneReservations reservation) {
		service.update(id, reservation);
		String response = "Updating booking of id: " + id;
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll() {
		service.deleteAll();
		return new ResponseEntity<>("All reservations deleted", HttpStatus.ACCEPTED);

	}

	@GetMapping("/get/{bedsize}")
	public ResponseEntity<List<DafneReservations>> getByBedsize(@PathVariable("bedsize") String bedsize) {
		List<DafneReservations> response = service.getByBedsize(bedsize);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getPrice{price}")
	public ResponseEntity<List<DafneReservations>> getByPrice(@PathVariable("price") float price) {
		List<DafneReservations> response = service.getByPrice(price);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getBreakfast{bool}")
	public ResponseEntity<List<DafneReservations>> getByBreakfast(@PathVariable("bool") boolean bool) {
		List<DafneReservations> response = service.getByBreakfast(bool);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

}
