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
 * The Enum PostType.
 */
public enum PostType implements ValueEnum {
	
	/** The ANSWER. */
	ANSWER("answer"),
	
	/** The COMMENT. */
	COMMENT("comment"),
	
	/** The QUESTION. */
	QUESTION("question");
	
    /** The Constant stringToEnum. */
	private static final Map<String, PostType> stringToEnum = new HashMap<String, PostType>();

	static { // Initialize map from constant name to enum constant
		for (PostType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new post type.
     * 
     * @param value the value
     */
    PostType(String value) {
        this.value = value;
    }

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the post type
	 */
	public static PostType fromValue(String value) {
		return stringToEnum.get(value);
	}
}
