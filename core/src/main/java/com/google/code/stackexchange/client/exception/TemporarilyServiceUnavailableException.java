package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class TemporarilyServiceUnavailableException extends
		StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new temporarily unavailable exception.
	 */
	public TemporarilyServiceUnavailableException() {
		super();
	}

	/**
	 * Instantiates a new temporarily unavailable exception.
	 * 
	 * @param description
	 *            the description
	 */
	public TemporarilyServiceUnavailableException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new temporarily unavailable exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public TemporarilyServiceUnavailableException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new temporarily unavailable exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public TemporarilyServiceUnavailableException(String message,
			Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new temporarily unavailable exception.
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
	public TemporarilyServiceUnavailableException(String description,
			int errorId, String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a temporarily unavailable exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public TemporarilyServiceUnavailableException(String message, Date timestamp) {
		super(message, ErrorCodes.TEMPORARILY_UNAVAILABLE,
				"temporarily_unavailable", timestamp);
	}

}
