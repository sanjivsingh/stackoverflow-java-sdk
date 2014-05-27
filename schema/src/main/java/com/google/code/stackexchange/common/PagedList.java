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
package com.google.code.stackexchange.common;

import java.util.List;

/**
 * The Interface PagedList.
 */
public interface PagedList<E> extends List<E> {
	
	/**
	 * Gets the total.
	 * 
	 * @return the total
	 */
	public long getTotal();
	
	/**
	 * Sets the total.
	 * 
	 * @param total the new total
	 */
	public void setTotal(long total);
	
	/**
	 * Gets the page.
	 * 
	 * @return the page
	 */
	public int getPage();
	
	/**
	 * Sets the page.
	 * 
	 * @param page the new page
	 */
	public void setPage(int page);
	
	/**
	 * Gets the page size.
	 * 
	 * @return the page size
	 */
	public int getPageSize();
	
	/**
	 * Sets the page size.
	 * 
	 * @param pageSize the new page size
	 */
	public void setPageSize(int pageSize);
}
