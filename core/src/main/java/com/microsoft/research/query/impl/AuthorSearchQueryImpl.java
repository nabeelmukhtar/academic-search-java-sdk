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

import org.datacontract.schemas._2004._07.libra_service.ObjectType;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.microsoft.research.Author;
import com.microsoft.research.PagedList;
import com.microsoft.research.query.AuthorSearchQuery;
import com.microsoft.research.query.constant.AcademicSearchApiUrls;
import com.microsoft.research.query.constant.ParameterNames;

/**
 * The Class AuthorSearchQueryImpl.
 */
public class AuthorSearchQueryImpl extends
		BaseAcademicSearchApiQuery<Author> implements
		AuthorSearchQuery {

	/**
	 * Instantiates a new author search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public AuthorSearchQueryImpl(String applicationId) {
		super(applicationId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createAcademicSearchApiUrlBuilder(AcademicSearchApiUrls.SEARCH_URL);
		apiUrlBuilder.withParameter(ParameterNames.RESULT_OBJECTS,
				ObjectType.AUTHOR.value());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.microsoft.research.query.impl.BaseAcademicSearchApiQuery#unmarshallList(com.google.gson.JsonObject)
	 */
	@Override
	protected PagedList<Author> unmarshallList(JsonObject response) {
		return super.unmarshallList(response, "Author",
				new TypeToken<List<Author>>() {
				});
	}
}
