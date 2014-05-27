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

import com.google.code.stackexchange.client.provider.url.ApiUrlBuilder;

/**
 * The Interface ApiProvider.
 */
public interface ApiProvider {
	
	/**
	 * Creates the api url builder.
	 * 
	 * @param methodName the method name
	 * @param applicationKey the application key
	 * @param apiVersion the api version
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder createApiUrlBuilder(String methodName, String applicationKey, String apiVersion);
}
