package com.capg.fms.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.model.Booking;

public interface IBookingRepository {
	@Repository
	public interface IBookingRepo extends JpaRepository<Booking, Long>{

	}

}
