package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import creckett.model.Turf;
import creckett.dao.TurfDAO;
import creckett.dao.exceptions.DAOException;
import creckett.services.exceptions.ServiceException;

class TestHostTurfFeature {

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

		Turf turf = new Turf("www.example.com", "Perum");
		TurfService host = new TurfService();

		try {
			assertFalse(host.hostTurf(turf));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void deleteTurf() {
		TurfDAO turfDAO = new TurfDAO();

		try {
			turfDAO.deleteTurf("Chennai chennai");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
