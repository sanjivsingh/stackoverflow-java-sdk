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
package com.google.code.stackexchange.client.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.google.code.stackexchange.client.StackExchangeApiClient;
import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.ApiUrlBuilder;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.Statistics;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.code.stackexchange.schema.UserTimeline;
import com.google.code.stackexchange.schema.User.QuestionSortOrder;

/**
 * The Class BaseStackExchangeApiClient.
 */
public abstract class BaseStackExchangeApiClient extends StackExchangeApiGateway implements StackExchangeApiClient {

    /**
     * Instantiates a new base stack exchange api client.
     * 
     * @param applicationKey the application key
     */
    protected BaseStackExchangeApiClient(String applicationKey) {
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
        this.applicationKey = applicationKey;
    }
    
    /**
     * Instantiates a new base stack exchange api client.
     * 
     * @param applicationKey the application key
     * @param apiVersion the api version
     */
    protected BaseStackExchangeApiClient(String applicationKey, String apiVersion) {
    	this(applicationKey);
    	this.apiVersion = apiVersion;
    }
    
    /**
     * Creates the stack overflow api url builder.
     * 
     * @param methodName the method name
     * 
     * @return the api url builder
     */
    protected abstract ApiUrlBuilder createStackOverflowApiUrlBuilder(String methodName);

    /**
     * Checks if is null or empty.
     * 
     * @param s the s
     * 
     * @return true, if is null or empty
     */
    protected boolean isNullOrEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert not null or empty.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
        if ((value == null) || value.isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     * Assert positive number.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertPositiveNumber(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be less than zero.");
        }
    }

