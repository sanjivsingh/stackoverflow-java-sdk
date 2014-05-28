package com.google.code.stackexchange.client.query.impl;

import java.util.Arrays;

import com.google.code.stackexchange.client.constant.StackExchangeApiMethods;
import com.google.code.stackexchange.client.provider.url.DefaultApiUrlBuilder;
import com.google.code.stackexchange.client.query.PostApiQuery;
import com.google.code.stackexchange.common.PagedList;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.StackExchangeSite;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.gson.JsonObject;

public class PostApiQueryImpl extends BaseStackOverflowApiQuery<PostTimeline>
		implements PostApiQuery {

	public PostApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite) {
		super(applicationId, stackExchangeSite);
	}

	public PostApiQueryImpl(String applicationId,
			StackExchangeSite stackExchangeSite, String accessToken) {
		super(applicationId, stackExchangeSite, accessToken);
	}

	public PostApiQueryImpl(String applicationId, String apiVersion,
			String accessToken, StackExchangeSite stackExchangeSite) {
		super(applicationId, apiVersion, accessToken, stackExchangeSite);
	}

	@Override
	public void reset() {
		apiUrlBuilder = getApiProvider().createApiUrlBuilder(
				StackExchangeApiMethods.GET_POSTS, getApplicationKey(),
				getAccessToken(), getSite(), getApiVersion());

	}

	@Override
	protected PagedList<PostTimeline> unmarshall(JsonObject json) {
		return unmarshallList(PostTimeline.class, json);
	}

	@Override
	public PostApiQuery withTags(String... tag) {
		apiUrlBuilder.withParameters("tagged", Arrays.asList(tag), ";");
		return this;
	}

	@Override
	public PostApiQuery withPaging(Paging paging) {
		apiUrlBuilder.withPaging(paging);
		return this;
	}

	@Override
	public PostApiQuery withTimePeriod(TimePeriod timePeriod) {
		apiUrlBuilder.withTimePeriod(timePeriod);
		return this;
	}

	@Override
	public PostApiQuery withFilter(String filter) {
		apiUrlBuilder.withParameter("filter", filter);
		return this;
	}

	@Override
	public PostApiQuery withRange(Range range) {
		apiUrlBuilder.withRange(range);
		return this;
	}

	@Override
	public PagedList<PostTimeline> list() {
		((DefaultApiUrlBuilder) apiUrlBuilder)
				.withMethod(StackExchangeApiMethods.GET_POSTS);
		return super.list();
	}

}
