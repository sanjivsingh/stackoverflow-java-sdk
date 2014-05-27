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

import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.User;

/**
 * The Class PostTimelineImpl.
 */
public class PostTimeline extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1401085998475480138L;
	
	/** The timeline type. */
	private PostTimelineType timelineType;
	
	/** The post id. */
	private long postId;
	
	/** The user. */
	private User user;
	
	/** The owner. */
	private User owner;
	
	/** The action. */
	private String action;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The revision guid. */
	private String revisionGuid;
	
	/** The comment id. */
	private long commentId;
	
	/** The display name. */
	private String displayName;
	
	/** The post comment url. */
	private String postCommentUrl;
	
	/** The email hash. */
	private String emailHash;
	
	/** The post url. */
	private String postUrl;
	
	/** The post revision url. */
	private String postRevisionUrl;
	
	private long questionId;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getTimelineType()
	 */
	public PostTimelineType getTimelineType() {
		return timelineType;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setTimelineType(com.google.code.stackexchange.schema.PostTimelineType)
	 */
	public void setTimelineType(PostTimelineType timelineType) {
		this.timelineType = timelineType;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getPostId()
	 */
	public long getPostId() {
		return postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setPostId(long)
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getAction()
	 */
	public String getAction() {
		return action;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setAction(java.lang.String)
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getCreationDate()
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setCreationDate(java.util.Date)
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getUserId()
	 */
	public User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setUserId(long)
	 */
	public void setUser(User user) {
		this.user = (User) user;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = (User) owner;
	}

	public String getRevisionGuid() {
		return revisionGuid;
	}

	public void setRevisionGuid(String revisionGuid) {
		this.revisionGuid = revisionGuid;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/**
	 * Gets the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 * 
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getPostCommentUrl()
	 */
	public String getPostCommentUrl() {
		return postCommentUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setPostCommentUrl(java.lang.String)
	 */
	public void setPostCommentUrl(String postCommentUrl) {
		this.postCommentUrl = postCommentUrl;
	}

	/**
	 * Gets the email hash.
	 * 
	 * @return the email hash
	 */
	public String getEmailHash() {
		return emailHash;
	}

	/**
	 * Sets the email hash.
	 * 
	 * @param emailHash the new email hash
	 */
	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getPostUrl()
	 */
	public String getPostUrl() {
		return postUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setPostUrl(java.lang.String)
	 */
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#getPostRevisionUrl()
	 */
	public String getPostRevisionUrl() {
		return postRevisionUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.PostTimeline#setPostRevisionUrl(java.lang.String)
	 */
	public void setPostRevisionUrl(String postRevisionUrl) {
		this.postRevisionUrl = postRevisionUrl;
	}

	/**
	 * @return the questionId
	 */
	public long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
}
