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
package com.google.code.stackexchange.client.query.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code.stackexchange.client.AsyncResponseHandler;
import com.google.code.stackexchange.client.constant.ApplicationConstants;
import com.google.code.stackexchange.client.exception.StackExchangeApiException;
import com.google.code.stackexchange.client.impl.StackExchangeApiGateway;
import com.google.code.stackexchange.client.provider.ApiProvider;
import com.google.code.stackexchange.client.provider.url.ApiUrlBuilder;
import com.google.code.stackexchange.client.query.StackExchangeApiQuery;
import com.google.code.stackexchange.common.PagedArrayList;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Answer;
import com.google.code.stackexchange.schema.Badge;
import com.google.code.stackexchange.schema.BadgeRank;
import com.google.code.stackexchange.schema.Comment;
import com.google.code.stackexchange.schema.Error;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.PostTimelineType;
import com.google.code.stackexchange.schema.PostType;
import com.google.code.stackexchange.schema.Question;
import com.google.code.stackexchange.schema.Reputation;
import com.google.code.stackexchange.schema.Revision;
import com.google.code.stackexchange.schema.RevisionType;
import com.google.code.stackexchange.schema.SchemaEntity;
import com.google.code.stackexchange.schema.Site;
import com.google.code.stackexchange.schema.SiteState;
import com.google.code.stackexchange.schema.Statistics;
import com.google.code.stackexchange.schema.Tag;
import com.google.code.stackexchange.schema.TagRestriction;
import com.google.code.stackexchange.schema.User;
import com.google.code.stackexchange.schema.UserTimeline;
import com.google.code.stackexchange.schema.UserTimelineType;
import com.google.code.stackexchange.schema.UserType;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * The Class BaseStackOverflowApiQuery.
 */
public abstract class BaseStackOverflowApiQuery<T> extends StackExchangeApiGateway implements StackExchangeApiQuery<T> {
	
	/** The api url builder. */
	protected ApiUrlBuilder apiUrlBuilder;
    
	protected static final Charset UTF_8_CHAR_SET = Charset.forName(ApplicationConstants.CONTENT_ENCODING);
	
    /** The parser. */
    private final JsonParser parser = new JsonParser();
    
	private static final Map<Class<? extends SchemaEntity>, String> LIST_PLACE_HOLDERS = new HashMap<Class<? extends SchemaEntity>, String>();
	
	static {
		LIST_PLACE_HOLDERS.put(Answer.class, "answers");
		LIST_PLACE_HOLDERS.put(Badge.class, "badges");
		LIST_PLACE_HOLDERS.put(Comment.class, "comments");
		LIST_PLACE_HOLDERS.put(Question.class, "questions");
		LIST_PLACE_HOLDERS.put(PostTimeline.class, "post_timelines");
		LIST_PLACE_HOLDERS.put(Reputation.class, "rep_changes");
		LIST_PLACE_HOLDERS.put(Statistics.class, "statistics");
		LIST_PLACE_HOLDERS.put(Tag.class, "tags");
		LIST_PLACE_HOLDERS.put(User.class, "users");
		LIST_PLACE_HOLDERS.put(UserTimeline.class, "user_timelines");
		LIST_PLACE_HOLDERS.put(Revision.class, "revisions");
		LIST_PLACE_HOLDERS.put(Site.class, "api_sites");
	}
    
    /** The handlers. */
    private List<AsyncResponseHandler<PagedList<T>>> handlers = new ArrayList<AsyncResponseHandler<PagedList<T>>>();
	
	/**
	 * Instantiates a new base stack overflow api query.
	 * 
	 * @param applicationId the application id
	 */
	public BaseStackOverflowApiQuery(String applicationId) {
		super.setApplicationKey(applicationId);
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
        this.reset();
	}
	
	@Override
	public void setApiProvider(ApiProvider apiProvider) {
		super.setApiProvider(apiProvider);
		this.reset();
	}

