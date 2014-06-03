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

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.CommentApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

/**
 * The Class CommentApiQueryImpl.
 */
public class CommentApiQueryImpl extends BaseStackOverflowApiQuery<Comment>
		implements CommentApiQuery {

	/**
	 * Instantiates a new comment api query impl.
	 * 
	 * @param applicationId
	 *            the application id
	 * @param site
	 *            the stack exchange site
	 */
	public CommentApiQueryImpl(String applicationId, StackExchangeSite site) {
		super(applicationId, site);
	}

	public CommentApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite, String accessToken) {
		super(applicationId, stackExchangeSite, accessToken);
	}

	public CommentApiQueryImpl(String applicationId, String apiVersion,
			String accessToken, StackExchangeSite stackExchangeSite) {
		super(applicationId, apiVersion, accessToken, stackExchangeSite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withCommentIds
	 * (long[])
	 */
	@Override
	public CommentApiQuery withCommentIds(long... commentIds) {
		apiUrlBuilder.withIds(commentIds);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withPaging
	 * (com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public CommentApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withSort(com
	 * .google.code.stackexchange.schema.Comment.SortOrder)
	 */
	@Override
	public CommentApiQuery withSort(Comment.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withTimePeriod
	 * (com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public CommentApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withToUserId
	 * (long)
	 */
	@Override
	public CommentApiQuery withToUserId(long toUserId) {
		apiUrlBuilder.withField("toid", String.valueOf(toUserId));
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withUserIds
	 * (long[])
	 */
	@Override
	public CommentApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds("uid", userIds);
		return this;
	}

	@Override
	public CommentApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds("qid", questionIds);
		return this;
	}

	@Override
	public CommentApiQuery withAnswerIds(long... answerIds) {
		apiUrlBuilder.withIds("aid", answerIds);
		return this;
	}

	@Override
	public CommentApiQuery withPostIds(long... postIds) {
		apiUrlBuilder.withIds("pid", postIds);
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
	protected PagedList<Comment> unmarshall(JsonObject json) {
		return unmarshallList(Comment.class, json);
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
				StackExchangeApiMethods.GET_COMMENT, getApplicationKey(),
				getAccessToken(), getSite(), getApiVersion());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#withRange(
	 * com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public CommentApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	/**
	 * Get the comments posted by users in {ids}.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max ,ids
	 * 
	 * Mandatory parameters : ids
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> listUserComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
		return super.list();
	}

	/**
	 * Gets the comments on a question.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max ,ids
	 * 
	 * Mandatory parameters : ids
	 * 
	 * @return the paged list< Comment>
	 */

	@Override
	public PagedList<Comment> listQuestionComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS_FOR_QUESTIONS);
		return super.list();
	}

	/**
	 * Gets the comments on a set of answers.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max ,ids
	 * 
	 * Mandatory parameters : ids
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> listAnswerComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS_FOR_ANSWERS);
		return super.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.CommentApiQuery#
	 * listUserCommentsToUser()
	 */
	@Override
	public PagedList<Comment> listUserCommentsToUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
		return super.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.query.CommentApiQuery#listUserMentions
	 * ()
	 */
	@Override
	public PagedList<Comment> listUserMentions() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_USER_MENTIONS);
		return super.list();
	}

	/**
	 * Gets all the comments on the site.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max
	 * 
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS);
		return super.list();
	}

	@Override
	public CommentApiQuery withAnswerIds(List<Long> answerIds) {
		apiUrlBuilder.withIds(answerIds);
		return this;
	}

	@Override
	public CommentApiQuery withQuestionIds(List<Long> questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	@Override
	public CommentApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/**
	 * Gets the comments on the posts identified in ids, regardless of the type
	 * of the posts.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max ,ids
	 * 
	 * Mandatory parameters : ids
	 * 
	 * @return the paged list< Comment>
	 */

	@Override
	public PagedList<Comment> listPostComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENTS_FOR_POSTS);
		return super.list();
	}

	/**
	 * Gets the comments identified in id.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max ,ids
	 * 
	 * Mandatory parameters : ids
	 * 
	 * @return the paged list< Comment>
	 */

	@Override
	public PagedList<Comment> listByIds() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_COMMENT);
		return super.list();
	}

	/**
	 * Returns the comments owned by the user associated with the given
	 * access_token.
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max
	 * ,accessToken
	 * 
	 * Mandatory parameters : accessToken
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> listMyComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_COMMENTS);
		return super.list();
	}

	/**
	 * Returns the comments owned by the user associated with the given
	 * access_token that are in reply to the user identified by {toUser}
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min,
	 * max,toUser ,accessToken
	 * 
	 * Mandatory parameters : accessToken,toUser
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> listMyCommentsToUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MT_COMMENTS_TO_USER);
		return super.list();
	}

	/**
	 * Returns the comments mentioning the user associated with the given
	 * access_token
	 * 
	 * Sort supported: creation , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max
	 * ,accessToken
	 * 
	 * Mandatory parameters : accessToken
	 * 
	 * @return the paged list< Comment>
	 */
	@Override
	public PagedList<Comment> listMyMentionComments() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_MENTION_COMMENTS);
		return super.list();
	}

	@Override
	public CommentApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

}
