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
package com.google.code.stackexchange.client.query;

import java.util.List;

import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.TimePeriod;

/**
 * The Interface ReputationApiQuery.
 */
public interface ReputationApiQuery extends StackExchangeApiQuery<Reputation> {
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the reputation api query
	 */
	public ReputationApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the reputation api query
	 */
	public ReputationApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the reputation api query
	 */
	public ReputationApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the reputation api query
	 */
	public ReputationApiQuery withTimePeriod(TimePeriod timePeriod);
}
