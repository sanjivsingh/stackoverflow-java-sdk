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
package com.google.code.stackexchange.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.stackexchange.client.constant.TestConstants;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.Notification;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.User;
import com.google.code.stackexchange.schema.UserTimeline;

/**
 * The Class StackExchangeApiJsonClientTest.
 */
public class StackExchangeApiJsonClientTest extends StackExchangeApiClientTest {

	/** The client. */
	private StackExchangeApiClient client;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.StackOverflowApiClientTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createStackExchangeApiClient();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.StackOverflowApiClientTest#tearDown
	 * ()
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}

	/**
	 * Test get favorite questions by user long paging.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Ids."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> favoriteQuestionsByUser = client
				.getFavoriteQuestionsByUsers(getPaging(),
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(favoriteQuestionsByUser);
		assertNotNullOrEmpty("Questions should never be null.",
				favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long time period.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> favoriteQuestionsByUser = client
				.getFavoriteQuestionsByUsers(getTimePeriod(),
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(favoriteQuestionsByUser);
		assertNotNullOrEmpty("Questions should never be null.",
				favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long set of filter option.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> favoriteQuestionsByUser = client
				.getFavoriteQuestionsByUsers(
						TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(favoriteQuestionsByUser);
		assertNotNullOrEmpty("Questions should never be null.",
				favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long user favorite sort order paging
	 * time period set of filter option.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongUserFavoriteSortOrderPagingTimePeriodSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> favoriteQuestionsByUser = client
				.getFavoriteQuestionsByUsers(
						TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(favoriteQuestionsByUser);
		assertNotNullOrEmpty("Questions should never be null.",
				favoriteQuestionsByUser);
	}

	/**
	 * Test get question long paging.
	 */
	@Test
	public void testGetQuestionLongPaging() {

		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Question> questions = client.getQuestions(getPaging(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question long set of filter option.
	 */
	@Test
	public void testGetQuestionLongSetOfFilter() {

		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Question> questions = client.getQuestions(
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
				getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question long paging set of filter option.
	 */
	@Test
	public void testGetQuestionLongPagingSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Question> questions = client.getQuestions(getPaging(),
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
				getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question timeline long time period.
	 */
	@Test
	public void testGetQuestionTimelineLongTimePeriod() {

		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<PostTimeline> questionTimeline = client.getQuestionsTimeline(
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(questionTimeline);
		assertNotNullOrEmpty("Question timeline should never be null.",
				questionTimeline);
	}

	/**
	 * Test get questions paging.
	 */
	@Test
	public void testGetQuestionsPaging() {
		PagedList<Question> questions = client.getQuestions(getPaging());
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions time period.
	 */
	@Test
	public void testGetQuestionsTimePeriod() {
		PagedList<Question> questions = client.getQuestions(getTimePeriod());
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions set of filter option.
	 */
	@Test
	public void testGetQuestionsSetOfFilter() {
		PagedList<Question> questions = client
				.getQuestions(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order paging time period set of filter
	 * option.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrderPagingTimePeriodSetOfFilter() {
		PagedList<Question> questions = client.getQuestions(
				Question.SortOrder.MOST_HOT, getPaging(), getTimePeriod(),
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long paging.
	 */
	@Test
	public void testGetQuestionsByUserLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getQuestionsByUsers(getPaging(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long time period.
	 */
	@Test
	public void testGetQuestionsByUserLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getQuestionsByUsers(
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long set of filter option.
	 */
	@Test
	public void testGetQuestionsByUserLongSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getQuestionsByUsers(
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long user question sort order paging time
	 * period set of filter option.
	 */
	@Test
	public void testGetQuestionsByUserLongUserQuestionSortOrderPagingTimePeriodSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getQuestionsByUsers(
				User.QuestionSortOrder.MOST_RECENTLY_UPDATED, getPaging(),
				getTimePeriod(), TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tagged questions list of string paging time period set of filter
	 * option.
	 */
	@Test
	public void testGetTaggedQuestionsListOfStringPagingTimePeriodSetOfFilter() {
		PagedList<Question> questions = client.getTaggedQuestions(getTags(),
				getPaging(), getTimePeriod(),
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test search questions string.
	 */
	@Test
	public void testSearchQuestionsString() {
		PagedList<Question> questions = client
				.searchQuestions(getTags().get(0));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test Advance Search questions string.
	 */
	@Test
	public void testAdanceSearchQuestionsString() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."),
				TestConstants.STACK_OVERFLOW_TEST_TAGS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test min views."),
				TestConstants.STACK_OVERFLOW_TEST_MIN_VIEWS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test min Answers."),
				TestConstants.STACK_OVERFLOW_TEST_MIN_ANSWERS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Query param"),
				TestConstants.STACK_OVERFLOW_TEST_QUERY);
		PagedList<Question> questions = client
				.advanceSearchQuestions(
						TestConstants.STACK_OVERFLOW_TEST_QUERY,
						null,
						null,
						null,
						null,
						getTags(),
						null,
						TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
						null,
						null,
						null,
						null,
						null,
						null,
						Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_MIN_ANSWERS),
						null,
						null,
						null,
						Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_MIN_VIEWS));

		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tags paging.
	 */
	@Test
	public void testGetTagsPaging() {
		PagedList<Tag> tags = client.getTags(getPaging());
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order paging.
	 */
	@Test
	public void testGetTagsTagSortOrderPaging() {
		PagedList<Tag> tags = client.getTags(Tag.SortOrder.MOST_POPULAR,
				getPaging());
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags for user long paging.
	 */
	@Test
	public void testGetTagsForUserLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Tag> tags = client.getTagsForUsers(getPaging(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions paging.
	 */
	@Test
	public void testGetUnansweredQuestionsPaging() {
		PagedList<Question> questions = client
				.getUnansweredQuestions(getPaging());
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions time period.
	 */
	@Test
	public void testGetUnansweredQuestionsTimePeriod() {
		PagedList<Question> questions = client
				.getUnansweredQuestions(getTimePeriod());
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsSetOfFilter() {
		PagedList<Question> questions = client
				.getUnansweredQuestions(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order paging time
	 * period set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrderPagingTimePeriodSetOfFilter() {
		PagedList<Question> questions = client.getUnansweredQuestions(
				Question.UnansweredSortOrder.VOTES, getPaging(),
				getTimePeriod(), TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get user mentions long time period.
	 */
	@Test
	public void testGetUserMentionsLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> mentions = client.getUsersMentions(getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(mentions);
		assertNotNullOrEmpty("Mentions should never be null.", mentions);
	}

	/**
	 * Test get user timeline long time period.
	 */
	@Test
	public void testGetUserTimelineLongTimePeriod() {

		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<UserTimeline> timelines = client.getUsersTimeline(
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(timelines);
		assertNotNullOrEmpty("User Timelines should never be null.", timelines);
	}

	/**
	 * Test get users paging.
	 */
	@Test
	public void testGetUsersPaging() {
		PagedList<User> users = client.getUsers(getPaging());
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users string.
	 */
	@Test
	public void testGetUsersString() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Filter."),
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		PagedList<User> users = client
				.getUsers(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users string user sort order paging.
	 */
	@Test
	public void testGetUsersStringUserSortOrderPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Filter."),
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		PagedList<User> users = client.getUsers(
				TestConstants.STACK_OVERFLOW_TEST_USER_FILTER,
				User.SortOrder.MOST_REPUTED, getPaging());
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get answer.
	 */
	@Test
	public void testGetAnswer() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Answer Id."),
				TestConstants.STACK_OVERFLOW_TEST_ANSWER_ID);
		PagedList<Answer> answers = client
				.getAnswers(getIds(TestConstants.STACK_OVERFLOW_TEST_ANSWER_ID));
		handleBackoff(answers);
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get answers by user long.
	 */
	@Test
	public void testGetAnswersByUserLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Answer> answers = client
				.getAnswersByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(answers);
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get answers by question long.
	 */
	@Test
	public void testGetAnswersByQuestionLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Answer> answers = client
				.getAnswersByQuestions(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(answers);
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get answers by user long answer sort order.
	 */
	@Test
	public void testGetAnswersByUserLongAnswerSortOrder() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Answer> answers = client.getAnswersByUsers(
				Answer.SortOrder.MOST_RECENTLY_UPDATED,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(answers);
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get badges.
	 */
	@Test
	public void testGetBadges() {
		PagedList<Badge> badges = client.getBadges();
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by name.
	 */
	@Test
	public void testGetBadgesByName() {
		PagedList<Badge> badges = client.getBadgesByName();
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by tags.
	 */
	@Test
	public void testGetBadgesByTags() {
		PagedList<Badge> badges = client.getBadgesByTags();
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges for user.
	 */
	@Test
	public void testGetBadgesForUser() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Badge> badges = client
				.getBadgesForUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get favorite questions by user long.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client
				.getFavoriteQuestionsByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get favorite questions by user long user favorite sort order.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongUserFavoriteSortOrder() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getFavoriteQuestionsByUsers(
				User.FavoriteSortOrder.MOST_RECENTLY_UPDATED,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get question long.
	 */
	@Test
	public void testGetQuestionLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Question> questions = client
				.getQuestions(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get question timeline long.
	 */
	@Test
	public void testGetQuestionTimelineLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<PostTimeline> timelines = client
				.getQuestionsTimeline(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(timelines);
		assertNotNullOrEmpty("Question timelines should never be null.",
				timelines);
	}

	/**
	 * Test get questions.
	 */
	@Test
	public void testGetQuestions() {
		PagedList<Question> questions = client.getQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrder() {
		PagedList<Question> questions = client
				.getQuestions(Question.SortOrder.MOST_VOTED);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long.
	 */
	@Test
	public void testGetQuestionsByUserLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client
				.getQuestionsByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long user question sort order.
	 */
	@Test
	public void testGetQuestionsByUserLongUserQuestionSortOrder() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> questions = client.getQuestionsByUsers(
				User.QuestionSortOrder.MOST_RECENTLY_CREATED,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tagged questions list of string.
	 */
	@Test
	public void testGetTaggedQuestionsListOfString() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."),
				TestConstants.STACK_OVERFLOW_TEST_TAGS);
		PagedList<Question> questions = client.getTaggedQuestions(getTags());
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tags.
	 */
	@Test
	public void testGetTags() {
		PagedList<Tag> tags = client.getTags();
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order.
	 */
	@Test
	public void testGetTagsTagSortOrder() {
		PagedList<Tag> tags = client
				.getTags(Tag.SortOrder.MOST_RECENTLY_UPDATED);
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags for user long.
	 */
	@Test
	public void testGetTagsForUserLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Tag> tags = client
				.getTagsForUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions.
	 */
	@Test
	public void testGetUnansweredQuestions() {
		PagedList<Question> questions = client.getUnansweredQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrder() {
		PagedList<Question> questions = client
				.getUnansweredQuestions(Question.UnansweredSortOrder.VOTES);
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get user.
	 */
	@Test
	public void testGetUser() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<User> users = client
				.getUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get user mentions long.
	 */
	@Test
	public void testGetUserMentionsLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> mentions = client
				.getUsersMentions(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(mentions);
		assertNotNullOrEmpty("Mentions should never be null.", mentions);
	}

	/**
	 * Test get user timeline long.
	 */
	@Test
	public void testGetUserTimelineLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<UserTimeline> timelines = client
				.getUsersTimeline(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(timelines);
		assertNotNullOrEmpty("User timeline should never be null.", timelines);
	}

	/**
	 * Test get users.
	 */
	@Test
	public void testGetUsers() {
		PagedList<User> users = client.getUsers();
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users user sort order.
	 */
	@Test
	public void testGetUsersUserSortOrder() {
		PagedList<User> users = client.getUsers(User.SortOrder.NAME_ASCENDING);
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get user reputations long.
	 */
	@Test
	public void testGetUserReputationsLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Reputation> reputations = client
				.getUsersReputations(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(reputations);
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long time period.
	 */
	@Test
	public void testGetUserReputationsLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Reputation> reputations = client.getUsersReputations(
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(reputations);
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long paging.
	 */
	@Test
	public void testGetUserReputationsLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Reputation> reputations = client
				.getUsersReputations(getPaging(),
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(reputations);
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long paging time period.
	 */
	@Test
	public void testGetUserReputationsLongPagingTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Reputation> reputations = client.getUsersReputations(
				getPaging(), getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(reputations);
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user comments long.
	 */
	@Test
	public void testGetUserCommentsLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client
				.getUsersComments(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long comment sort order.
	 */
	@Test
	public void testGetUserCommentsLongCommentSortOrder() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersComments(
				Comment.SortOrder.MOST_VOTED,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long time period.
	 */
	@Test
	public void testGetUserCommentsLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersComments(getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long paging.
	 */
	@Test
	public void testGetUserCommentsLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersComments(getPaging(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long comment sort order paging time period.
	 */
	@Test
	public void testGetUserCommentsLongCommentSortOrderPagingTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersComments(
				Comment.SortOrder.MOST_RECENTLY_CREATED, getPaging(),
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long.
	 */
	@Test
	public void testGetUserCommentsLongLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersCommentsToUser(
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0],
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long comment sort order.
	 */
	@Test
	public void testGetUserCommentsLongLongCommentSortOrder() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersCommentsToUser(
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0],
				Comment.SortOrder.MOST_RECENTLY_CREATED,
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long time period.
	 */
	@Test
	public void testGetUserCommentsLongLongTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersCommentsToUser(
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0],
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long paging.
	 */
	@Test
	public void testGetUserCommentsLongLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client
				.getUsersCommentsToUser(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0],
						getPaging(),
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long comment sort order paging time period.
	 */
	@Test
	public void testGetUserCommentsLongLongCommentSortOrderPagingTimePeriod() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Comment> comments = client.getUsersCommentsToUser(
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0],
				Comment.SortOrder.MOST_RECENTLY_CREATED, getPaging(),
				getTimePeriod(),
				getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		handleBackoff(comments);
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get revisions by RevisionGuid.
	 */
	@Test
	public void testGetRevisionsByRevisionGuid() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Revision Id."),
				TestConstants.STACK_OVERFLOW_TEST_REVISION_GUIDS);
		PagedList<Revision> revisions = client
				.getRevisionByRevisionGuid(TestConstants.STACK_OVERFLOW_TEST_REVISION_GUIDS);
		handleBackoff(revisions);
		assertNotNullOrEmpty("Revisions should never be null.", revisions);
	}

	/**
	 * Test get revisions for post long.
	 */
	@Test
	public void testGetRevisionsForPostLong() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."),
				TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		PagedList<Revision> revisions = client
				.getRevisionsForPosts(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		handleBackoff(revisions);
		assertNotNullOrEmpty("Revisions should never be null.", revisions);
	}

	/**
	 * Test get user notification accros Site
	 */
	@Test
	public void testGetUserNotificationsAccrossSite() {
		PagedList<Notification> notifications = client.getNotifications();
		handleBackoff(notifications);
		assertNotNullOrEmpty("Notifications should never be null.",
				notifications);
	}

	/**
	 * Test get my notification.
	 */
	@Test
	public void testGetUserNotifications() {

		PagedList<Notification> notifications = client.getMyNotifications();
		handleBackoff(notifications);
		assertNotNullOrEmpty("Notifications should never be null.",
				notifications);
	}

	/**
	 * Test get user notification by Ids.
	 */
	@Test
	public void testGetUserNotificationsByIds() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Notification> notifications = client
				.getUserNotifications(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0]);
		handleBackoff(notifications);
		assertNotNullOrEmpty("Notifications should never be null.",
				notifications);
	}
}
