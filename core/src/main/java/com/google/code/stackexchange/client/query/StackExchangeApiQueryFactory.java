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
package com.google.code.stackexchange.client.query;

import com.google.code.stackexchange.client.query.impl.AdvanceSearchApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.AnswerApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.BadgeApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.CommentApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.PostApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.QuestionApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.QuestionTimelineApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.ReputationApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.RevisionApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.SearchApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.StackAuthApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.StatisticsApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.TagApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.UserApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.UserTimelineApiQueryImpl;
import com.google.code.stackexchange.schema.StackExchangeSite;

/**
 * A factory for creating StackExchangeApiQuery objects.
 */
public class StackExchangeApiQueryFactory {

	/** The application key. */
	private String applicationKey;

	/** The Stack Exchange Site . */
	private StackExchangeSite site = StackExchangeSite.STACK_OVERFLOW;

	/**
	 * Instantiates a new stack exchange api query factory.
	 * 
	 * 
	 * @param applicationKey
	 *            the application Key
	 * @param site
	 *            the stack exchange site
	 */
	private StackExchangeApiQueryFactory(String applicationKey,
			StackExchangeSite site) {
		this.applicationKey = applicationKey;
		this.site = site;
	}

	/**
	 * New instance.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            The Stack Exchange Site
	 * @return the stack exchange api query factory
	 */

	public static StackExchangeApiQueryFactory newInstance(
			String applicationKey, StackExchangeSite site) {
		return new StackExchangeApiQueryFactory(applicationKey, site);
	}

	/**
	 * New answer api query.
	 * 
	 * @return the answer api query
	 */
	public AnswerApiQuery newAnswerApiQuery() {
		return new AnswerApiQueryImpl(applicationKey, site);
	}

	/**
	 * New badge api query.
	 * 
	 * @return the badge api query
	 */
	public BadgeApiQuery newBadgeApiQuery() {
		return new BadgeApiQueryImpl(applicationKey, site);
	}

	/**
	 * New comment api query.
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery newCommentApiQuery() {
		return new CommentApiQueryImpl(applicationKey, site);
	}

	/**
	 * New question api query.
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery newQuestionApiQuery() {
		return new QuestionApiQueryImpl(applicationKey, site);
	}

	/**
	 * New search api query.
	 * 
	 * @return the search api query
	 */
	public SearchApiQuery newSearchApiQuery() {
		return new SearchApiQueryImpl(applicationKey, site);
	}

	/**
	 * New Advance search api query.
	 * 
	 * @return the Advance search api query
	 */
	public AdvanceSearchApiQuery newAdvanceSearchApiQuery() {
		return new AdvanceSearchApiQueryImpl(applicationKey, site);
	}
	
	
	/**
	 * New post api query.
	 * 
	 * @return the post api query
	 */
	public PostApiQuery newPostApiQuery() {
		return new PostApiQueryImpl(applicationKey, site);
	}

	/**
	 * New question timeline api query.
	 * 
	 * @return the question timeline api query
	 */
	public QuestionTimelineApiQuery newQuestionTimelineApiQuery() {
		return new QuestionTimelineApiQueryImpl(applicationKey, site);
	}

	/**
	 * New reputation api query.
	 * 
	 * @return the reputation api query
	 */
	public ReputationApiQuery newReputationApiQuery() {
		return new ReputationApiQueryImpl(applicationKey, site);
	}

	/**
	 * New revision api query.
	 * 
	 * @return the revision api query
	 */
	public RevisionApiQuery newRevisionApiQuery() {
		return new RevisionApiQueryImpl(applicationKey, site);
	}

	/**
	 * New statistics api query.
	 * 
	 * @return the statistics api query
	 */
	public StatisticsApiQuery newStatisticsApiQuery() {
		return new StatisticsApiQueryImpl(applicationKey, site);
	}

	/**
	 * New tag api query.
	 * 
	 * @return the tag api query
	 */
	public TagApiQuery newTagApiQuery() {
		return new TagApiQueryImpl(applicationKey, site);
	}

	/**
	 * New user api query.
	 * 
	 * @return the user api query
	 */
	public UserApiQuery newUserApiQuery() {
		return new UserApiQueryImpl(applicationKey, site);
	}

	/**
	 * New user timeline api query.
	 * 
	 * @return the user timeline api query
	 */
	public UserTimelineApiQuery newUserTimelineApiQuery() {
		return new UserTimelineApiQueryImpl(applicationKey, site);
	}

	/**
	 * New user timeline api query.
	 * 
	 * @return the user timeline api query
	 */
	public StackAuthApiQuery newStackAuthApiQuery() {
		return new StackAuthApiQueryImpl(applicationKey, site);
	}

}
