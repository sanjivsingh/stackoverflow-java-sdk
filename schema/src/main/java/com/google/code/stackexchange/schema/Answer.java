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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.User;

/**
 * The Class AnswerImpl.
 */
public class Answer extends SchemaEntity {
	
	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {
		
		/** The MOS t_ recentl y_ updated. */
		MOST_RECENTLY_UPDATED("activity", Order.DESCENDING),
		
		/** The LEAS t_ recentl y_ updated. */
		LEAST_RECENTLY_UPDATED("activity", Order.ASCENDING),
		
		/** The MOS t_ viewed. */
		MOST_VIEWED("views", Order.DESCENDING),
		
		/** The LEAS t_ viewed. */
		LEAST_VIEWED("views", Order.ASCENDING),
		
		/** The MOS t_ recentl y_ created. */
		MOST_RECENTLY_CREATED("creation", Order.DESCENDING),
		
		/** The LEAS t_ recentl y_ created. */
		LEAST_RECENTLY_CREATED("creation", Order.ASCENDING),
		
		/** The MOS t_ voted. */
		MOST_VOTED("votes", Order.DESCENDING),
		
		/** The LEAS t_ voted. */
		LEAST_VOTED("votes", Order.ASCENDING);
		
	    /** The Constant stringToEnum. */
		private static final Map<String, SortOrder> stringToEnum = new HashMap<String, SortOrder>();

		static { // Initialize map from constant name to enum constant
			for (SortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /** The order. */
	    private final Order order;
	    
	    /**
    	 * Instantiates a new sort order.
    	 * 
    	 * @param value the value
    	 * @param order the order
    	 */
	    SortOrder(String value, Order order) {
	        this.value = value;
	        this.order = order;
	    }

		/* (non-Javadoc)
		 * @see com.google.code.stackexchange.schema.ValueEnum#value()
		 */
		@Override
		public String value() {
			return value;
		}
		
		/**
		 * From value.
		 * 
		 * @param value the value
		 * 
		 * @return the sort order
		 */
		public static SortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/* (non-Javadoc)
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return order;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2188321598388034039L;
	
	/** The answer id. */
	private long answerId;
	
	/** The accepted. */
	private boolean accepted;
	
	/** The question id. */
	private long questionId;
	
	/** The owner. */
	private User owner;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The last edit date. */
	private Date lastEditDate;
	
	/** The last activity date. */
	private Date lastActivityDate;
	
	/** The up vote count. */
	private long upVoteCount;
	
	/** The down vote count. */
	private long downVoteCount;
	
	/** The favorite count. */
	private long favoriteCount;
	
	/** The view count. */
	private long viewCount;
	
	/** The score. */
	private long score;
	
	/** The community owned. */
	private boolean communityOwned;
	
	/** The title. */
	private String title;
	
	/** The body. */
	private String body;
	
	/** The comments. */
	private List<Comment> comments = new ArrayList<Comment>();
	
	/** The answer comments url. */
	private String answerCommentsUrl;
	
	private Date lockedDate;
	
	/**
	 * @return the lockedDate
	 */
	public Date getLockedDate() {
		return lockedDate;
	}

	/**
	 * @param lockedDate the lockedDate to set
	 */
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = (User) owner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getUpVoteCount() {
		return upVoteCount;
	}

	public void setUpVoteCount(long upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	public long getDownVoteCount() {
		return downVoteCount;
	}

	public void setDownVoteCount(long downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	public long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public boolean isCommunityOwned() {
		return communityOwned;
	}

	public void setCommunityOwned(boolean communityOwned) {
		this.communityOwned = communityOwned;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}
	
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	
	public Date getLastActivityDate() {
		return lastActivityDate;
	}
	
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
	
	public String getAnswerCommentsUrl() {
		return answerCommentsUrl;
	}

	public void setAnswerCommentsUrl(String answerCommentsUrl) {
		this.answerCommentsUrl = answerCommentsUrl;
	}
}
