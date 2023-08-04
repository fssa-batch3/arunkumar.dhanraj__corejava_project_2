package creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Requirement extends Features {
	
//	Default constructor
	public Requirement() {
		super();
	}
	
//	Main constructor
	public Requirement(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "{Message = " + getMessage() + "}";
	}
	
}
