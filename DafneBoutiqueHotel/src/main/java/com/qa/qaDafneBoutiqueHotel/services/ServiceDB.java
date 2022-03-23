package com.qa.qaDafneBoutiqueHotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.qa.qaDafneBoutiqueHotel.model.DafneReservations;
import com.qa.qaDafneBoutiqueHotel.repo.Repo;

@Service
public class ServiceDB {

	private Repo repo;

	public ServiceDB(Repo repo) {
		super();
		this.repo = repo;
	}

	// Replace the SQL query INSERT INTO Dafne_reservations (suite, bedsize, breakfast),
	// CREATE DONE
	public DafneReservations createReservationDB(DafneReservations reservation) {

		return repo.save(reservation);
	}


	// Search a record by Id
	public DafneReservations getById(long id) {
		// create an optional
		Optional<DafneReservations> a = repo.findById(id);
		return a.get();

	}

	//GET ALL DONE
	public List<DafneReservations> getReservation() {
		return repo.findAll();

	}

	public boolean deleteAll() {
		repo.deleteAll();
		return true;

	}

	// Update
	public boolean update(long id, DafneReservations reservation) {
		DafneReservations oldReservation = getById(id);

		oldReservation.setSuite(reservation.getSuite());
		oldReservation.setBedsize(reservation.getBedsize());
		oldReservation.setPrice(reservation.getPrice());
		oldReservation.setBreakfast(reservation.isBreakfast());

		DafneReservations updatedReservation = oldReservation;

		repo.save(updatedReservation);
		return true;

	}

	public List<DafneReservations> getBySuite(String Suite) {
		return repo.findBySuite(Suite);

	}

	public List<DafneReservations> getByBedsize(String Bedsize) {
		return repo.findByBedsize(Bedsize);

	}

	public List<DafneReservations> getByPrice(float price) {
		return null;

	}

	public List<DafneReservations> getByBreakfast(boolean bool) {
		return null;

	}

	public void remove(long id) {
		

	}

	

}
