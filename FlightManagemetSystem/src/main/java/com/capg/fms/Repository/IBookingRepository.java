package com.capg.fms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.model.Booking;


	@Repository
	public interface IBookingRepo extends JpaRepository<Booking, Long>{
		

	}

