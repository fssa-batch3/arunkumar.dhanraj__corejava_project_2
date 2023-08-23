package com.fssa.creckett.validation.exceptions;

/**
 * @author ArunkumarDhanraj
 *
 */

public class InvalidTurfException extends Exception{
	
private static final long serialVersionUID = 1L;
	
	public InvalidTurfException(String msg) {
		super(msg);
	}
	
	public InvalidTurfException(Throwable e) {
		super(e);
	}
	
	public InvalidTurfException(String msg,Throwable e) {
		super(msg,e);
	}

}
