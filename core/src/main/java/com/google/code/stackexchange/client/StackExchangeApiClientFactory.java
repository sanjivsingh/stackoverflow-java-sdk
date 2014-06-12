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
package com.google.code.stackexchange.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.code.stackexchange.client.exception.StackExchangeApiException;
import com.google.code.stackexchange.client.impl.AsyncStackExchangeApiClientAdapter;
import com.google.code.stackexchange.client.impl.StackExchangeApiJsonClient;
import com.google.code.stackexchange.schema.StackExchangeSite;

/**
 * A factory for creating StackExchangeApiClient objects.
 */
public class StackExchangeApiClientFactory {

	/** The task executor. */
	private ExecutorService taskExecutor = Executors.newCachedThreadPool();

	/** The application key. */
	private String applicationKey;

	/** The Access Token . */
	private String accessToken = null;

	private StackExchangeSite site;

	/**
	 * Instantiates a new stack exchange api client factory.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 */
	private StackExchangeApiClientFactory(String applicationKey,
			StackExchangeSite site) {
		this.applicationKey = applicationKey;
		this.site = site;
	}

	/**
	 * Instantiates a new stack exchange api client factory.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param accessToken
	 *            the access Token
	 * @param site
	 *            the stack exchange site
	 */
	private StackExchangeApiClientFactory(String applicationKey,
			String accessToken, StackExchangeSite site) {
		this.applicationKey = applicationKey;
		this.accessToken = accessToken;
		this.site = site;
	}

	/**
	 * Sets the task executor.
	 * 
	 * @param taskExecutor
	 *            the new task executor
	 */
	public void setTaskExecutor(ExecutorService taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/**
	 * New instance.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 * 
	 * @return the stack exchange api client factory
	 */
	public static StackExchangeApiClientFactory newInstance(
			String applicationKey, StackExchangeSite site) {
		return new StackExchangeApiClientFactory(applicationKey, site);
	}

	/**
	 * New instance.
	 * 
	 * @param applicationKey
	 *            the application key
	 * @param site
	 *            the stack exchange site
	 * 
	 * @return the stack exchange api client factory
	 */
	public static StackExchangeApiClientFactory newInstance(
			String applicationKey, String accessToken, StackExchangeSite site) {
		return new StackExchangeApiClientFactory(applicationKey, accessToken,
				site);
	}

	/**
	 * Creates a new StackExchangeApiClient object.
	 * 
	 * @return the stack exchange api client
	 */
	public StackExchangeApiClient createStackExchangeApiClient() {
		final StackExchangeApiClient client = new StackExchangeApiJsonClient(
				applicationKey, accessToken, site);

		return client;
	}

	/**
	 * Creates a new StackExchangeApiClient object.
	 * 
	 * @param apiVersion
	 *            the api version
	 * 
	 * @return the stack exchange api client
	 */
	public StackExchangeApiClient createStackExchangeApiClient(String apiVersion) {
		final StackExchangeApiClient client = new StackExchangeApiJsonClient(
				applicationKey, site, apiVersion);

		return client;
	}

	/**
	 * Creates a new StackExchangeApiClient object.
	 * 
	 * @param implClass
	 *            the impl class
	 * 
	 * @return the stack exchange api client
	 */
	public StackExchangeApiClient createStackEchangeApiClient(
			Class<? extends StackExchangeApiClient> implClass) {
		try {
			final StackExchangeApiClient client = implClass.getConstructor(
					String.class).newInstance(applicationKey);

			return client;
		} catch (Exception e) {
			throw new StackExchangeApiException(e);
		}
	}

	/**
	 * Creates a new StackExchangeApiClient object.
	 * 
	 * @return the async stack overflow api client
	 */
	public AsyncStackExchangeApiClient createAsyncStackExchangeApiClient() {
		final StackExchangeApiClient client = createStackExchangeApiClient();

		return new AsyncStackExchangeApiClientAdapter(client, taskExecutor);
	}
}
