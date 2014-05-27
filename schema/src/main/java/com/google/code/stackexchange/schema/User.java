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

import com.google.code.stackexchange.schema.User;

/**
 * The Class UserImpl.
 */
public class User extends SchemaEntity {
	
	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {
		
		/** The MOS t_ reputed. */
		MOST_REPUTED("reputation", Order.DESCENDING),
		
		/** The LEAS t_ reputed. */
		LEAST_REPUTED("reputation", Order.ASCENDING),
		
		/** The MOS t_ recentl y_ created. */
		MOST_RECENTLY_CREATED("creation", Order.DESCENDING),
		
		/** The LEAS t_ recentl y_ created. */
		LEAST_RECENTLY_CREATED("creation", Order.ASCENDING),
		
		/** The NAM e_ ascending. */
		NAME_ASCENDING("name", Order.DESCENDING),
		
		/** The NAM e_ descending. */
		NAME_DESCENDING("name", Order.ASCENDING);
		
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
	
	/**
	 * The Enum FavoriteSortOrder.
	 */
	public enum FavoriteSortOrder implements SortEnum {
		
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
		
		/** The MOS t_ recentl y_ added. */
		MOST_RECENTLY_ADDED("added", Order.DESCENDING),
		
		/** The LEAS t_ recentl y_ added. */
		LEAST_RECENTLY_ADDED("added", Order.ASCENDING),
		
		/** The MOS t_ voted. */
		MOST_VOTED("votes", Order.DESCENDING),
		
		/** The LEAS t_ voted. */
		LEAST_VOTED("votes", Order.ASCENDING);
		
	    /** The Constant stringToEnum. */
		private static final Map<String, FavoriteSortOrder> stringToEnum = new HashMap<String, FavoriteSortOrder>();

		static { // Initialize map from constant name to enum constant
			for (FavoriteSortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;

	    /** The order. */
	    private final Order order;
	    
	    /**
    	 * Instantiates a new favorite sort order.
    	 * 
    	 * @param value the value
    	 * @param order the order
    	 */
	    FavoriteSortOrder(String value, Order order) {
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
		 * @return the favorite sort order
		 */
		public static FavoriteSortOrder fromValue(String value) {
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
	
	/**
	 * The Enum QuestionSortOrder.
	 */
	public enum QuestionSortOrder implements SortEnum {
		
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
		private static final Map<String, QuestionSortOrder> stringToEnum = new HashMap<String, QuestionSortOrder>();

		static { // Initialize map from constant name to enum constant
			for (QuestionSortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /** The order. */
	    private final Order order;
	    
	    /**
    	 * Instantiates a new question sort order.
    	 * 
    	 * @param value the value
    	 * @param order the order
    	 */
	    QuestionSortOrder(String value, Order order) {
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
		 * @return the question sort order
		 */
		public static QuestionSortOrder fromValue(String value) {
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
	private static final long serialVersionUID = -5517600617397335450L;
	
	/** The user id. */
	private long userId;
	
	/** The user type. */
	private UserType userType;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The display name. */
	private String displayName;
	
	/** The reputation. */
	private long reputation;
	
	/** The email hash. */
	private String emailHash;
	
	/** The age. */
	private long age;
	
	/** The last access date. */
	private Date lastAccessDate;
	
	/** The website url. */
	private String websiteUrl;
	
	/** The location. */
	private String location;
	
	/** The about me. */
	private String aboutMe;
	
	/** The question count. */
	private long questionCount;
	
	/** The answer count. */
	private long answerCount;
	
	/** The view count. */
	private long viewCount;
	
	/** The up vote count. */
	private long upVoteCount;
	
	/** The down vote count. */
	private long downVoteCount;
	
	/** The accept rate. */
	private double acceptRate;
	
	/** The user questions url. */
	private String userQuestionsUrl;
	
	/** The user answers url. */
	private String userAnswersUrl;
	
	/** The user favorites url. */
	private String userFavoritesUrl;
	
	/** The user tags url. */
	private String userTagsUrl;
	
	/** The user badges url. */
	private String userBadgesUrl;
	
	/** The user timeline url. */
	private String userTimelineUrl;
	
	/** The user mentioned url. */
	private String userMentionedUrl;
	
	/** The user comments url. */
	private String userCommentsUrl;
	
	/** The user reputation url. */
	private String userReputationUrl;
	
	/** The badge counts. */
	private Map<BadgeRank, Long> badgeCounts = new HashMap<BadgeRank, Long>();
	
	private Date timedPenaltyDate;
	
	private String associationId;
	
	private Site onSite;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserId()
	 */
	public long getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserId(long)
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserType()
	 */
	public UserType getUserType() {
		return userType;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserType(com.google.code.stackexchange.schema.UserType)
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getCreationDate()
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setCreationDate(java.util.Date)
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getDisplayName()
	 */
	public String getDisplayName() {
		return displayName;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setDisplayName(java.lang.String)
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getReputation()
	 */
	public long getReputation() {
		return reputation;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setReputation(long)
	 */
	public void setReputation(long reputation) {
		this.reputation = reputation;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getEmailHash()
	 */
	public String getEmailHash() {
		return emailHash;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setEmailHash(java.lang.String)
	 */
	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getAge()
	 */
	public long getAge() {
		return age;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setAge(long)
	 */
	public void setAge(long age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getLastAccessDate()
	 */
	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setLastAccessDate(java.util.Date)
	 */
	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getWebsiteUrl()
	 */
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setWebsiteUrl(java.lang.String)
	 */
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getLocation()
	 */
	public String getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setLocation(java.lang.String)
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getAboutMe()
	 */
	public String getAboutMe() {
		return aboutMe;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setAboutMe(java.lang.String)
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getQuestionCount()
	 */
	public long getQuestionCount() {
		return questionCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setQuestionCount(long)
	 */
	public void setQuestionCount(long questionCount) {
		this.questionCount = questionCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getAnswerCount()
	 */
	public long getAnswerCount() {
		return answerCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setAnswerCount(long)
	 */
	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getViewCount()
	 */
	public long getViewCount() {
		return viewCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setViewCount(long)
	 */
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUpVoteCount()
	 */
	public long getUpVoteCount() {
		return upVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUpVoteCount(long)
	 */
	public void setUpVoteCount(long upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getDownVoteCount()
	 */
	public long getDownVoteCount() {
		return downVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setDownVoteCount(long)
	 */
	public void setDownVoteCount(long downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getAcceptRate()
	 */
	public double getAcceptRate() {
		return acceptRate;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setAcceptRate(double)
	 */
	public void setAcceptRate(double acceptRate) {
		this.acceptRate = acceptRate;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserQuestionsUrl()
	 */
	public String getUserQuestionsUrl() {
		return userQuestionsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserQuestionsUrl(java.lang.String)
	 */
	public void setUserQuestionsUrl(String userQuestionsUrl) {
		this.userQuestionsUrl = userQuestionsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserAnswersUrl()
	 */
	public String getUserAnswersUrl() {
		return userAnswersUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserAnswersUrl(java.lang.String)
	 */
	public void setUserAnswersUrl(String userAnswersUrl) {
		this.userAnswersUrl = userAnswersUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserFavoritesUrl()
	 */
	public String getUserFavoritesUrl() {
		return userFavoritesUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserFavoritesUrl(java.lang.String)
	 */
	public void setUserFavoritesUrl(String userFavoritesUrl) {
		this.userFavoritesUrl = userFavoritesUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserTagsUrl()
	 */
	public String getUserTagsUrl() {
		return userTagsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserTagsUrl(java.lang.String)
	 */
	public void setUserTagsUrl(String userTagsUrl) {
		this.userTagsUrl = userTagsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserBadgesUrl()
	 */
	public String getUserBadgesUrl() {
		return userBadgesUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserBadgesUrl(java.lang.String)
	 */
	public void setUserBadgesUrl(String userBadgesUrl) {
		this.userBadgesUrl = userBadgesUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserTimelineUrl()
	 */
	public String getUserTimelineUrl() {
		return userTimelineUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserTimelineUrl(java.lang.String)
	 */
	public void setUserTimelineUrl(String userTimelineUrl) {
		this.userTimelineUrl = userTimelineUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserMentionedUrl()
	 */
	public String getUserMentionedUrl() {
		return userMentionedUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserMentionedUrl(java.lang.String)
	 */
	public void setUserMentionedUrl(String userMentionedUrl) {
		this.userMentionedUrl = userMentionedUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserCommentsUrl()
	 */
	public String getUserCommentsUrl() {
		return userCommentsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserCommentsUrl(java.lang.String)
	 */
	public void setUserCommentsUrl(String userCommentsUrl) {
		this.userCommentsUrl = userCommentsUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getUserReputationUrl()
	 */
	public String getUserReputationUrl() {
		return userReputationUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setUserReputationUrl(java.lang.String)
	 */
	public void setUserReputationUrl(String userReputationUrl) {
		this.userReputationUrl = userReputationUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#getBadgeCounts()
	 */
	public Map<BadgeRank, Long> getBadgeCounts() {
		return badgeCounts;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.User#setBadgeCounts(java.util.Map)
	 */
	public void setBadgeCounts(Map<BadgeRank, Long> badgeCounts) {
		this.badgeCounts = badgeCounts;
	}

	/**
	 * @return the timedPenaltyDate
	 */
	public Date getTimedPenaltyDate() {
		return timedPenaltyDate;
	}

	/**
	 * @param timedPenaltyDate the timedPenaltyDate to set
	 */
	public void setTimedPenaltyDate(Date timedPenaltyDate) {
		this.timedPenaltyDate = timedPenaltyDate;
	}

	/**
	 * @return the associationId
	 */
	public String getAssociationId() {
		return associationId;
	}

	/**
	 * @param associationId the associationId to set
	 */
	public void setAssociationId(String associationId) {
		this.associationId = associationId;
	}

	/**
	 * @return the onSite
	 */
	public Site getOnSite() {
		return onSite;
	}

	/**
	 * @param onSite the onSite to set
	 */
	public void setOnSite(Site onSite) {
		this.onSite = onSite;
	}
}
