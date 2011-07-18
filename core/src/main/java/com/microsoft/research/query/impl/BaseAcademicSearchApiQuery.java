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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import org.datacontract.schemas._2004._07.libra_service.PublicationType;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.microsoft.research.PagedArrayList;
import com.microsoft.research.PagedList;
import com.microsoft.research.query.AcademicSearchException;
import com.microsoft.research.query.AcademicSearchQuery;
import com.microsoft.research.query.constant.ApplicationConstants;
import com.microsoft.research.query.constant.ParameterNames;
import com.microsoft.research.query.constant.AcademicSearchApiUrls.AcademicSearchApiUrlBuilder;

/**
 * The Class BaseAcademicSearchApiQuery.
 */
public abstract class BaseAcademicSearchApiQuery<T> extends
		AcademicSearchApiGateway implements AcademicSearchQuery<T> {

	/** The Constant UTF_8_CHAR_SET. */
	protected static final Charset UTF_8_CHAR_SET = Charset
			.forName(ApplicationConstants.CONTENT_ENCODING);

	/** The api url builder. */
	protected AcademicSearchApiUrlBuilder apiUrlBuilder;

	/** The parser. */
	protected final JsonParser parser = new JsonParser();

	/**
	 * Instantiates a new base academic search api query.
	 * 
	 * @param applicationId
	 *            the application id
	 */
	public BaseAcademicSearchApiQuery(String applicationId) {
		super.setApplicationKey(applicationId);
		requestHeaders = new HashMap<String, String>();

		// by default we compress contents
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
		this.reset();
	}

	/**
	 * Instantiates a new base academic search api query.
	 * 
	 * @param applicationId
	 *            the application id
	 * @param apiVersion
	 *            the api version
	 */
	public BaseAcademicSearchApiQuery(String applicationId, String apiVersion) {
		this(applicationId);
		super.setApiVersion(apiVersion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#list()
	 */
	@Override
	public PagedList<T> list() {
		InputStream jsonContent = null;
		try {
			jsonContent = callApiGet(apiUrlBuilder.buildUrl());
			JsonElement response = parser.parse(new InputStreamReader(
					jsonContent, UTF_8_CHAR_SET));
			if (response.isJsonObject()) {
				JsonElement jsonElement = response.getAsJsonObject().get("d");
				if (jsonElement != null && jsonElement.isJsonObject()) {
					PagedList<T> responseList = unmarshallList(jsonElement
							.getAsJsonObject());
					return responseList;
				}
			}
			throw new AcademicSearchException(
					"Unknown content found in response:" + response.toString());
		} catch (Exception e) {
			throw new AcademicSearchException(e);
		} finally {
			closeStream(jsonContent);
		}
	}

	/**
	 * Unmarshall list.
	 * 
	 * @param response
	 *            the response
	 * 
	 * @return the paged list< t>
	 */
	protected abstract PagedList<T> unmarshallList(JsonObject response);

	/**
	 * Unmarshall list.
	 * 
	 * @param response
	 *            the response
	 * @param name
	 *            the name
	 * @param typeToken
	 *            the type token
	 * 
	 * @return the paged list< t>
	 */
	protected PagedList<T> unmarshallList(JsonObject response, String name,
			TypeToken<? extends List<T>> typeToken) {
		JsonObject data = response.get(name).getAsJsonObject();
		PagedArrayList<T> list = new PagedArrayList<T>();
		if (data != null) {
			if (data.get("EndIdx") != null) {
				list.setEndIndex(data.get("EndIdx").getAsInt());
			}
			if (data.get("StartIdx") != null) {
				list.setStartIndex(data.get("StartIdx").getAsInt());
			}
			if (data.get("TotalItem") != null) {
				list.setTotalItems(data.get("TotalItem").getAsLong());
			}
			Gson gson = getGsonBuilder().create();
			List<T> resultsList = gson.fromJson(data.get("Result"), typeToken
					.getType());
			list.addAll(resultsList);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#singleResult()
	 */
	@Override
	public T singleResult() {
		PagedList<T> list = list();
		return (list.isEmpty()) ? null : list.get(0);
	}

	/**
	 * Gets the gson builder.
	 * 
	 * @return the gson builder
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(ApplicationConstants.RFC822DATEFORMAT);
		builder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
		builder.registerTypeAdapter(PublicationType.class,
				new JsonDeserializer<PublicationType>() {

					@Override
					public PublicationType deserialize(JsonElement arg0,
							Type arg1, JsonDeserializationContext arg2)
							throws JsonParseException {
						return PublicationType.fromNumber(arg0.getAsInt());
					}

				});
		return builder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.googlesearch.client.impl.GoogleSearchApiGateway#unmarshallObject(java.lang.Class,
	 *      java.io.InputStream)
	 */
	@Override
	protected <V> V unmarshallObject(Class<V> clazz, InputStream xmlContent) {
		return null;
	}

	/**
	 * Creates the academic search api url builder.
	 * 
	 * @param urlFormat
	 *            the url format
	 * 
	 * @return the academic search api url builder
	 */
	protected AcademicSearchApiUrlBuilder createAcademicSearchApiUrlBuilder(
			String urlFormat) {
		AcademicSearchApiUrlBuilder urlBuilder = new AcademicSearchApiUrlBuilder(
				urlFormat);
		urlBuilder.withParameter(ParameterNames.APP_ID, getApplicationKey());
		return urlBuilder;
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
}
