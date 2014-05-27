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
import com.google.code.stackexchange.client.query.RevisionApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

/**
 * The Class RevisionApiQueryImpl.
 */
public class RevisionApiQueryImpl extends BaseStackOverflowApiQuery<Revision> implements RevisionApiQuery {

	/**
	 * Instantiates a new revision api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public RevisionApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.RevisionApiQuery#withQuestionIds(long[])
	 */
	@Override
	public RevisionApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.RevisionApiQuery#withRevisionGuid(java.lang.String)
	 */
	@Override
	public RevisionApiQuery withRevisionGuid(String revisionGuid) {
		apiUrlBuilder.withField("revisionguid", revisionGuid);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.RevisionApiQuery#withTimePeriod(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public RevisionApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<Revision> unmarshall(JsonObject json) {
		return unmarshallList(Revision.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_REVISION_FOR_POST, getApplicationKey(), getApiVersion());
	}

	@Override
	public RevisionApiQuery withQuestionIds(List<Long> questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}
}
