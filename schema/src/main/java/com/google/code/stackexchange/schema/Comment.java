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
import java.util.HashMap;
import java.util.Map;

import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.User;

/**
 * The Class CommentImpl.
 */
public class Comment extends SchemaEntity {
	
	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {
		
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
	private static final long serialVersionUID = 9211122295203879070L;
	
	/** The comment id. */
	private long commentId;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The owner. */
	private User owner;
	
	/** The post id. */
	private long postId;
	
	/** The post type. */
	private PostType postType;
	
	/** The body. */
	private String body;
	
	/** The reply to user. */
	private User replyToUser;
	
	/** The score. */
	private long score;
	
	/** The edit count. */
	private long editCount;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getCommentId()
	 */
	public long getCommentId() {
		return commentId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setCommentId(long)
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getCreationDate()
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setCreationDate(java.util.Date)
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getOwnerUserId()
	 */
	public User getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setOwnerUserId(long)
	 */
	public void setOwner(User owner) {
		this.owner = (User) owner;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getPostId()
	 */
	public long getPostId() {
		return postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setPostId(long)
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getPostType()
	 */
	public PostType getPostType() {
		return postType;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setPostType(com.google.code.stackexchange.schema.PostType)
	 */
	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getBody()
	 */
	public String getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setBody(java.lang.String)
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getReplyToUserId()
	 */
	public User getReplyToUser() {
		return replyToUser;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setReplyToUserId(long)
	 */
	public void setReplyToUser(User replyToUser) {
		this.replyToUser = (User) replyToUser;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getScore()
	 */
	public long getScore() {
		return score;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setScore(long)
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#getEditCount()
	 */
	public long getEditCount() {
		return editCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Comment#setEditCount(long)
	 */
	public void setEditCount(long editCount) {
		this.editCount = editCount;
	}
}
