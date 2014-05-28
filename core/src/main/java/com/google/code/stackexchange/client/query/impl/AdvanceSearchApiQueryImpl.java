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

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.AdvanceSearchApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.gson.JsonObject;

/**
 * The Class AdvanceSearchApiQueryImpl.
 * 
 * @author Sanjiv.Singh
 * 
 */
public class AdvanceSearchApiQueryImpl extends
		BaseStackOverflowApiQuery<Question> implements AdvanceSearchApiQuery {

	/**
	 * Instantiates a new question api query impl.
	 * 
	 * 
	 * @param applicationId
	 *            the application id
	 * @param site
	 *            the stack exchange site
	 */
	public AdvanceSearchApiQueryImpl(String applicationId,
			StackExchangeSite site) {
		super(applicationId, site);
	}

	public AdvanceSearchApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite, String accessToken) {
		super(applicationId, stackExchangeSite, accessToken);
	}

	public AdvanceSearchApiQueryImpl(String applicationId, String apiVersion,
			String accessToken, StackExchangeSite stackExchangeSite) {
		super(applicationId, apiVersion, accessToken, stackExchangeSite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withPaging
	 * (com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public AdvanceSearchApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(
	 * com.google.code.stackexchange.schema.User.QuestionSortOrder)
	 */
	@Override
	public AdvanceSearchApiQuery withSort(User.QuestionSortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withTags(
	 * java.lang.String[])
	 */
	@Override
	public AdvanceSearchApiQuery withTags(String... tag) {
		apiUrlBuilder.withParameters("tagged", Arrays.asList(tag), ";");
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withOutTags(String... tag) {
		apiUrlBuilder.withParameters("nottagged", Arrays.asList(tag), ";");
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withTimePeriod
	 * (com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public AdvanceSearchApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery
	 * #unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Question> unmarshall(JsonObject json) {
		return unmarshallList(Question.class, json);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(
				StackExchangeApiMethods.SEARCH_QUESTIONS, getApplicationKey(),
				getAccessToken(), getSite(), getApiVersion());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withRange
	 * (com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public AdvanceSearchApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery
	 * #list()
	 */
	@Override
	public PagedList<Question> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.ADVANCE_SEARCH_QUESTIONS);
		return super.list();
	}

	@Override
	public AdvanceSearchApiQuery withOutTags(List<String> tag) {
		apiUrlBuilder.withParameters("nottagged", tag, ";");
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withTags(List<String> tag) {
		apiUrlBuilder.withParameters("tagged", tag, ";");
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withTitle(String title) {
		apiUrlBuilder.withParameter("title", title);
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withQuery(String query) {
		apiUrlBuilder.withParameter("q", query);
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withClosed(Boolean closed) {
		apiUrlBuilder.withParameter("closed", closed.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withMigrated(Boolean migrated) {
		apiUrlBuilder.withParameter("migrated", migrated.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withWiki(Boolean wiki) {
		apiUrlBuilder.withParameter("wiki", wiki.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withNotice(Boolean notice) {
		apiUrlBuilder.withParameter("notice", notice.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withAccepted(Boolean accepted) {
		apiUrlBuilder.withParameter("accepted", accepted.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withMinAnswers(Integer answers) {
		apiUrlBuilder.withParameter("answers", answers.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withBody(String body) {
		apiUrlBuilder.withParameter("body", body);
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withUser(Long user) {
		apiUrlBuilder.withParameter("user", user.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withURL(String url) {
		apiUrlBuilder.withParameter("url", url);
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withMinViews(Integer views) {
		apiUrlBuilder.withParameter("views", views.toString());
		return this;
	}

	@Override
	public AdvanceSearchApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

}
