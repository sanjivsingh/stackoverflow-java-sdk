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

import java.util.List;
import java.util.Set;

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.AnswerApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.gson.JsonObject;

/**
 * The Class AnswerApiQueryImpl.
 */
public class AnswerApiQueryImpl extends BaseStackOverflowApiQuery<Answer> implements AnswerApiQuery {

	/**
	 * Instantiates a new answer api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public AnswerApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withAnswerIds(long[])
	 */
	@Override
	public AnswerApiQuery withAnswerIds(long... answerIds) {
		apiUrlBuilder.withIds(answerIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withFetchOptions(java.util.Set)
	 */
	@Override
	public AnswerApiQuery withFetchOptions(Set<FilterOption> fetchOptions) {
		apiUrlBuilder.withFetchOptions(fetchOptions);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withPaging(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public AnswerApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withSort(com.google.code.stackexchange.schema.Answer.SortOrder)
	 */
	@Override
	public AnswerApiQuery withSort(Answer.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withUserIds(long[])
	 */
	@Override
	public AnswerApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withQuestionIds(long[])
	 */
	@Override
	public AnswerApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Answer> unmarshall(JsonObject json) {
		return unmarshallList(Answer.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_ANSWER, getApplicationKey(), getApiVersion());
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#withRange(com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public AnswerApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#listByQuestions()
	 */
	@Override
	public PagedList<Answer> listByQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
		return super.list();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.AnswerApiQuery#listByUsers()
	 */
	@Override
	public PagedList<Answer> listByUsers() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
		return super.list();
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<Answer> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_ANSWER);
		return super.list();
	}

	@Override
	public AnswerApiQuery withAnswerIds(List<Long> answerIds) {
		apiUrlBuilder.withIds(answerIds);
		return this;
	}

	@Override
	public AnswerApiQuery withQuestionIds(List<Long> questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	@Override
	public AnswerApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
