package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class AccessTokenRequiredException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new access token required exception.
	 */
	public AccessTokenRequiredException() {
		super();
	}

	/**
	 * Instantiates a new access token required exception.
	 * 
	 * @param description
	 *            the description
	 */
	public AccessTokenRequiredException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new access token required exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public AccessTokenRequiredException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new access token required exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public AccessTokenRequiredException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new access token required exception.
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
	public AccessTokenRequiredException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a access token required exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public AccessTokenRequiredException(String message, Date timestamp) {
		super(message, ErrorCodes.ACCESS_TOKEN_REQUIRED,
				"access_token_required", timestamp);
	}

}
