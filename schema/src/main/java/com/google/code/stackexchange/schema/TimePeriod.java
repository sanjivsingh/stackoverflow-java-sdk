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
 * The Class TimePeriod.
 */
public class TimePeriod {
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/**
	 * Instantiates a new time period.
	 * 
	 * @param startDate the start date
	 * @param endDate the end date
	 */
	public TimePeriod(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}
}