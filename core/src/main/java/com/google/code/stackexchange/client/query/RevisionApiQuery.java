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

import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.TimePeriod;

/**
 * The Interface RevisionApiQuery.
 */
public interface RevisionApiQuery extends StackExchangeApiQuery<Revision> {
	
	/**
	 * With question ids.
	 * 
	 * @param questionIds the question ids
	 * 
	 * @return the revision api query
	 */
	public RevisionApiQuery withQuestionIds(long... questionIds);
	
	/**
	 * With question ids.
	 * 
	 * @param questionIds the question ids
	 * 
	 * @return the revision api query
	 */
	public RevisionApiQuery withQuestionIds(List<Long> questionIds);
	
	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the revision api query
	 */
	public RevisionApiQuery withTimePeriod(TimePeriod timePeriod);
	
	/**
	 * With revision guid.
	 * 
	 * @param revisionGuid the revision guid
	 * 
	 * @return the revision api query
	 */
	public RevisionApiQuery withRevisionGuid(String revisionGuid);
}
