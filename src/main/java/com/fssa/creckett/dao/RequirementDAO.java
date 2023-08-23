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
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.utils.ConnectionDb;

public class RequirementDAO {

//	Inserting the requirements details in the DB
	public boolean createRequirement(Requirement requirement) throws DAOException {

		final String QUERY = "INSERT INTO requirement (message) VALUES (?)";

		try (PreparedStatement pmt = new ConnectionDb().connect().prepareStatement(QUERY)) {

			pmt.setString(1, requirement.getMessage());

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in creating the requirement", e);
		}

	}

//	get all requirement list by message
	public List<Requirement> getAllRequirementList() throws DAOException {

		ArrayList<Requirement> list = new ArrayList<Requirement>();

		final String QUERY = "SELECT * FROM requirement";

		try (PreparedStatement std = new ConnectionDb().connect().prepareStatement(QUERY);
				ResultSet rs = std.executeQuery()) {

			while (rs.next()) {

				list.add(new Requirement(rs.getString("message")));

			}

			return list;

		} catch (SQLException e) {
			throw new DAOException("Error in getting the requirement", e);
		}

	}

//	delete requirements by messsage
	public boolean deleteRequirement(String message) throws DAOException {

		final String QUERY = "DELETE FROM requirement WHERE message=?";

		try (PreparedStatement pmt = new ConnectionDb().connect().prepareStatement(QUERY)) {

			pmt.setString(1, message);

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the requirement", e);
		}

	}

}
