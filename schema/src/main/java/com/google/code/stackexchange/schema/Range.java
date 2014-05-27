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
package com.google.code.stackexchange.schema;

/**
 * The Class Range.
 */
public final class Range {
	
	/** The min. */
	private long min;
	
	/** The max. */
	private long max;
	
	/**
	 * Instantiates a new range.
	 * 
	 * @param min the min
	 * @param max the max
	 */
	public Range(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	/**
	 * Gets the min.
	 * 
	 * @return the min
	 */
	public long getMin() {
		return min;
	}
	
	/**
	 * Gets the max.
	 * 
	 * @return the max
	 */
	public long getMax() {
		return max;
	}
}