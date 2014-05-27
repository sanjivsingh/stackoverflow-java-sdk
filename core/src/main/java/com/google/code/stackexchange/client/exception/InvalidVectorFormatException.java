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
 * The Class InvalidVectorFormatException.
 */
public class InvalidVectorFormatException extends StackExchangeApiException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4116844039359929855L;

	/**
	 * Instantiates a new invalid vector format exception.
	 */
	public InvalidVectorFormatException() {
		super();
	}

	/**
	 * Instantiates a new invalid vector format exception.
	 * 
	 * @param message the message
	 */
	public InvalidVectorFormatException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid vector format exception.
	 * 
	 * @param cause the cause
	 */
	public InvalidVectorFormatException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new invalid vector format exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidVectorFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new invalid vector format exception.
	 * 
	 * @param message the message
	 * @param statusCode the status code
	 * @param errorCode the error code
	 * @param timestamp the timestamp
	 */
	public InvalidVectorFormatException(String message, int statusCode, int errorCode,
			Date timestamp) {
		super(message, statusCode, errorCode, timestamp);
	}
	
	/**
	 * Instantiates a new invalid vector format exception.
	 * 
	 * @param message the message
	 * @param timestamp the timestamp
	 */
	public InvalidVectorFormatException(String message, Date timestamp) {
		super(message, 400, ErrorCodes.INVALID_VECTOR_FORMAT, timestamp);
	}
}
