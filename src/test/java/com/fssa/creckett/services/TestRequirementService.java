package com.fssa.creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;




import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.fssa.creckett.dao.RequirementDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestRequirementService {


	
	
	
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
