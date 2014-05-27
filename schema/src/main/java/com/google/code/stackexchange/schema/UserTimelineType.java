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
 * The Enum UserTimelineType.
 */
public enum UserTimelineType implements ValueEnum {

	/** The BADGE. */
	BADGE("badge"),
	
	/** The COMMENT. */
	COMMENT("comment"),
	
	/** The AS k_ o r_ answered. */
	ASK_OR_ANSWERED("askoranswered"),
	
	/** The ACCEPTED. */
	ACCEPTED("accepted"),
	
	/** The REVISION. */
	REVISION("revision");
	
    /** The Constant stringToEnum. */
	private static final Map<String, UserTimelineType> stringToEnum = new HashMap<String, UserTimelineType>();

	static { // Initialize map from constant name to enum constant
		for (UserTimelineType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new user timeline type.
     * 
     * @param value the value
     */
    UserTimelineType(String value) {
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
	 * @return the user timeline type
	 */
	public static UserTimelineType fromValue(String value) {
		return stringToEnum.get(value);
	}
	
}
