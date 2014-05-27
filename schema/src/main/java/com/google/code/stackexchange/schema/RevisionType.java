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
 * The Enum RevisionType.
 */
public enum RevisionType implements ValueEnum {

	/** The SINGL e_ user. */
	SINGLE_USER("single_user"),
	
	/** The VOT e_ based. */
	VOTE_BASED("vote_based");
	
    /** The Constant stringToEnum. */
	private static final Map<String, RevisionType> stringToEnum = new HashMap<String, RevisionType>();

	static { // Initialize map from constant name to enum constant
		for (RevisionType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new revision type.
     * 
     * @param value the value
     */
    RevisionType(String value) {
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
	 * @return the revision type
	 */
	public static RevisionType fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
