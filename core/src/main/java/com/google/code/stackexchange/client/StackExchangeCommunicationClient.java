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

import java.util.Map;

import com.google.code.stackexchange.client.provider.ApiProvider;

/**
 * The Interface StackExchangeCommunicationClient.
 */
public interface StackExchangeCommunicationClient {

    /**
     * Sets the request headers.
     * 
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders);

    /**
     * Gets the request headers.
     * 
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders();

    /**
     * Adds the request header.
     * 
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue);

    /**
     * Removes the request header.
     * 
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName);
    
    /**
     * Sets the api provider.
     * 
     * @param apiProvider the new api provider
     */
    public void setApiProvider(ApiProvider apiProvider);
    
    /**
     * Gets the api provider.
     * 
     * @return the api provider
     */
    public ApiProvider getApiProvider();
    
    /**
     * Gets the max rate limit.
     * 
     * @return the max rate limit
     */
    public int getMaxRateLimit();
    
    /**
     * Gets the current rate limit.
     * 
     * @return the current rate limit
     */
    public int getCurrentRateLimit();
}
