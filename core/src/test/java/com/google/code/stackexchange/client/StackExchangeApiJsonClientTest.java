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

import java.util.EnumSet;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.stackexchange.client.constant.TestConstants;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.FilterOption;
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
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClientTest#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createStackExchangeApiClient();
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.StackOverflowApiClientTest#tearDown()
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
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Ids."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> favoriteQuestionsByUser = client.getFavoriteQuestionsByUsers(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long time period.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> favoriteQuestionsByUser = client.getFavoriteQuestionsByUsers(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long set of filter option.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> favoriteQuestionsByUser = client.getFavoriteQuestionsByUsers(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", favoriteQuestionsByUser);
	}

	/**
	 * Test get favorite questions by user long user favorite sort order paging time period set of filter option.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongUserFavoriteSortOrderPagingTimePeriodSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> favoriteQuestionsByUser = client.getFavoriteQuestionsByUsers(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", favoriteQuestionsByUser);
	}

	/**
	 * Test get question long paging.
	 */
	@Test
	public void testGetQuestionLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
    	List<Question> questions = client.getQuestions(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question long set of filter option.
	 */
	@Test
	public void testGetQuestionLongSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
    	List<Question> questions = client.getQuestions(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
    	assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question long paging set of filter option.
	 */
	@Test
	public void testGetQuestionLongPagingSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
    	List<Question> questions = client.getQuestions(getPaging(), EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
    	assertNotNullOrEmpty("Question should never be null.", questions);
	}

	/**
	 * Test get question timeline long time period.
	 */
	@Test
	public void testGetQuestionTimelineLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
    	List<PostTimeline> questionTimeline = client.getQuestionsTimeline(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Question timeline should never be null.", questionTimeline);
	}

	/**
	 * Test get questions paging.
	 */
	@Test
	public void testGetQuestionsPaging() {
		List<Question> questions = client.getQuestions(getPaging());
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions time period.
	 */
	@Test
	public void testGetQuestionsTimePeriod() {
		List<Question> questions = client.getQuestions(getTimePeriod());
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions set of filter option.
	 */
	@Test
	public void testGetQuestionsSetOfFilterOption() {
		List<Question> questions = client.getQuestions(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order paging time period set of filter option.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrderPagingTimePeriodSetOfFilterOption() {
		List<Question> questions = client.getQuestions(Question.SortOrder.HOT, getPaging(), getTimePeriod(), EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long paging.
	 */
	@Test
	public void testGetQuestionsByUserLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long time period.
	 */
	@Test
	public void testGetQuestionsByUserLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long set of filter option.
	 */
	@Test
	public void testGetQuestionsByUserLongSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long user question sort order paging time period set of filter option.
	 */
	@Test
	public void testGetQuestionsByUserLongUserQuestionSortOrderPagingTimePeriodSetOfFilterOption() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(User.QuestionSortOrder.MOST_RECENTLY_UPDATED, getPaging(), getTimePeriod(), EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tagged questions list of string paging time period set of filter option.
	 */
	@Test
	public void testGetTaggedQuestionsListOfStringPagingTimePeriodSetOfFilterOption() {
		List<Question> questions = client.getTaggedQuestions(getTags(), getPaging(), getTimePeriod(), EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test search questions string.
	 */
	@Test
	public void testSearchQuestionsString() {
		List<Question> questions = client.searchQuestions(getTags().get(0));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}
	
	/**
	 * Test get tags paging.
	 */
	@Test
	public void testGetTagsPaging() {
		List<Tag> tags = client.getTags(getPaging());
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order paging.
	 */
	@Test
	public void testGetTagsTagSortOrderPaging() {
		List<Tag> tags = client.getTags(Tag.SortOrder.MOST_POPULAR, getPaging());
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags for user long paging.
	 */
	@Test
	public void testGetTagsForUserLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Tag> tags = client.getTagsForUsers(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions paging.
	 */
	@Test
	public void testGetUnansweredQuestionsPaging() {
		List<Question> questions = client.getUnansweredQuestions(getPaging());
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions time period.
	 */
	@Test
	public void testGetUnansweredQuestionsTimePeriod() {
		List<Question> questions = client.getUnansweredQuestions(getTimePeriod());
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsSetOfFilterOption() {
		List<Question> questions = client.getUnansweredQuestions(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order paging time period set of filter option.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrderPagingTimePeriodSetOfFilterOption() {
		List<Question> questions = client.getUnansweredQuestions(Question.UnansweredSortOrder.VOTES, getPaging(), getTimePeriod(), EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get user mentions long time period.
	 */
	@Test
	public void testGetUserMentionsLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> mentions = client.getUsersMentions(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Mentions should never be null.", mentions);
	}

	/**
	 * Test get user timeline long time period.
	 */
	@Test
	public void testGetUserTimelineLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<UserTimeline> timelines = client.getUsersTimeline(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("User Timelines should never be null.", timelines);
	}

	/**
	 * Test get users paging.
	 */
	@Test
	public void testGetUsersPaging() {
		List<User> users = client.getUsers(getPaging());
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users string.
	 */
	@Test
	public void testGetUsersString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Filter."), TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		List<User> users = client.getUsers(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users string user sort order paging.
	 */
	@Test
	public void testGetUsersStringUserSortOrderPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Filter."), TestConstants.STACK_OVERFLOW_TEST_USER_FILTER);
		List<User> users = client.getUsers(TestConstants.STACK_OVERFLOW_TEST_USER_FILTER, User.SortOrder.MOST_REPUTED, getPaging());
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get answer.
	 */
	@Test
	public void testGetAnswer() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Answer Id."), TestConstants.STACK_OVERFLOW_TEST_ANSWER_ID);
		List<Answer> answers = client.getAnswers(getIds(TestConstants.STACK_OVERFLOW_TEST_ANSWER_ID));
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get answers by user long.
	 */
	@Test
	public void testGetAnswersByUserLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Answer> answers = client.getAnswersByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get answers by question long.
	 */
	@Test
	public void testGetAnswersByQuestionLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		List<Answer> answers = client.getAnswersByQuestions(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}
	
	/**
	 * Test get answers by user long answer sort order.
	 */
	@Test
	public void testGetAnswersByUserLongAnswerSortOrder() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Answer> answers = client.getAnswersByUsers(Answer.SortOrder.MOST_RECENTLY_UPDATED, getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Answers should never be null.", answers);
	}

	/**
	 * Test get badges.
	 */
	@Test
	public void testGetBadges() {
		List<Badge> badges = client.getBadges();
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by name.
	 */
	@Test
	public void testGetBadgesByName() {
		List<Badge> badges = client.getBadgesByName();
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get badges by tags.
	 */
	@Test
	public void testGetBadgesByTags() {
		List<Badge> badges = client.getBadgesByTags();
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}
	
	/**
	 * Test get badges for user.
	 */
	@Test
	public void testGetBadgesForUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Badge> badges = client.getBadgesForUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Badges should never be null.", badges);
	}

	/**
	 * Test get favorite questions by user long.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getFavoriteQuestionsByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get favorite questions by user long user favorite sort order.
	 */
	@Test
	public void testGetFavoriteQuestionsByUserLongUserFavoriteSortOrder() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getFavoriteQuestionsByUsers(User.FavoriteSortOrder.MOST_RECENTLY_UPDATED, getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get question long.
	 */
	@Test
	public void testGetQuestionLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		List<Question> questions = client.getQuestions(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get question timeline long.
	 */
	@Test
	public void testGetQuestionTimelineLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		List<PostTimeline> timelines = client.getQuestionsTimeline(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Question timelines should never be null.", timelines);
	}

	/**
	 * Test get questions.
	 */
	@Test
	public void testGetQuestions() {
		List<Question> questions = client.getQuestions();
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions question sort order.
	 */
	@Test
	public void testGetQuestionsQuestionSortOrder() {
		List<Question> questions = client.getQuestions(Question.SortOrder.VOTES);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long.
	 */
	@Test
	public void testGetQuestionsByUserLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get questions by user long user question sort order.
	 */
	@Test
	public void testGetQuestionsByUserLongUserQuestionSortOrder() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Question> questions = client.getQuestionsByUsers(User.QuestionSortOrder.MOST_RECENTLY_CREATED, getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tagged questions list of string.
	 */
	@Test
	public void testGetTaggedQuestionsListOfString() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Tags."), TestConstants.STACK_OVERFLOW_TEST_TAGS);
		List<Question> questions = client.getTaggedQuestions(getTags());
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get tags.
	 */
	@Test
	public void testGetTags() {
		List<Tag> tags = client.getTags();
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags tag sort order.
	 */
	@Test
	public void testGetTagsTagSortOrder() {
		List<Tag> tags = client.getTags(Tag.SortOrder.MOST_RECENTLY_UPDATED);
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get tags for user long.
	 */
	@Test
	public void testGetTagsForUserLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Tag> tags = client.getTagsForUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Tags should never be null.", tags);
	}

	/**
	 * Test get unanswered questions.
	 */
	@Test
	public void testGetUnansweredQuestions() {
		List<Question> questions = client.getUnansweredQuestions();
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get unanswered questions unanswered question sort order.
	 */
	@Test
	public void testGetUnansweredQuestionsUnansweredQuestionSortOrder() {
		List<Question> questions = client.getUnansweredQuestions(Question.UnansweredSortOrder.VOTES);
		assertNotNullOrEmpty("Questions should never be null.", questions);
	}

	/**
	 * Test get user.
	 */
	@Test
	public void testGetUser() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<User> users = client.getUsers(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get user mentions long.
	 */
	@Test
	public void testGetUserMentionsLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> mentions = client.getUsersMentions(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Mentions should never be null.", mentions);
	}

	/**
	 * Test get user timeline long.
	 */
	@Test
	public void testGetUserTimelineLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<UserTimeline> timelines = client.getUsersTimeline(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("User timeline should never be null.", timelines);
	}

	/**
	 * Test get users.
	 */
	@Test
	public void testGetUsers() {
		List<User> users = client.getUsers();
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get users user sort order.
	 */
	@Test
	public void testGetUsersUserSortOrder() {
		List<User> users = client.getUsers(User.SortOrder.NAME_ASCENDING);
		assertNotNullOrEmpty("Users should never be null.", users);
	}

	/**
	 * Test get user reputations long.
	 */
	@Test
	public void testGetUserReputationsLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Reputation> reputations = client.getUsersReputations(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long time period.
	 */
	@Test
	public void testGetUserReputationsLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Reputation> reputations = client.getUsersReputations(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long paging.
	 */
	@Test
	public void testGetUserReputationsLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Reputation> reputations = client.getUsersReputations(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user reputations long paging time period.
	 */
	@Test
	public void testGetUserReputationsLongPagingTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Reputation> reputations = client.getUsersReputations(getPaging(), getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Reputations should never be null.", reputations);
	}

	/**
	 * Test get user comments long.
	 */
	@Test
	public void testGetUserCommentsLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersComments(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long comment sort order.
	 */
	@Test
	public void testGetUserCommentsLongCommentSortOrder() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersComments(Comment.SortOrder.MOST_VOTED, getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long time period.
	 */
	@Test
	public void testGetUserCommentsLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersComments(getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long paging.
	 */
	@Test
	public void testGetUserCommentsLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersComments(getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long comment sort order paging time period.
	 */
	@Test
	public void testGetUserCommentsLongCommentSortOrderPagingTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersComments(Comment.SortOrder.MOST_RECENTLY_CREATED, getPaging(), getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long.
	 */
	@Test
	public void testGetUserCommentsLongLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersCommentsToUser(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0], getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long comment sort order.
	 */
	@Test
	public void testGetUserCommentsLongLongCommentSortOrder() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersCommentsToUser(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0], Comment.SortOrder.MOST_RECENTLY_CREATED, getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long time period.
	 */
	@Test
	public void testGetUserCommentsLongLongTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersCommentsToUser(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0], getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long paging.
	 */
	@Test
	public void testGetUserCommentsLongLongPaging() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersCommentsToUser(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0], getPaging(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}

	/**
	 * Test get user comments long long comment sort order paging time period.
	 */
	@Test
	public void testGetUserCommentsLongLongCommentSortOrderPagingTimePeriod() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test User Id."), TestConstants.STACK_OVERFLOW_TEST_USER_IDS);
		List<Comment> comments = client.getUsersCommentsToUser(getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS)[0], Comment.SortOrder.MOST_RECENTLY_CREATED, getPaging(), getTimePeriod(), getIds(TestConstants.STACK_OVERFLOW_TEST_USER_IDS));
		assertNotNullOrEmpty("Comments should never be null.", comments);
	}
	
	/**
	 * Test get revisions for post long.
	 */
	@Test
	public void testGetRevisionsForPostLong() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Question Id."), TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS);
		List<Revision> revisions = client.getRevisionsForPosts(getIds(TestConstants.STACK_OVERFLOW_TEST_QUESTION_IDS));
		assertNotNullOrEmpty("Revisions should never be null.", revisions);
	}
}
