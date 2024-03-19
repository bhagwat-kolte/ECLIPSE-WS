/**
 * 
 */
package com.amol.ems.exceptions;

/**
 * @author MACK-WORLD
 *
 */
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	public EmployeeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
