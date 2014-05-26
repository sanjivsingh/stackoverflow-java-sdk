package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * @author Sanjiv.Singh
 * 
 */
public class ThrottleVoilationException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6271751110746617988L;

	/**
	 * Instantiates a new throttle violation exception.
	 */
	public ThrottleVoilationException() {
		super();
	}

	/**
	 * Instantiates a new throttle violation exception.
	 * 
	 * @param description
	 *            the description
	 */
	public ThrottleVoilationException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new throttle violation exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ThrottleVoilationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new throttle violation exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ThrottleVoilationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new throttle violation exception.
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
	public ThrottleVoilationException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description, errorId, errorName, timestamp);
	}

	/**
	 * Instantiates a throttle violation exception.
	 * 
	 * @param message
	 *            the message
	 * @param timestamp
	 *            the timestamp
	 */
	public ThrottleVoilationException(String message, Date timestamp) {
		super(message, ErrorCodes.THROTTLE_VOILATION, "throttle_violation", timestamp);
	}

}
