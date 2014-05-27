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

import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.TimePeriod;

/**
 * The Interface TagApiQuery.
 */
public interface TagApiQuery extends StackExchangeApiQuery<Tag> {
	
	/**
	 * List by user.
	 * 
	 * @return the paged list< tag>
	 */
	public PagedList<Tag> listByUser();
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery withPaging(Paging paging);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery withSort(Tag.SortOrder sort);
	
	/**
	 * With range.
	 * 
	 * @param range the range
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery withRange(Range range);
	
	public TagApiQuery withFilter(String filter);
	
	public TagApiQuery withTimePeriod(TimePeriod timePeriod);
}
