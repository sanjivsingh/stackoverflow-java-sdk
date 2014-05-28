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
package com.google.code.stackexchange.client.provider;

import com.google.code.stackexchange.client.constant.ApplicationConstants;
import com.google.code.stackexchange.client.provider.url.ApiUrlBuilder;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.schema.StackExchangeSite;

/**
 * The Class StackExchangeApiProvider.
 */
public class StackExchangeApiProvider implements ApiProvider {

	/** The Constant HOST_NAME. */
	private static final String HOST_NAME = ApplicationConstants.HOST_NAME;

	/**
	 * 
	 * Get Api Url Builder
	 * 
	 * @param methodName
	 * @param applicationKey
	 * @param accessToken
	 * @param site
	 * @param apiVersion
	 * @return ApiUrlBuilder
	 */
	@Override
	public ApiUrlBuilder createApiUrlBuilder(String methodName,
			String applicationKey, String accessToken, StackExchangeSite site,
			String apiVersion) {
		return new DefaultApiUrlBuilder(methodName, applicationKey,
				accessToken, site, HOST_NAME, apiVersion);
	}
}
