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

import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.User;

/**
 * The Class QuestionImpl.
 */
public class Question extends SchemaEntity {
	
	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {
		
		/** The ACTIVE. */
		ACTIVITY("activity"),
		
		/** The NEWEST. */
		CREATION("creation"),
		
		/** The FEATURED. */
		FEATURED("featured"),
		
		/** The HOT. */
		HOT("hot"),
		
		/** The WEEKL y_ hot. */
		WEEKLY_HOT("week"),
		
		/** The MONTHL y_ hot. */
		MONTHLY_HOT("month"),
		
		/** The VOTES. */
		VOTES("votes");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, SortOrder> stringToEnum = new HashMap<String, SortOrder>();

		static { // Initialize map from constant name to enum constant
			for (SortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
    	 * Instantiates a new sort order.
    	 * 
    	 * @param value the value
    	 */
	    SortOrder(String value) {
	        this.value = value;
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
			return null;
		}
	}
	
	/**
	 * The Enum UnansweredSortOrder.
	 */
	public enum UnansweredSortOrder implements SortEnum {
		
		/** The NEWEST. */
		NEWEST("newest"),
		
		/** The VOTES. */
		VOTES("votes");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, UnansweredSortOrder> stringToEnum = new HashMap<String, UnansweredSortOrder>();

		static { // Initialize map from constant name to enum constant
			for (UnansweredSortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
    	 * Instantiates a new unanswered sort order.
    	 * 
    	 * @param value the value
    	 */
	    UnansweredSortOrder(String value) {
	        this.value = value;
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
		 * @return the unanswered sort order
		 */
		public static UnansweredSortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/* (non-Javadoc)
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return null;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8343229589647315647L;
	
	/** The answer count. */
	private long answerCount;
	
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
	
	/** The tags. */
	private List<String> tags = new ArrayList<String>();
	
	/** The answers. */
	private List<Answer> answers = new ArrayList<Answer>();
	
	/** The comments. */
	private List<Comment> comments = new ArrayList<Comment>();
	
	/** The accepted answer id. */
	private long acceptedAnswerId;
	
	/** The body. */
	private String body;
	
	/** The closed date. */
	private Date closedDate;
	
	/** The closed reason. */
	private String closedReason;
	
	/** The locked date. */
	private Date lockedDate;
	
	/** The bounty closes date. */
	private Date bountyClosesDate;
	
	/** The bounty amount. */
	private long bountyAmount;
	
	/** The question timeline url. */
	private String questionTimelineUrl;
	
	/** The question comments url. */
	private String questionCommentsUrl;
	
	/** The question answers url. */
	private String questionAnswersUrl;
	
	/** The question answers url. */
	private String questionUrl;
	
	private Date protectedDate;
	
	private Migration migrated;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getAnswers()
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setAnswers(java.util.List)
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getAnswerCount()
	 */
	public long getAnswerCount() {
		return answerCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setAnswerCount(long)
	 */
	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getQuestionId()
	 */
	public long getQuestionId() {
		return questionId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setQuestionId(long)
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getOwnerUserId()
	 */
	public User getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setOwnerUserId(long)
	 */
	public void setOwner(User owner) {
		this.owner = (User) owner;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getCreationDate()
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setCreationDate(java.util.Date)
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getLastEditDate()
	 */
	public Date getLastEditDate() {
		return lastEditDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setLastEditDate(java.util.Date)
	 */
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getLastActivityDate()
	 */
	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setLastActivityDate(java.util.Date)
	 */
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getUpVoteCount()
	 */
	public long getUpVoteCount() {
		return upVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setUpVoteCount(long)
	 */
	public void setUpVoteCount(long upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getDownVoteCount()
	 */
	public long getDownVoteCount() {
		return downVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setDownVoteCount(long)
	 */
	public void setDownVoteCount(long downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getFavoriteCount()
	 */
	public long getFavoriteCount() {
		return favoriteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setFavoriteCount(long)
	 */
	public void setFavoriteCount(long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getViewCount()
	 */
	public long getViewCount() {
		return viewCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setViewCount(long)
	 */
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getScore()
	 */
	public long getScore() {
		return score;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setScore(long)
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#isCommunityOwned()
	 */
	public boolean isCommunityOwned() {
		return communityOwned;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setCommunityOwned(boolean)
	 */
	public void setCommunityOwned(boolean communityOwned) {
		this.communityOwned = communityOwned;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getTitle()
	 */
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getTags()
	 */
	public List<String> getTags() {
		return tags;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setTags(java.util.List)
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setComments(java.util.List)
	 */
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getAcceptedAnswerId()
	 */
	
	public long getAcceptedAnswerId() {
		return acceptedAnswerId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setAcceptedAnswerId(long)
	 */
	
	public void setAcceptedAnswerId(long acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getBody()
	 */
	
	public String getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setBody(java.lang.String)
	 */
	
	public void setBody(String body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getClosedDate()
	 */
	
	public Date getClosedDate() {
		return closedDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setClosedDate(java.util.Date)
	 */
	
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getClosedReason()
	 */
	
	public String getClosedReason() {
		return closedReason;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setClosedReason(java.lang.String)
	 */
	
	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getLockedDate()
	 */
	
	public Date getLockedDate() {
		return lockedDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setLockedDate(java.util.Date)
	 */
	
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getBountyClosesDate()
	 */
	
	public Date getBountyClosesDate() {
		return bountyClosesDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setBountyClosesDate(java.util.Date)
	 */
	
	public void setBountyClosesDate(Date bountyClosesDate) {
		this.bountyClosesDate = bountyClosesDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getBountyAmount()
	 */
	
	public long getBountyAmount() {
		return bountyAmount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setBountyAmount(long)
	 */
	
	public void setBountyAmount(long bountyAmount) {
		this.bountyAmount = bountyAmount;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getQuestionTimelineUrl()
	 */
	
	public String getQuestionTimelineUrl() {
		return questionTimelineUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setQuestionTimelineUrl(java.lang.String)
	 */
	
	public void setQuestionTimelineUrl(String questionTimelineUrl) {
		this.questionTimelineUrl = questionTimelineUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getQuestionCommentsUrl()
	 */
	
	public String getQuestionCommentsUrl() {
		return questionCommentsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setQuestionCommentsUrl(java.lang.String)
	 */
	
	public void setQuestionCommentsUrl(String questionCommentsUrl) {
		this.questionCommentsUrl = questionCommentsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#getQuestionAnswersUrl()
	 */
	
	public String getQuestionAnswersUrl() {
		return questionAnswersUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Question#setQuestionAnswersUrl(java.lang.String)
	 */
	
	public void setQuestionAnswersUrl(String questionAnswersUrl) {
		this.questionAnswersUrl = questionAnswersUrl;
	}

	/**
	 * @return the protectedDate
	 */
	public Date getProtectedDate() {
		return protectedDate;
	}

	/**
	 * @param protectedDate the protectedDate to set
	 */
	public void setProtectedDate(Date protectedDate) {
		this.protectedDate = protectedDate;
	}

	/**
	 * @return the migrated
	 */
	public Migration getMigrated() {
		return migrated;
	}

	/**
	 * @param migrated the migrated to set
	 */
	public void setMigrated(Migration migrated) {
		this.migrated = migrated;
	}

	/**
	 * @return the questionUrl
	 */
	public String getQuestionUrl() {
		return questionUrl;
	}

	/**
	 * @param questionUrl the questionUrl to set
	 */
	public void setQuestionUrl(String questionUrl) {
		this.questionUrl = questionUrl;
	}
}
