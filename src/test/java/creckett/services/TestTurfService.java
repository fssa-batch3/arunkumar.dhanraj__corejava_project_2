package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.services.TurfService;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestTurfService {

	@Test
	void testHostTurfSuccess() {

		Turf turf = new Turf("https://www.example.com", "Chennai chennai");
		TurfService host = new TurfService();

		try {
			assertTrue(host.hostTurf(turf));
		} catch (ServiceException e) {
			e.printStackTrace();
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

}
