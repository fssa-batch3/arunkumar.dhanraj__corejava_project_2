package creckett.validation;

import java.time.LocalDate;

import creckett.model.Match;
import creckett.validation.exceptions.InvalidMatchException;

/**
 * @author ArunkumarDhanraj
 *
 */
public class MatchValidator {

	public boolean validMatch(Match match) throws InvalidMatchException {

		if (validMatchPlace(match.getPlace()) && validMatchDate(match.getDate()))
			return true;
		else
			throw new InvalidMatchException("invalid input");

	}

	public boolean validMatchPlace(String place) {

		if (place != null && !place.isEmpty())
			return true;
		else
			return false;

	}

	public boolean validMatchDate(LocalDate date) {

		return date != null;

	}

}
