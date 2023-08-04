package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import creckett.validation.RequirementValidator;
import creckett.validation.exceptions.InvalidTurfException;
import creckett.dao.RequirementDAO;
import creckett.dao.exceptions.DAOException;
import creckett.model.Requirement;
import creckett.services.exceptions.ServiceException;

public class RequirementService {

	public boolean postRequirement(Requirement requirement) throws ServiceException {

		RequirementValidator validator = new RequirementValidator(requirement);
		RequirementDAO requirementDAO = new RequirementDAO();

		try {
			if (validator.validateAll()) {
				if (requirementDAO.createRequirement(requirement)) {
					return true;
				}
			}
		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException("Error in posting the requirement in service", e);
		}
		return false;
	}

}
