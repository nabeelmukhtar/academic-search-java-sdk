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

import java.util.Set;

import org.datacontract.schemas._2004._07.libra_service.AuthorRelationshipType;
import org.datacontract.schemas._2004._07.libra_service.OrderType;
import org.datacontract.schemas._2004._07.libra_service.PublicationContentType;
import org.datacontract.schemas._2004._07.libra_service.ReferenceRelationship;
import org.datacontract.schemas._2004._07.libra_service.SuggestionType;

import com.microsoft.research.PagedList;

/**
 * The Interface AcademicSearchQuery.
 */
public interface AcademicSearchQuery<T> extends
		AcademicSearchAuthenticationClient {
	

	/**
	 * With publication id.
	 * 
	 * @param publicationId the publication id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withPublicationId(int publicationId);
	
	/**
	 * With author id.
	 * 
	 * @param authorId the author id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withAuthorId(int authorId);
	
	/**
	 * With conference id.
	 * 
	 * @param conferenceId the conference id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withConferenceId(int conferenceId);
	
	/**
	 * With journal id.
	 * 
	 * @param journalId the journal id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withJournalId(int journalId);
	
	/**
	 * With organization id.
	 * 
	 * @param organizationId the organization id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withOrganizationId(int organizationId);
	
	/**
	 * With domain id.
	 * 
	 * @param domainId the domain id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withDomainId(int domainId);
	
	/**
	 * With sub domain id.
	 * 
	 * @param subDomainId the sub domain id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withSubDomainId(int subDomainId);
	
	/**
	 * With keyword id.
	 * 
	 * @param keywordId the keyword id
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withKeywordId(int keywordId);
	
	/**
	 * With full text query.
	 * 
	 * @param query the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withFullTextQuery(String query);
	
	/**
	 * With title query.
	 * 
	 * @param query the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withTitleQuery(String query);
	
	/**
	 * With author query.
	 * 
	 * @param query the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withAuthorQuery(String query);
	
	/**
	 * With conference query.
	 * 
	 * @param query the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withConferenceQuery(String query);
	
	/**
	 * With journal query.
	 * 
	 * @param query the query
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withJournalQuery(String query);
	
	/**
	 * With author relationship.
	 * 
	 * @param type the type
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withAuthorRelationship(AuthorRelationshipType type);
	
	/**
	 * With order.
	 * 
	 * @param order the order
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withOrder(OrderType order);
	
	/**
	 * With publication content.
	 * 
	 * @param types the types
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withPublicationContent(Set<PublicationContentType> types);
	
	/**
	 * With reference relationship.
	 * 
	 * @param type the type
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withReferenceRelationship(ReferenceRelationship type);
	
	/**
	 * With suggestion.
	 * 
	 * @param type the type
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withSuggestion(SuggestionType type);
	
	/**
	 * With year start.
	 * 
	 * @param year the year
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withYearStart(short year);
	
	/**
	 * With year end.
	 * 
	 * @param year the year
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withYearEnd(short year);

	/**
	 * With start index.
	 * 
	 * @param startIndex the start index
	 * 
	 * @return the academic search query< t>
	 */
	public AcademicSearchQuery<T> withStartIndex(int startIndex);

	/**
	 * With end index.
	 * 
	 * @param endIndex the end index
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
