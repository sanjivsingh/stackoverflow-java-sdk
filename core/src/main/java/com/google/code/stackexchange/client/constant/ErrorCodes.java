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
package com.google.code.stackexchange.client.constant;

/**
 * The Interface ErrorCodes.
 */
public interface ErrorCodes {

	/** The bad_parameter. */
	public int BAD_PARAMETER = 400;

	/** The access_token_required. */
	public int ACCESS_TOKEN_REQUIRED = 401;

	/** The invalid_access_token. */
	public int INVALID_ACCESS_TOKEN = 402;

	/** The access_denied. */
	public int ACCESS_DENIED = 403;

	/** The no_method. */
	public int NO_METHOD = 404;

	/** The key_required. */
	public int KEY_REQUIRED = 405;

	/** The access_token_compromised. */
	public int ACCESS_TOKEN_COMPROMISED = 406;

	/** The write_failed. */
	public int WRITE_FAILED = 407;

	/** The duplicate_request. */
	public int DUPLICATE_REQUEST = 409;

	/** The internal_error. */
	public int INTERNAL_ERROR = 500;

	/** The throttle_violation. */
	public int THROTTLE_VOILATION = 502;

	/** The temporarily_unavailable. */
	public int TEMPORARILY_UNAVAILABLE = 503;

}