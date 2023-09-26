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
import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.model.User;
import com.fssa.creckett.utils.ConnectionUtil;

public class RequirementDAO {

	/**
	 * Inserting the requirements details in the DB
	 * 
	 * @param requirement
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean createRequirement(Requirement requirement) throws DAOException {

		final String QUERY = "INSERT INTO requirement (message,posted_by) VALUES (?,?)";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pmt = connect.prepareStatement(QUERY)) {

			pmt.setString(1, requirement.getMessage());
			pmt.setInt(2, requirement.getPostedBy().getId());

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in creating the requirement", e);
		}

	}

	/**
	 * get all requirement list by message
	 * 
	 * @return List<Requirement>
	 * @throws DAOException
	 */
	public List<Requirement> getAllRequirementList() throws DAOException {

		List<Requirement> list = new ArrayList<Requirement>();

		final String QUERY = "SELECT " + "u.name, " + "u.email, " + "u.phonenumber, " + "req.requirement_id, "
				+ "req.message, " + "req.posted_by " + "FROM requirement AS req "
				+ "INNER JOIN users AS u ON req.posted_by = u.id;";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement std = connect.prepareStatement(QUERY);
				ResultSet rs = std.executeQuery()) {

			while (rs.next()) {

				int reqId = rs.getInt("requirement_id");
				String message = rs.getString("message");

				User postedUser = new User();
				postedUser.setId(rs.getInt("posted_by"));
				postedUser.setName(rs.getString("name"));
				postedUser.setEmail(rs.getString("email"));
				postedUser.setPhonenumber(rs.getString("phonenumber"));

				list.add(new Requirement(reqId, message, postedUser));

			}

			return list;

		} catch (SQLException e) {
			throw new DAOException("Error in getting the requirement", e);
		}

	}

//	delete requirements by messsage
	public boolean deleteRequirement(String message) throws DAOException {

		final String QUERY = "DELETE FROM requirement WHERE message=?";

		try (Connection connect = new ConnectionUtil().connect();
				PreparedStatement pmt = connect.prepareStatement(QUERY)) {

			pmt.setString(1, message);

			int row = pmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the requirement", e);
		}

	}

}
