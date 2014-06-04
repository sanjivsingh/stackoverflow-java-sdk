package com.google.code.stackexchange.client.example;

import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;
import com.google.code.stackexchange.schema.StackExchangeSite;

public class TestIntegration {

	public static void main(String[] args) {

		boolean isAuth = true;
		StackExchangeApiQueryFactory queryFactory = null;
		if (isAuth) {
			queryFactory = StackExchangeApiQueryFactory.newInstance(
					"applicationKey",
					StackExchangeSite.STACK_OVERFLOW);
		} else {
			queryFactory = StackExchangeApiQueryFactory.newInstance();
		}



	}

	/*	*//**
	 * Gets the paging.
	 * 
	 * @return the paging
	 */
	/*
	 * protected static Paging getPaging() {
	 * 
	 * return new Paging(
	 * Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_PAGE_NO),
	 * Integer.parseInt(TestConstants.STACK_OVERFLOW_TEST_PAGE_SIZE)); }
	 *//**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	/*
	 * protected List<String> getTags() { return
	 * Arrays.asList(TestConstants.STACK_OVERFLOW_TEST_TAGS.split(",")); }
	 *//**
	 * Gets the ids.
	 * 
	 * @param idString
	 *            the id string
	 * 
	 * @return the ids
	 */
	/*
	 * protected static long[] getIds(String idString) { String[] tokens =
	 * idString.split(","); long[] ids = new long[tokens.length]; for (int i =
	 * 0; i < tokens.length; i++) { ids[i] = Long.valueOf(tokens[i]); } return
	 * ids; }
	 * 
	 * protected static String[] getStringIds(String idsString) { String[] ids =
	 * idsString.split(","); return ids; }
	 *//**
	 * Gets the time period.
	 * 
	 * @return the time period
	 */
	/*
	 * protected static TimePeriod getTimePeriod() { return new
	 * TimePeriod(getLastWeekDate(), new Date()); }
	 *//**
	 * Gets the last week date.
	 * 
	 * @return the last week date
	 */
	/*
	 * protected static Date getLastWeekDate() { Calendar calendar =
	 * Calendar.getInstance(); calendar.add(Calendar.DATE, -7); return
	 * calendar.getTime(); }
	 */

}
