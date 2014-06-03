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
package com.google.code.stackexchange.common;

import java.util.ArrayList;

/**
 * The Class PagedArrayList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements PagedList<E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;

	/** The page. */
	private int page;

	/** The page size. */
	private int pageSize;

	/** The Has more records. */
	private boolean hasMore;

	private int quotaMax;

	private int quotaRemaining;

	/*
	 * If an application receives a response with the backoff field set, it must
	 * wait that many seconds before hitting the same method again
	 */
	private int backoff;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.common.PagedList#getPage()
	 */
	public int getPage() {
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.common.PagedList#setPage(int)
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.common.PagedList#getPageSize()
	 */
	public int getPageSize() {
		return pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.common.PagedList#setPageSize(int)
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean hasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public int getQuotaMax() {
		return quotaMax;
	}

	public void setQuotaMax(int quotaMax) {
		this.quotaMax = quotaMax;
	}

	public int getQuotaRemaining() {
		return quotaRemaining;
	}

	public void setQuotaRemaining(int quotaRemaining) {
		this.quotaRemaining = quotaRemaining;
	}

	@Override
	public int getBackoff() {
		return backoff;
	}

	@Override
	public void setBackoff(int backoff) {
		this.backoff = backoff;
	}

}
