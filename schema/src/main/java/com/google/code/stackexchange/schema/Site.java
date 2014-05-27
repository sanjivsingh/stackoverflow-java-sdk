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

import java.util.List;

/**
 * @author nmukhtar
 *
 */
public class Site extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9095528905439888541L;
	
	private String name;
	private String logoUrl;
	private String apiEndpoint;
	private String siteUrl;
	private String description;
	private String iconUrl;
	private List<String> aliases;
	private SiteState state;
	private SiteStyle styling;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}
	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	/**
	 * @return the apiEndpoint
	 */
	public String getApiEndpoint() {
		return apiEndpoint;
	}
	/**
	 * @param apiEndpoint the apiEndpoint to set
	 */
	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}
	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}
	/**
	 * @param siteUrl the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}
	/**
	 * @param iconUrl the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	/**
	 * @return the aliases
	 */
	public List<String> getAliases() {
		return aliases;
	}
	/**
	 * @param aliases the aliases to set
	 */
	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
	/**
	 * @return the state
	 */
	public SiteState getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(SiteState state) {
		this.state = state;
	}
	/**
	 * @return the styling
	 */
	public SiteStyle getStyling() {
		return styling;
	}
	/**
	 * @param styling the styling to set
	 */
	public void setStyling(SiteStyle styling) {
		this.styling = styling;
	}
}
