package creckett.validation;

/**
 * @author ArunkumarDhanraj
 *
 */

import creckett.model.Turf;
import creckett.validation.exceptions.InvalidTurfException;

public class TurfValidator extends FeatureValidator {

//	Attibutes for turf object
	private Turf turf;

//	Default constructor
	public TurfValidator() {

	}

//	Main constructor
	public TurfValidator(Turf turf) {
		this.turf = turf;
	}

//  Getter and setter 
	public Turf getTurf() {
		return turf;
	}

	public void setTurf(Turf turf) {
		this.turf = turf;
	}

//  Method for validate all
	public boolean validateAll() throws InvalidTurfException {
		return validImage(turf.getImage()) && validMessage(turf.getMessage());
	}

}
