package com.fssa.creckett.dao;

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
import com.fssa.creckett.utils.ConnectionDb;

public class TurfDAO {

// Inserting the turf details in the DB
	public boolean createTurf(Turf turf) throws DAOException {

		final String QUERY = "INSERT INTO turf (image,details) VALUES (?,?)";

		try (PreparedStatement pmt = new ConnectionDb().connect().prepareStatement(QUERY)) {

			pmt.setString(1, turf.getImage());
			pmt.setString(2, turf.getMessage());

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in creating the turf", e);
		}

	}

//	Getting all the turf list from DB 
	public List<Turf> getAllTurfList() throws DAOException {

		ArrayList<Turf> turfList = new ArrayList<>();

		final String QUERY = "SELECT * FROM turf";

		try (PreparedStatement std = new ConnectionDb().connect().prepareStatement(QUERY);
				ResultSet rs = std.executeQuery()) {

			while (rs.next()) {

				String image = rs.getString("image");
				String details = rs.getString("details");

				turfList.add(new Turf(image, details));

			}

			return turfList;

		} catch (SQLException e) {
			throw new DAOException("Error in getting the turflist", e);
		}

	}

//	update the turf by details
	public boolean updateTurf(Turf turf) throws DAOException {

		final String UPDATEQUERY = "UPDATE turf SET details=?,image =? WHERE turf_id=?";

		try (PreparedStatement std = new ConnectionDb().connect().prepareStatement(UPDATEQUERY)) {

			std.setString(1, turf.getMessage());
			std.setString(2, turf.getImage());
			std.setInt(3, turf.getTurfId());

			int row = std.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error while updating the turf",e);
		}

	}

//	Delete the turf by details
	public boolean deleteTurf(int id) throws DAOException {

		final String DELETEQUERY = "DELETE FROM turf WHERE turf_id=?";

		try (PreparedStatement std = new ConnectionDb().connect().prepareStatement(DELETEQUERY)) {

			std.setInt(1, id);

			int row = std.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the turf", e);
		}

	}
	

	

}
