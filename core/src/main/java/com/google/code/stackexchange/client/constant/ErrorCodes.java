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
	
	/** The NO t_ found. */
	public int NOT_FOUND = 404;
	
	/** The INTERNA l_ serve r_ error. */
	public int INTERNAL_SERVER_ERROR = 500;
	
	/** The INVALI d_ applicatio n_ key. */
	public int INVALID_APPLICATION_KEY = 4000;
	
	/** The INVALI d_ pag e_ size. */
	public int INVALID_PAGE_SIZE = 4001;
	
	/** The INVALI d_ sort. */
	public int INVALID_SORT = 4002;
	
	/** The INVALI d_ order. */
	public int INVALID_ORDER = 4003;
	
	/** The REQUES t_ limi t_ exceeded. */
	public int REQUEST_LIMIT_EXCEEDED = 4004;
	
	/** The INVALI d_ vecto r_ format. */
	public int INVALID_VECTOR_FORMAT = 4005;
	
	/** The TO o_ man y_ ids. */
	public int TOO_MANY_IDS = 4006;
	
	/** The UNCONSTRAINE d_ search. */
	public int UNCONSTRAINED_SEARCH = 4007;
}