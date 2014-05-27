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
 * @author nmukhtar
 *
 */
public class SiteStyle extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6468007026606509603L;
	
	private String linkColor;
	private String tagForegroundColor;
	private String tagBackgroundColor;
	/**
	 * @return the linkColor
	 */
	public String getLinkColor() {
		return linkColor;
	}
	/**
	 * @param linkColor the linkColor to set
	 */
	public void setLinkColor(String linkColor) {
		this.linkColor = linkColor;
	}
	/**
	 * @return the tagForegroundColor
	 */
	public String getTagForegroundColor() {
		return tagForegroundColor;
	}
	/**
	 * @param tagForegroundColor the tagForegroundColor to set
	 */
	public void setTagForegroundColor(String tagForegroundColor) {
		this.tagForegroundColor = tagForegroundColor;
	}
	/**
	 * @return the tagBackgroundColor
	 */
	public String getTagBackgroundColor() {
		return tagBackgroundColor;
	}
	/**
	 * @param tagBackgroundColor the tagBackgroundColor to set
	 */
	public void setTagBackgroundColor(String tagBackgroundColor) {
		this.tagBackgroundColor = tagBackgroundColor;
	}
}
