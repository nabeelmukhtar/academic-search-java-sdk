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
package com.microsoft.research.query;

import com.microsoft.research.PagedList;

/**
 * The Interface AcademicSearchQuery.
 */
public interface AcademicSearchQuery<T> extends
		AcademicSearchAuthenticationClient {

	/**
	 * With full text query.
	 * 
	 * @param query
	 *            the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withFullTextQuery(String query);

	/**
	 * With start index.
	 * 
	 * @param startIndex
	 *            the start index
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withStartIndex(int startIndex);

	/**
	 * With end index.
	 * 
	 * @param endIndex
	 *            the end index
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withEndIndex(int endIndex);

	/**
	 * Single result.
	 * 
	 * @return the t
	 */
	public T singleResult();

	/**
	 * List.
	 * 
	 * @return the paged list< t>
	 */
	public PagedList<T> list();

	/**
	 * Reset.
	 */
	public void reset();
}
