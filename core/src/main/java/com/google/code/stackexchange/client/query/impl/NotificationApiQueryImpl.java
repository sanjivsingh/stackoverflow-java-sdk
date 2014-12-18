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

package com.google.code.stackexchange.client.query.impl;

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.NotificationApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Notification;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.gson.JsonObject;

/**
 * @author Sanjiv.Singh
 * 
 */
public class NotificationApiQueryImpl extends
		BaseStackOverflowApiQuery<Notification> implements NotificationApiQuery {

	/**
	 * Instantiates a new notification api query impl.
	 * 
	 * @param applicationId
	 *            the application id
	 * @param site
	 *            the stack exchange site
	 */
	public NotificationApiQueryImpl(String applicationId, StackExchangeSite site) {
		super(applicationId, site);
	}

	public NotificationApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite, String accessToken) {
		super(applicationId, stackExchangeSite, accessToken);
	}

	public NotificationApiQueryImpl(String applicationId, String apiVersion,
			String accessToken, StackExchangeSite stackExchangeSite) {
		super(applicationId, apiVersion, accessToken, stackExchangeSite);
	}

	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(
				StackExchangeApiMethods.GET_NOTIFICATIONS, getApplicationKey(),
				getAccessToken(), getSite(), getApiVersion());
	}

	@Override
	public NotificationApiQuery withUserIds(long... userIds) {
		apiUrlBuilder.withIds(userIds);
		return this;
	}

	@Override
	public NotificationApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	@Override
	protected PagedList<Notification> unmarshall(JsonObject json) {
		return unmarshallList(Notification.class, json);
	}

	@Override
	public NotificationApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

	@Override
	public PagedList<Notification> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_NOTIFICATIONS);
		return super.list();
	}

	@Override
	public PagedList<Notification> listNotificationsUnread() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_NOTIFICATIONS_UNREAD);
		return super.list();
	}

	@Override
	public PagedList<Notification> listMyNotifications() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_NOTIFICATIONS);
		return super.list();
	}

	@Override
	public PagedList<Notification> listMyNotificationsUnread() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_MY_NOTIFICATIONS_UNREAD);
		return super.list();
	}

	@Override
	public PagedList<Notification> listUserNotifications() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_NOTIFICATIONS_BY_USER_IDS);
		return super.list();
	}

	@Override
	public PagedList<Notification> listUserNotificationsUnread() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_UNREAD_NOTIFICATIONS_BY_USER_IDS);
		return super.list();
	}

}
