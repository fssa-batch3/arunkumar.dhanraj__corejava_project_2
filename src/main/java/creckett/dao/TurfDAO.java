package creckett.dao;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import creckett.dao.exceptions.DAOException;
import creckett.model.Turf;

public class TurfDAO {

// Inserting the turf details in the DB
	public boolean createTurf(Turf turf) throws DAOException {

		final String QUERY = "INSERT INTO turf (image,details) VALUES (?,?)";

		try (PreparedStatement pmt = UserDAO.connect().prepareStatement(QUERY)) {

			pmt.setString(1, turf.getImage());
			pmt.setString(2, turf.getMessage());

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in creating the turf", e);
		}

	}

//	Getting all the turf list from DB 
	public ArrayList<Turf> getAllTurfList() throws DAOException {

		ArrayList<Turf> turfList = new ArrayList<>();

		final String QUERY = "SELECT * FROM turf";

		try (PreparedStatement std = UserDAO.connect().prepareStatement(QUERY); ResultSet rs = std.executeQuery()) {

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

//	Delete the turf by details
	public boolean deleteTurf(String details) throws DAOException {

		final String QUERY = "DELETE FROM turf WHERE details=?";

		try (PreparedStatement std = UserDAO.connect().prepareStatement(QUERY)) {

			std.setString(1, details);

			int row = std.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the turf",e);
		}

	}

}
