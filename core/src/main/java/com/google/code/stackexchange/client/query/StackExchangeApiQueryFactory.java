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

import com.google.code.stackexchange.client.query.impl.AnswerApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.BadgeApiQueryImpl;
import com.google.code.stackexchange.client.query.impl.CommentApiQueryImpl;
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


/**
 * A factory for creating StackExchangeApiQuery objects.
 */
public class StackExchangeApiQueryFactory {

    /** The application key. */
    private String applicationKey;

    /**
     * Instantiates a new stack exchange api query factory.
     * 
     * @param applicationKey the application key
     */
	private StackExchangeApiQueryFactory(String applicationKey) {
        this.applicationKey = applicationKey;
    }
	
    /**
     * New instance.
     * 
     * @param applicationKey the application key
     * 
     * @return the stack exchange api query factory
     */
    public static StackExchangeApiQueryFactory newInstance(String applicationKey) {
        return new StackExchangeApiQueryFactory(applicationKey);
    }
    
    /**
     * New answer api query.
     * 
     * @return the answer api query
     */
    public AnswerApiQuery newAnswerApiQuery() {
    	return new AnswerApiQueryImpl(applicationKey);
    }
    
    /**
     * New badge api query.
     * 
     * @return the badge api query
     */
    public BadgeApiQuery newBadgeApiQuery() {
    	return new BadgeApiQueryImpl(applicationKey);
    }
    
    /**
     * New comment api query.
     * 
     * @return the comment api query
     */
    public CommentApiQuery newCommentApiQuery() {
    	return new CommentApiQueryImpl(applicationKey);
    }
    
    /**
     * New question api query.
     * 
     * @return the question api query
     */
    public QuestionApiQuery newQuestionApiQuery() {
    	return new QuestionApiQueryImpl(applicationKey);
    }
    
    /**
     * New search api query.
     * 
     * @return the search api query
     */
    public SearchApiQuery newSearchApiQuery() {
    	return new SearchApiQueryImpl(applicationKey);
    }

    /**
     * New question timeline api query.
     * 
     * @return the question timeline api query
     */
    public QuestionTimelineApiQuery newQuestionTimelineApiQuery() {
    	return new QuestionTimelineApiQueryImpl(applicationKey);
    }

    /**
     * New reputation api query.
     * 
     * @return the reputation api query
     */
    public ReputationApiQuery newReputationApiQuery() {
    	return new ReputationApiQueryImpl(applicationKey);
    }

    /**
     * New revision api query.
     * 
     * @return the revision api query
     */
    public RevisionApiQuery newRevisionApiQuery() {
    	return new RevisionApiQueryImpl(applicationKey);
    }

    /**
     * New statistics api query.
     * 
     * @return the statistics api query
     */
    public StatisticsApiQuery newStatisticsApiQuery() {
    	return new StatisticsApiQueryImpl(applicationKey);
    }

    /**
     * New tag api query.
     * 
     * @return the tag api query
     */
    public TagApiQuery newTagApiQuery() {
    	return new TagApiQueryImpl(applicationKey);
    }

    /**
     * New user api query.
     * 
     * @return the user api query
     */
    public UserApiQuery newUserApiQuery() {
    	return new UserApiQueryImpl(applicationKey);
    }

    /**
     * New user timeline api query.
     * 
     * @return the user timeline api query
     */
    public UserTimelineApiQuery newUserTimelineApiQuery() {
    	return new UserTimelineApiQueryImpl(applicationKey);
    }
    
    /**
     * New user timeline api query.
     * 
     * @return the user timeline api query
     */
    public StackAuthApiQuery newStackAuthApiQuery() {
    	return new StackAuthApiQueryImpl(applicationKey);
    }
    
}
