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

package com.google.code.stackexchange.client.query;

import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Notification;
import com.google.code.stackexchange.schema.Paging;

/**
 * @author Sanjiv.Singh
 * 
 */
public interface NotificationApiQuery extends
		StackExchangeApiQuery<Notification> {

	/**
	 * With user ids.
	 * 
	 * @param userIds
	 *            the user ids
	 * 
	 * @return the notification api query
	 */
	public NotificationApiQuery withUserIds(long... userIds);

	/**
	 * With paging.
	 * 
	 * @param paging
	 *            the paging
	 * 
	 * @return the notification api query
	 */
	public NotificationApiQuery withPaging(Paging paging);

	public NotificationApiQuery withFilter(String filter);

	/**
	 * Get user notifications across site
	 * 
	 * Supported parameters: - paging , accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< Notification>
	 */
	public PagedList<Notification> list();

	/**
	 * Get user notifications across site
	 * 
	 * Supported parameters: - paging , accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< Notification>
	 */
	public PagedList<Notification> listNotificationsUnread();

	/**
	 * Get my notifications
	 * 
	 * Supported parameters: - paging , accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< Notification>
	 */

	public PagedList<Notification> listMyNotifications();

	/**
	 * Get my notifications
	 * 
	 * Supported parameters: - paging , accessToken
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< Notification>
	 */

	public PagedList<Notification> listMyNotificationsUnread();

	/**
	 * Get user notifications
	 * 
	 * Supported parameters: - paging , accessToken , ids
	 * 
	 * Mandatory Parameters :accessToken
	 * 
	 * @return the paged list< Notification>
	 */

	public PagedList<Notification> listUserNotifications();

	/**
	 * Get user notifications
	 * 
	 * Supported parameters: - paging , accessToken , ids
	 * 
	 * Mandatory Parameters :accessToken , ids
	 * 
	 * @return the paged list< Notification>
	 */
	public PagedList<Notification> listUserNotificationsUnread();

}
