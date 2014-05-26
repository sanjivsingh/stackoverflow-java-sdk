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

	/** The error Id. */
	private int errorId;

	/** The description. */
	private String description;

	/** The error Name. */
	private String errorName;

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
	 * @param description
	 *            the description
	 */
	public StackExchangeApiException(String description) {
		super(description);
	}

	/**
	 * Instantiates a new stack exchange api exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public StackExchangeApiException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new stack exchange api exception.
	 * 
	 * @param description
	 *            the description
	 * @param cause
	 *            the cause
	 */
	public StackExchangeApiException(String description, Throwable cause) {
		super(description, cause);
	}

	/**
	 * Instantiates a new stack exchange api exception.
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
	public StackExchangeApiException(String description, int errorId,
			String errorName, Date timestamp) {
		super(description);
		this.errorId = errorId;
		this.errorName = errorName;
		this.timestamp = timestamp;
	}

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
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
	 * @param timestamp
	 *            the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
