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

import com.google.code.stackexchange.schema.ApiVersion;

/**
 * The Class ApiVersionImpl.
 */
public class ApiVersion extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4844722882774546494L;
	
	/** The version. */
	private String version;
	
	/** The revision. */
	private String revision;
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ApiVersion#getVersion()
	 */
	public String getVersion() {
		return version;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ApiVersion#setVersion(java.lang.String)
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ApiVersion#getRevision()
	 */
	public String getRevision() {
		return revision;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.schema.ApiVersion#setRevision(java.lang.String)
	 */
	public void setRevision(String revision) {
		this.revision = revision;
	}
}
