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

import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.microsoft.research.PagedList;
import com.microsoft.research.Publication;
import com.microsoft.research.query.GetMostViewedPublicationQuery;
import com.microsoft.research.query.constant.AcademicSearchApiUrls;
import com.microsoft.research.query.constant.ParameterNames;

/**
 * The Class GetMostViewedPublicationQueryImpl.
 */
public class GetMostViewedPublicationQueryImpl extends
		BaseApiQuery<Publication> implements
		GetMostViewedPublicationQuery {

	/**
	 * Instantiates a new gets the most viewed publication query impl.
	 * 
	 * @param applicationId the application id
	 */
	public GetMostViewedPublicationQueryImpl(String applicationId) {
		super(applicationId);
	}

	/* (non-Javadoc)
	 * @see com.microsoft.research.query.GetMostViewedPublicationQuery#withDomainId(int)
	 */
	public GetMostViewedPublicationQuery withDomainId(int domainId) {
		apiUrlBuilder.withParameter(ParameterNames.DOMAIN_ID, domainId);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.microsoft.research.query.GetMostViewedPublicationQuery#withSubDomainId(int)
	 */
	public GetMostViewedPublicationQuery withSubDomainId(int subDomainId) {
		apiUrlBuilder.withParameter(ParameterNames.SUB_DOMAIN_ID, subDomainId);
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createAcademicSearchApiUrlBuilder(AcademicSearchApiUrls.GET_MOST_VIEWED_PUBLICATION_LIST);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.microsoft.research.query.impl.BaseAcademicSearchApiQuery#unmarshallList(com.google.gson.JsonObject)
	 */
	@Override
	protected PagedList<Publication> unmarshallList(JsonObject response) {
		return super.unmarshallList(response, null,
				new TypeToken<List<Publication>>() {
				});
	}
}
