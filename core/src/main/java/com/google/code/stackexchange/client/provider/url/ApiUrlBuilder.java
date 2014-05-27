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
package com.google.code.stackexchange.client.provider.url;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Paging;
import com.google.code.stackexchange.schema.Range;
import com.google.code.stackexchange.schema.SortEnum;
import com.google.code.stackexchange.schema.TimePeriod;
import com.google.code.stackexchange.schema.ValueEnum;

/**
 * The Interface ApiUrlBuilder.
 */
public interface ApiUrlBuilder {

	/**
	 * With parameter.
	 * 
	 * @param name the name
	 * @param value the value
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withParameter(String name, String value);

	/**
	 * With parameters.
	 * 
	 * @param name the name
	 * @param values the values
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withParameters(String name,
			Collection<String> values);

	/**
	 * With parameters.
	 * 
	 * @param name the name
	 * @param values the values
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withParameters(String name,
			Collection<String> values, String delimiter);
	
	/**
	 * With fields.
	 * 
	 * @param name the name
	 * @param values the values
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withFields(String name,
			Collection<String> values);
	
	/**
	 * With parameter enum.
	 * 
	 * @param name the name
	 * @param value the value
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withParameterEnum(String name,
			ValueEnum value);

	/**
	 * With id.
	 * 
	 * @param id the id
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withId(long id);
	
	/**
	 * With ids.
	 * 
	 * @param ids the ids
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withIds(long... ids);
	
	/**
	 * With ids.
	 * 
	 * @param ids the ids
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withIds(List<Long> ids);
	
	/**
	 * With paging.
	 * 
	 * @param paging the paging
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withPaging(Paging paging);

	/**
	 * With range.
	 * 
	 * @param range the range
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withRange(Range range);
	
	/**
	 * With time period.
	 * 
	 * @param timePeriod the time period
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withTimePeriod(TimePeriod timePeriod);

	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withSort(SortEnum sort);

	/**
	 * With fetch options.
	 * 
	 * @param fetchOptions the fetch options
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withFetchOptions(
			Set<FilterOption> fetchOptions);

	/**
	 * With parameter enum map.
	 * 
	 * @param enumMap the enum map
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withParameterEnumMap(
			Map<? extends ValueEnum, String> enumMap);

	/**
	 * With empty field.
	 * 
	 * @param name the name
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withEmptyField(String name);

	/**
	 * With field.
	 * 
	 * @param name the name
	 * @param value the value
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withField(String name, String value);

	/**
	 * With field.
	 * 
	 * @param name the name
	 * @param value the value
	 * @param escape the escape
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withField(String name, String value,
			boolean escape);

	/**
	 * With field enum.
	 * 
	 * @param name the name
	 * @param value the value
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withFieldEnum(String name, ValueEnum value);

	/**
	 * With field enum set.
	 * 
	 * @param name the name
	 * @param enumSet the enum set
	 * 
	 * @return the api url builder
	 */
	public ApiUrlBuilder withFieldEnumSet(String name,
			Set<? extends ValueEnum> enumSet);

	/**
	 * Builds the url.
	 * 
	 * @return the string
	 */
	public String buildUrl();

}