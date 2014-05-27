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
package com.google.code.stackexchange.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.google.code.stackexchange.client.constant.ApplicationConstants;
import com.google.code.stackexchange.client.constant.ErrorCodes;
import com.google.code.stackexchange.client.exception.InternalServerException;
import com.google.code.stackexchange.client.exception.InvalidApplicationKeyException;
import com.google.code.stackexchange.client.exception.InvalidOrderException;
import com.google.code.stackexchange.client.exception.InvalidPageSizeException;
import com.google.code.stackexchange.client.exception.InvalidSortException;
import com.google.code.stackexchange.client.exception.InvalidVectorFormatException;
import com.google.code.stackexchange.client.exception.NotFoundException;
import com.google.code.stackexchange.client.exception.RequestLimitExceededException;
import com.google.code.stackexchange.client.exception.StackExchangeApiException;
import com.google.code.stackexchange.client.exception.TooManyIdsException;
import com.google.code.stackexchange.client.exception.UnconstrainedSearchException;
import com.google.code.stackexchange.client.provider.ApiProvider;
import com.google.code.stackexchange.client.provider.StackOverflowApiProvider;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Error;

/**
 * The Class StackExchangeApiGateway.
 */
public abstract class StackExchangeApiGateway {
	
    /** The LOG. */
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());
	
	/** The Constant GZIP_ENCODING. */
	private static final String GZIP_ENCODING = "gzip";
	
	/** The request headers. */
	protected Map<String, String> requestHeaders;
	
	/** The application key. */
	protected String applicationKey;
	
	/** The api provider. */
	private ApiProvider apiProvider = new StackOverflowApiProvider();
	
	/** The api version. */
	protected String apiVersion = ApplicationConstants.DEFAULT_API_VERSION;
	
	/** The max rate limit. */
	private int maxRateLimit = -1;
	
	/** The current rate limit. */
	private int currentRateLimit = -1;

	/**
	 * Gets the api version.
	 * 
	 * @return the api version
	 */
	public String getApiVersion() {
		return apiVersion;
	}

	/**
	 * Sets the api version.
	 * 
	 * @param apiVersion the new api version
	 */
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * Sets the request headers.
	 * 
	 * @param requestHeaders the request headers
	 */
	public void setRequestHeaders(Map<String, String> requestHeaders) {
	    this.requestHeaders = requestHeaders;
	}

	/**
	 * Gets the request headers.
	 * 
	 * @return the request headers
	 */
	public Map<String, String> getRequestHeaders() {
	    return requestHeaders;
	}

	/**
	 * Adds the request header.
	 * 
	 * @param headerName the header name
	 * @param headerValue the header value
	 */
	public void addRequestHeader(String headerName, String headerValue) {
	    requestHeaders.put(headerName, headerValue);
	}

	/**
	 * Removes the request header.
	 * 
	 * @param headerName the header name
	 */
	public void removeRequestHeader(String headerName) {
	    requestHeaders.remove(headerName);
	}

	/**
	 * Gets the application key.
	 * 
	 * @return the application key
	 */
	public String getApplicationKey() {
		return applicationKey;
	}

	/**
	 * Sets the application key.
	 * 
	 * @param applicationKey the new application key
	 */
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}

	/**
	 * Gets the api provider.
	 * 
	 * @return the api provider
	 */
	public ApiProvider getApiProvider() {
		return apiProvider;
	}

	/**
	 * Sets the api provider.
	 * 
	 * @param apiProvider the new api provider
	 */
	public void setApiProvider(ApiProvider apiProvider) {
		this.apiProvider = apiProvider;
	}
	
    /**
     * Gets the max rate limit.
     * 
     * @return the max rate limit
     */
    public int getMaxRateLimit() {
    	return maxRateLimit;
    }
    
    /**
     * Gets the current rate limit.
     * 
     * @return the current rate limit
     */
    public int getCurrentRateLimit() {
    	return currentRateLimit;
    }

	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	
	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    return sb.toString();
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl) {
		return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK);
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl, int expected) {
	    try {
	        URL               url     = new URL(apiUrl);
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	
	        if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
	            request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
	        }
	
	        if (ApplicationConstants.READ_TIMEOUT > -1) {
	            request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
	        }
	
	        for (String headerName : requestHeaders.keySet()) {
	            request.setRequestProperty(headerName, requestHeaders.get(headerName));
	        }
	        
	        request.connect();
	        maxRateLimit = request.getHeaderFieldInt(ApplicationConstants.MAX_RATE_LIMIT_HEADER, -1);
	        currentRateLimit = request.getHeaderFieldInt(ApplicationConstants.CURRENT_RATE_LIMIT_HEADER, -1);
	        
	        if (request.getResponseCode() != expected) {
	            Error error = unmarshallObject(Error.class,
	                    getWrappedInputStream(request.getErrorStream(),
	                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));
	            error.setStatusCode(request.getResponseCode());
	        	
	            throw createStackOverflowApiClientException(error);
	        } else {
	            return getWrappedInputStream(request.getInputStream(),
	                                         GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
	        }
	    } catch (IOException e) {
	        throw new StackExchangeApiException(e);
	    }
	}

	/**
	 * Call api method.
	 * 
	 * @param apiUrl the api url
	 * @param xmlContent the xml content
	 * @param contentType the content type
	 * @param method the method
	 * @param expected the expected
	 * 
	 * @return the input stream
	 */
	protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType,
			String method, int expected) {
			    try {
			        URL               url     = new URL(apiUrl);
			        HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			        if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
			            request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
			        }
			
			        if (ApplicationConstants.READ_TIMEOUT > -1) {
			            request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
			        }
			
			        for (String headerName : requestHeaders.keySet()) {
			            request.setRequestProperty(headerName, requestHeaders.get(headerName));
			        }
			
			        request.setRequestMethod(method);
			        request.setDoOutput(true);
			
			        if (contentType != null) {
			            request.setRequestProperty("Content-Type", contentType);
			        }
			
			        if (xmlContent != null) {
			            PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));
			
			            out.print(xmlContent);
			            out.flush();
			            out.close();
			        }
			
			        request.connect();
			        
			        maxRateLimit = request.getHeaderFieldInt(ApplicationConstants.MAX_RATE_LIMIT_HEADER, -1);
			        currentRateLimit = request.getHeaderFieldInt(ApplicationConstants.CURRENT_RATE_LIMIT_HEADER, -1);
			        
			        if (request.getResponseCode() != expected) {
			            Error error = unmarshallObject(Error.class,
			                    getWrappedInputStream(request.getErrorStream(),
			                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));
			            error.setStatusCode(request.getResponseCode());
			            
			            throw createStackOverflowApiClientException(error);
			        } else {
			            return getWrappedInputStream(request.getInputStream(),
			                                         GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
			        }
			    } catch (IOException e) {
			        throw new StackExchangeApiException(e);
			    }
			}

	/**
	 * Close stream.
	 * 
	 * @param is the is
	 */
	protected void closeStream(InputStream is) {
	    try {
	    	if (is != null) {
		        is.close();
	    	}
	    } catch (IOException e) {
	    	LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);	
	    }
	}

	/**
	 * Close connection.
	 * 
	 * @param connection the connection
	 */
	protected void closeConnection(HttpURLConnection connection) {
	    try {
	    	if (connection != null) {
	    		connection.disconnect();
	    	}
	    } catch (Exception e) {
	    	LOG.log(Level.SEVERE, "An error occurred while disconnecting connection.", e);	
	    }
	}

	/**
	 * Creates the stack overflow api client exception.
	 * 
	 * @param error the error
	 * 
	 * @return the stack exchange api exception
	 */
	protected StackExchangeApiException createStackOverflowApiClientException(Error error) {
		switch (error.getErrorCode()) {
		
		case ErrorCodes.INTERNAL_SERVER_ERROR:
			return new InternalServerException(error.getMessage(), new Date());
	
		case ErrorCodes.INVALID_APPLICATION_KEY:
			return new InvalidApplicationKeyException(error.getMessage(), new Date());
			
		case ErrorCodes.INVALID_ORDER:
			return new InvalidOrderException(error.getMessage(), new Date());
			
		case ErrorCodes.INVALID_PAGE_SIZE:
			return new InvalidPageSizeException(error.getMessage(), new Date());
			
		case ErrorCodes.INVALID_SORT:
			return new InvalidSortException(error.getMessage(), new Date());
	
		case ErrorCodes.NOT_FOUND:
			return new NotFoundException(error.getMessage(), new Date());
			
		case ErrorCodes.REQUEST_LIMIT_EXCEEDED:
			return new RequestLimitExceededException(error.getMessage(), new Date());
			
		case ErrorCodes.INVALID_VECTOR_FORMAT:
			return new InvalidVectorFormatException(error.getMessage(), new Date());
			
		case ErrorCodes.TOO_MANY_IDS:
			return new TooManyIdsException(error.getMessage(), new Date());
			
		case ErrorCodes.UNCONSTRAINED_SEARCH:
			return new UnconstrainedSearchException(error.getMessage(), new Date());
		default:
			return new StackExchangeApiException(error.getMessage(), error.getStatusCode(), error.getErrorCode(), new Date());
		}
	}

	/**
	 * Gets the wrapped input stream.
	 * 
	 * @param is the is
	 * @param gzip the gzip
	 * 
	 * @return the wrapped input stream
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
			    if (gzip) {
			        return new BufferedInputStream(new GZIPInputStream(is));
			    } else {
			        return new BufferedInputStream(is);
			    }
			}

    /**
     * Unmarshall object.
     * 
     * @param clazz the clazz
     * @param xmlContent the xml content
     * 
     * @return the t
     */
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Unmarshall object.
     * 
     * @param clazz the clazz
     * @param xmlContent the xml content
     * 
     * @return the t
     */
    protected abstract <T> PagedList<T> unmarshallList(Class<T> clazz, InputStream xmlContent);
    
    /**
     * Marshall object.
     * 
     * @param element the element
     * 
     * @return the string
     */
    protected abstract String marshallObject(Object element);
}
