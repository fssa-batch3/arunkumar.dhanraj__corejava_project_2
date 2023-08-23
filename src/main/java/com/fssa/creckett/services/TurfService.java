package com.fssa.creckett.services;

import com.fssa.creckett.dao.TurfDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Turf;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.TurfValidator;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

public class TurfService {

	public boolean hostTurf(Turf turf) throws ServiceException {

		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();

		try {

			return turfValidator.validateTurf(turf) && turfDAO.createTurf(turf);

		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException("Error in hosting a turf in service", e);
		}

	}
	
	
	public boolean updateTurf(Turf turf) throws ServiceException{
		
		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();
		
		try {

			return turfValidator.validateTurf(turf) && turfDAO.updateTurf(turf);

		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException("Error in updating a turf in service", e);
		}
		
	}

}
