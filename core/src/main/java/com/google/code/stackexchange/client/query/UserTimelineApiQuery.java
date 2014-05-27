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
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.UserTimeline;

/**
 * The Interface UserTimelineApiQuery.
 */
public interface UserTimelineApiQuery extends StackExchangeApiQuery<UserTimeline> {

	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the user timeline api query
	 */
	public UserTimelineApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the user timeline api query
	 */
	public UserTimelineApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the user timeline api query
	 */
	public UserTimelineApiQuery withTimePeriod(TimePeriod timePeriod);
	
	public UserTimelineApiQuery withPaging(Paging paging);
}
