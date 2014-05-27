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
import com.google.code.stackexchange.client.query.TagApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

/**
 * The Class TagApiQueryImpl.
 */
public class TagApiQueryImpl extends BaseStackOverflowApiQuery<Tag> implements TagApiQuery {

	/**
	 * Instantiates a new tag api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public TagApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.TagApiQuery#withPaging(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public TagApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.TagApiQuery#withSort(com.google.code.stackexchange.schema.Tag.SortOrder)
	 */
	@Override
	public TagApiQuery withSort(Tag.SortOrder sort) {
		apiUrlBuilder.withSort(sort);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.TagApiQuery#withUserIds(long[])
	 */
	@Override
	public TagApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Tag> unmarshall(JsonObject json) {
		return unmarshallList(Tag.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_TAGS, getApplicationKey(), getApiVersion());
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.TagApiQuery#withRange(com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public TagApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}
	
	@Override
	public TagApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}
	
	@Override
	public TagApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.TagApiQuery#listByUser()
	 */
	@Override
	public PagedList<Tag> listByUser() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_TAGS_FOR_USER);
		return super.list();
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<Tag> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder).withMethod(StackExchangeApiMethods.GET_TAGS);
		return super.list();
	}

	@Override
	public TagApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
