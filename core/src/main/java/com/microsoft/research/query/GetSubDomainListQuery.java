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

import com.microsoft.research.Domain;
import com.microsoft.research.PagedList;

/**
 * The Interface GetSubDomainListQuery.
 */
public interface GetSubDomainListQuery extends
		AcademicSearchAuthenticationClient {
	
	/**
	 * With domain id.
	 * 
	 * @param domainId the domain id
	 * 
	 * @return the gets the sub domain list query
	 */
	public GetSubDomainListQuery withDomainId(int domainId);
	
	/**
	 * List.
	 * 
	 * @return the paged list< domain>
	 */
	public PagedList<Domain> list();

	/**
	 * Reset.
	 */
	public void reset();
}