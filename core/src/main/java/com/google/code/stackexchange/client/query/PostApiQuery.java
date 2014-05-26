package com.google.code.stackexchange.client.query;

import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.PostTimeline;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.TimePeriod;

public interface PostApiQuery extends StackExchangeApiQuery<PostTimeline> {

	/**
	 * With tagged.
	 * 
	 * @param tag
	 *            the tag
	 * 
	 * @return the post api query
	 */
	public PostApiQuery withTags(String... tag);

	/**
	 * With paging.
	 * 
	 * @param paging
	 *            the paging
	 * 
	 * @return the post api query
	 */
	public PostApiQuery withPaging(Paging paging);

	/**
	 * With time period.
	 * 
	 * @param timePeriod
	 *            the time period
	 * 
	 * @return the post api query
	 */
	public PostApiQuery withTimePeriod(TimePeriod timePeriod);

	/**
	 * With filter.
	 * 
	 * @param filter
	 *            the filter
	 * 
	 * @return the post api query
	 */
	public PostApiQuery withFilter(String filter);

	/**
	 * With range.
	 * 
	 * @param range
	 *            the range
	 * 
	 * @return the post api query
	 */
	public PostApiQuery withRange(Range range);

}
