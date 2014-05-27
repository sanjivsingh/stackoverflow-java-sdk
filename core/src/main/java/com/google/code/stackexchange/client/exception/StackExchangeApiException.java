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

/**
 * The Class StackExchangeApiException.
 */
public class StackExchangeApiException extends RuntimeException {
	
	/** The status code. */
	private int statusCode;
	
	/** The error code. */
	private int errorCode;
	
	/** The timestamp. */
	private Date timestamp;

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Instantiates a new stack exchange api exception.
	 */
    public StackExchangeApiException() {
        super();
    }

    /**
     * Instantiates a new stack exchange api exception.
     * 
     * @param message the message
     */
    public StackExchangeApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new stack exchange api exception.
     * 
     * @param cause the cause
     */
    public StackExchangeApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new stack exchange api exception.
     * 
     * @param message the message
     * @param cause the cause
     */
    public StackExchangeApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new stack exchange api exception.
     * 
     * @param message the message
     * @param statusCode the status code
     * @param errorCode the error code
     * @param timestamp the timestamp
     */
    public StackExchangeApiException(String message, int statusCode , int errorCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }
    
	/**
	 * Gets the status code.
	 * 
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 * 
	 * @param statusCode the new status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the timestamp.
	 * 
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 * 
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
