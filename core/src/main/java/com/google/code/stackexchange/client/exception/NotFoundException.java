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
 * The Class NotFoundException.
 */
public class NotFoundException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4116844039359929855L;

	/**
	 * Instantiates a new not found exception.
	 */
	public NotFoundException() {
		super();
	}

	/**
	 * Instantiates a new not found exception.
	 * 
	 * @param message the message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new not found exception.
	 * 
	 * @param cause the cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new not found exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new not found exception.
	 * 
	 * @param message the message
	 * @param statusCode the status code
	 * @param errorCode the error code
	 * @param timestamp the timestamp
	 */
	public NotFoundException(String message, int statusCode, int errorCode,
			Date timestamp) {
		super(message, statusCode, errorCode, timestamp);
	}
	
	/**
	 * Instantiates a new not found exception.
	 * 
	 * @param message the message
	 * @param timestamp the timestamp
	 */
	public NotFoundException(String message, Date timestamp) {
		super(message, 404, ErrorCodes.NOT_FOUND, timestamp);
	}
}
