package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import creckett.model.Turf;
import creckett.validation.TurfValidator;
import creckett.validation.exceptions.InvalidTurfException;
import creckett.dao.TurfDAO;
import creckett.dao.exceptions.DAOException;
import creckett.services.exceptions.ServiceException;

public class TurfService {

	public boolean hostTurf(Turf turf) throws ServiceException {

		TurfValidator turfValidator = new TurfValidator(turf);
		TurfDAO turfDAO = new TurfDAO();

		try {
			if (turfValidator.validateAll()) {
				if (turfDAO.createTurf(turf)) {
					return true;
				}
			}
		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException("Error in hosting a turf in service", e);
		}
		return false;

	}

}