	/**
	 * Instantiates a new base stack overflow api query.
	 * 
	 * @param applicationId the application id
	 * @param apiVersion the api version
	 */
	public BaseStackOverflowApiQuery(String applicationId, String apiVersion) {
		this(applicationId);
		super.setApiVersion(apiVersion);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<T> list() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiMethod(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		PagedList<T> responseList = unmarshall(response.getAsJsonObject());
        		notifyObservers(responseList);
				return responseList;
        	}
        	throw new StackExchangeApiException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new StackExchangeApiException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#singleResult()
	 */
	@Override
	public T singleResult() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiMethod(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		PagedList<T> responseList = unmarshall(response.getAsJsonObject());
        		notifyObservers(responseList);
				return getFirstElement(responseList);
        	}
        	throw new StackExchangeApiException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new StackExchangeApiException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	/**
	 * Notify observers.
	 * 
	 * @param response the response
	 */
	protected void notifyObservers(PagedList<T> response) {
		for(AsyncResponseHandler<PagedList<T>> handler : handlers) {
			handler.handleResponse(response);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackExchangeApiQuery#addResonseHandler(com.google.code.stackexchange.client.AsyncResponseHandler)
	 */
	public void addResonseHandler(AsyncResponseHandler<PagedList<T>> handler) {
		handlers.add(handler);
	}
	
	
	protected <A> A unmarshallObject(Class<A> clazz, InputStream jsonContent) {
    	if (clazz.equals(Error.class)) {
            try {
            	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
            	if (response.isJsonObject()) {
            		JsonObject adaptee = response.getAsJsonObject();
            		Gson gson = getGsonBuilder().create();
            		return gson.fromJson(adaptee.get("error"), clazz);
            	}
            } catch (Exception e) {
                throw new StackExchangeApiException(e);
            }
    	}
    	return null;
    }
    
    protected <A> PagedList<A> unmarshallList(Class<A> clazz, InputStream jsonContent) {
        try {
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		JsonObject adaptee = response.getAsJsonObject();
        		return unmarshallList(clazz, adaptee);
        	}
        	throw new StackExchangeApiException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new StackExchangeApiException(e);
        }
    }

	/**
	 * @param <A>
	 * @param clazz
	 * @param adaptee
	 * @return
	 */
	protected <A> PagedList<A> unmarshallList(Class<A> clazz, JsonObject adaptee) {
		PagedList<A> list = new PagedArrayList<A>();
		if (adaptee.has("total")) {
			list.setTotal(adaptee.get("total").getAsLong());
		}
		if (adaptee.has("page")) {
			list.setPage(adaptee.get("page").getAsInt());
		}
		if (adaptee.has("pagesize")) {
			list.setPageSize(adaptee.get("pagesize").getAsInt());
		}
		String placeHolder = LIST_PLACE_HOLDERS.get(clazz);
		if (adaptee.has(placeHolder)) {
			JsonArray elements = adaptee.get(placeHolder).getAsJsonArray();
			if (elements != null) {
				Gson gson = getGsonBuilder().create();
				for (JsonElement o : elements) {			
					list.add(gson.fromJson(o, clazz));
				}
			}
		}
		return list;
	}

    /* (non-Javadoc)
     * @see com.google.code.stackexchange.client.impl.StackOverflowApiGateway#marshallObject(java.lang.Object)
     */
    protected String marshallObject(Object element) {
    	return null;
    }
	
	/**
	 * Unmarshall.
	 * 
	 * @param json the json
	 * 
	 * @return the paged list< t>
	 */
	protected abstract PagedList<T> unmarshall(JsonObject json);
	
	/**
	 * Gets the first element.
	 * 
	 * @param list the list
	 * 
	 * @return the first element
	 */
	private T getFirstElement(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement source, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return new Date(source.getAsLong() * 1000);
			}
			
		});
		builder.registerTypeAdapter(BadgeRank.class, new JsonDeserializer<BadgeRank>() {

			@Override
			public BadgeRank deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return BadgeRank.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(PostType.class, new JsonDeserializer<PostType>() {

			@Override
			public PostType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return PostType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(PostTimelineType.class, new JsonDeserializer<PostTimelineType>() {

			@Override
			public PostTimelineType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return PostTimelineType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(UserTimelineType.class, new JsonDeserializer<UserTimelineType>() {

			@Override
			public UserTimelineType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return UserTimelineType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(UserType.class, new JsonDeserializer<UserType>() {

			@Override
			public UserType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return UserType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(RevisionType.class, new JsonDeserializer<RevisionType>() {

			@Override
			public RevisionType deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return RevisionType.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(TagRestriction.class, new JsonDeserializer<TagRestriction>() {

			@Override
			public TagRestriction deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return TagRestriction.fromValue(arg0.getAsString());
			}
			
		});
		builder.registerTypeAdapter(SiteState.class, new JsonDeserializer<SiteState>() {

			@Override
			public SiteState deserialize(JsonElement arg0, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return SiteState.fromValue(arg0.getAsString());
			}
		});
		
		builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		
		return builder;		
	}
}
