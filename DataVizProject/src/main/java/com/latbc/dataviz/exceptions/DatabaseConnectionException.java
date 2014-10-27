package com.latbc.dataviz.exceptions;

/**
*  Class of the general exception of the database connection.
* 
* @author Latbc Consulting
*
*/


public class DatabaseConnectionException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public DatabaseConnectionException(){
		super();
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param message
	 * 				Exception message
	 */
	public DatabaseConnectionException(final String message){
		super(message);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param message
	 *            Exception message
	 * @param cause
	 *            Throwable of the exception
	 */
	public DatabaseConnectionException(final String message,
			final Throwable cause) {
		super(message, cause);
	}
	
	
	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            Throwable of the exception
	 */
	public DatabaseConnectionException(final Throwable cause) {
		super(cause);
	}
	
	
}
