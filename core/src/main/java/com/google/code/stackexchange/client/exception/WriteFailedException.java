package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class WriteFailedException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new write failed exception.
	 */
	public WriteFailedException() {
		super();
	}

	/**
	 * Instantiates a new write failed exception.
	 * 
	 * @param description
	 *            the description
	 */
	public WriteFailedException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new write failed exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public WriteFailedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new write failed exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public WriteFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new write failed exception.
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
	public WriteFailedException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a write failed exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public WriteFailedException(String message, Date timestamp) {
		super(message, ErrorCodes.WRITE_FAILED, "write_failed", timestamp);
	}

}
