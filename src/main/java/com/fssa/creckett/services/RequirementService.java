package com.fssa.creckett.services;

import java.util.List;

import com.fssa.creckett.dao.RequirementDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.RequirementValidator;
import com.fssa.creckett.validation.exceptions.InvalidRequirementException;

public class RequirementService {
	
    /**
     * method for posting the requirement
     * @param requirement
     * @return boolean
     * @throws ServiceException
     */
	public boolean postRequirement(Requirement requirement) throws ServiceException {

		RequirementValidator validator = new RequirementValidator();
		RequirementDAO requirementDAO = new RequirementDAO();

		try {

			validator.validateRequirement(requirement);
			return requirementDAO.createRequirement(requirement);

		} catch (InvalidRequirementException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * getting the list of requirement list
	 * @return List<Requirement>
	 * @throws ServiceException
	 */
	public List<Requirement> listRequirement() throws ServiceException {

		RequirementValidator validator = new RequirementValidator();
		RequirementDAO requirementDAO = new RequirementDAO();

		try {
			List<Requirement> reqList = requirementDAO.getAllRequirementList();
			validator.validateRequirementList(reqList);

			return reqList;
		} catch (DAOException | InvalidRequirementException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

}
