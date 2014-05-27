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

import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.User;

/**
 * The Class BadgeImpl.
 */
public class Badge extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6303516718529213320L;
	
	/** The badge id. */
	private long badgeId;
	
	/** The rank. */
	private BadgeRank rank;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The award count. */
	private long awardCount;
	
	/** The tag based. */
	private boolean tagBased;
	
	/** The user. */
	private User user;
	
	/** The badges recipients url. */
	private String badgesRecipientsUrl;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = (User) user;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#getBadgeId()
	 */
	public long getBadgeId() {
		return badgeId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setBadgeId(long)
	 */
	public void setBadgeId(long badgeId) {
		this.badgeId = badgeId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#getRank()
	 */
	public BadgeRank getRank() {
		return rank;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setRank(com.google.code.stackexchange.schema.BadgeRank)
	 */
	public void setRank(BadgeRank rank) {
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#getDescription()
	 */
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#getAwardCount()
	 */
	public long getAwardCount() {
		return awardCount;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setAwardCount(long)
	 */
	public void setAwardCount(long awardCount) {
		this.awardCount = awardCount;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#isTagBased()
	 */
	public boolean isTagBased() {
		return tagBased;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Badge#setTagBased(boolean)
	 */
	public void setTagBased(boolean tagBased) {
		this.tagBased = tagBased;
	}

	public String getBadgesRecipientsUrl() {
		return badgesRecipientsUrl;
	}

	public void setBadgesRecipientsUrl(String badgesRecipientsUrl) {
		this.badgesRecipientsUrl = badgesRecipientsUrl;
	}
}
