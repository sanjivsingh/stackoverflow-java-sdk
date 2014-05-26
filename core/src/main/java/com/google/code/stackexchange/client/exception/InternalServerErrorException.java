package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class InternalServerErrorException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new internal error exception.
	 */
	public InternalServerErrorException() {
		super();
	}

	/**
	 * Instantiates a new internal error exception.
	 * 
	 * @param description
	 *            the description
	 */
	public InternalServerErrorException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new internal error exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public InternalServerErrorException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new internal error exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public InternalServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new internal error exception.
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
	public InternalServerErrorException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a internal error exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public InternalServerErrorException(String message, Date timestamp) {
		super(message, ErrorCodes.INTERNAL_ERROR, "internal_error", timestamp);
	}

}
