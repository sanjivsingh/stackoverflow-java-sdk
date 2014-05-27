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
package com.google.code.stackexchange.schema;

import java.util.Date;

import com.google.code.stackexchange.schema.UserTimeline;

/**
 * The Class UserTimelineImpl.
 */
public class UserTimeline extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1401085998475480138L;
	
	/** The timeline type. */
	private UserTimelineType timelineType;
	
	/** The post id. */
	private long postId;
	
	/** The user id. */
	private long userId;
	
	/** The action. */
	private String action;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The description. */
	private String description;
	
	/** The detail. */
	private String detail;
	
	/** The comment id. */
	private long commentId;
	
	/** The post type. */
	private PostType postType;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getTimelineType()
	 */
	public UserTimelineType getTimelineType() {
		return timelineType;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setTimelineType(com.google.code.stackexchange.schema.UserTimelineType)
	 */
	public void setTimelineType(UserTimelineType timelineType) {
		this.timelineType = timelineType;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getPostId()
	 */
	public long getPostId() {
		return postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setPostId(long)
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getAction()
	 */
	public String getAction() {
		return action;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setAction(java.lang.String)
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getCreationDate()
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setCreationDate(java.util.Date)
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getDetail()
	 */
	public String getDetail() {
		return detail;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setDetail(java.lang.String)
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getUserId()
	 */
	public long getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setUserId(long)
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getCommentId()
	 */
	
	public long getCommentId() {
		return commentId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setCommentId(long)
	 */
	
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#getPostType()
	 */
	
	public PostType getPostType() {
		return postType;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.UserTimeline#setPostType(com.google.code.stackexchange.schema.PostType)
	 */
	
	public void setPostType(PostType postType) {
		this.postType = postType;
	}
}
