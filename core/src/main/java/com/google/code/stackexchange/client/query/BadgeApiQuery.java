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
import com.google.code.stackexchange.schema.Badge;

/**
 * The Interface BadgeApiQuery.
 */
public interface BadgeApiQuery extends StackExchangeApiQuery<Badge> {
	
	/**
	 * List by name.
	 * 
	 * @return the paged list< badge>
	 */
	public PagedList<Badge> listByName();
	
	/**
	 * List by tags.
	 * 
	 * @return the paged list< badge>
	 */
	public PagedList<Badge> listByTags();
	
	/**
	 * List by users.
	 * 
	 * @return the paged list< badge>
	 */
	public PagedList<Badge> listByUsers();
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the badge api query
	 */
	public BadgeApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the badge api query
	 */
	public BadgeApiQuery withUserIds(List<Long> userIds);
}
