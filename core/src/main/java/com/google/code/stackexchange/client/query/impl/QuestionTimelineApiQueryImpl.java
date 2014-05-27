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
import com.google.code.stackexchange.client.query.QuestionTimelineApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

/**
 * The Class QuestionTimelineApiQueryImpl.
 */
public class QuestionTimelineApiQueryImpl extends BaseStackOverflowApiQuery<PostTimeline> implements QuestionTimelineApiQuery {

	/**
	 * Instantiates a new question timeline api query impl.
	 * 
	 * @param applicationId the application id
	 */
	public QuestionTimelineApiQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionTimelineApiQuery#withQuestionIds(long[])
	 */
	@Override
	public QuestionTimelineApiQuery withQuestionIds(long... questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.QuestionTimelineApiQuery#withTimePeriod(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public QuestionTimelineApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}
	
	@Override
	public QuestionTimelineApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}
	

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.impl.BaseStackOverflowApiQuery#unmarshall(org.json.simple.JSONObject)
	 */
	@Override
	protected PagedList<PostTimeline> unmarshall(JsonObject json) {
		return unmarshallList(PostTimeline.class, json);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION_TIMELINE, getApplicationKey(), getApiVersion());
	}

	@Override
	public QuestionTimelineApiQuery withQuestionIds(List<Long> questionIds) {
		apiUrlBuilder.withIds(questionIds);
		return this;
	}
}
