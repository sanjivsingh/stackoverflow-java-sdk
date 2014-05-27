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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.stackexchange.client.AsyncStackExchangeApiClient;
import com.google.code.stackexchange.client.StackExchangeApiClient;
import com.google.code.stackexchange.client.provider.ApiProvider;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.Statistics;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;
import com.google.code.stackexchange.schema.UserTimeline;
import com.google.code.stackexchange.schema.Answer.SortOrder;

/**
 * The Class AsyncStackExchangeApiClientAdapter.
 */
public class AsyncStackExchangeApiClientAdapter implements AsyncStackExchangeApiClient {

    /** The client. */
    private StackExchangeApiClient client;
    
    /** The task executor. */
    private ExecutorService taskExecutor;

    /**
     * Instantiates a new async stack exchange api client adapter.
     * 
     * @param client the client
     * @param taskExecutor the task executor
     */

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncStackExchangeApiClientAdapter(StackExchangeApiClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future<?>
     */
    protected Future<?> execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Execute.
     * 
     * @param task the task
     * 
     * @return the future< t>
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
    }
    
    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#setRequestHeaders(java.util.Map)
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	client.setRequestHeaders(requestHeaders);
    }

    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#getRequestHeaders()
     */
    public Map<String, String> getRequestHeaders() {
        return client.getRequestHeaders();
    }

    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#addRequestHeader(java.lang.String, java.lang.String)
     */
    public void addRequestHeader(String headerName, String headerValue) {
        client.addRequestHeader(headerName, headerValue);
    }

    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#removeRequestHeader(java.lang.String)
     */
    public void removeRequestHeader(String headerName) {
        client.removeRequestHeader(headerName);
    }

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowAuthenticationClient#getApplicationKey()
	 */
	@Override
	public String getApplicationKey() {
		return client.getApplicationKey();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowAuthenticationClient#setApplicationKey(java.lang.String)
	 */
	@Override
	public void setApplicationKey(String applicationKey) {
		client.setApplicationKey(applicationKey);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#getApiProvider()
	 */
	@Override
	public ApiProvider getApiProvider() {
		return client.getApiProvider();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#setApiProvider(com.google.code.stackexchange.client.provider.ApiProvider)
	 */
	@Override
	public void setApiProvider(ApiProvider apiProvider) {
		client.setApiProvider(apiProvider);
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswers(long[])
	 */
	@Override
	public Future<List<Answer>> getAnswers(final long... answerIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswers(answerIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswers(java.util.Set, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswers(final Set<FilterOption> filterOptions,
			final long... answerIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswers(filterOptions, answerIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByUsers(long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByUsers(final long... userIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByUsers(java.util.Set, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByUsers(final Set<FilterOption> filterOptions,
			final long... userIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByUsers(filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByUsers(com.google.code.stackexchange.schema.Answer.SortOrder, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByUsers(final Answer.SortOrder sort,
			final long... userIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByUsers(sort, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByUsers(com.google.code.stackexchange.schema.Answer.SortOrder, java.util.Set, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByUsers(final Answer.SortOrder sort,
			final Set<FilterOption> filterOptions, final long... userIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByUsers(sort, filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadges()
	 */
	@Override
	public Future<List<Badge>> getBadges() {
		return execute(new Callable<List<Badge>>() {
            @Override
            public List<Badge> call() throws Exception {
                return client.getBadges();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadgesByName()
	 */
	@Override
	public Future<List<Badge>> getBadgesByName() {
		return execute(new Callable<List<Badge>>() {
            @Override
            public List<Badge> call() throws Exception {
                return client.getBadgesByName();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadgesByTags()
	 */
	@Override
	public Future<List<Badge>> getBadgesByTags() {
		return execute(new Callable<List<Badge>>() {
            @Override
            public List<Badge> call() throws Exception {
                return client.getBadgesByTags();
            }
        });
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadgesForUsers(long[])
	 */
	@Override
	public Future<List<Badge>> getBadgesForUsers(final long... userIds) {
		return execute(new Callable<List<Badge>>() {
            @Override
            public List<Badge> call() throws Exception {
                return client.getBadgesForUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getComments(long[])
	 */
	@Override
	public Future<List<Comment>> getComments(final long... commentIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getComments(commentIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.User.FavoriteSortOrder, long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final User.FavoriteSortOrder sort,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(sort, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final Paging paging,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final Set<FilterOption> filterOptions,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getFavoriteQuestionsByUsers(com.google.code.stackexchange.schema.User.FavoriteSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getFavoriteQuestionsByUsers(final User.FavoriteSortOrder sort,
			final Paging paging, final TimePeriod timePeriod, final Set<FilterOption> filterOptions,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getFavoriteQuestionsByUsers(sort, paging, timePeriod, filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(long[])
	 */
	@Override
	public Future<List<Question>> getQuestions(final long... questionIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Question>> getQuestions(final Paging paging, final long... questionIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(paging, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getQuestions(final Set<FilterOption> filterOptions,
			final long... questionIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(filterOptions, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging, java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getQuestions(final Paging paging, final Set<FilterOption> filterOptions,
			final long... questionIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(paging, filterOptions, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsTimeline(long[])
	 */
	@Override
	public Future<List<PostTimeline>> getQuestionsTimeline(final long... questionIds) {
		return execute(new Callable<List<PostTimeline>>() {
            @Override
            public List<PostTimeline> call() throws Exception {
                return client.getQuestionsTimeline(questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsTimeline(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<PostTimeline>> getQuestionsTimeline(final TimePeriod timePeriod,
			final long... questionIds) {
		return execute(new Callable<List<PostTimeline>>() {
            @Override
            public List<PostTimeline> call() throws Exception {
                return client.getQuestionsTimeline(timePeriod, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions()
	 */
	@Override
	public Future<List<Question>> getQuestions() {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<Question>> getQuestions(final Paging paging) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public Future<List<Question>> getQuestions(final TimePeriod timePeriod) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(timePeriod);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Question.SortOrder)
	 */
	@Override
	public Future<List<Question>> getQuestions(final Question.SortOrder sort) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(sort);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(java.util.Set)
	 */
	@Override
	public Future<List<Question>> getQuestions(final Set<FilterOption> filterOptions) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(filterOptions);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestions(com.google.code.stackexchange.schema.Question.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public Future<List<Question>> getQuestions(final Question.SortOrder sort,
			final Paging paging, final TimePeriod timePeriod,
			final Set<FilterOption> filterOptions) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestions(sort, paging, timePeriod, filterOptions);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.User.QuestionSortOrder, long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final User.QuestionSortOrder sort,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(sort, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final Paging paging, final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final Set<FilterOption> filterOptions,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getQuestionsByUsers(com.google.code.stackexchange.schema.User.QuestionSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set, long[])
	 */
	@Override
	public Future<List<Question>> getQuestionsByUsers(final User.QuestionSortOrder sort,
			final Paging paging, final TimePeriod timePeriod, final Set<FilterOption> filterOptions,
			final long... userIds) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getQuestionsByUsers(sort, paging, timePeriod, filterOptions, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getStatistics()
	 */
	@Override
	public Future<List<Statistics>> getStatistics() {
		return execute(new Callable<List<Statistics>>() {
            @Override
            public List<Statistics> call() throws Exception {
                return client.getStatistics();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTaggedQuestions(java.util.List)
	 */
	@Override
	public Future<List<Question>> getTaggedQuestions(final List<String> tags) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getTaggedQuestions(tags);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTaggedQuestions(java.util.List, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public Future<List<Question>> getTaggedQuestions(final List<String> tags,
			final Paging paging, final TimePeriod timePeriod,
			final Set<FilterOption> filterOptions) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getTaggedQuestions(tags, paging, timePeriod, filterOptions);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTags()
	 */
	@Override
	public Future<List<Tag>> getTags() {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTags();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Tag.SortOrder)
	 */
	@Override
	public Future<List<Tag>> getTags(final Tag.SortOrder sort) {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTags(sort);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<Tag>> getTags(final Paging paging) {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTags(paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTags(com.google.code.stackexchange.schema.Tag.SortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<Tag>> getTags(final Tag.SortOrder sort, final Paging paging) {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTags(sort, paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTagsForUsers(long[])
	 */
	@Override
	public Future<List<Tag>> getTagsForUsers(final long... userIds) {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTagsForUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getTagsForUsers(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Tag>> getTagsForUsers(final Paging paging, final long... userIds) {
		return execute(new Callable<List<Tag>>() {
            @Override
            public List<Tag> call() throws Exception {
                return client.getTagsForUsers(paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions()
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions() {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Question.UnansweredSortOrder)
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions(
			final Question.UnansweredSortOrder sort) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions(sort);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions(final Paging paging) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions(paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.TimePeriod)
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions(final TimePeriod timePeriod) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions(timePeriod);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions(java.util.Set)
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions(
			final Set<FilterOption> filterOptions) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions(filterOptions);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUnansweredQuestions(com.google.code.stackexchange.schema.Question.UnansweredSortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, java.util.Set)
	 */
	@Override
	public Future<List<Question>> getUnansweredQuestions(
			final Question.UnansweredSortOrder sort, final Paging paging,
			final TimePeriod timePeriod, final Set<FilterOption> filterOptions) {
		return execute(new Callable<List<Question>>() {
            @Override
            public List<Question> call() throws Exception {
                return client.getUnansweredQuestions(sort, paging, timePeriod, filterOptions);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers(long[])
	 */
	@Override
	public Future<List<User>> getUsers(final long... userIds) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersComments(long[])
	 */
	@Override
	public Future<List<Comment>> getUsersComments(final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersComments(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Comment.SortOrder, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersComments(final Comment.SortOrder sort,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersComments(sort, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersComments(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersComments(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersComments(final Paging paging, final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersComments(paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersComments(com.google.code.stackexchange.schema.Comment.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersComments(final Comment.SortOrder sort,
			final Paging paging, final TimePeriod timePeriod, final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersComments(sort, paging, timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersCommentsToUser(long, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersCommentsToUser(final long toUserId, final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersCommentsToUser(toUserId, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Comment.SortOrder, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersCommentsToUser(final long toUserId, final Comment.SortOrder sort,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersCommentsToUser(toUserId, sort, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersCommentsToUser(final long toUserId, final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersCommentsToUser(toUserId, timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersCommentsToUser(final long toUserId, final Paging paging,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersCommentsToUser(toUserId, paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersCommentsToUser(long, com.google.code.stackexchange.schema.Comment.SortOrder, com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersCommentsToUser(final long toUserId, final Comment.SortOrder sort,
			final Paging paging, final TimePeriod timePeriod, final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersCommentsToUser(toUserId, sort, paging, timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersMentions(long[])
	 */
	@Override
	public Future<List<Comment>> getUsersMentions(final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersMentions(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersMentions(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Comment>> getUsersMentions(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return client.getUsersMentions(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersReputations(long[])
	 */
	@Override
	public Future<List<Reputation>> getUsersReputations(final long... userIds) {
		return execute(new Callable<List<Reputation>>() {
            @Override
            public List<Reputation> call() throws Exception {
                return client.getUsersReputations(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Reputation>> getUsersReputations(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<Reputation>>() {
            @Override
            public List<Reputation> call() throws Exception {
                return client.getUsersReputations(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<Reputation>> getUsersReputations(final Paging paging,
			final long... userIds) {
		return execute(new Callable<List<Reputation>>() {
            @Override
            public List<Reputation> call() throws Exception {
                return client.getUsersReputations(paging, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersReputations(com.google.code.stackexchange.schema.Paging, com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Reputation>> getUsersReputations(final Paging paging,
			final TimePeriod timePeriod, final long... userIds) {
		return execute(new Callable<List<Reputation>>() {
            @Override
            public List<Reputation> call() throws Exception {
                return client.getUsersReputations(paging, timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersTimeline(long[])
	 */
	@Override
	public Future<List<UserTimeline>> getUsersTimeline(final long... userIds) {
		return execute(new Callable<List<UserTimeline>>() {
            @Override
            public List<UserTimeline> call() throws Exception {
                return client.getUsersTimeline(userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsersTimeline(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<UserTimeline>> getUsersTimeline(final TimePeriod timePeriod,
			final long... userIds) {
		return execute(new Callable<List<UserTimeline>>() {
            @Override
            public List<UserTimeline> call() throws Exception {
                return client.getUsersTimeline(timePeriod, userIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers()
	 */
	@Override
	public Future<List<User>> getUsers() {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers();
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers(com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<User>> getUsers(final Paging paging) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers(paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers(java.lang.String)
	 */
	@Override
	public Future<List<User>> getUsers(final String filter) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers(filter);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers(com.google.code.stackexchange.schema.User.SortOrder)
	 */
	@Override
	public Future<List<User>> getUsers(final User.SortOrder sort) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers(sort);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getUsers(java.lang.String, com.google.code.stackexchange.schema.User.SortOrder, com.google.code.stackexchange.schema.Paging)
	 */
	@Override
	public Future<List<User>> getUsers(final String filter, final User.SortOrder sort,
			final Paging paging) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getUsers(filter, sort, paging);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getRevisionForPost(long, java.lang.String)
	 */
	@Override
	public Future<Revision> getRevisionForPost(final long postId, final String revisionGuid) {
		return execute(new Callable<Revision>() {
            @Override
            public Revision call() throws Exception {
                return client.getRevisionForPost(postId, revisionGuid);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getRevisionsForPosts(long[])
	 */
	@Override
	public Future<List<Revision>> getRevisionsForPosts(final long... postIds) {
		return execute(new Callable<List<Revision>>() {
            @Override
            public List<Revision> call() throws Exception {
                return client.getRevisionsForPosts(postIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getRevisionsForPosts(com.google.code.stackexchange.schema.TimePeriod, long[])
	 */
	@Override
	public Future<List<Revision>> getRevisionsForPosts(final TimePeriod timePeriod,
			final long... postIds) {
		return execute(new Callable<List<Revision>>() {
            @Override
            public List<Revision> call() throws Exception {
                return client.getRevisionsForPosts(timePeriod, postIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#getCurrentRateLimit()
	 */
	@Override
	public int getCurrentRateLimit() {
		return client.getCurrentRateLimit();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowCommunicationClient#getMaxRateLimit()
	 */
	@Override
	public int getMaxRateLimit() {
		return client.getMaxRateLimit();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByQuestions(long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByQuestions(final long... questionIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByQuestions(questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByQuestions(java.util.Set, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByQuestions(
			final Set<FilterOption> filterOptions, final long... questionIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByQuestions(filterOptions, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByQuestions(com.google.code.stackexchange.schema.Answer.SortOrder, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByQuestions(final SortOrder sort,
			final long... questionIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByQuestions(sort, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getAnswersByQuestions(com.google.code.stackexchange.schema.Answer.SortOrder, java.util.Set, long[])
	 */
	@Override
	public Future<List<Answer>> getAnswersByQuestions(final SortOrder sort,
			final Set<FilterOption> filterOptions, final long... questionIds) {
		return execute(new Callable<List<Answer>>() {
            @Override
            public List<Answer> call() throws Exception {
                return client.getAnswersByQuestions(sort, filterOptions, questionIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadgesRecipients(long[])
	 */
	@Override
	public Future<List<User>> getBadgesRecipients(final long... badgeIds) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getBadgesRecipients(badgeIds);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.AsyncStackOverflowApiClient#getBadgesRecipients(com.google.code.stackexchange.schema.Paging, long[])
	 */
	@Override
	public Future<List<User>> getBadgesRecipients(final Paging paging,
			final long... badgeIds) {
		return execute(new Callable<List<User>>() {
            @Override
            public List<User> call() throws Exception {
                return client.getBadgesRecipients(paging, badgeIds);
            }
        });
	}
}
