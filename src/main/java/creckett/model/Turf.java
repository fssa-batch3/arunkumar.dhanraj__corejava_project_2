package creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Turf extends Features {

//	Default constructor
	public Turf() {
		super();
	}

// Main Constructor
	public Turf(String image, String message) {
		super(image, message);
	}

	@Override
	public String toString() {
		return "{Image = " + getImage() + ", Message = " + getMessage() + "}";
	}

}
