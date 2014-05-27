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
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;

/**
 * The Interface UserApiQuery.
 */
public interface UserApiQuery extends StackExchangeApiQuery<User> {
	
	/**
	 * List by badge.
	 * 
	 * @return the paged list< user>
	 */
	public PagedList<User> listByBadge();
	
	/**
	 * List by badge.
	 * 
	 * @return the paged list< user>
	 */
	public PagedList<User> listModerators();
	
	/**
	 * List by badge.
	 * 
	 * @return the paged list< user>
	 */
	public PagedList<User> listAssociatedAccounts();
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With badge ids.
	 * 
	 * @param badgeIds the badge ids
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withBadgeIds(long... badgeIds);
	
	/**
	 * With badge ids.
	 * 
	 * @param badgeIds the badge ids
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withBadgeIds(List<Long> badgeIds);
	
	/**
	 * With filter.
	 * 
	 * @param filter the filter
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withFilter(String filter);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withPaging(Paging paging);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withSort(User.SortOrder sort);
	
	/**
	 * With range.
	 * 
	 * @param range the range
	 * 
	 * @return the user api query
	 */
	public UserApiQuery withRange(Range range);
	
	public UserApiQuery withTimePeriod(TimePeriod timePeriod);
	
	public UserApiQuery withAssociationId(String associationId);
}