    /**
     * Assert not null.
     * 
     * @param name the name
     * @param value the value
     */
    protected void assertNotNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(Paging paging, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(TimePeriod timePeriod,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.User.FavoriteSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(User.FavoriteSortOrder sort,
			Paging paging, TimePeriod timePeriod, Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withPaging(paging).withTimePeriod(timePeriod).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Question> getQuestions(Paging paging, long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getQuestions(Set<FilterOption> filterOptions, long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging, java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getQuestions(Paging paging, Set<FilterOption> filterOptions,
			long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withPaging(paging).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsTimeline(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<PostTimeline> getQuestionsTimeline(TimePeriod timePeriod,
			long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION_TIMELINE);
        String                apiUrl  = builder.withIds(questionIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(PostTimeline.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Question> getQuestions(Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public PagedList<Question> getQuestions(TimePeriod timePeriod) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(java.util.Set)
	 */
	@Override
	public PagedList<Question> getQuestions(Set<FilterOption> filterOptions) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Question.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public PagedList<Question> getQuestions(Question.SortOrder sort, Paging paging,
			TimePeriod timePeriod, Set<FilterOption> filterOptions) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).withPaging(paging).withTimePeriod(timePeriod).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(Paging paging, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(User.QuestionSortOrder sort,
			Paging paging, TimePeriod timePeriod, Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withPaging(paging).withTimePeriod(timePeriod).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTaggedQuestions(java.util.List, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public PagedList<Question> getTaggedQuestions(List<String> tags,
			Paging paging, TimePeriod timePeriod,
			Set<FilterOption> filterOptions) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withParameters("tagged", tags, ";").withPaging(paging).withTimePeriod(timePeriod).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Tag> getTags(Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS);
        String                apiUrl  = builder.withPaging(paging).buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Tag.SortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Tag> getTags(Tag.SortOrder sort, Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS);
        String                apiUrl  = builder.withSort(sort).withPaging(paging).buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTagsForUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Tag> getTagsForUsers(Paging paging, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS_FOR_USER);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(TimePeriod timePeriod) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions(java.util.Set)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(Set<FilterOption> filterOptions) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Question.UnansweredSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(
			Question.UnansweredSortOrder sort, Paging paging,
			TimePeriod timePeriod, Set<FilterOption> filterOptions) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).withPaging(paging).withTimePeriod(timePeriod).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersMentions(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Comment> getUsersMentions(TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_MENTIONS);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersTimeline(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<UserTimeline> getUsersTimeline(TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_TIMELINE);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(UserTimeline.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<User> getUsers(Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.withPaging(paging).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers(java.lang.String)
	 */
	@Override
	public PagedList<User> getUsers(String filter) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.withParameter("filter", filter).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers(java.lang.String, com.google.code.stackexchange.schema.User.SortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<User> getUsers(String filter, User.SortOrder sort, Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.withParameter("filter", filter).withSort(sort).withPaging(paging).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswers(long[])
	 */
	@Override
	public PagedList<Answer> getAnswers(long... answerIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWER);
        String                apiUrl  = builder.withIds(answerIds).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByUsers(long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByQuestions(long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByQuestions(long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByUsers(com.google.code.stackexchange.schema.Answer.SortOrder, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByUsers(Answer.SortOrder sort, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getAnswersByUsers(com.google.code.stackexchange.schema.Answer.SortOrder, com.google.code.stackexchange.schema.Range, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByUsers(Answer.SortOrder sort, Range range, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByQuestions(com.google.code.stackexchange.schema.Answer.SortOrder, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByQuestions(Answer.SortOrder sort, long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withSort(sort).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getAnswersByQuestions(com.google.code.stackexchange.schema.Answer.SortOrder, com.google.code.stackexchange.schema.Range, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByQuestions(Answer.SortOrder sort, Range range, long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadges()
	 */
	@Override
	public PagedList<Badge> getBadges() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGES);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Badge.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadgesByName()
	 */
	@Override
	public PagedList<Badge> getBadgesByName() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGES_BY_NAME);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Badge.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadgesByTags()
	 */
	@Override
	public PagedList<Badge> getBadgesByTags() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGES_BY_TAGS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Badge.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadgesForUsers(long[])
	 */
	@Override
	public PagedList<Badge> getBadgesForUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGES_FOR_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Badge.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.User.FavoriteSortOrder, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(User.FavoriteSortOrder sort,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.User.FavoriteSortOrder, com.google.code.stackexchange.schema.Range, long[])
	 */
	@Override
	public PagedList<Question> getFavoriteQuestionsByUsers(User.FavoriteSortOrder sort, Range range,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_FAVORITE_QUESTIONS);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(long[])
	 */
	@Override
	public PagedList<Question> getQuestions(long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsTimeline(long[])
	 */
	@Override
	public PagedList<PostTimeline> getQuestionsTimeline(long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTION_TIMELINE);
        String                apiUrl  = builder.withIds(questionIds).buildUrl();

        return unmarshallList(PostTimeline.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions()
	 */
	@Override
	public PagedList<Question> getQuestions() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Question.SortOrder)
	 */
	@Override
	public PagedList<Question> getQuestions(Question.SortOrder sort) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).buildUrl();
        
        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getQuestions(com.google.code.stackexchange.schema.Question.SortOrder, com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public PagedList<Question> getQuestions(Question.SortOrder sort, Range range) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).withRange(range).buildUrl();
        
        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.User.QuestionSortOrder, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(User.QuestionSortOrder sort,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Range, long[])
	 */
	@Override
	public PagedList<Question> getQuestionsByUsers(User.QuestionSortOrder sort, Range range,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTaggedQuestions(java.util.List)
	 */
	@Override
	public PagedList<Question> getTaggedQuestions(List<String> tags) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_QUESTIONS);
        String                apiUrl  = builder.withParameters("tagged", tags, ";").buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTags()
	 */
	@Override
	public PagedList<Tag> getTags() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Tag.SortOrder)
	 */
	@Override
	public PagedList<Tag> getTags(Tag.SortOrder sort) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS);
        String                apiUrl  = builder.withSort(sort).buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getTagsForUsers(long[])
	 */
	@Override
	public PagedList<Tag> getTagsForUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_TAGS_FOR_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Tag.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions()
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Question.UnansweredSortOrder)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(Question.UnansweredSortOrder sort) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Question.UnansweredSortOrder, com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public PagedList<Question> getUnansweredQuestions(Question.UnansweredSortOrder sort, Range range) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_UN_ANSWERED_QUESTIONS);
        String                apiUrl  = builder.withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers(long[])
	 */
	@Override
	public PagedList<User> getUsers(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersMentions(long[])
	 */
	@Override
	public PagedList<Comment> getUsersMentions(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_MENTIONS);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersTimeline(long[])
	 */
	@Override
	public PagedList<UserTimeline> getUsersTimeline(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_TIMELINE);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(UserTimeline.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers()
	 */
	@Override
	public PagedList<User> getUsers() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsers(com.google.code.stackexchange.schema.User.SortOrder)
	 */
	@Override
	public PagedList<User> getUsers(User.SortOrder sort) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.withSort(sort).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getUsers(com.google.code.stackexchange.schema.User.SortOrder, com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public PagedList<User> getUsers(User.SortOrder sort, Range range) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USERS);
        String                apiUrl  = builder.withSort(sort).withRange(range).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersReputations(long[])
	 */
	@Override
	public PagedList<Reputation> getUsersReputations(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_REPUTATIONS);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Reputation.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Reputation> getUsersReputations(TimePeriod timePeriod,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_REPUTATIONS);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Reputation.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Reputation> getUsersReputations(Paging paging, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_REPUTATIONS);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).buildUrl();

        return unmarshallList(Reputation.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Reputation> getUsersReputations(Paging paging,
			TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_USER_REPUTATIONS);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Reputation.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersComments(long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Comment.SortOrder, long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(Comment.SortOrder sort, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#getUsersComments(com.google.code.stackexchange.schema.Comment.SortOrder, com.google.code.stackexchange.schema.Range, long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(Comment.SortOrder sort, Range range, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(Paging paging, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withPaging(paging).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Comment.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Comment> getUsersComments(Comment.SortOrder sort, Paging paging,
			TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withPaging(paging).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersCommentsToUser(long, long[])
	 */
	@Override
	public PagedList<Comment> getUsersCommentsToUser(long toUserId, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
        String                apiUrl  = builder.withIds(userIds).withField("toid", String.valueOf(toUserId)).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Comment.SortOrder, long[])
	 */
	@Override
	public PagedList<Comment> getUsersCommentsToUser(long toUserId, Comment.SortOrder sort,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
        String                apiUrl  = builder.withIds(userIds).withField("toid", String.valueOf(toUserId)).withSort(sort).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Comment> getUsersCommentsToUser(long toUserId, TimePeriod timePeriod,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
        String                apiUrl  = builder.withIds(userIds).withField("toid", String.valueOf(toUserId)).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<Comment> getUsersCommentsToUser(long toUserId, Paging paging,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
        String                apiUrl  = builder.withIds(userIds).withField("toid", String.valueOf(toUserId)).withPaging(paging).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Comment.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Comment> getUsersCommentsToUser(long toUserId, Comment.SortOrder sort,
			Paging paging, TimePeriod timePeriod, long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENTS_BY_USER_TO_USER);
        String                apiUrl  = builder.withIds(userIds).withField("toid", String.valueOf(toUserId)).withSort(sort).withPaging(paging).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getComments(long[])
	 */
	@Override
	public PagedList<Comment> getComments(long... commentIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_COMMENT);
        String                apiUrl  = builder.withIds(commentIds).buildUrl();

        return unmarshallList(Comment.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getStatistics()
	 */
	@Override
	public List<Statistics> getStatistics() {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_STATISTICS);
        String                apiUrl  = builder.buildUrl();

        return unmarshallList(Statistics.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswers(java.util.Set, long[])
	 */
	@Override
	public PagedList<Answer> getAnswers(Set<FilterOption> filterOptions, long... answerIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWER);
        String                apiUrl  = builder.withIds(answerIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByUsers(java.util.Set, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByUsers(Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByQuestions(java.util.Set, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByQuestions(Set<FilterOption> filterOptions,
			long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByUsers(com.google.code.stackexchange.schema.Answer.SortOrder, java.util.Set, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByUsers(Answer.SortOrder sort, Set<FilterOption> filterOptions,
			long... userIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_USER);
        String                apiUrl  = builder.withIds(userIds).withSort(sort).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getAnswersByQuestions(com.google.code.stackexchange.schema.Answer.SortOrder, java.util.Set, long[])
	 */
	@Override
	public PagedList<Answer> getAnswersByQuestions(Answer.SortOrder sort, Set<FilterOption> filterOptions,
			long... questionIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_ANSWERS_BY_QUESTION);
        String                apiUrl  = builder.withIds(questionIds).withSort(sort).withFetchOptions(filterOptions).buildUrl();

        return unmarshallList(Answer.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getRevisionForPost(long, java.lang.String)
	 */
	@Override
	public Revision getRevisionForPost(long postId, String revisionGuid) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_REVISIONS_FOR_POST);
        String                apiUrl  = builder.withId(postId).withField("revisionguid", revisionGuid).buildUrl();

        PagedList<Revision> list = unmarshallList(Revision.class, callApiMethod(apiUrl));
        return (list.isEmpty())? null : list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getRevisionsForPosts(long[])
	 */
	@Override
	public PagedList<Revision> getRevisionsForPosts(long... postIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_REVISIONS_FOR_POST);
        String                apiUrl  = builder.withIds(postIds).buildUrl();

        return unmarshallList(Revision.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getRevisionsForPosts(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public PagedList<Revision> getRevisionsForPosts(TimePeriod timePeriod, long... postIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_REVISIONS_FOR_POST);
        String                apiUrl  = builder.withIds(postIds).withTimePeriod(timePeriod).buildUrl();

        return unmarshallList(Revision.class, callApiMethod(apiUrl));
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadgesRecipients(long[])
	 */
	@Override
	public PagedList<User> getBadgesRecipients(long... badgeIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGE_RECIPIENTS);
        String                apiUrl  = builder.withIds(badgeIds).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#getBadgesRecipients(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public PagedList<User> getBadgesRecipients(Paging paging, long... badgeIds) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.GET_BADGE_RECIPIENTS);
        String                apiUrl  = builder.withIds(badgeIds).withPaging(paging).buildUrl();

        return unmarshallList(User.class, callApiMethod(apiUrl));
        
        
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#searchQuestions(java.lang.String)
	 */
	@Override
	public PagedList<Question> searchQuestions(String query) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameter("intitle", query).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#searchQuestions(java.lang.String, com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Question> searchQuestions(String query, QuestionSortOrder sort,
			Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameter("intitle", query).withSort(sort).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackExchangeApiClient#searchQuestions(java.lang.String, com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Range)
	 */
	@Override
	public PagedList<Question> searchQuestions(String query, QuestionSortOrder sort,
			Range range) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameter("intitle", query).withSort(sort).withRange(range).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#searchQuestions(java.util.List, java.util.List)
	 */
	@Override
	public PagedList<Question> searchQuestions(List<String> includeTags,
			List<String> excludeTags) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameters("tagged", includeTags, ";").withParameters("nottagged", excludeTags, ";").buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#searchQuestions(java.util.List, java.util.List, com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Question> searchQuestions(List<String> includeTags,
			List<String> excludeTags, QuestionSortOrder sort, Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameters("tagged", includeTags, ";").withParameters("nottagged", excludeTags, ";").withSort(sort).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
        
        
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClient#searchQuestions(java.lang.String, java.util.List, java.util.List, com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public PagedList<Question> searchQuestions(String query,
			List<String> includeTags, List<String> excludeTags,
			QuestionSortOrder sort, Paging paging) {
		ApiUrlBuilder builder = createStackOverflowApiUrlBuilder(StackExchangeApiMethods.SEARCH_QUESTIONS);
        String                apiUrl  = builder.withParameter("intitle", query).withParameters("tagged", includeTags, ";").withParameters("nottagged", excludeTags, ";").withSort(sort).withPaging(paging).buildUrl();

        return unmarshallList(Question.class, callApiMethod(apiUrl));
	}
}
