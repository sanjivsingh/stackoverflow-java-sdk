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


/**
 * The Class StatisticsImpl.
 */
public class Statistics extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3816093709987797926L;
	
	/** The total questions. */
	private long totalQuestions;
	
	/** The total unanswered. */
	private long totalUnanswered;
	
	/** The total answers. */
	private long totalAnswers;
	
	/** The total comments. */
	private long totalComments;
	
	/** The total votes. */
	private long totalVotes;
	
	/** The total badges. */
	private long totalBadges;
	
	/** The total users. */
	private long totalUsers;
	
	/** The questions per minute. */
	private double questionsPerMinute;
	
	/** The answers per minute. */
	private double answersPerMinute;
	
	/** The badges per minute. */
	private double badgesPerMinute;
	
	private long totalAccepted;
	
	private double viewsPerDay;
	
	private Site site;
	
	/** The api version. */
	private ApiVersion apiVersion;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalQuestions()
	 */
	public long getTotalQuestions() {
		return totalQuestions;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalQuestions(long)
	 */
	public void setTotalQuestions(long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalUnanswered()
	 */
	public long getTotalUnanswered() {
		return totalUnanswered;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalUnanswered(long)
	 */
	public void setTotalUnanswered(long totalUnanswered) {
		this.totalUnanswered = totalUnanswered;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalAnswers()
	 */
	public long getTotalAnswers() {
		return totalAnswers;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalAnswers(long)
	 */
	public void setTotalAnswers(long totalAnswers) {
		this.totalAnswers = totalAnswers;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalComments()
	 */
	public long getTotalComments() {
		return totalComments;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalComments(long)
	 */
	public void setTotalComments(long totalComments) {
		this.totalComments = totalComments;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalVotes()
	 */
	public long getTotalVotes() {
		return totalVotes;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalVotes(long)
	 */
	public void setTotalVotes(long totalVotes) {
		this.totalVotes = totalVotes;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalBadges()
	 */
	public long getTotalBadges() {
		return totalBadges;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalBadges(long)
	 */
	public void setTotalBadges(long totalBadges) {
		this.totalBadges = totalBadges;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getTotalUsers()
	 */
	public long getTotalUsers() {
		return totalUsers;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setTotalUsers(long)
	 */
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getQuestionsPerMinute()
	 */
	public double getQuestionsPerMinute() {
		return questionsPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setQuestionsPerMinute(double)
	 */
	public void setQuestionsPerMinute(double questionsPerMinute) {
		this.questionsPerMinute = questionsPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getAnswersPerMinute()
	 */
	public double getAnswersPerMinute() {
		return answersPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setAnswersPerMinute(double)
	 */
	public void setAnswersPerMinute(double answersPerMinute) {
		this.answersPerMinute = answersPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getBadgesPerMinute()
	 */
	public double getBadgesPerMinute() {
		return badgesPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setBadgesPerMinute(double)
	 */
	public void setBadgesPerMinute(double badgesPerMinute) {
		this.badgesPerMinute = badgesPerMinute;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#getApiVersion()
	 */
	public ApiVersion getApiVersion() {
		return apiVersion;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Statistics#setApiVersion(com.google.code.stackexchange.schema.ApiVersion)
	 */
	public void setApiVersion(ApiVersion apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * @return the totalAccepted
	 */
	public long getTotalAccepted() {
		return totalAccepted;
	}

	/**
	 * @param totalAccepted the totalAccepted to set
	 */
	public void setTotalAccepted(long totalAccepted) {
		this.totalAccepted = totalAccepted;
	}

	/**
	 * @return the viewsPerDay
	 */
	public double getViewsPerDay() {
		return viewsPerDay;
	}

	/**
	 * @param viewsPerDay the viewsPerDay to set
	 */
	public void setViewsPerDay(double viewsPerDay) {
		this.viewsPerDay = viewsPerDay;
	}

	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
	}
}
