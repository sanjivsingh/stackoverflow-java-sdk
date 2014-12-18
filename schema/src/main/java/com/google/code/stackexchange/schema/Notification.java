/*
 * Copyright 2014 Sanjiv Singh
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

/**
 * @author Sanjiv.Singh
 *
 */
public class Notification extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The site. */
	private Site site;

	/** The creation date. */
	private Date creationDate;

	/** The body. */
	private String body;

	/** The notification type . */
	private String notificationType;

	/** is Un read **/
	private Boolean isUnread;

	public Site getSite() {
		return site;
	}

	/** The post id. */
	private long postId;

	public void setSite(Site site) {
		this.site = site;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public Boolean getIsUnread() {
		return isUnread;
	}

	public void setIsUnread(Boolean isUnread) {
		this.isUnread = isUnread;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

}
