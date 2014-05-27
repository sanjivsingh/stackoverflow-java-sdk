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
package com.google.code.stackexchange.client.query.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.QuestionApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.gson.JsonObject;

/**
 * The Class QuestionApiQueryImpl.
 */
public class QuestionApiQueryImpl extends BaseStackOverflowApiQuery<Question> implements QuestionApiQuery {

	/**
	 * Instantiates a new question api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public QuestionApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withFetchOptions(java.util.Set)
	 */
	@Override
	public QuestionApiQuery withFetchOptions(Set<FilterOption> fetchOptions) {
		apiUrlBuilder.withFetchOptions(fetchOptions);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withPaging(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public QuestionApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withQuestionIds(long[])
	 */
	@Override
	public QuestionApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(com.google.code.stackexchange.schema.Question.SortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(Question.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(com.google.code.stackexchange.schema.Question.UnansweredSortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(Question.UnansweredSortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(com.google.code.stackexchange.schema.User.QuestionSortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(User.QuestionSortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(com.google.code.stackexchange.schema.User.FavoriteSortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(User.FavoriteSortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withTags(java.lang.String[])
	 */
	@Override
	public QuestionApiQuery withTags(String... tag) {
		apiUrlBuilder.withParameters("tagged", Arrays.asList(tag), ";");
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withTimePeriod(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public QuestionApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withUserIds(long[])
	 */
	@Override
	public QuestionApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Question> unmarshall(JsonObject json) {
		return unmarshallList(Question.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS, getApplicationKey(), getApiVersion());
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#withRange(com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public QuestionApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#listFavoriteQuestions()
	 */
	@Override
	public PagedList<Question> listFavoriteQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
		return super.list();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#listUnansweredQuestions()
	 */
	@Override
	public PagedList<Question> listUnansweredQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
		return super.list();
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<Question> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_QUESTIONS);
		return super.list();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#listQuestionsByUser()
	 */
	@Override
	public PagedList<Question> listQuestionsByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
		return super.list();
	}

	@Override
	public QuestionApiQuery withQuestionIds(List<Long> questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	@Override
	public QuestionApiQuery withTags(List<String> tag) {
		apiUrlBuilder.withParameters("tagged", tag, ";");
		return this;
	}

	@Override
	public QuestionApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
