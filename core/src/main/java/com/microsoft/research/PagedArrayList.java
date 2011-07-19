/*
 * Copyright 2011 Nabeel Mukhtar 
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
package com.microsoft.research;

import java.util.ArrayList;


/**
 * The Class PagedArrayList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements PagedList<E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;
	
	/** The start index. */
	private int startIndex;
	
	/** The end index. */
	private int endIndex;
	
	/** The total items. */
	private long totalItems;
	
	/* (non-Javadoc)
	 * @see com.microsoft.research.PagedList#getStartIndex()
	 */
	public int getStartIndex() {
		return startIndex;
	}
	
	/**
	 * Sets the start index.
	 * 
	 * @param startIndex the new start index
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.research.PagedList#getEndIndex()
	 */
	public int getEndIndex() {
		return endIndex;
	}
	
	/**
	 * Sets the end index.
	 * 
	 * @param endIndex the new end index
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.research.PagedList#getTotalItems()
	 */
	public long getTotalItems() {
		return totalItems;
	}
	
	/**
	 * Sets the total items.
	 * 
	 * @param totalItems the new total items
	 */
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
}
