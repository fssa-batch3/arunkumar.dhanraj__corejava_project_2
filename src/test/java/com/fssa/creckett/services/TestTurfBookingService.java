package com.fssa.creckett.services;

import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.model.TurfBooking;
import com.fssa.creckett.model.User;
import com.fssa.creckett.services.exceptions.ServiceException;

/**
 * @author ArunkumarDhanraj
 *
 */
class TestTurfBookingService {
	
	private TurfBookingService service;

	@BeforeEach
	void setUp() {
		service = new TurfBookingService();
	}


	@Test
	void testInvalidBooking() {
		
		
		Turf turf =new Turf();
		turf.setTurfId(2); //invalid turf id
		
		User user = new User();
		user.setId(90); 
		
		TurfBooking invalidBooking = new TurfBooking(turf,user,LocalDate.now(),"01PM - 02PM");

		assertThrows(ServiceException.class, () -> service.bookTurf(invalidBooking));
	}

}
