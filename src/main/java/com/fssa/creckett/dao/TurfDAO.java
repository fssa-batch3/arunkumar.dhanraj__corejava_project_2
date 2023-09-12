package com.fssa.creckett.dao;

import java.sql.Connection;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.Turf;
import com.fssa.creckett.model.User;
import com.fssa.creckett.utils.ConnectionUtil;

public class TurfDAO {

	/**
	 * Inserting the turf details in the DB
	 * 
	 * @param turf
	 * @return
	 * @throws DAOException
	 */
	public boolean createTurf(Turf turf) throws DAOException {

		final String QUERY = "INSERT INTO turf (image,details,created_user) VALUES (?,?,?)";
 
		try (Connection connection = new ConnectionUtil().connect();
				PreparedStatement pmt = connection.prepareStatement(QUERY)) {

			pmt.setString(1, turf.getImage());
			pmt.setString(2, turf.getMessage());
			pmt.setInt(3, turf.getCreatedBy().getId());

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in creating the turf", e);
		}

	}

	/**
	 * Getting all the turf list from DB
	 * 
	 * @return List<Turf>
	 * @throws DAOException
	 */
	public List<Turf> getAllTurfList() throws DAOException {

		ArrayList<Turf> turfList = new ArrayList<>();

		final String QUERY = "SELECT * FROM turf";

		try (Connection connection = new ConnectionUtil().connect();
				PreparedStatement std = connection.prepareStatement(QUERY);
				ResultSet rs = std.executeQuery()) {

			while (rs.next()) {

				String image = rs.getString("image");
				String details = rs.getString("details");
				int turfId = rs.getInt("turf_id");
				int userId = rs.getInt("created_user");

				Turf turf = new Turf(turfId, image, details);

				User user = new User();
				user.setId(userId);

				turf.setCreatedBy(user);

				turfList.add(turf);

			}

			return turfList;

		} catch (SQLException e) {
			throw new DAOException("Error in getting the turflist", e);
		}

	}

	/**
	 * update the turf by id
	 * 
	 * @param turf
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean updateTurf(Turf turf) throws DAOException {

		final String UPDATEQUERY = "UPDATE turf SET details=?,image =? WHERE turf_id=?";

		try (Connection connection = new ConnectionUtil().connect();
				PreparedStatement std = connection.prepareStatement(UPDATEQUERY)) {

			std.setString(1, turf.getMessage());
			std.setString(2, turf.getImage());
			std.setInt(3, turf.getTurfId());

			int row = std.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error while updating the turf", e);
		}

	}

	/**
	 * Delete the turf by id
	 * 
	 * @param id
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean deleteTurf(int id) throws DAOException {

		final String DELETEQUERY = "DELETE FROM turf WHERE turf_id=?";

		try (Connection connection = new ConnectionUtil().connect();
				PreparedStatement std = connection.prepareStatement(DELETEQUERY)) {

			std.setInt(1, id);

			int row = std.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the turf", e);
		}

	}

	/**
	 * Getting the turf object by turf_id
	 * 
	 * @param turfId
	 * @return Turf
	 * @throws DAOException
	 */
	public Turf getTurfById(int turfId) throws DAOException {

		final String SELECTQUERY = "SELECT * FROM turf WHERE turf_id=?";

		try (Connection connection = new ConnectionUtil().connect();
				PreparedStatement std = connection.prepareStatement(SELECTQUERY)) {

			std.setInt(1, turfId);

			try (ResultSet rs = std.executeQuery()) {

				if (rs.next()) {

					int id = rs.getInt("turf_id");
					String imageUrl = rs.getString("image");
					String details = rs.getString("details");

					User user = new User();
					user.setId(rs.getInt("created_user"));

					Turf turf = new Turf(id, imageUrl, details);
					turf.setCreatedBy(user);

					return turf;

				}

			}

			return null;

		} catch (SQLException e) {

			throw new DAOException("Cannot get the turf details", e);
		}

	}

}
