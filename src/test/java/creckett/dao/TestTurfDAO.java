package creckett.dao;

/**
 * @author ArunkumarDhanraj
 *
 */



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.dao.TurfDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Turf;
import com.fssa.creckett.services.TurfService;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestTurfDAO {

	@Test
	void testGetAllTurfSuccess() {

		TurfDAO turfDAO = new TurfDAO();
		TurfService service = new TurfService();
		try {
			assertTrue(service
					.hostTurf(new Turf("https://github.com/geek-bhirahatees", System.nanoTime() + "Chennai chennai")));
			List<Turf> list = turfDAO.getAllTurfList();
			assertNotNull(list);
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
		}

	}

}
