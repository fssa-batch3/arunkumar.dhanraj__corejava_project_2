package com.fssa.creckett.validation.exceptions;

/**
 * @author ArunkumarDhanraj
 *
 */
public class InvalidMatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMatchException(String msg) {
		super(msg);
	}

	public InvalidMatchException(Throwable e) {
		super(e);
	}

}
