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

import com.microsoft.research.query.impl.AuthorSearchQueryImpl;
import com.microsoft.research.query.impl.ConferenceSearchQueryImpl;
import com.microsoft.research.query.impl.DomainSearchQueryImpl;
import com.microsoft.research.query.impl.JournalSearchQueryImpl;
import com.microsoft.research.query.impl.KeywordSearchQueryImpl;
import com.microsoft.research.query.impl.OrganizationSearchQueryImpl;
import com.microsoft.research.query.impl.PublicationSearchQueryImpl;

/**
 * A factory for creating AcademicSearchQuery objects.
 */
public class AcademicSearchQueryFactory {

	/** The application key. */
	private String applicationKey;

	/**
	 * Instantiates a new academic search query factory.
	 * 
	 * @param applicationKey the application key
	 */
	private AcademicSearchQueryFactory(String applicationKey) {
		this.applicationKey = applicationKey;
	}

	/**
	 * New instance.
	 * 
	 * @param applicationKey the application key
	 * 
	 * @return the academic search query factory
	 */
	public static AcademicSearchQueryFactory newInstance(String applicationKey) {
		return new AcademicSearchQueryFactory(applicationKey);
	}

	/**
	 * New publication search query.
	 * 
	 * @return the publication search query
	 */
	public PublicationSearchQuery newPublicationSearchQuery() {
		return new PublicationSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New author search query.
	 * 
	 * @return the author search query
	 */
	public AuthorSearchQuery newAuthorSearchQuery() {
		return new AuthorSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New conference search query.
	 * 
	 * @return the conference search query
	 */
	public ConferenceSearchQuery newConferenceSearchQuery() {
		return new ConferenceSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New domain search query.
	 * 
	 * @return the domain search query
	 */
	public DomainSearchQuery newDomainSearchQuery() {
		return new DomainSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New journal search query.
	 * 
	 * @return the journal search query
	 */
	public JournalSearchQuery newJournalSearchQuery() {
		return new JournalSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New keyword search query.
	 * 
	 * @return the keyword search query
	 */
	public KeywordSearchQuery newKeywordSearchQuery() {
		return new KeywordSearchQueryImpl(applicationKey);
	}
	
	/**
	 * New organization search query.
	 * 
	 * @return the organization search query
	 */
	public OrganizationSearchQuery newOrganizationSearchQuery() {
		return new OrganizationSearchQueryImpl(applicationKey);
	}
}
