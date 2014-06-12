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
import com.google.code.stackexchange.client.query.QuestionApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.gson.JsonObject;

/**
 * The Class QuestionApiQueryImpl.
 */
public class QuestionApiQueryImpl extends BaseStackOverflowApiQuery<Question>
		implements QuestionApiQuery {

	/**
	 * Instantiates a new question api query impl.
	 * 
	 * @param applicationId
	 *            the application id
	 * @param site
	 *            the stack exchange site
	 */
	public QuestionApiQueryImpl(String applicationId, StackExchangeSite site) {
		super(applicationId, site);
	}

	public QuestionApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite, String accessToken) {
		super(applicationId, stackExchangeSite, accessToken);
	}

	public QuestionApiQueryImpl(String applicationId, String apiVersion,
			String accessToken, StackExchangeSite stackExchangeSite) {
		super(applicationId, apiVersion, accessToken, stackExchangeSite);
	}

	@Override
	public QuestionApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withPaging
	 * (com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public QuestionApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withQuestionIds
	 * (long[])
	 */
	@Override
	public QuestionApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(
	 * com.google.code.stackexchange.schema.Question.SortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(Question.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(
	 * com.google.code.stackexchange.schema.Question.UnansweredSortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(Question.UnansweredSortOrder sort) {
		apiUrlBuilder.withSort(sort);
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
	public QuestionApiQuery withSort(User.QuestionSortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withSort(
	 * com.google.code.stackexchange.schema.User.FavoriteSortOrder)
	 */
	@Override
	public QuestionApiQuery withSort(User.FavoriteSortOrder sort) {
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
	public QuestionApiQuery withTags(String... tag) {
		apiUrlBuilder.withParameters("tagged", Arrays.asList(tag), ";");
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
	public QuestionApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.QuestionApiQuery#withUserIds
	 * (long[])
	 */
	@Override
	public QuestionApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
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
				StackExchangeApiMethods.GET_QUESTIONS, getApplicationKey(),
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
	public QuestionApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#
	 * listFavoriteQuestions()
	 */
	@Override
	public PagedList<Question> listUserFavoriteQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_USER_FAVORITE_QUESTIONS);
		return super.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#
	 * listUnansweredQuestions()
	 */
	@Override
	public PagedList<Question> listUnansweredQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
		return super.list();
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
				.withMethod(StackExchangeApiMethods.GET_QUESTIONS);
		return super.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.QuestionApiQuery#
	 * listQuestionsByUser()
	 */
	@Override
	public PagedList<Question> listQuestionsByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_USER_QUESTIONS);
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

	@Override
	public QuestionApiQuery withAnswerIds(long... answerIds) {
		apiUrlBuilder.withIds(answerIds);
		return this;
	}

	@Override
	public QuestionApiQuery withAnswerIds(List<Long> answerIds) {
		apiUrlBuilder.withIds(answerIds);
		return this;
	}

	@Override
	public PagedList<Question> listQuestionsByAnswer() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_QUESTIONS_BY_ANSWER);
		return super.list();
	}

	@Override
	public QuestionApiQuery withNotTags(String... tag) {
		apiUrlBuilder.withParameters("nottagged", Arrays.asList(tag), ";");
		return this;
	}

	@Override
	public QuestionApiQuery withOutTags(List<String> tag) {
		apiUrlBuilder.withParameters("nottagged", tag, ";");
		return this;
	}

	@Override
	public QuestionApiQuery withTitle(String title) {
		apiUrlBuilder.withParameter("title", title);
		return this;
	}

	@Override
	public PagedList<Question> listSimilarQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_SIMILAR_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listLinkedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_LINKED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listRelatedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_RELATED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listUnAnsweredQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listUnAnsweredQuestionsByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UN_ANSWERED_USER_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listUnAcceptedQuestionsByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UN_ACCEPTED_USER_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listQuestionsWithNoAnswerByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_USER_QUESTIONS_WITH_NO_ANSWER);
		return super.list();
	}

	@Override
	public PagedList<Question> listTopQuestionsWithTagPostedByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_TOP_USER_QUESTIONS_WITH_TAG);
		return super.list();
	}

	@Override
	public PagedList<Question> listUserFeaturedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_USER_FEATURED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listFeaturedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_FEATURED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listUnansweredUserQuestionWithFavoriteTags() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UNANSWERED_USER_QUESTIONS_WITH_FAV_TAGS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyFavoritesQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_FAVORITE_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyQuestionsWithNoAnswer() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_QUESTIONS_WITN_NO_ANSWER);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyUnacceptedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_UN_ACCEPTED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyUnansweredQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_UN_ANSWERED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyFeaturedQuestions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_FEATURED_QUESTIONS);
		return super.list();
	}

	@Override
	public PagedList<Question> listMyTopQuestionsWithTag() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_TOP_QUESTIONS_WITH_TAGS);
		return super.list();
	}

	@Override
	public PagedList<Question> listQuestionsWithNoAnswer() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_QUESTIONS_WITH_NO_ANSWER);
		return super.list();
	}

	@Override
	public PagedList<Question> listFrequentlyAskedQuestionsByTags() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_FAQ_BY_TAGS);
		return super.list();
	}
}
