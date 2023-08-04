package creckett.dao;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import creckett.dao.exceptions.DAOException;
import creckett.services.TurfService;
import creckett.services.exceptions.ServiceException;
import creckett.model.Turf;

class TestTurfValidator {

	@Test
	void testGetAllTurfSuccess() {

		TurfDAO turfDAO = new TurfDAO();
		TurfService service = new TurfService();
		try {
			assertTrue(service.hostTurf(new Turf("https://github.com/geek-bhirahatees", "Chennai chennai")));
			ArrayList<Turf> list = turfDAO.getAllTurfList();
			assertNotNull(list);
			assertTrue(turfDAO.deleteTurf("Chennai chennai"));
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testGetAllTurfFailure() {

		TurfDAO turfDAO = new TurfDAO();
		TurfService service = new TurfService();

		try {
			assertFalse(service.hostTurf(new Turf("github.com/geek-bhirahatees", "Chennai chennai")));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		ArrayList<Turf> list = null;

		try {
			list = turfDAO.getAllTurfList();
		} catch (DAOException e) {
			e.printStackTrace();
		}

		assertEquals(0, list.size());

	}

}
