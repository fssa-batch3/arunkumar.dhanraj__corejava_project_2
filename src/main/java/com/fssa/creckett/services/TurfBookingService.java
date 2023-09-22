package com.fssa.creckett.services;

import java.util.List;

import com.fssa.creckett.dao.TurfBookingDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.TurfBooking;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.TurfBookingValidator;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

/**
 * @author ArunkumarDhanraj
 *
 */
public class TurfBookingService {

	/**
	 * Booking the turf by turfbooking object
	 * 
	 * @param booking
	 * @return boolean
	 * @throws ServiceException
	 */
	public boolean bookTurf(TurfBooking booking) throws ServiceException {

		TurfBookingValidator validator = new TurfBookingValidator();
		TurfBookingDAO bookingDAO = new TurfBookingDAO();

		try {

			validator.validateTurfBooking(booking);
			return bookingDAO.bookTurf(booking);

		} catch (InvalidTurfException | DAOException e) {
			throw new ServiceException("Cannot book now", e);
		}

	}

	public List<String> getTimeByDate(int turfId, String date) throws ServiceException {
		TurfBookingDAO bookingDAO = new TurfBookingDAO();

		try {

			return bookingDAO.getAllTimesbyDate(turfId, date);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

}
