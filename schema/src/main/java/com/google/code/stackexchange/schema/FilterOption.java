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

import java.util.HashMap;
import java.util.Map;


/**
 * The Enum FilterOption.
 */
public enum FilterOption implements ValueEnum {
	
	/** The INCLUD e_ comments. */
	INCLUDE_COMMENTS("comments", "true"),
	
	/** The INCLUD e_ body. */
	INCLUDE_BODY("body", "true"),
	
	/** The INCLUD e_ answers. */
	INCLUDE_ANSWERS("answers", "true");
	
    /** The Constant stringToEnum. */
	private static final Map<String, FilterOption> stringToEnum = new HashMap<String, FilterOption>();

	static { // Initialize map from constant name to enum constant
		for (FilterOption op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The default value. */
    private final String defaultValue;
    
    /**
     * Instantiates a new filter option.
     * 
     * @param value the value
     * @param defaultValue the default value
     */
    FilterOption(String value, String defaultValue) {
        this.value = value;
        this.defaultValue = defaultValue;
    }

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/**
	 * Default value.
	 * 
	 * @return the string
	 */
	public String defaultValue() {
		return defaultValue;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the filter option
	 */
	public static FilterOption fromValue(String value) {
		return stringToEnum.get(value);
	}
}
