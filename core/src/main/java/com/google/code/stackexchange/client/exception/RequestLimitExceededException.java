/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.stackexchange.client.exception;

import java.util.Date;

import com.google.code.stackexchange.client.constant.ErrorCodes;

/**
 * The Class RequestLimitExceededException.
 */
public class RequestLimitExceededException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4116844039359929855L;

	/**
	 * Instantiates a new request limit exceeded exception.
	 */
	public RequestLimitExceededException() {
		super();
	}

	/**
	 * Instantiates a new request limit exceeded exception.
	 * 
	 * @param message the message
	 */
	public RequestLimitExceededException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new request limit exceeded exception.
	 * 
	 * @param cause the cause
	 */
	public RequestLimitExceededException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new request limit exceeded exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public RequestLimitExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new request limit exceeded exception.
	 * 
	 * @param message the message
	 * @param statusCode the status code
	 * @param errorCode the error code
	 * @param timestamp the timestamp
	 */
	public RequestLimitExceededException(String message, int statusCode, int errorCode,
			Date timestamp) {
		super(message, statusCode, errorCode, timestamp);
	}
	
	/**
	 * Instantiates a new request limit exceeded exception.
	 * 
	 * @param message the message
	 * @param timestamp the timestamp
	 */
	public RequestLimitExceededException(String message, Date timestamp) {
		super(message, 403, ErrorCodes.REQUEST_LIMIT_EXCEEDED, timestamp);
	}
}
