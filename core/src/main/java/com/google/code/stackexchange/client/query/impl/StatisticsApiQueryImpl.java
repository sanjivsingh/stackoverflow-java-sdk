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

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.query.StatisticsApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Statistics;
import com.google.gson.JsonObject;

/**
 * The Class StatisticsApiQueryImpl.
 */
public class StatisticsApiQueryImpl extends BaseStackOverflowApiQuery<Statistics> implements StatisticsApiQuery {

	/**
	 * Instantiates a new statistics api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public StatisticsApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Statistics> unmarshall(JsonObject json) {
		return unmarshallList(Statistics.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_STATISTICS, getApplicationKey(), getApiVersion());
	}
}
