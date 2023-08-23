package com.fssa.creckett.services;

import com.fssa.creckett.dao.RequirementDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.RequirementValidator;
import com.fssa.creckett.validation.exceptions.InvalidRequirementException;

public class RequirementService {

	public boolean postRequirement(Requirement requirement) throws ServiceException {

		RequirementValidator validator = new RequirementValidator();
		RequirementDAO requirementDAO = new RequirementDAO();
 
		try {
			
			return validator.validateRequirement(requirement) && requirementDAO.createRequirement(requirement);
		
		} catch (InvalidRequirementException | DAOException e) {
			throw new ServiceException("Error in posting the requirement in service", e);
		}
		
	}

}
