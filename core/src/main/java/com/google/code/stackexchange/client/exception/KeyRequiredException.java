package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class KeyRequiredException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new key required exception.
	 */
	public KeyRequiredException() {
		super();
	}

	/**
	 * Instantiates a new key required exception.
	 * 
	 * @param description
	 *            the description
	 */
	public KeyRequiredException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new key required exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public KeyRequiredException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new key required exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public KeyRequiredException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new key required exception.
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
	public KeyRequiredException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a key required exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public KeyRequiredException(String message, Date timestamp) {
		super(message, ErrorCodes.KEY_REQUIRED, "key_required", timestamp);
	}

}
