package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class DuplicateRequestException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new duplicate request exception.
	 */
	public DuplicateRequestException() {
		super();
	}

	/**
	 * Instantiates a new duplicate request exception.
	 * 
	 * @param description
	 *            the description
	 */
	public DuplicateRequestException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new duplicate request exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public DuplicateRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new duplicate request exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public DuplicateRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new duplicate request exception.
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
	public DuplicateRequestException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a duplicate request exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public DuplicateRequestException(String message, Date timestamp) {
		super(message, ErrorCodes.DUPLICATE_REQUEST, "duplicate_request", timestamp);
	}

}
