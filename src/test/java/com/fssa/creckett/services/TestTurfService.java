package com.fssa.creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.model.User;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestTurfService {

	@Test
	void testHostTurfSuccess() {

		Turf turf = new Turf("https://www.example.com", "Chennai chennai");

		User user = new User();
		user.setId(16);

		turf.setCreatedBy(user);

		TurfService host = new TurfService();

		try {
			assertTrue(host.hostTurf(turf));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testHostTurfFailure() {

		Turf turf = new Turf("www.example.com", "Peru");
		TurfService host = new TurfService();

		try {
			assertFalse(host.hostTurf(turf));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test case for turflists
	 */
	@Test
	void testListTurf() {

		TurfService service = new TurfService();

		try {
			List<Turf> listOfTurf = service.turfList();
			assertNotNull(listOfTurf);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test case update turf
	 */
	@Test
	void testUpdateTurfSuccess() {

		TurfService service = new TurfService();

		Turf updateTurf = new Turf(86,
				"https://img.freepik.com/premium-photo/picturesque-cricket-stadium-with-lush-green-field-vibrant-crowd-spectators_75778-5540.jpg?w=2000",
				"Fresh Turf, Perungudi, Chennai");

		try {
			assertTrue(service.updateTurf(updateTurf));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	
	@Test
	void testUpdateTurfFailure() {

		TurfService service = new TurfService();
		
//		Giving the wrong turf Id

		Turf updateTurf = new Turf(10,
				"https://img.freepik.com/premium-photo/picturesque-cricket-stadium-with-lush-green-field-vibrant-crowd-spectators_75778-5540.jpg?w=2000",
				"Fresh Turf, Perungudi, Chennai");

		try {
			assertFalse(service.updateTurf(updateTurf));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
/**
 * Test cases for getTurfObject
 */
	
	@Test
	void testGetTurfObjectSuccess() {
		
		TurfService service = new TurfService();
		
		try {
			Turf turf = service.getTurfObject(71);
			
			assertNotNull(turf);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testGetTurfObjectFailure() {
		
		TurfService service = new TurfService();
		
		try {
//			Giving the wrong turf id
			Turf turf = service.getTurfObject(10);
			
			assertNull(turf);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * To-do Need to write testcases for deleteTurf 
	 */



}
