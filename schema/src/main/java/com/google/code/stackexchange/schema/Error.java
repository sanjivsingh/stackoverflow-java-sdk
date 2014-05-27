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
package com.google.code.stackexchange.schema;

import java.util.Date;

/**
 * The Class ErrorImpl.
 */
public class Error extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5493694517895646459L;
	
	/** The error code. */
	private int code;
	
	/** The status code. */
	private int statusCode;
	
	/** The message. */
	private String message;
	
	/** The timestamp. */
	private Date timestamp;

	public int getErrorCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setErrorCode(int value) {
		code = value;
	}

	public void setMessage(String value) {
		message = value;
	}

	public void setTimestamp(Date value) {
		timestamp = value;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int value) {
		statusCode = value;
	}
}
