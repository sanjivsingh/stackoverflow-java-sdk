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
import com.google.code.stackexchange.client.query.UserApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.gson.JsonObject;

/**
 * The Class UserApiQueryImpl.
 */
public class UserApiQueryImpl extends BaseStackOverflowApiQuery<User> implements UserApiQuery {

	/**
	 * Instantiates a new user api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public UserApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withFilter(java.lang.String)
	 */
	@Override
	public UserApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withPaging(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public UserApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withSort(com.google.code.stackexchange.schema.User.SortOrder)
	 */
	@Override
	public UserApiQuery withSort(User.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withUserIds(long[])
	 */
	@Override
	public UserApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<User> unmarshall(JsonObject json) {
		return unmarshallList(User.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_USERS, getApplicationKey(), getApiVersion());
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withBadgeIds(long[])
	 */
	@Override
	public UserApiQuery withBadgeIds(long... badgeIds) {
		apiUrlBuilder.withIds(badgeIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#withRange(com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public UserApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}
	
	@Override
	public UserApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.UserApiQuery#listByBadge()
	 */
	@Override
	public PagedList<User> listByBadge() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_BADGE_RECIPIENTS);
		return super.list();
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<User> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_USERS);
		return super.list();
	}

	@Override
	public PagedList<User> listModerators() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_MODERATORS);
		return super.list();
	}

	@Override
	public PagedList<User> listAssociatedAccounts() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_ASSOCIATED_USERS);
		return super.list();
	}

	@Override
	public UserApiQuery withAssociationId(String associationId) {
		((DefaultApiUrlBuilder) apiUrlBuilder).withField("id", associationId, false);
		return this;
	}

	@Override
	public UserApiQuery withBadgeIds(List<Long> badgeIds) {
		apiUrlBuilder.withIds(badgeIds);
		return this;
	}

	@Override
	public UserApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
