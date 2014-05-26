package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class NoMethodException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new no method exception.
	 */
	public NoMethodException() {
		super();
	}

	/**
	 * Instantiates a new no method exception.
	 * 
	 * @param description
	 *            the description
	 */
	public NoMethodException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new no method exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public NoMethodException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new no method exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public NoMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new no method exception.
	 * 
	 * @param description
	 *            the description
	 * @param errorId
	 *            the error Id
	 * @param errorName
	 *            the error Name
	 * @param timestamp
	 *            the timestamp
	 */
	public NoMethodException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a no method exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public NoMethodException(String message, Date timestamp) {
		super(message, ErrorCodes.NO_METHOD, "no_method", timestamp);
	}

}
