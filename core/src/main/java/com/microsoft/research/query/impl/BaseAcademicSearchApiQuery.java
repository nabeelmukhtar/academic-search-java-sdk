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
package com.microsoft.research.query.impl;

import java.util.HashMap;
import java.util.Set;

import org.datacontract.schemas._2004._07.libra_service.AuthorRelationshipType;
import org.datacontract.schemas._2004._07.libra_service.OrderType;
import org.datacontract.schemas._2004._07.libra_service.PublicationContentType;
import org.datacontract.schemas._2004._07.libra_service.ReferenceRelationship;
import org.datacontract.schemas._2004._07.libra_service.SuggestionType;

import com.microsoft.research.query.AcademicSearchQuery;
import com.microsoft.research.query.constant.ParameterNames;

/**
 * The Class BaseAcademicSearchApiQuery.
 */
public abstract class BaseAcademicSearchApiQuery<T> extends
	BaseApiQuery<T> implements AcademicSearchQuery<T> {

	/**
	 * Instantiates a new base academic search api query.
	 * 
	 * @param applicationId the application id
	 */
	public BaseAcademicSearchApiQuery(String applicationId) {
		super(applicationId);
		requestHeaders = new HashMap<String, String>();

		// by default we compress contents
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
		this.reset();
	}

	/**
	 * Instantiates a new base academic search api query.
	 * 
	 * @param applicationId the application id
	 * @param apiVersion the api version
	 */
	public BaseAcademicSearchApiQuery(String applicationId, String apiVersion) {
		this(applicationId);
		super.setApiVersion(apiVersion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.googlesearch.client.AcademicSearchQuery#withQuery(java.lang.String)
	 */
	@Override
	public AcademicSearchQuery<T> withFullTextQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.FULL_TEXT_QUERY, query);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.googlesearch.client.AcademicSearchQuery#withStartIndex(int)
	 */
	@Override
	public AcademicSearchQuery<T> withStartIndex(int startIndex) {
		apiUrlBuilder.withParameter(ParameterNames.START_INDEX, String
				.valueOf(startIndex));
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.microsoft.research.query.AcademicSearchQuery#withEndIndex(int)
	 */
	@Override
	public AcademicSearchQuery<T> withEndIndex(int endIndex) {
		apiUrlBuilder.withParameter(ParameterNames.END_INDEX, String
				.valueOf(endIndex));
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withAuthorId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withAuthorId(int authorId) {
		apiUrlBuilder.withParameter(ParameterNames.AUTHOR_ID, String
				.valueOf(authorId));
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withAuthorQuery(java.lang.String)
	 */
	@Override
	public AcademicSearchQuery<T> withAuthorQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.AUTHOR_QUERY, query);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withAuthorRelationship(org.datacontract.schemas._2004._07.libra_service.AuthorRelationshipType)
	 */
	@Override
	public AcademicSearchQuery<T> withAuthorRelationship(
			AuthorRelationshipType type) {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withConferenceId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withConferenceId(int conferenceId) {
		apiUrlBuilder.withParameter(ParameterNames.CONFERENCE_ID, conferenceId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withConferenceQuery(java.lang.String)
	 */
	@Override
	public AcademicSearchQuery<T> withConferenceQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.CONFERENCE_QUERY, query);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withDomainId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withDomainId(int domainId) {
		apiUrlBuilder.withParameter(ParameterNames.DOMAIN_ID, domainId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withJournalId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withJournalId(int journalId) {
		apiUrlBuilder.withParameter(ParameterNames.JOURNAL_ID, journalId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withJournalQuery(java.lang.String)
	 */
	@Override
	public AcademicSearchQuery<T> withJournalQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.JOURNAL_QUERY, query);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withKeywordId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withKeywordId(int keywordId) {
		apiUrlBuilder.withParameter(ParameterNames.KEYWORD_ID, keywordId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withOrder(org.datacontract.schemas._2004._07.libra_service.OrderType)
	 */
	@Override
	public AcademicSearchQuery<T> withOrder(OrderType order) {
		apiUrlBuilder.withParameter(ParameterNames.ORDER_BY, order.value());
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withOrganizationId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withOrganizationId(int organizationId) {
		apiUrlBuilder.withParameter(ParameterNames.ORGANIZATION_ID, organizationId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withPublicationContent(java.util.Set)
	 */
	@Override
	public AcademicSearchQuery<T> withPublicationContent(
			Set<PublicationContentType> types) {
		apiUrlBuilder.withParameterEnumSet(ParameterNames.PUBLICATION_CONTENT, types);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withPublicationId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withPublicationId(int publicationId) {
		apiUrlBuilder.withParameter(ParameterNames.PUBLICATION_ID, publicationId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withReferenceRelationship(org.datacontract.schemas._2004._07.libra_service.ReferenceRelationship)
	 */
	@Override
	public AcademicSearchQuery<T> withReferenceRelationship(
			ReferenceRelationship type) {
		apiUrlBuilder.withParameterEnum(ParameterNames.REFERENCE_TYPE, type);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withSubDomainId(int)
	 */
	@Override
	public AcademicSearchQuery<T> withSubDomainId(int subDomainId) {
		apiUrlBuilder.withParameter(ParameterNames.SUB_DOMAIN_ID, subDomainId);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withSuggestion(org.datacontract.schemas._2004._07.libra_service.SuggestionType)
	 */
	@Override
	public AcademicSearchQuery<T> withSuggestion(SuggestionType type) {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withTitleQuery(java.lang.String)
	 */
	@Override
	public AcademicSearchQuery<T> withTitleQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.TITLE_QUERY, query);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withYearEnd(short)
	 */
	@Override
	public AcademicSearchQuery<T> withYearEnd(short year) {
		apiUrlBuilder.withParameter(ParameterNames.YEAR_END, year);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.AcademicSearchQuery#withYearStart(short)
	 */
	@Override
	public AcademicSearchQuery<T> withYearStart(short year) {
		apiUrlBuilder.withParameter(ParameterNames.YEAR_START, year);
		return this;
	}
}
