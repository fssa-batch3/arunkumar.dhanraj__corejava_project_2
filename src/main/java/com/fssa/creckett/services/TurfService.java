package com.fssa.creckett.services;

import java.util.List;

import com.fssa.creckett.dao.TurfDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Turf;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.TurfValidator;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

public class TurfService {

	/**
	 * Hosting the turf
	 * 
	 * @param turf
	 * @return boolean
	 * @throws ServiceException
	 */

	public boolean hostTurf(Turf turf) throws ServiceException {

		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();

		try {
			turfValidator.validateTurf(turf);
			return turfDAO.createTurf(turf);
		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Listing the list of turfs
	 * 
	 * @return List<Turf>
	 * @throws ServiceException
	 */
	public List<Turf> turfList() throws ServiceException {

		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();

		try {
			List<Turf> listOfturf = turfDAO.getAllTurfList();
			turfValidator.validateTurfList(listOfturf);
			return listOfturf;
		} catch (DAOException | InvalidTurfException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Updating the turf
	 * 
	 * @param turf
	 * @return boolean
	 * @throws ServiceException
	 */
	public boolean updateTurf(Turf turf) throws ServiceException {

		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();

		try {

			return turfValidator.validateTurf(turf) && turfDAO.updateTurf(turf);

		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * deleting the turf by id
	 * 
	 * @param id
	 * @return boolean
	 * @throws ServiceException
	 */

	public boolean deleteTurf(int id) throws ServiceException {

		TurfDAO turfDAO = new TurfDAO();

		try {
			return turfDAO.deleteTurf(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}
	
	
	/**
	 * getting the turf object by turf id
	 * @param turfId
	 * @return Turf
	 * @throws ServiceException
	 */

	public Turf getTurfObject(int turfId) throws ServiceException {

		TurfValidator turfValidator = new TurfValidator();
		TurfDAO turfDAO = new TurfDAO();

		try {
			
			Turf turf = turfDAO.getTurfById(turfId);
			turfValidator.validateTurfObject(turf);
			return turf;
			
		} catch (DAOException | InvalidTurfException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

}
