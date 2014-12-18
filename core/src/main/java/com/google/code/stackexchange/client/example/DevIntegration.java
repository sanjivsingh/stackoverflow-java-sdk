package com.google.code.stackexchange.client.example;

import java.util.ArrayList;
import java.util.List;

import com.google.code.stackexchange.client.StackExchangeApiClient;
import com.google.code.stackexchange.client.impl.StackExchangeApiJsonClient;
import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Notification;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.User;

public class DevIntegration {

	public static void main(String[] args) {

		String accessToken = "accessToken";
		String applicationKey = "applicationKey";
		StackExchangeApiClient client = new StackExchangeApiJsonClient(
				applicationKey, accessToken, StackExchangeSite.STACK_OVERFLOW);

		PagedList<Notification> notificationts = client.getNotifications();
		
		System.out.println(notificationts);

		StackExchangeApiQueryFactory queryFactory = null;
		boolean isAuth = true;
		if (isAuth) {
			queryFactory = StackExchangeApiQueryFactory.newInstance(
					applicationKey, accessToken,
					StackExchangeSite.STACK_OVERFLOW);
		} else {
			queryFactory = StackExchangeApiQueryFactory.newInstance();
		}

		Paging paging = new Paging(1, 100);
		String filter = "!.HyUZkWlofC7M_G9zj_hwoQeZj).-";
		List<String> tag = new ArrayList<String>();
		tag.add("java");

		System.out.println("listNotifications");
		PagedList<Notification> notifications = queryFactory
				.newNotificationApiQuery().withUserIds(2384778).list();
		System.out.println(notifications);

		System.out.println("listNotificationsUnread");
		PagedList<Notification> notification1s = queryFactory
				.newNotificationApiQuery().withUserIds(2384778)
				.listNotificationsUnread();
		System.out.println(notification1s);

		System.out.println("listUserNotifications");
		PagedList<Notification> notification2s = queryFactory
				.newNotificationApiQuery().withUserIds(2384778)
				.listUserNotifications();
		System.out.println(notification2s);

		System.out.println("listUserNotificationsUnread");
		PagedList<Notification> notification3s = queryFactory
				.newNotificationApiQuery().withUserIds(2384778)
				.listUserNotificationsUnread();
		System.out.println(notification3s);

		System.out.println("listMyNotifications");
		PagedList<Notification> notification4s = queryFactory
				.newNotificationApiQuery().withUserIds(2384778)
				.listMyNotifications();
		System.out.println(notification4s);

		System.out.println("listMyNotificationsUnread");
		PagedList<Notification> notification5s = queryFactory
				.newNotificationApiQuery().withUserIds(2384778)
				.listMyNotificationsUnread();
		System.out.println(notification5s);

		System.out.println("get user by Id");
		PagedList<Question> qqqqqs = queryFactory.newQuestionApiQuery()
				.withPaging(paging).withUserIds(1934044).list();

		/*
		 * PagedList<User> users = queryFactory.newUserApiQuery()
		 * .withUserIds(1934044).listUserByIds(); printUsers(users);
		 */
		System.out.println("get hot questions");

		/*
		 * PagedList<Question> questions = queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_HOT).withTags(tag)
		 * .withFilter(filter).list(); printQuestions(questions);
		 */

		System.out.println("Question by user ids ");
		long userId = 2384778;
		/*
		 * long userId = 2384778; List<Question> question2s =
		 * queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_RECENTLY_CREATED)
		 * .withTags(tag).withUserIds(userId).listQuestionsByUser();
		 * 
		 * printQuestions(question2s);
		 */

		System.out.println("Question by answer ids ");
		long answerId = 21859130;
		/*
		 * long answerId = 21859130; List<Question> question3s =
		 * queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_RECENTLY_CREATED)
		 * .withTags(tag).withAnswerIds(answerId).listQuestionsByAnswer();
		 * printQuestions(question3s);
		 */

		System.out.println("get Unanswered Questions");
		/*
		 * PagedList<Question> question4s = queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_RECENTLY_CREATED)
		 * .withTags(tag).listUnansweredQuestions(); printQuestions(question4s);
		 */

		System.out.println("get Favorite Questions");
		/*
		 * PagedList<Question> question5s = queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_RECENTLY_CREATED)
		 * .withTags(tag).withUserIds(userId).listFavoriteQuestions();
		 * printQuestions(question5s);
		 */

		System.out.println("get Similer Questions");
		String title = "How to design";
		/*
		 * PagedList<Question> question6s = queryFactory.newQuestionApiQuery()
		 * .withPaging(paging).withFilter(filter)
		 * .withSort(Question.SortOrder.MOST_RELEVANT)
		 * .withTags(tag).withTitle(title).listSimilarQuestions();
		 * printQuestions(question6s);
		 */

		System.out.println("Search Questions");
		/*
		 * PagedList<Question> question7s = queryFactory.newSearchApiQuery()
		 * .withInTitle(title).withTags(tag)
		 * .withSort(QuestionSortOrder.LEAST_RECENTLY_UPDATED).list();
		 * printQuestions(question7s);
		 */

		System.out.println("get Linked Questions");
		long questionId = 23845211;
		List<Long> questionIds = new ArrayList<Long>();
		questionIds.add(new Long(2807613));
		questionIds.add(new Long(11736681));
		/*
		 * PagedList<Question> question8s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.LEAST_VOTED)
		 * .withQuestionIds(questionIds).listLinkedQuestions();
		 * printQuestions(question8s);
		 */

		System.out.println("get Related Questions");
		/*
		 * PagedList<Question> question9s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_RANKED)
		 * .withQuestionIds(questionIds).listRelatedQuestions();
		 * printQuestions(question9s);
		 */

		System.out.println("get UnAnswered Questions");
		/*
		 * PagedList<Question> question9s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_VOTED)
		 * .listUnAnsweredQuestions(); printQuestions(question9s);
		 */

		System.out.println("get UnAnswered Questions posted By User");
		/*
		 * PagedList<Question> question10s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_VOTED)
		 * .withUserIds(userId).listUnAnsweredQuestionsByUser();
		 * printQuestions(question10s);
		 */

		System.out.println("get UnAccepted Questions posted By User");
		/*
		 * PagedList<Question> question11s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_VOTED)
		 * .withUserIds(userId).listUnAcceptedQuestionsByUser();
		 * printQuestions(question11s);
		 */

		System.out.println("get No-answer Questions posted By User");
		/*
		 * PagedList<Question> question11s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_VOTED)
		 * .withUserIds(userId).listQuestionsWithNoAnswerByUser();
		 * printQuestions(question11s);
		 */

		System.out
				.println("get Top Questions posted By User with the given tags");
		/*
		 * PagedList<Question> question11s = queryFactory.newQuestionApiQuery()
		 * .withTags(tag).withSort(Question.SortOrder.MOST_VOTED)
		 * .withUserIds(userId).listTopQuestionsWithTagPostedByUser();
		 * printQuestions(question11s);
		 */

		System.out
				.println("Gets the FEATURED questions on which the users in {ids} have active bounties()");
		/*
		 * PagedList<Question> question11s = queryFactory.newQuestionApiQuery()
		 * .withSort(Question.SortOrder.MOST_VOTED).withUserIds(userId)
		 * .listUserFeaturedQuestions(); printQuestions(question11s);
		 */

		System.out.println("Get UnAnswered Questions With User favoritetags");
		/*
		 * PagedList<Question> question12s = queryFactory.newQuestionApiQuery()
		 * .withSort(Question.SortOrder.MOST_VOTED)
		 * .listUnansweredUserQuestionWithFavoriteTags();
		 * printQuestions(question12s);
		 */

		System.out
				.println("Gets the FEATURED questions which have active bounties()");
		/*
		 * PagedList<Question> question12s = queryFactory.newQuestionApiQuery()
		 * .withSort(Question.SortOrder.MOST_VOTED).withUserIds(userId)
		 * .listFeaturedQuestions(); printQuestions(question12s);
		 */

		System.out.println("Gets Users with name");
		String name = "sanjiv";
		/*
		 * PagedList<User> user1s =
		 * queryFactory.newUserApiQuery().withName(name)
		 * .withSort(User.SortOrder.MOST_REPUTED).list(); printUsers(user1s);
		 */

		System.out.println("Gets Users by User Ids");
		/*
		 * PagedList<User> user2s = queryFactory.newUserApiQuery()
		 * .withUserIds(userId).withSort(User.SortOrder.MOST_REPUTED)
		 * .listUserByIds(); printUsers(user2s);
		 */

		System.out.println("Gets moderator Users ");
		/*
		 * PagedList<User> user3s = queryFactory.newUserApiQuery()
		 * .withSort(User.SortOrder.MOST_REPUTED).listModeratorUsers();
		 * printUsers(user3s);
		 */

		System.out.println("Gets moderator elected Users ");
		/*
		 * PagedList<User> user4s = queryFactory.newUserApiQuery()
		 * .withSort(User.SortOrder.MOST_REPUTED) .listModeratorElectedUsers();
		 * printUsers(user4s);
		 */

		System.out.println("Get user with AccessToken ");
		/*
		 * PagedList<User> user4s = queryFactory.newUserApiQuery()
		 * .withSort(User.SortOrder.MOST_REPUTED).listMe(); printUsers(user4s);
		 */

		System.out.println("Get Advance Search ");

		int minViews = 100;
		int minAnswers = 10;
		String filterName = "default";
		String query = "mongodb";

		List<String> tagged = new ArrayList<String>();
		tagged.add("java");
		tagged.add("mongodb");

		List<String> nottagged = new ArrayList<String>();
		nottagged.add("php");

		PagedList<Question> question13s = queryFactory
				.newAdvanceSearchApiQuery().withMinViews(100)
				.withAccepted(true).withClosed(true).withMigrated(true)
				.withMinViews(minViews).withMinAnswers(minAnswers)
				.withNotice(true).withFilter(filterName).withQuery(query)
				.withTags(tagged).withOutTags(nottagged).list();

		printQuestions(question13s);

		System.out.println("get My Questions");
		PagedList<Question> question14s = (PagedList<Question>) queryFactory
				.newQuestionApiQuery().listMyQuestions();
		System.out.println(question14s);
		printQuestions(question14s);

		System.out.println("Get posts ");
		Range range = new Range(1, 2);
		PagedList<PostTimeline> post1s = queryFactory.newPostApiQuery().list();
		System.out.println(post1s);
		printPosts(post1s);

		/*
		 * PagedList<Tag> list =
		 * queryFactory.newTagApiQuery().withPaging(paging)
		 * .withSort(Tag.SortOrder.LEAST_POPULAR).list();
		 * System.out.println(list);
		 * 
		 * PagedList<Answer> list2 = queryFactory.newAnswerApiQuery()
		 * .withPaging(paging)
		 * .withSort(Answer.SortOrder.LEAST_RECENTLY_CREATED)
		 * .listByQuestions(); System.out.println(list2);
		 */
	}

	private static void printPosts(PagedList<PostTimeline> posts) {
		System.out.println("######################################");
		System.out.println(posts);
		if (null != posts && posts.size() > 0) {
			for (PostTimeline post : posts) {
				System.out.println("{id='" + post.getPostId() + "',name='"
						+ post.getDisplayName() + "' }");
			}
		}
		System.out.println("######################################");
	}

	private static void printUsers(PagedList<User> users) {
		System.out.println("######################################");
		System.out.println(users);
		if (null != users && users.size() > 0) {
			for (User user : users) {
				System.out.println("{id='" + user.getUserId() + "',name='"
						+ user.getDisplayName() + "' }");
			}
		}
		System.out.println("######################################");
	}

	private static void printQuestions(List<Question> questions) {
		System.out.println("######################################");
		System.out.println(questions);
		if (null != questions && questions.size() > 0) {
			for (Question question : questions) {
				System.out.println("{id='" + question.getQuestionId()
						+ "',title='" + question.getTitle() + "' }");
			}
		}
		System.out.println("######################################");
	}

	protected static long[] getIds(String idString) {
		String[] tokens = idString.split(",");
		long[] ids = new long[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			ids[i] = Long.valueOf(tokens[i]);
		}
		return ids;
	}
}
