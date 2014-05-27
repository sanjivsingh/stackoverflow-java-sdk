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
import com.google.code.stackexchange.client.query.BadgeApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Badge;
import com.google.gson.JsonObject;

/**
 * The Class BadgeApiQueryImpl.
 */
public class BadgeApiQueryImpl extends BaseStackOverflowApiQuery<Badge> implements BadgeApiQuery {

	/**
	 * Instantiates a new badge api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public BadgeApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.BadgeApiQuery#withUserIds(long[])
	 */
	@Override
	public BadgeApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Badge> unmarshall(JsonObject json) {
		return unmarshallList(Badge.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_BADGES, getApplicationKey(), getApiVersion());
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.BadgeApiQuery#listByName()
	 */
	@Override
	public PagedList<Badge> listByName() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_BADGES_BY_NAME);
		return super.list();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.BadgeApiQuery#listByTags()
	 */
	@Override
	public PagedList<Badge> listByTags() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_BADGES_BY_TAGS);
		return super.list();
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<Badge> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_BADGES);
		return super.list();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.BadgeApiQuery#listByUsers()
	 */
	@Override
	public PagedList<Badge> listByUsers() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_BADGES_FOR_USER);
		return super.list();
	}

	@Override
	public BadgeApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
