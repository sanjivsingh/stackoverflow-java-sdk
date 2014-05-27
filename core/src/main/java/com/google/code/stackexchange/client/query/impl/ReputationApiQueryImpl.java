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
import com.google.code.stackexchange.client.query.ReputationApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

/**
 * The Class ReputationApiQueryImpl.
 */
public class ReputationApiQueryImpl extends BaseStackOverflowApiQuery<Reputation> implements ReputationApiQuery {

	/**
	 * Instantiates a new reputation api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public ReputationApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.ReputationApiQuery#withPaging(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public ReputationApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.ReputationApiQuery#withTimePeriod(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public ReputationApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.ReputationApiQuery#withUserIds(long[])
	 */
	@Override
	public ReputationApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Reputation> unmarshall(JsonObject json) {
		return unmarshallList(Reputation.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_USER_REPUTATIONS, getApplicationKey(), getApiVersion());
	}

	@Override
	public ReputationApiQuery withUserIds(List<Long> userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}
}
