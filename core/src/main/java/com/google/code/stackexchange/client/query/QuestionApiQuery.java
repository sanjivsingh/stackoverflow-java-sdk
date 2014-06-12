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

import java.util.List;

import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.User;

/**
 * The Interface QuestionApiQuery.
 */
public interface QuestionApiQuery extends StackExchangeApiQuery<Question> {

	/**
	 * List unanswered questions.
	 * 
	 * Sort supported : creation, activity , votes Tagged supported.
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUnansweredQuestions();

	/**
	 * Get the questions that users have favorited ,
	 * 
	 * Sort supported: creation, activity , votes ,added
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds
	 * 
	 * Mandatory parameters: userIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUserFavoriteQuestions();

	/**
	 * With question ids.
	 * 
	 * @param questionIds
	 *            the question ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withQuestionIds(long... questionIds);

	/**
	 * With question ids.
	 * 
	 * @param questionIds
	 *            the question ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withQuestionIds(List<Long> questionIds);

	/**
	 * With answer ids.
	 * 
	 * Sort supported : creation, activity , votes
	 * 
	 * @param answerIds
	 *            the answer ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withAnswerIds(long... answerIds);

	/**
	 * With user ids.
	 * 
	 * @param answerIds
	 *            the answer ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withAnswerIds(List<Long> answerIds);

	/**
	 * With user ids.
	 * 
	 * @param userIds
	 *            the user ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withUserIds(long... userIds);

	/**
	 * With user ids.
	 * 
	 * @param userIds
	 *            the user ids
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withUserIds(List<Long> userIds);

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTags(String... tag);

	/**
	 * With tags.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTags(List<String> tag);

	/**
	 * With not tagged.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withNotTags(String... tag);

	/**
	 * With not tagged.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withOutTags(List<String> tag);

	/**
	 * With paging.
	 * 
	 * @param paging
	 *            the paging
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod
	 *            the time period
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTimePeriod(TimePeriod timePeriod);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(Question.SortOrder sort);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(Question.UnansweredSortOrder sort);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(User.QuestionSortOrder sort);

	/**
	 * With sort.
	 * 
	 * @param sort
	 *            the sort
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withSort(User.FavoriteSortOrder sort);

	/**
	 * With range.
	 * 
	 * @param range
	 *            the range
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withRange(Range range);

	/**
	 * With filter.
	 * 
	 * @param fetchOptions
	 *            the fetch options
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withFilter(String filter);

	/**
	 * With title.
	 * 
	 * @param title
	 *            the title
	 * 
	 * @return the question api query
	 */
	public QuestionApiQuery withTitle(String title);

	/**
	 * List questions by answer.
	 * 
	 * Sort supported : creation, activity , votes
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listQuestionsByAnswer();

	/**
	 * List questions by user.
	 * 
	 * Sort supported : creation, activity , votes
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listQuestionsByUser();

	/**
	 * List questions by similarity.
	 * 
	 * Sort supported: creation, activity , votes, relevance
	 * 
	 * Supported parameters: - paging , fromDate , toDate, order , sort , min ,
	 * max tagged, nottagged, title
	 * 
	 * Mandatory params: title
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listSimilarQuestions();

	/**
	 * List linked questions by question Ids.
	 * 
	 * Sort supported: creation, activity , votes, rank
	 * 
	 * Supported parameters: - paging , fromDate , toDate, order , sort , min
	 * ,questionIds, max
	 * 
	 * Mandatory params: questionIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listLinkedQuestions();

	/**
	 * List related questions by question Ids.
	 * 
	 * Sort supported: creation, activity , votes, rank
	 * 
	 * Supported parameters: - paging , fromDate , toDate, order , sort , min
	 * ,questionIds, max
	 * 
	 * Mandatory params: questionIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listRelatedQuestions();

	/**
	 * List Un-Answered Questions
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min max,
	 * tagged
	 * 
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUnAnsweredQuestions();

	/**
	 * List Un-Answered Questions posted by User
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds
	 * 
	 * Mandatory parameters: userIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUnAnsweredQuestionsByUser();

	/**
	 * List Un-Accepted Questions posted by User
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds
	 * 
	 * Mandatory parameters: userIds
	 * 
	 * @return the paged list< question>
	 */

	public PagedList<Question> listUnAcceptedQuestionsByUser();

	/**
	 * List Questions with no answer posted by User
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds
	 * 
	 * Mandatory parameters: userIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listQuestionsWithNoAnswerByUser();

	/**
	 * List Top Questions posted By User with the given tags
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds, tagged
	 * 
	 * Mandatory parameters: userIds, tagged
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listTopQuestionsWithTagPostedByUser();

	/**
	 * Gets the questions on which the users in {ids} have active bounties
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * userIds
	 * 
	 * Mandatory parameters: userIds
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUserFeaturedQuestions();

	/**
	 * Gets the questions with active bounties in the system.
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * tagged
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listFeaturedQuestions();

	/**
	 * Gets the questions the site considers to be unanswered, which are within
	 * a user's favorite tags. If a user has not favorites, their frequented
	 * tags are used instead.
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listUnansweredUserQuestionWithFavoriteTags();

	/**
	 * Returns the questions favorites by the user associated with the given
	 * access_token
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyFavoritesQuestions();

	/**
	 * Returns the questions owned by the user associated with the given
	 * access_token.
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyQuestions();

	/**
	 * Returns the questions owned by the user associated with the given
	 * access_token that have no answers
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyQuestionsWithNoAnswer();

	/**
	 * Returns the questions owned by the user associated with the given
	 * access_token that have no accepted answer
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyUnacceptedQuestions();

	/**
	 * Returns the questions owned by the user associated with the given
	 * access_token that are not considered answered
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyUnansweredQuestions();

	/**
	 * Returns the questions that have active bounties offered by the user
	 * associated with the given access_token
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyFeaturedQuestions();

	/**
	 * Returns the top 30 questions the user associated with the given
	 * access_token has posted in response to questions with the given tags.
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max,
	 * accessToken,tagged
	 * 
	 * Mandatory Parameters :accessToken,tagged
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listMyTopQuestionsWithTag();

	/**
	 * Returns questions which have received no answers
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , fromDate , toDate, Sort , min, max
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listQuestionsWithNoAnswer();

	/**
	 * Returns the frequently asked questions for the given set of tags
	 * 
	 * Sort supported: creation, activity , votes
	 * 
	 * Supported parameters: - paging , tagged
	 * 
	 * Mandatory Parameters : tagged
	 * 
	 * @return the paged list< question>
	 */
	public PagedList<Question> listFrequentlyAskedQuestionsByTags();

}
