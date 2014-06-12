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
import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.Notification;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.User;
import com.google.code.stackexchange.schema.UserTimeline;

/**
 * The Class StackExchangeApiJsonQueryTest.
 */
public class StackExchangeApiJsonQueryTest extends StackExchangeApiClientTest {

	/** The query factory. */
	private StackExchangeApiQueryFactory queryFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.code.stackexchange.client.StackOverflowApiClientTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();

		queryFactory = StackExchangeApiQueryFactory.newInstance(
				TestConstants.STACK_OVERFLOW_TEST_API_KEY,
				TestConstants.STACK_OVERFLOW_TEST_ACCESS_TOKEN,
				StackExchangeSite.fromValue(TestConstants.STACK_EXCHANGE_SITE));
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
		queryFactory = null;
	}

	/**
	 * Test get favorite questions by user long paging.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongPaging() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test User Ids."),
				TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		PagedList<Question> favoriteQuestionsByUser = queryFactory
				.newQuestionApiQuery()
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> favoriteQuestionsByUser = queryFactory
				.newQuestionApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> favoriteQuestionsByUser = queryFactory
				.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> favoriteQuestionsByUser = queryFactory
				.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withPaging(getPaging())
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withPaging(getPaging())
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
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
		PagedList<PostTimeline> questionTimeline = queryFactory
				.newQuestionTimelineApiQuery()
				.withTimePeriod(getTimePeriod())
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
		handleBackoff(questionTimeline);
		assertNotNullOrEmpty("Question timeline should never be null.",
				questionTimeline);
	}

	/**
	 * Test get questions paging.
	 */
	@Test
	public void testGetQuestionsPaging() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withPaging(getPaging()).list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions time period.
	 */
	@Test
	public void testGetQuestionsTimePeriod() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withTimePeriod(getTimePeriod()).list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions set of filter option.
	 */
	@Test
	public void testGetQuestionsSetOfFilter() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order paging time period set of filter
	 * option.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrderPagingTimePeriodSetOfFilter() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withSort(Question.SortOrder.MOST_HOT).withPaging(getPaging())
				.withTimePeriod(getTimePeriod())
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.list();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withSort(User.QuestionSortOrder.MOST_RECENTLY_UPDATED)
				.withPaging(getPaging())
				.withTimePeriod(getTimePeriod())
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tagged questions list of string paging time period set of filter
	 * option.
	 */
	@Test
	public void testGetTaggedQuestionsListOfStringPagingTimePeriodSetOfFilter() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."),
				TestConstants.STACK_OVERFLOW_TEST_TAGS);
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withTags(TestConstants.STACK_OVERFLOW_TEST_TAGS.split(","))
				.withPaging(getPaging()).withTimePeriod(getTimePeriod())
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test search questions string.
	 */
	@Test
	public void testSearchQuestionsString() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."),
				TestConstants.STACK_OVERFLOW_TEST_TAGS);
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withTags(TestConstants.STACK_OVERFLOW_TEST_TAGS.split(",")[0])
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test Advance search questions string.
	 */
	@Test
	public void testAdvanceSearchQuestionsString() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."),
				TestConstants.STACK_OVERFLOW_TEST_TAGS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test min views."),
				TestConstants.STACK_OVERFLOW_TEST_MIN_ANSWERS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test min Answers."),
				TestConstants.STACK_OVERFLOW_TEST_MIN_ANSWERS);
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Query param"),
				TestConstants.STACK_OVERFLOW_TEST_QUERY);
		PagedList<Question> questions = queryFactory
				.newAdvanceSearchApiQuery()
				.withAccepted(true)
				.withClosed(true)
				.withMigrated(true)
				.withMinViews(
						Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_MIN_VIEWS))
				.withMinAnswers(
						Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_MIN_ANSWERS))
				.withNotice(true)
				.withQuery(TestConstants.STACK_OVERFLOW_TEST_QUERY)
				.withTags(TestConstants.STACK_OVERFLOW_TEST_TAGS.split(",")[0])
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tags paging.
	 */
	@Test
	public void testGetTagsPaging() {
		PagedList<Tag> tags = queryFactory.newTagApiQuery()
				.withPaging(getPaging()).list();
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order paging.
	 */
	@Test
	public void testGetTagsTagSortOrderPaging() {
		PagedList<Tag> tags = queryFactory.newTagApiQuery()
				.withSort(Tag.SortOrder.MOST_POPULAR).withPaging(getPaging())
				.list();
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
		PagedList<Tag> tags = queryFactory
				.newTagApiQuery()
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listTagsOnUser();
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions paging.
	 */
	@Test
	public void testGetUnansweredQuestionsPaging() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withPaging(getPaging()).listUnansweredQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions time period.
	 */
	@Test
	public void testGetUnansweredQuestionsTimePeriod() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withTimePeriod(getTimePeriod()).listUnansweredQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsSetOfFilter() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.listUnansweredQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order paging time
	 * period set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrderPagingTimePeriodSetOfFilter() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withSort(Question.UnansweredSortOrder.VOTES)
				.withPaging(getPaging()).withTimePeriod(getTimePeriod())
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.listUnansweredQuestions();
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
		PagedList<Comment> mentions = queryFactory
				.newCommentApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserMentions();
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
		PagedList<UserTimeline> timelines = queryFactory
				.newUserTimelineApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
		handleBackoff(timelines);
		assertNotNullOrEmpty("User Timelines should never be null.", timelines);
	}

	/**
	 * Test get users paging.
	 */
	@Test
	public void testGetUsersPaging() {
		PagedList<User> users = queryFactory.newUserApiQuery()
				.withPaging(getPaging()).list();
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
		PagedList<User> users = queryFactory.newUserApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.list();
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
		PagedList<User> users = queryFactory.newUserApiQuery()
				.withFilter(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER)
				.withSort(User.SortOrder.MOST_REPUTED).withPaging(getPaging())
				.list();
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
		PagedList<Answer> answers = queryFactory
				.newAnswerApiQuery()
				.withAnswerIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_ANSWER_ID))
				.list();
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
		PagedList<Answer> answers = queryFactory
				.newAnswerApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listByUsers();
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
		PagedList<Answer> answers = queryFactory
				.newAnswerApiQuery()
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.listByQuestions();
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
		PagedList<Answer> answers = queryFactory
				.newAnswerApiQuery()
				.withSort(Answer.SortOrder.MOST_RECENTLY_UPDATED)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listByUsers();
		handleBackoff(answers);
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get badges.
	 */
	@Test
	public void testGetBadges() {
		PagedList<Badge> badges = queryFactory.newBadgeApiQuery().list();
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by name.
	 */
	@Test
	public void testGetBadgesByName() {
		PagedList<Badge> badges = queryFactory.newBadgeApiQuery().listByName();
		handleBackoff(badges);
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by tags.
	 */
	@Test
	public void testGetBadgesByTags() {
		PagedList<Badge> badges = queryFactory.newBadgeApiQuery().listByTags();
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
		PagedList<Badge> badges = queryFactory
				.newBadgeApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listByUsers();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withSort(User.FavoriteSortOrder.MOST_RECENTLY_UPDATED)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserFavoriteQuestions();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
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
		PagedList<PostTimeline> timelines = queryFactory
				.newQuestionTimelineApiQuery()
				.withQuestionIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.list();
		handleBackoff(timelines);
		assertNotNullOrEmpty("Question timelines should never be null.",
				timelines);
	}

	/**
	 * Test get questions.
	 */
	@Test
	public void testGetQuestions() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrder() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withSort(Question.SortOrder.MOST_VOTED).list();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
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
		PagedList<Question> questions = queryFactory
				.newQuestionApiQuery()
				.withSort(User.QuestionSortOrder.MOST_RECENTLY_CREATED)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listQuestionsByUser();
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
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withTags(TestConstants.STACK_OVERFLOW_TEST_TAGS.split(","))
				.list();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tags.
	 */
	@Test
	public void testGetTags() {
		PagedList<Tag> tags = queryFactory.newTagApiQuery().list();
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order.
	 */
	@Test
	public void testGetTagsTagSortOrder() {
		PagedList<Tag> tags = queryFactory.newTagApiQuery()
				.withSort(Tag.SortOrder.MOST_RECENTLY_UPDATED).list();
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
		PagedList<Tag> tags = queryFactory
				.newTagApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
		handleBackoff(tags);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions.
	 */
	@Test
	public void testGetUnansweredQuestions() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.listUnansweredQuestions();
		handleBackoff(questions);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrder() {
		PagedList<Question> questions = queryFactory.newQuestionApiQuery()
				.withSort(Question.UnansweredSortOrder.VOTES)
				.listUnansweredQuestions();
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
		PagedList<User> users = queryFactory
				.newUserApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
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
		PagedList<Comment> mentions = queryFactory
				.newCommentApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserMentions();
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
		PagedList<UserTimeline> timelines = queryFactory
				.newUserTimelineApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
		handleBackoff(timelines);
		assertNotNullOrEmpty("User timeline should never be null.", timelines);
	}

	/**
	 * Test get users.
	 */
	@Test
	public void testGetUsers() {
		PagedList<User> users = queryFactory.newUserApiQuery().list();
		handleBackoff(users);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users user sort order.
	 */
	@Test
	public void testGetUsersUserSortOrder() {
		PagedList<User> users = queryFactory.newUserApiQuery()
				.withSort(User.SortOrder.NAME_ASCENDING).list();
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
		PagedList<Reputation> reputations = queryFactory
				.newReputationApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
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
		PagedList<Reputation> reputations = queryFactory
				.newReputationApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
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
		PagedList<Reputation> reputations = queryFactory
				.newReputationApiQuery()
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
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
		PagedList<Reputation> reputations = queryFactory
				.newReputationApiQuery()
				.withPaging(getPaging())
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.list();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserComments();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withSort(Comment.SortOrder.MOST_VOTED)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserComments();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserComments();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserComments();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withSort(Comment.SortOrder.MOST_RECENTLY_CREATED)
				.withPaging(getPaging())
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserComments();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.withToUserId(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0])
				.listUserCommentsToUser();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withToUserId(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0])
				.withSort(Comment.SortOrder.MOST_RECENTLY_CREATED)
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserCommentsToUser();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withToUserId(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0])
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserCommentsToUser();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withToUserId(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0])
				.withPaging(getPaging())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserCommentsToUser();
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
		PagedList<Comment> comments = queryFactory
				.newCommentApiQuery()
				.withToUserId(
						getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0])
				.withSort(Comment.SortOrder.MOST_RECENTLY_CREATED)
				.withPaging(getPaging())
				.withTimePeriod(getTimePeriod())
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserCommentsToUser();
		handleBackoff(comments);
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get revisions by Ids.
	 */
	@Test
	public void testGetRevisionsByIds() {
		assertNotNullOrEmpty(
				String.format(RESOURCE_MISSING_MESSAGE, "Test Revision Id."),
				TestConstants.STACK_OVERFLOW_TEST_REVISION_GUIDS);
		PagedList<Revision> revisions = queryFactory
				.newRevisionApiQuery()
				.withRevisionGuid(
						TestConstants.STACK_OVERFLOW_TEST_REVISION_GUIDS)
				.list();
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
		PagedList<Revision> revisions = queryFactory
				.newRevisionApiQuery()
				.withPostIds(
						getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS))
				.listRevisionsForPost();
		handleBackoff(revisions);
		assertNotNullOrEmpty("Revisions should never be null.", revisions);
	}

	/**
	 * Test get user notification accros Site
	 */
	@Test
	public void testGetUserNotificationsAccrossSite() {
		PagedList<Notification> notifications = queryFactory
				.newNotificationApiQuery().list();
		handleBackoff(notifications);
		assertNotNullOrEmpty("Notifications should never be null.",
				notifications);
	}

	/**
	 * Test get my notification.
	 */
	@Test
	public void testGetUserNotifications() {

		PagedList<Notification> notifications = queryFactory
				.newNotificationApiQuery().listMyNotifications();
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
		PagedList<Notification> notifications = queryFactory
				.newNotificationApiQuery()
				.withUserIds(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS))
				.listUserNotifications();
		handleBackoff(notifications);
		assertNotNullOrEmpty("Notifications should never be null.",
				notifications);
	}

}
