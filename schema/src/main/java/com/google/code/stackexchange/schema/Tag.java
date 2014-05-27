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

import com.google.code.stackexchange.schema.Tag;

/**
 * The Class TagImpl.
 */
public class Tag extends SchemaEntity {
	
	/**
	 * The Enum SortOrder.
	 */
	public enum SortOrder implements SortEnum {
		
		/** The MOS t_ popular. */
		MOST_POPULAR("popular", Order.DESCENDING),
		
		/** The LEAS t_ popular. */
		LEAST_POPULAR("popular", Order.ASCENDING),
		
		/** The NAM e_ ascending. */
		NAME_ASCENDING("name", Order.DESCENDING),
		
		/** The NAM e_ descending. */
		NAME_DESCENDING("name", Order.ASCENDING),
		
		/** The MOS t_ recentl y_ updated. */
		MOST_RECENTLY_UPDATED("activity", Order.DESCENDING),
		
		/** The LEAS t_ recentl y_ updated. */
		LEAST_RECENTLY_UPDATED("activity", Order.ASCENDING);
		
	    /** The Constant stringToEnum. */
		private static final Map<String, SortOrder> stringToEnum = new HashMap<String, SortOrder>();

		static { // Initialize map from constant name to enum constant
			for (SortOrder op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /** The order. */
	    private final Order order;
	    
	    /**
    	 * Instantiates a new sort order.
    	 * 
    	 * @param value the value
    	 * @param order the order
    	 */
	    SortOrder(String value, Order order) {
	        this.value = value;
	        this.order = order;
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
		 * @return the sort order
		 */
		public static SortOrder fromValue(String value) {
			return stringToEnum.get(value);
		}

		/* (non-Javadoc)
		 * @see com.google.code.stackexchange.schema.SortEnum#order()
		 */
		@Override
		public Order order() {
			return order;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4228675989610922635L;
	
	/** The name. */
	private String name;
	
	/** The count. */
	private long count;
	
	/** The user id. */
	private long userId;
	
	private boolean fulfillsRequired;
	
	private TagRestriction restrictedTo;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#getUserId()
	 */
	
	public long getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#setUserId(long)
	 */
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#getCount()
	 */
	public long getCount() {
		return count;
	}

	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.Tag#setCount(long)
	 */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * @return the fulfillsRequired
	 */
	public boolean isFulfillsRequired() {
		return fulfillsRequired;
	}

	/**
	 * @param fulfillsRequired the fulfillsRequired to set
	 */
	public void setFulfillsRequired(boolean fulfillsRequired) {
		this.fulfillsRequired = fulfillsRequired;
	}

	/**
	 * @return the restrictedTo
	 */
	public TagRestriction getRestrictedTo() {
		return restrictedTo;
	}

	/**
	 * @param restrictedTo the restrictedTo to set
	 */
	public void setRestrictedTo(TagRestriction restrictedTo) {
		this.restrictedTo = restrictedTo;
	}
}
