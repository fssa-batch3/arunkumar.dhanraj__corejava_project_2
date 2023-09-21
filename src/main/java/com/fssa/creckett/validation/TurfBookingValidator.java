package com.fssa.creckett.validation;

import java.time.LocalDate;

import com.fssa.creckett.utils.HelperFunctions;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

/**
 * @author ArunkumarDhanraj
 *
 */
public class TurfBookingValidator {
	
	public boolean validateDate(LocalDate date) throws InvalidTurfException{
		
		HelperFunctions helper = new HelperFunctions();
		
		if(helper.validDate(date))
			return true;
		
		throw new InvalidTurfException("Invalid Date");
	}
	
	
	

}



