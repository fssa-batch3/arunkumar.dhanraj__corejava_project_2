package com.fssa.creckett.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Getting all the booked times by date
	 * 
	 * @param turfId
	 * @param date
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> getAllTimesbyDate(int turfId, String date) throws DAOException {

		List<String> times = new ArrayList<>();

		final String SELECTQUERY = "Select time from turf_booking where turf_id=? AND date = ?";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pst = connect.prepareStatement(SELECTQUERY);) {

			pst.setInt(1, turfId);

			java.sql.Date sqlDate = java.sql.Date.valueOf(date);
			pst.setDate(2, sqlDate);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					times.add(rs.getString("time"));
				}
			}
			return times;

		} catch (SQLException e) {
			throw new DAOException("Cannot get the time", e);
		}

	}

}
