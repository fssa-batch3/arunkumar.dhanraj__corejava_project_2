package com.fssa.creckett.validation.exceptions;

/**
 * @author ArunkumarDhanraj
 *
 */
public class InvalidRequirementException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidRequirementException(String msg) {
		super(msg);
	}

	public InvalidRequirementException(Throwable e) {
		super(e);
	}

	public InvalidRequirementException(String msg, Throwable e) {
		super(msg, e);
	}
}
