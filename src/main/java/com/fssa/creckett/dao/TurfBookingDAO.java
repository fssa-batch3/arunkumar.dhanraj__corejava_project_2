package com.fssa.creckett.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Turf;
import com.fssa.creckett.model.TurfBooking;
import com.fssa.creckett.model.User;
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

	/**
	 * Getting the turf and turf owner details by turf id
	 * 
	 * @param turfId
	 * @return TurfBooking
	 * @throws DAOException
	 */

	public TurfBooking getTurfBookingById(int turfId) throws DAOException {

		TurfBooking turfBooking = new TurfBooking();

		final String SELECTQUERY = "SELECT t.image, t.details, t.created_user, u.id, u.name, u.email, u.phonenumber "
				+ "FROM turf t " + "INNER JOIN users u ON u.id = t.created_user " + "WHERE t.turf_id = ?";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pst = connect.prepareStatement(SELECTQUERY);) {

			pst.setInt(1, turfId);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPhonenumber(rs.getString("phonenumber"));

					Turf turf = new Turf(rs.getString("image"), rs.getString("details"));
					turf.setTurfId(turfId);
					turf.setCreatedBy(user);

					turfBooking.setTurf(turf);

				}

			}

		} catch (SQLException e) {
			throw new DAOException("Cannot view the turf now", e);
		}

		return turfBooking;

	}

	/**
	 * Getting all the bookings by for the user by userId
	 * 
	 * @param userId
	 * @return List<TurfBooking>
	 * @throws DAOException
	 */

	public List<TurfBooking> getAllTurfBookingByUserId(int userId) throws DAOException {

		List<TurfBooking> bookings = new ArrayList<>();

		final String SELECTQUERY = "SELECT " + "    tb.booking_id, " + "    tb.date, " + "    tb.time, "
				+ "    tb.user_id, " + "    t.image, " + "    t.details, " + "    t.created_user, " + "    u.id, "
				+ "    u.name, " + "    u.email, " + "    u.phonenumber " + "FROM " + "    turf_booking AS tb "
				+ "INNER JOIN " + "    turf AS t ON tb.turf_id = t.turf_id "
				+ "INNER JOIN users as u ON u.id = t.created_user " + "WHERE " + "    tb.user_id = ? " + "ORDER BY "
				+ "    tb.date DESC, " + "    STR_TO_DATE(SUBSTRING_INDEX(tb.time, ' - ', 1), '%l%p') ASC, "
				+ "    STR_TO_DATE(SUBSTRING_INDEX(tb.time, ' - ', -1), '%l%p') ASC";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pst = connect.prepareStatement(SELECTQUERY);) {

			pst.setInt(1, userId);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					User createdUser = new User();
					createdUser.setName(rs.getString("name"));
					createdUser.setEmail(rs.getString("email"));
					createdUser.setPhonenumber(rs.getString("phonenumber"));

					Turf turf = new Turf(rs.getString("image"), rs.getString("details"));
					turf.setCreatedBy(createdUser);

					TurfBooking booking = new TurfBooking();
					booking.setBookingId(rs.getInt("booking_id"));

					Date sqlDate = rs.getDate("date");
					String dateString = sqlDate.toString();

					booking.setStrDate(dateString);
					booking.setTime(rs.getString("time"));

					booking.setTurf(turf);

					bookings.add(booking);

				}

				return bookings;
			}

		} catch (SQLException e) {
			throw new DAOException("Cannot show the bookings", e);
		}

	}

}
