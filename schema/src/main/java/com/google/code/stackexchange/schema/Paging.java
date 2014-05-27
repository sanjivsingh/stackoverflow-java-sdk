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

/**
 * The Class Paging.
 */
public final class Paging {
	
	/** The page number. */
	private int pageNumber;
	
	/** The page size. */
	private int pageSize;
	
	/**
	 * Instantiates a new paging.
	 * 
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 */
	public Paging(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	/**
	 * Gets the page number.
	 * 
	 * @return the page number
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	
	/**
	 * Gets the page size.
	 * 
	 * @return the page size
	 */
	public int getPageSize() {
		return pageSize;
	}
}