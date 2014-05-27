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
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;

/**
 * The Interface CommentApiQuery.
 */
public interface CommentApiQuery extends StackExchangeApiQuery<Comment> {
	
	/**
	 * List user comments.
	 * 
	 * @return the paged list< comment>
	 */
	public PagedList<Comment> listUserComments();
	
	/**
	 * List user comments.
	 * 
	 * @return the paged list< comment>
	 */
	public PagedList<Comment> listQuestionComments();
	
	/**
	 * List user comments.
	 * 
	 * @return the paged list< comment>
	 */
	public PagedList<Comment> listAnswerComments();
	
	/**
	 * List user mentions.
	 * 
	 * @return the paged list< comment>
	 */
	public PagedList<Comment> listUserMentions();

	/**
	 * List user comments to user.
	 * 
	 * @return the paged list< comment>
	 */
	public PagedList<Comment> listUserCommentsToUser();
	
	/**
	 * With comment ids.
	 * 
	 * @param commentIds the comment ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withCommentIds(long... commentIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withUserIds(long... userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withUserIds(List<Long> userIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withQuestionIds(long... questionIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withQuestionIds(List<Long> questionIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withAnswerIds(long... answerIds);
	
	/**
	 * With user ids.
	 * 
	 * @param userIds the user ids
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withAnswerIds(List<Long> answerIds);
	
	/**
	 * With to user id.
	 * 
	 * @param toUserId the to user id
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withToUserId(long toUserId);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withTimePeriod(TimePeriod timePeriod);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withSort(Comment.SortOrder sort);

	/**
	 * With range.
	 * 
	 * @param range the range
	 * 
	 * @return the comment api query
	 */
	public CommentApiQuery withRange(Range range);
}
