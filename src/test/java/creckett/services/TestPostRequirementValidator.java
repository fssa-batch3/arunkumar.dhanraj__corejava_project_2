package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import creckett.model.Requirement;
import creckett.dao.RequirementDAO;
import creckett.dao.exceptions.DAOException;
import creckett.services.exceptions.ServiceException;

class TestPostRequirementValidator {

	@Test
	void testPostRequirementSuccess() {

		Requirement requirement = new Requirement("I want a batsman");
		RequirementService hostReq = new RequirementService();

		try {
			assertTrue(hostReq.postRequirement(requirement));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	void testPostRequirementFailure() {

		Requirement requirement = new Requirement("I    ");
		RequirementService hostReq = new RequirementService();

		try {
			assertFalse(hostReq.postRequirement(requirement));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
	
	@AfterAll
	static void deleteRequirement() {
		RequirementDAO requirementDAO = new RequirementDAO();
		
		try {
			requirementDAO.deleteRequirement("I want a batsman");
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}
