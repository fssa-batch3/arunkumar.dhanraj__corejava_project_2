package creckett.dao;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.dao.RequirementDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.services.RequirementService;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestRequirementDAO {

	@Test
	void testGetAllRequirementSuccess() {

		RequirementDAO requirementDAO = new RequirementDAO();
		RequirementService service = new RequirementService();

		try {
			assertTrue(service.postRequirement(new Requirement("I want a bowler")));
			List<Requirement> list = requirementDAO.getAllRequirementList();
			assertNotNull(list);
			assertTrue(requirementDAO.deleteRequirement("I want a bowler"));
		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testGetAllRequirementFailure() {

		RequirementDAO requirementDAO = new RequirementDAO();
		RequirementService service = new RequirementService();

		try {
			assertFalse(service.postRequirement(new Requirement("L   ")));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		List<Requirement> list = null;
		try {
			list = requirementDAO.getAllRequirementList();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		assertEquals(0, list.size());

	}

}
