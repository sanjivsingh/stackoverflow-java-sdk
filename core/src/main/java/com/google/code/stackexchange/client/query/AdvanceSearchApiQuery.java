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
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;

/**
 * The Interface QuestionApiQuery.
 * 
 * @author Sanjiv.Singh
 * 
 */
public interface AdvanceSearchApiQuery extends StackExchangeApiQuery<Question> {

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withTags(String... tag);

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withTags(List<String> tag);

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withOutTags(String... tag);

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withOutTags(List<String> tag);

	/**
	 * With paging.
	 * 
	 * @param paging
	 *            the paging
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod
	 *            the time period
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withTimePeriod(TimePeriod timePeriod);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withSort(User.QuestionSortOrder sort);

	/**
	 * With range.
	 * 
	 * @param range
	 *            the range
	 * 
	 * @return the question api query
	 */
	public AdvanceSearchApiQuery withRange(Range range);

	public AdvanceSearchApiQuery withTitle(String title);

	public AdvanceSearchApiQuery withQuery(String query);

	public AdvanceSearchApiQuery withClosed(Boolean closed);

	public AdvanceSearchApiQuery withMigrated(Boolean migrated);

	public AdvanceSearchApiQuery withWiki(Boolean wiki);

	public AdvanceSearchApiQuery withNotice(Boolean notice);

	public AdvanceSearchApiQuery withAccepted(Boolean accepted);

	public AdvanceSearchApiQuery withMinAnswers(Integer answers);

	public AdvanceSearchApiQuery withBody(String body);

	public AdvanceSearchApiQuery withUser(Long user);

	public AdvanceSearchApiQuery withURL(String url);

	public AdvanceSearchApiQuery withMinViews(Integer views);

	public AdvanceSearchApiQuery withFilter(String filter);

}
