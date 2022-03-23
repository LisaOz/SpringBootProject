package com.qa.qaDafneBoutiqueHotel.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.qaDafneBoutiqueHotel.model.DafneReservations;

@Repository
public interface Repo extends JpaRepository<DafneReservations, Long> {


	public List<DafneReservations> findBySuite(String suite);
	public List<DafneReservations> findByBedsize(String bedsize);
	public List<DafneReservations> findByPrice(float price);
	public List<DafneReservations> findByBreakfast(boolean bool);
	

	
	
	

}
