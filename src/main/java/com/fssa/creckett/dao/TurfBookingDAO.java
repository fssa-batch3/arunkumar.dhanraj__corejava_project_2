package com.fssa.creckett.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.TurfBooking;
import com.fssa.creckett.utils.ConnectionUtil;

/**
 * @author ArunkumarDhanraj
 *
 */
public class TurfBookingDAO {

	/**
	 * Inserting the booking details
	 * 
	 * @param TurfBooking
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean bookTurf(TurfBooking booking) throws DAOException {

		final String INSERTQUERY = "insert into turf_booking (turf_id,user_id,date,time) values (?,?,?,?)";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pst = connect.prepareStatement(INSERTQUERY);) {

			pst.setInt(1, booking.getTurf().getTurfId());
			pst.setInt(2, booking.getUser().getId());

			java.sql.Date sqlDate = java.sql.Date.valueOf(booking.getDate());

			pst.setDate(3, sqlDate);
			pst.setString(4, booking.getTime());

			int row = pst.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Cannot book the turf", e);
		}

	}

}
