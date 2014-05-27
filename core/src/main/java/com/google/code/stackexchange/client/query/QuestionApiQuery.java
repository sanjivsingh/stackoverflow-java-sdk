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
import java.util.Set;

import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;

/**
 * The Interface QuestionApiQuery.
 */
public interface QuestionApiQuery extends StackExchangeApiQuery<Question> {
	
	/**
	 * List unanswered questions.
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUnansweredQuestions();
	
	/**
	 * List favorite questions.
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listFavoriteQuestions();

	/**
	 * List questions by user.
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listQuestionsByUser();
	
	/**
	 * With question ids.
	 * 
	 * @param questionIds the question ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withQuestionIds(long... questionIds);
	
	/**
	 * With question ids.
	 * 
	 * @param questionIds the question ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withQuestionIds(List<Long> questionIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With tags.
	 * 
	 * @param tag the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTags(String... tag);
	
	/**
	 * With tags.
	 * 
	 * @param tag the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTags(List<String> tag);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTimePeriod(TimePeriod timePeriod);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(Question.SortOrder sort);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(Question.UnansweredSortOrder sort);
	
	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(User.QuestionSortOrder sort);
	
	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(User.FavoriteSortOrder sort);
	
	/**
	 * With range.
	 * 
	 * @param range the range
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withRange(Range range);
	
	/**
	 * With fetch options.
	 * 
	 * @param fetchOptions the fetch options
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withFetchOptions(Set<FilterOption> fetchOptions);
}
